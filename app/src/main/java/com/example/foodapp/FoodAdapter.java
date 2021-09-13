package com.example.foodapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    List<FoodItem_Model> list;
    Context context;
    Boolean isGrid = false;

    public FoodAdapter(List<FoodItem_Model> list, Context context, Boolean isGrid) {
        this.isGrid = isGrid;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = null;
        if (isGrid){
            view = inflater.inflate(R.layout.layout_fooditem,parent,false);
        }else {
            view = inflater.inflate(R.layout.layout_fooditem1,parent,false);
        }
        return new FoodViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.food_imgID.setImageResource(list.get(position).food_imgID);
        holder.food_nameID.setText(list.get(position).food_nameID);
        holder.food_priceID.setText(list.get(position).food_priceID);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, FoodDetails.class);
                intent.putExtra("Food_Item", list.get(position));
//                intent.putExtra("food_priceID", list.get(position).getFood_price());
//                intent.putExtra("food_imgID", list.get(position).getFood_img());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView food_imgID;
        TextView food_nameID, food_priceID;
        View view;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            food_imgID = itemView.findViewById(R.id.food_imgID);
            food_nameID = itemView.findViewById(R.id.food_nameID);
            food_priceID = itemView.findViewById(R.id.food_priceID);
        }
    }
}






