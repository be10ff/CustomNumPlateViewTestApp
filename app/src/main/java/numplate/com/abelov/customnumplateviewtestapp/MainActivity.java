package numplate.com.abelov.customnumplateviewtestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import numplate.com.abelov.customnumplateview.CustomNumPlateView;
import numplate.com.abelov.customnumplateview.NumberPlate;

public class MainActivity extends AppCompatActivity {

//    CustomNumPlateView npAutoRu;
    CustomNumPlateView npMotoRu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        npAutoRu = findViewById(R.id.npAutoRu);
        npMotoRu = findViewById(R.id.npMotoRu);


//        new CustomNumPlateView.Builder(npAutoRu)
//                .setType(NumberPlate.RU)
//                .setNum("A008XM177")
//                .build();

        new CustomNumPlateView.Builder(npMotoRu)
                .setType(NumberPlate.RU_MOTO)
                .setNum("4606AC77")
                .build();

    }
}
