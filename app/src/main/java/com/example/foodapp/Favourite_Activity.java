package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Favourite_Activity extends AppCompatActivity {

    ImageView back_btn5;
    Button startOrder3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        back_btn5 = findViewById(R.id.back_btn5);
        startOrder3 = findViewById(R.id.startOrder3);

        back_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        startOrder3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Favourite_Activity.this, Dash_Activity.class));

            }
        });


    }
}