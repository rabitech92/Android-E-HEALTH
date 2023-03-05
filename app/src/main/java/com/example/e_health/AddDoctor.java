package com.example.e_health;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.e_health.database.db;

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
                db database = new db(getApplicationContext(),"doctors",null,1) ;

            }
        });

    }
}