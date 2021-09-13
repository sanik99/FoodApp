package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Checkout_activity extends AppCompatActivity {

    RadioGroup radioGroup, radioGroup2;
    RadioButton radioButton, radioButton2;
    Button proceed_btn;
    ImageView back_btn2;

    EditText address, streetname, phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        radioGroup = findViewById(R.id.radiogroup);
        radioGroup2 = findViewById(R.id.radiogroup2);

        proceed_btn = findViewById(R.id.proceed_btn);
        back_btn2 = findViewById(R.id.back_btn2);

        address = findViewById(R.id.address);
        streetname = findViewById(R.id.streetname);
        phoneNum = findViewById(R.id.phoneNum);


        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        proceed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String addres = address.getText().toString();
                String street = streetname.getText().toString();
                String phone = phoneNum.getText().toString();

                Intent intent = new Intent(Checkout_activity.this, Order_details_Activity.class);
                intent.putExtra("KeyAddress", addres);
                intent.putExtra("KeyStreet", street);
                intent.putExtra("KeyPhone", phone);
                startActivity(intent);

            }
        });

    }

    public void checkButton(View v){

            int radioBtnID = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById(radioBtnID);

        Toast.makeText(this, "You choose : " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }


    public void checkButton2(View v){

        int radioBtnID2 = radioGroup2.getCheckedRadioButtonId();
        radioButton2 = findViewById(radioBtnID2);

        Toast.makeText(this, "You choose : " + radioButton2.getText(), Toast.LENGTH_SHORT).show();
    }

}