package com.example.e_health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_health.database.db;

public class Registration extends AppCompatActivity {


    EditText Name,Description,Pass,Repass;
    Button btnLSignUp,loginbtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        Name = findViewById(R.id.name);
        Description = findViewById(R.id.description);
        Pass = findViewById(R.id.signPass);
        btnLSignUp = findViewById(R.id.signupbtn);
        Repass = findViewById(R.id.repass);
        loginbtn = findViewById(R.id.logbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Registration.this,MainActivity.class);
                startActivity(it);
            }
        });






        btnLSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName = Name.getText().toString();
                String UserDes = Description.getText().toString();
                String Password = Pass.getText().toString();
                String RePass =Repass.getText().toString();
                System.out.println(UserName + UserDes + Password);

              db Db =new db(getApplicationContext(),"healthcare",null,1);
              if(UserName.length()==0 ||Password.length()==0 ){
                  Toast.makeText(getApplicationContext(),"Please fiil all field", Toast.LENGTH_SHORT).show();
              }
              else{
                  if(Password.length()>4){
                      Db.addNewUser(UserName,UserDes,Password);
                      Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(Registration.this,MainActivity.class));
                  } else{

                    Toast.makeText(getApplicationContext(), "Invalid Password", Toast.LENGTH_SHORT).show();

                }


            }



//        Intent it =getIntent();
//        String userName = it.getStringExtra("UserName");//key value of main activity
//        String address = it.getStringExtra("address");
//        String pass = it.getStringExtra("Password");
//
//        Name.setText(userName);
//        Description.setText(address);
//        Pass.setText(pass);


    }


}
);}
}