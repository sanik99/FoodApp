package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class FoodDetails extends AppCompatActivity {

    ViewPager viewpager2;
    ArrayList<Integer> image = new ArrayList<>();
    FoodsVPagerAdapter_details adapter;
    CircleIndicator circleIndicator;

    TextView food_nameBox, food_priceBox, addToCart_btn;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        FoodItem_Model foodItem_model = intent.getParcelableExtra("Food_Item");

        int foodImg = foodItem_model.getFood_img();
        String foodName = foodItem_model.getFood_name();
        String foodPrice = foodItem_model.getFood_price();


//        food_img3 = findViewById(R.id.food_img3);
//        food_img3.setFood_img(foodImg);

        food_nameBox = findViewById(R.id.food_nameBox);
        food_nameBox.setText(foodName);

        food_priceBox = findViewById(R.id.food_priceBox);
        food_priceBox.setText(foodPrice);


//        food_img3.setImageResource(intent.getIntExtra("food_imgID",R.drawable.ctandori));
//        food_nameBox.setText(intent.getStringExtra("food_nameID"));
//        food_priceBox.setText(intent.getStringExtra("food_priceID"));


        viewpager2 = findViewById(R.id.viewpager2);
        circleIndicator = findViewById(R.id.circleIndicator);

        image.add(R.drawable.momo);
        image.add(R.drawable.ctandori);
        image.add(R.drawable.momo);
        image.add(R.drawable.ctandori);

        adapter = new FoodsVPagerAdapter_details(this, image);
        viewpager2.setAdapter(adapter);
        circleIndicator.setViewPager(viewpager2);



        addToCart_btn = findViewById(R.id.addToCart_btn);

        addToCart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(FoodDetails.this, Checkout_activity.class));
            }
        });



    }
}