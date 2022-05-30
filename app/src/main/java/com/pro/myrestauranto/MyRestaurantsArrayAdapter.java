package com.pro.myrestauranto;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyRestaurantsArrayAdapter extends ArrayAdapter{
    private Context mContext;
    private String[] mRestaurants;
    private String[] mCuisines;

    public MyRestaurantsArrayAdapter(Context mContext, int resource, String[] mRestaurants, String[] mCuisines){
        super(mContext, resource);
        this.mContext = mContext;
        this.mRestaurants = mRestaurants;
        this.mCuisines = mCuisines;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        String restaurant = mRestaurants[position];
        String cuisine = mCuisines[position];
        return String.format("%s \n Serves Great: %s", restaurant, cuisine);
    }

    @Override
    public int getCount() {
        return mRestaurants.length;
    }
}
