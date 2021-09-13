package com.example.foodapp;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodItem_Model implements Parcelable {

    int food_imgID;
    String food_nameID, food_priceID;


    public FoodItem_Model(int food_img, String food_name, String food_price) {
        this.food_imgID = food_img;
        this.food_nameID = food_name;
        this.food_priceID = food_price;
    }

    protected FoodItem_Model(Parcel in) {
        food_imgID = in.readInt();
        food_nameID = in.readString();
        food_priceID = in.readString();
    }

    public static final Creator<FoodItem_Model> CREATOR = new Creator<FoodItem_Model>() {
        @Override
        public FoodItem_Model createFromParcel(Parcel in) {
            return new FoodItem_Model(in);
        }

        @Override
        public FoodItem_Model[] newArray(int size) {
            return new FoodItem_Model[size];
        }
    };

    public int getFood_img() {return food_imgID;}

    public void setFood_img(int food_img) {this.food_imgID = food_img;}

    public String getFood_name() {return food_nameID;}

    public void setFood_name(String food_name) {this.food_nameID = food_name;}

    public String getFood_price() {return food_priceID;}

    public void setFood_price(String food_price) {this.food_priceID = food_price;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(food_imgID);
        dest.writeString(food_nameID);
        dest.writeString(food_priceID);
    }
}

