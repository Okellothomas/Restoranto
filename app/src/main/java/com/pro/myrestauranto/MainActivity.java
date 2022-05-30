package com.pro.myrestauranto;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // method declaration
//    private Button button;
//    private EditText editText;
    @BindView(R.id.findRestaurantButton) Button button;
    @BindView(R.id.locationEditText)TextView editText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // type casting the button.
//        button = (Button) findViewById(R.id.findRestaurantButton);
//        editText = (EditText) findViewById(R.id.locationEditText);
//

        button.setOnClickListener(this);

        // setting the onclick event listiner.

    }

    @Override
    public void onClick(View v) {

        // creating the condition:
        if (v == button){
            // making a toast
//                Toast.makeText(MainActivity.this, "Okellothomas", Toast.LENGTH_SHORT).show();
            // setting the intent
            String location = editText.getText().toString();
            Intent intent = new Intent(MainActivity.this, Restaurant_Activity.class);
//                Log.d(TAG,location );
//                Toast.makeText(MainActivity.this, location, Toast.LENGTH_SHORT).show();

            // pass the date to the next activity.
            intent.putExtra("location", location);
            startActivity(intent);
        }
        }
}