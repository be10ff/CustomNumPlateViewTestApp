package numplate.com.abelov.customnumplateview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.regex.Pattern;

import numplate.com.abelov.customnumplateview.MaskFormatter.MaskFormatter;

//import com.azimolabs.maskformatter.MaskFormatter;

public class CustomNumPlateView extends LinearLayout {

    private Context context;

    private NumberPlate plate;

    private Drawable background;

    ViewGroup alPlate;
    EditText etNum;
    EditText etRegion;
    EditText etSuffix;

    private String fullNumberString;

    private String number;
    private String region;
    private String suffix;

    private MaskFormatter numberMaskedWatcher;

    public CustomNumPlateView(Context context) {
        super(context);
        this.context = context;
        init();

    }

    public CustomNumPlateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public CustomNumPlateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public CustomNumPlateView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        init();
    }

    private void init() {
        background = context.getResources().getDrawable(R.drawable.auto_number);
    }

    private void init(Builder builder){

        this.plate = builder.plate;
        View v = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(plate.resourceId, this);

        this.fullNumberString = builder.num;

        int length = fullNumberString.length();

        //R.id.tvNum, R.id.tvRegion, R.id.tvMotoSuffix
        alPlate = v.findViewById(R.id.alPlate);
        etNum = v.findViewById(plate.etNumberId);
        etRegion = v.findViewById(plate.etRegionId);
        etSuffix = v.findViewById(plate.etNumberMotoSuffixId);

        switch (plate) {
            case RU: {
                int d6 = length > 6 ? 6 : length;
                int d9 = length > 9 ? 9 : length;
                number = fullNumberString.substring(0, d6);
                region = fullNumberString.substring(d6, d9);

//                numberMaskedWatcher =  new MaskFormatter("CDDDCC", etNum, plate.regexPattern);
                etNum.addTextChangedListener(new MaskFormatter("CDDDCC", etNum, plate.regexPattern));
                etRegion.addTextChangedListener(new MaskFormatter("DDD", etRegion, plate.regexPattern));
                break;
            }
            case RU_MOTO: {
                int d4 = length > 4 ? 4 : length;
                int d6 = length > 6 ? 6 : length;
                int d9 = length > 9 ? 9 : length;
                number = fullNumberString.substring(0, d4);
                suffix = fullNumberString.substring(d4, d6);
                region = fullNumberString.substring(d6, d9);

//                numberMaskedWatcher =  new MaskFormatter("CCCC", etNum, plate.regexPattern);
                etNum.addTextChangedListener(new MaskFormatter("DDDD", etNum, plate.regexPattern));
                etRegion.addTextChangedListener(new MaskFormatter("DDD", etRegion, plate.regexPattern));
                etSuffix.addTextChangedListener(new MaskFormatter("CC", etSuffix, plate.regexPattern));
                break;
            }
        }

        background = context.getResources().getDrawable(plate.backgroundId);
        alPlate.setBackgroundDrawable(background);

        etNum.setText(number);

        etSuffix.setText(suffix);
        etRegion.setText(region);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int desiredWidth = background.getIntrinsicWidth();
        int desiredHeight = background.getIntrinsicHeight();

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        float scale = 1;

        if(widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.AT_MOST) {
            scale = ((float)widthSize)/desiredWidth;
        } else if(widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.EXACTLY) {
            scale = ((float)heightSize)/desiredHeight;
        } else {
            scale = Math.min(((float)widthSize)/desiredWidth, ((float)heightSize)/desiredHeight);
        }

        alPlate.setScaleX(scale);
        alPlate.setScaleY(scale);

        int widthSpec = MeasureSpec.makeMeasureSpec(Math.round(scale*desiredWidth), MeasureSpec.EXACTLY);
        int heightSpec = MeasureSpec.makeMeasureSpec(Math.round(scale*desiredHeight), MeasureSpec.EXACTLY);
        super.onMeasure(widthSpec, heightSpec);
    }

    public static class Builder {
        private CustomNumPlateView view;
        private String num;
        private NumberPlate plate;
        boolean enabled;

        public Builder(CustomNumPlateView view) {
            this.view = view;
        }

        public Builder setType(NumberPlate plate) {
            this.plate = plate;
            return this;
        }

//        public Builder setKind(int plate) {
//            this.plate = plate;
//            return this;
//        }
        public Builder setEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder setNum(String num) {
            this.num = num;
            return this;
        }

        public void build(){
            view.init(this);
        }
    }


}
