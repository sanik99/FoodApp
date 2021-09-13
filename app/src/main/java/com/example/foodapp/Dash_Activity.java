package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class Dash_Activity extends AppCompatActivity {

    TabLayout tablayout;
    ViewPager viewpager;
    TextView seemore_btn;
    ImageView ordersImg;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        if ( !isConnected( this)){
            showInternetDialog();
        }


        seemore_btn = findViewById(R.id.seemore_btn);
        seemore_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                SeeMore_Fragment fragment = new SeeMore_Fragment();
                fm.beginTransaction().replace(R.id.dash,fragment).commit();
            }
        });


        tablayout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);

        tablayout.addTab(tablayout.newTab().setText("Foods")); //1
        tablayout.addTab(tablayout.newTab().setText("Drinks")); //2
        tablayout.addTab(tablayout.newTab().setText("Snacks")); //3
        tablayout.addTab(tablayout.newTab().setText("Chicken")); //4
        tablayout.addTab(tablayout.newTab().setText("Deserts")); //5
        tablayout.addTab(tablayout.newTab().setText("Beers")); //6
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final FoodItem_Adapter adapter = new FoodItem_Adapter(getSupportFragmentManager(), tablayout.getTabCount());
        viewpager.setAdapter(adapter);

        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(@NonNull TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


        bottomNavigationView = findViewById(R.id.ButtomNavigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Homepage.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.favourite:
                        startActivity(new Intent(getApplicationContext(), Favourite_Activity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),User_Profile_Activity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.history:
                        startActivity(new Intent(getApplicationContext(),History_Activity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        ordersImg = findViewById(R.id.ordersImg);
        ordersImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dash_Activity.this, Order_Activity.class));
            }
        });


    }

    private void showInternetDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);

        View view = LayoutInflater.from(this).inflate(R.layout.no_internet, findViewById(R.id.no_internet));
        view.findViewById(R.id.tryAgain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isConnected(Dash_Activity.this)){
                    showInternetDialog();
                } else {
                    startActivity(new Intent(getApplicationContext(), Dash_Activity.class));
                    finish();
                }
            }
        });

        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }


    private boolean isConnected (Dash_Activity dash_Activity){

        ConnectivityManager connectivityManager = (ConnectivityManager) dash_Activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        return (wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected());
    }
}