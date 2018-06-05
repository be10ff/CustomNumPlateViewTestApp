package numplate.com.abelov.customnumplateview.MaskFormatter;

import android.text.InputType;

/**
 * Created by maciek on 21.03.2016.
 */
public class CharInputType {

    public static int getKeyboardTypeForNextChar(char nextChar) {
        if (Character.isDigit(nextChar)) {
            return InputType.TYPE_CLASS_NUMBER;
        }

        switch (nextChar) {
            case 'D':
                return InputType.TYPE_CLASS_NUMBER;
            case 'C':
                return InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;
        }

        return InputType.TYPE_CLASS_TEXT;
    }

}