package com.example.e_health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Button addDocBtn;

    CardView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefer", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Welcome "+userName+" " , Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this,MainActivity.class));

            }
        });
        addDocBtn = findViewById(R.id.btnAddDoc);

        addDocBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(HomeActivity.this, AddDoctor.class);
                startActivity(it);
            }
        });
        home=findViewById(R.id.cardLabTest);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(HomeActivity.this, doctor_list_view.class);
                startActivity(it);
            }
        });

//        CardView exit = findViewById(R.id.cardExit);
//
//        exit.setOnClickListener(){
//
//        };
    }
}