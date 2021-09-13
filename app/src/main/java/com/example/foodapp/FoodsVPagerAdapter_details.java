package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FoodsVPagerAdapter_details extends PagerAdapter {

    Context context;
    ArrayList<Integer> image;

    public FoodsVPagerAdapter_details(Context context, ArrayList<Integer> image) {
        this.context = context;
        this.image = image;
    }

    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_view_pager_details, null);

        ImageView food_img3 = view.findViewById(R.id.food_img3);

//        Glide.with(context)
//                .asBitmap()
//                .load("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9b/Flag_of_Nepal.svg/100px-Flag_of_Nepal.svg.png")
//                .into(food_img3);

        Glide.with(context)
                .asBitmap()
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMzVtgmWYOyjuYBuaYMoGnNqDP9MLqkA_OH2zLBQQup8q0gdIwgBgyjNnzAo66nTYwHhg&usqp=CAU" )
                .into(food_img3);

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
