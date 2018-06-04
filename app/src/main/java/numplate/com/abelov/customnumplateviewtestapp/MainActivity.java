package numplate.com.abelov.customnumplateviewtestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import numplate.com.abelov.customnumplateview.CustomNumPlateView;

public class MainActivity extends AppCompatActivity {

//    numplate.com.abelov.customnumplateviewtestapp.
    CustomNumPlateView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.npView);

        new CustomNumPlateView.Builder(view)
                .setBackgroundResourceId(R.drawable.auto_number)
                .setLayoutResourceId(R.layout.layout_num_plate)
                .build();

    }
}
