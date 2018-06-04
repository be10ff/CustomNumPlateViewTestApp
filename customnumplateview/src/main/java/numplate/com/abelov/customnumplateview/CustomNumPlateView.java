package numplate.com.abelov.customnumplateview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class CustomNumPlateView extends LinearLayout {

    private int layoutResourceId;
    private int backgroundResourceId;

    public CustomNumPlateView(Context context) {
        super(context);
    }

    public CustomNumPlateView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomNumPlateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomNumPlateView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Builder builder){
        this.layoutResourceId = builder.layoutResourceId;
        this.backgroundResourceId = builder.backgroundResourceId;
        View v = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(layoutResourceId, this);
        v.setBackgroundResource(backgroundResourceId);
    }

    public static class Builder {
        private CustomNumPlateView view;
        private int layoutResourceId;
        private int backgroundResourceId;

        public Builder(CustomNumPlateView view) {
            this.view = view;
        }

        public Builder setLayoutResourceId(int layoutResourceId) {
            this.layoutResourceId = layoutResourceId;
            return this;
        }

        public Builder setBackgroundResourceId(int backgroundResourceId) {
            this.backgroundResourceId = backgroundResourceId;
            return this;
        }

        public void build(){
            view.init(this);
        }
    }


}
