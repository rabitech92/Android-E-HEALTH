package com.example.e_health;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.e_health.database.db;

import java.util.ArrayList;

public class doctor_list_view extends AppCompatActivity {

    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list_view);

        db Db =new db(getApplicationContext(),"healthcare",null,1);
        list =Db.getDoctors();
        System.out.println(list.size());
        System.out.println("--------------");

        sa =new SimpleAdapter(this,
                list,
                R.layout.doctor_list,
                new String []{" id" , "userName","address","email"},
                new int []{R.id.line_2,R.id.line_3, R.id.line_4,R.id.line_5,R.id.line_6});
        ListView lv=findViewById(R.id.listViewId);
        lv.setAdapter(sa);
    }
}