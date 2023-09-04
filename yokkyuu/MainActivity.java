package com.example.yokkyuu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import java.util.HashMap;
import java.util.Map;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference userRef;
    private int userCounter = 1;


    ImageSlider imageSlider;
    ImageSlider imageSlider11;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        imageSlider11 = findViewById(R.id.imageSlider1);
        ArrayList<SlideModel> slideModels1 = new ArrayList<>();

        imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.original, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.superjimat, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.teritama, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.redmayo, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.ebimayao, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.chickenfloss, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.cheesementakoi, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);



        slideModels1.add(new SlideModel(R.drawable.ad1, ScaleTypes.FIT));
        slideModels1.add(new SlideModel(R.drawable.ad2, ScaleTypes.FIT));


        imageSlider11.setImageList(slideModels1, ScaleTypes.FIT);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
                String itemKey = "User" + userCounter;

            }
        });

    }
}