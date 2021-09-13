package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Order_details_Activity extends AppCompatActivity {

    TextView address, streetname, phoneNum;
    Button cancel_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        address = findViewById(R.id.add_txt);
        streetname = findViewById(R.id.street_txt);
        phoneNum = findViewById(R.id.phone_txt);

        String addres = getIntent().getStringExtra("KeyAddress");
        String street = getIntent().getStringExtra("KeyStreet");
        String phone = getIntent().getStringExtra("KeyPhone");

        address.setText(addres);
        streetname.setText(street);
        phoneNum.setText(phone);

        cancel_btn = findViewById(R.id.cancel_btn);
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
}