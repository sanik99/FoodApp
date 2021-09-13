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

public class Food_Fragment6 extends Fragment {

    RecyclerView food_rcview;
    FoodAdapter foodAdapter;
    List<FoodItem_Model> list;

    public Food_Fragment6() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_food_6, container, false);

        list = new ArrayList<>();
        list.add(new FoodItem_Model(R.drawable.america, "America", "Rs. 600"));
        list.add(new FoodItem_Model(R.drawable.budlightbeer, "Bud Light", "Rs. 600"));
        list.add(new FoodItem_Model(R.drawable.coronaextra, "Corona Extra", "Rs. 500"));
        list.add(new FoodItem_Model(R.drawable.gorkhabeer, "Gorkha Strong", "Rs. 300"));
        list.add(new FoodItem_Model(R.drawable.tuborg, "Tuborg", "Rs. 400"));

        food_rcview = view.findViewById(R.id.food_rcview);
        foodAdapter = new FoodAdapter(list, getActivity().getApplicationContext(), false);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.HORIZONTAL, false);
        food_rcview.setLayoutManager(manager);
        food_rcview.setAdapter(foodAdapter);
        food_rcview.setHasFixedSize(true);

        return  view;



    }
}