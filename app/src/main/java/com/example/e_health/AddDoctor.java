package com.example.e_health;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDoctor extends AppCompatActivity {

    Button addBtn;
    EditText Docname,DocAddress,DocEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);

        addBtn = findViewById(R.id.addDocBtn);
        Docname =findViewById(R.id.docName);
        DocAddress = findViewById(R.id.docAddress);
        DocEmail = findViewById(R.id.docMail);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}