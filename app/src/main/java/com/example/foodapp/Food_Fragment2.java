package com.example.foodapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Food_Fragment2 extends Fragment {

    RecyclerView food_rcview;
    FoodAdapter foodAdapter;
    List<FoodItem_Model> list;

    public Food_Fragment2() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_food_2, container, false);

        list = new ArrayList<>();
        list.add(new FoodItem_Model(R.drawable.hotlecitea, "Hot Leci Tea ", "Rs. 120"));
        list.add(new FoodItem_Model(R.drawable.hotcoffeebrewed, "Hot Coffee Brewed", "Rs. 130"));
        list.add(new FoodItem_Model(R.drawable.icecoffee, "Ice Coffee", "Rs. 150"));
        list.add(new FoodItem_Model(R.drawable.cocacola, "Coca Cola ", "Rs. 100"));
        list.add(new FoodItem_Model(R.drawable.sprite, "Sprite ", "Rs. 100"));

        food_rcview = view.findViewById(R.id.food_rcview);
        foodAdapter = new FoodAdapter(list, getActivity().getApplicationContext(), false);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.HORIZONTAL, false);
        food_rcview.setLayoutManager(manager);
        food_rcview.setAdapter(foodAdapter);
        food_rcview.setHasFixedSize(true);

        return  view;



    }
}