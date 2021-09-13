package com.example.foodapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FoodItem_Adapter extends FragmentPagerAdapter {
    int tabcounts;

    public FoodItem_Adapter(FragmentManager fm, int tabcounts){
        super(fm);
        this.tabcounts = tabcounts;
    }

    public Fragment getItem(int position){
        switch (position){
            case 0:
                Food_Fragment1 food_fragment1 = new Food_Fragment1();
                return food_fragment1;


            case 1:
                Food_Fragment2 food_fragment2 = new Food_Fragment2();
                return food_fragment2;

            case 2:
                Food_Fragment3 food_fragment3 = new Food_Fragment3();
                return food_fragment3;

            case 3:
                Food_Fragment4 food_fragment4 = new Food_Fragment4();
                return food_fragment4;

            case 4:
                Food_Fragment5 food_fragment5 = new Food_Fragment5();
                return food_fragment5;

            case 5:
                Food_Fragment6 food_fragment6 = new Food_Fragment6();
                return food_fragment6;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {return tabcounts;}

}
