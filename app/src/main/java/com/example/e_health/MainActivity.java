package com.example.e_health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_health.database.db;

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
        db Db =new db(getApplicationContext(),"healthcare",null,1);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String userName = UserName.getText().toString();
                String password = Password.getText().toString();
                if (userName.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(), "Please Fill All the sata Field", Toast.LENGTH_SHORT).show();
                }else{
                    if(Db.login(userName,password)==1){
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                        SharedPreferences preferences= getSharedPreferences("shared_prefer", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("username",userName);
                        editor.apply();
                        startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    } else
                    {
                        Toast.makeText(getApplicationContext(), "Wrong Password and User Name", Toast.LENGTH_SHORT).show();
                    }
                }
//                Intent it = new Intent(MainActivity.this,Registration.class);
//                it.putExtra("UserName",UserName.getText().toString()); //nil UserName KAy value
//                it.putExtra("Password",Password.getText().toString());
//
//                startActivity(it);


            }
        });

        tv.setOnClickListener(new View.OnClickListener() {//button routing call kore ana hoicy
            @Override
            public void onClick(View view) {
                startActivity( new Intent(MainActivity.this,Registration.class));// routing kora holu
            }
        });



    }
}