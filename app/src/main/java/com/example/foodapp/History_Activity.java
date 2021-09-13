package com.example.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class History_Activity extends AppCompatActivity {

    ImageView back_btn4;
    Button startOrder2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        back_btn4 = findViewById(R.id.back_btn4);
        startOrder2 = findViewById(R.id.startOrder2);

        back_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        startOrder2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(History_Activity.this, Dash_Activity.class));

            }
        });



    }

}
