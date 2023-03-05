package com.example.e_health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_health.database.db;
import com.example.e_health.model.Doctors;

public class AddDoctor extends AppCompatActivity {

    Button addBtn;
    EditText Docname,DocAddress,DocEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);


        Docname =findViewById(R.id.docName);
        DocAddress = findViewById(R.id.docAddress);
        DocEmail = findViewById(R.id.docMail);

        addBtn = findViewById(R.id.addDocBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName =Docname.getText().toString();
                String docAddress =DocAddress.getText().toString();
                String docEmail =DocEmail.getText().toString();

                System.out.println(userName + docAddress + docEmail);

                db database = new db(getApplicationContext(),"doctors",null,1);
                if(userName.length()==0 || docAddress.length()==0 || docEmail.length()==0){
                    Toast.makeText(getApplicationContext(),"Please fiil all field", Toast.LENGTH_SHORT).show();
                }else{
                    database.addDoctor(userName,docAddress,docEmail);
                    Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddDoctor.this,MainActivity.class));

                }

            }
        });

    }
}