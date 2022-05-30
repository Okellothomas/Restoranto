package com.pro.myrestauranto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Restaurant_Activity extends AppCompatActivity {

    // declaring tag for the purposes of carrying out test
    public static final String TAG = Restaurant_Activity.class.getSimpleName();

    // declare the mLocationtextVeiw;
    // private TextView textView;
    // declare the listview
    // private ListView mListView;

    // using the butterknife for binding
    @BindView(R.id.listViewone) TextView textView;
    @BindView(R.id.locationTextView) ListView mListView;

    // declaring the list of restaurant we will be using
    private String[] restaurants = new String[] {"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    private String[] cuisines = new String[] {"Vegan Food", "Breakfast", "Fishs Dishs", "Scandinavian", "Coffee", "English Food", "Burgers", "Fast Food", "Noodle Soups", "Mexican", "BBQ", "Cuban", "Bar Food", "Sports Bar", "Breakfast", "Mexican" };


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        ButterKnife.bind(this);

        //carry out the type casting.
        textView = (TextView) findViewById(R.id.listViewone);
        mListView = (ListView) findViewById(R.id.locationTextView);

        // we create the new arrayAdapter
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants);
        MyRestaurantsArrayAdapter arrayAdapter = new MyRestaurantsArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines);
        mListView.setAdapter(arrayAdapter);
        // create a new instance of intent

       mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String restaurant = ((TextView)view).getText().toString();
               Toast.makeText(Restaurant_Activity.this, restaurant, Toast.LENGTH_SHORT).show();
               Log.v(TAG,"In the onItemClickListiner");
           }
       });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        textView.setText("Here are all the restaurants near: " + location);
        Log.d(TAG, "In the Oncreate Method.");

    }
}