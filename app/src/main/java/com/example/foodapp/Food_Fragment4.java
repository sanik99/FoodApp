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

public class Food_Fragment4 extends Fragment {

    RecyclerView food_rcview;
    FoodAdapter foodAdapter;
    List<FoodItem_Model> list;

    public Food_Fragment4() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_food_4, container, false);

        list = new ArrayList<>();
        list.add(new FoodItem_Model(R.drawable.fingerchicken, "Finger Chicken", "Rs. 1200"));
        list.add(new FoodItem_Model(R.drawable.chickengrilled, "Chicken Grilled", "Rs. 1300"));
        list.add(new FoodItem_Model(R.drawable.chickengrilledbutter, "Chicken Grilled with Butter", "Rs. 1200"));
        list.add(new FoodItem_Model(R.drawable.chickenwrap, "Chicken Wrap", "Rs. 800"));
        list.add(new FoodItem_Model(R.drawable.chickenmasala, "Chicken Masala", "Rs. 1100"));

        food_rcview = view.findViewById(R.id.food_rcview);
        foodAdapter = new FoodAdapter(list, getActivity().getApplicationContext(), false);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.HORIZONTAL, false);
        food_rcview.setLayoutManager(manager);
        food_rcview.setAdapter(foodAdapter);
        food_rcview.setHasFixedSize(true);

        return  view;



    }
}