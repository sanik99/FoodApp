package com.example.foodapp;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class SeeMore_Fragment extends Fragment {

List<FoodItem_Model> list;
RecyclerView seemore_recview;
    FoodAdapter adapter;
    ImageView back_btnn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_see_more, container, false);

        back_btnn = view.findViewById(R.id.back_btnn);
        back_btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Dash_Activity.class);
                startActivity(intent);
            }
        });

        list = new ArrayList<>();
        list.add(new FoodItem_Model(R.drawable.beefsandwich, "Lunch-meat Sandwiches", "Rs. 900"));
        list.add(new FoodItem_Model(R.drawable.oatmeal, "Oatmeal", "Rs. 150"));
        list.add(new FoodItem_Model(R.drawable.grilledcheese, "Grilled Cheese3 ", "Rs. 250"));
        list.add(new FoodItem_Model(R.drawable.soup, "Soups", "Rs. 200"));
        list.add(new FoodItem_Model(R.drawable.qquesadilla, "Beef Quesadillas", "Rs. 1000"));
        list.add(new FoodItem_Model(R.drawable.hotlecitea, "Hot Leci Tea ", "Rs. 120"));
        list.add(new FoodItem_Model(R.drawable.hotcoffeebrewed, "Hot Coffee Brewed", "Rs. 130"));
        list.add(new FoodItem_Model(R.drawable.icecoffee, "Ice Coffee", "Rs. 150"));
        list.add(new FoodItem_Model(R.drawable.cocacola, "Coca Cola ", "Rs. 100"));
        list.add(new FoodItem_Model(R.drawable.sprite, "Sprite ", "Rs. 100"));
        list.add(new FoodItem_Model(R.drawable.burger, "Burger ", "Rs. 250"));
        list.add(new FoodItem_Model(R.drawable.hotdog, "Hot Dog ", "Rs. 150"));
        list.add(new FoodItem_Model(R.drawable.frenchfries, "French Fries ", "Rs. 170"));
        list.add(new FoodItem_Model(R.drawable.noodles, "Noodles ", "Rs. 120"));
        list.add(new FoodItem_Model(R.drawable.deepfriedcrab, "Deep fried crab sticks ", "Rs. 300"));
        list.add(new FoodItem_Model(R.drawable.fingerchicken, "Finger Chicken", "Rs. 1200"));
        list.add(new FoodItem_Model(R.drawable.chickengrilled, "Chicken Grilled", "Rs. 1300"));
        list.add(new FoodItem_Model(R.drawable.chickengrilledbutter, "Chicken Grilled with Butter", "Rs. 1200"));
        list.add(new FoodItem_Model(R.drawable.chickenwrap, "Chicken Wrap", "Rs. 800"));
        list.add(new FoodItem_Model(R.drawable.chickenmasala, "Chicken Masala", "Rs. 1100"));
        list.add(new FoodItem_Model(R.drawable.swissroll, "Swiss ROll", "Rs. 150"));
        list.add(new FoodItem_Model(R.drawable.brownies, "Brownies", "Rs. 150"));
        list.add(new FoodItem_Model(R.drawable.waffles, "Waffles", "Rs. 220"));
        list.add(new FoodItem_Model(R.drawable.pancakes, "Pancakes", "Rs. 200"));
        list.add(new FoodItem_Model(R.drawable.cupcakes, "Cup Cakes", "Rs. 140"));
        list.add(new FoodItem_Model(R.drawable.america, "America", "Rs. 600"));
        list.add(new FoodItem_Model(R.drawable.budlightbeer, "Bud Light", "Rs. 600"));
        list.add(new FoodItem_Model(R.drawable.coronaextra, "Corona Extra", "Rs. 500"));
        list.add(new FoodItem_Model(R.drawable.gorkhabeer, "Gorkha Strong", "Rs. 300"));
        list.add(new FoodItem_Model(R.drawable.tuborg, "Tuborg", "Rs. 400"));
        seemore_recview = view.findViewById(R.id.seemore_recview);
        adapter = new FoodAdapter(list, getActivity().getApplicationContext(), true);
        GridLayoutManager manager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
      //  LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.VERTICAL, false);
        seemore_recview.setLayoutManager(manager);
        seemore_recview.setAdapter(adapter);
        seemore_recview.setHasFixedSize(true);
        return  view;


    }
}