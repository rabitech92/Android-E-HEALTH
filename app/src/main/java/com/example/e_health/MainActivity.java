package com.example.e_health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText UserName,Password;
    Button btn;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserName= findViewById(R.id.userName);// main xml hoty id neya
        Password = findViewById(R.id.userPassword);
        btn = findViewById(R.id.button);
        tv =findViewById(R.id.register);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this,Registration.class);
                it.putExtra("UserName",UserName.getText());
                it.putExtra("Password",Password.getText());
//            startActivity( new Intent(MainActivity.this,Registration.class));// routing kora holu

            }
        });



    }
}