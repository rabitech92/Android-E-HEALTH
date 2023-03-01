package com.example.e_health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefer", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Welcome "+userName+" " , Toast.LENGTH_SHORT).show();

//        CardView exit = findViewById(R.id.cardExit);
//
//        exit.setOnClickListener(){
//
//        };
    }
}