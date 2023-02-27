package com.example.e_health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Registration extends AppCompatActivity {

    TextView tv ,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        tv = findViewById(R.id.name);
        tv2 = findViewById(R.id.address);
        Intent it =getIntent();
        String userName = it.getStringExtra("UserName");
        String pass = it.getStringExtra("Password");

        tv.setText(userName);
        tv2.setText(pass);
    }
}