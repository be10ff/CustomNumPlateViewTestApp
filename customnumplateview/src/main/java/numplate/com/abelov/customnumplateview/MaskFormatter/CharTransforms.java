package numplate.com.abelov.customnumplateview.MaskFormatter;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by maciek on 16.03.2016.
 */
public class CharTransforms {

    private Map<Character, TransformPattern> transformMap = new HashMap<>();

    public CharTransforms(String pattern){
        this.transformMap.put('D', new TransformPattern("[0-9]", false, false));
        this.transformMap.put('C', new TransformPattern(pattern, false, false));


    }

    private static class TransformPattern {

        private Pattern pattern;
        private boolean upperCase;
        private boolean lowerCase;

        public TransformPattern(String pattern, boolean upperCase, boolean lowerCase) {
            this.pattern = Pattern.compile(pattern);
            this.upperCase = upperCase;
            this.lowerCase = lowerCase;
        }

        public char transformChar(char stringChar) throws InvalidTextException {
            char modified;
            if (upperCase) {
                modified = Character.toUpperCase(stringChar);
            } else if (lowerCase) {
                modified = Character.toLowerCase(stringChar);
            } else {
                modified = stringChar;
            }

            if (!pattern.matcher(modified + "").matches()) {
                throw new InvalidTextException();
            }
            return modified;
        }

    }

     public char transformChar(char stringChar, char maskChar) throws InvalidTextException {
        TransformPattern transform = transformMap.get(maskChar);
        if (transform == null) {
            return stringChar;
        }

        return transform.transformChar(stringChar);
    }

}