package com.example.e_health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.e_health.database.db;
import com.example.e_health.model.Doctors;

import java.util.ArrayList;
import java.util.HashMap;

public class doctor_list_view extends AppCompatActivity {

    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list_view);

        db Db =new db(getApplicationContext(),"doctors",null,1);
        list =Db.getDoctors();
        System.out.println(list.size());
        System.out.println("--------------");

        sa =new SimpleAdapter(this,
                list,
                R.layout.doctor_list,
                new String []{" id" , "userName","address","email"},
                new int []{R.id.line_2,R.id.line_3, R.id.line_4,R.id.line_5,}
        )
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v=super.getView(position, convertView, parent);
                ImageView imeEdit = v.findViewById(R.id.edit);
                ImageView imeDelete = v.findViewById(R.id.delete);

                imeEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        HashMap<String,String> doctors;
                        try {
                            doctors=(HashMap<String,String>)list.get(position);
                            Intent intent =new Intent(doctor_list_view.this, Registration.class);
                            intent.putExtra("id",Integer.parseInt(doctors.get("id")));
                            intent.putExtra("userName",doctors.get("userName"));
                            intent.putExtra("address",doctors.get("address"));
                            intent.putExtra("email",doctors.get("email"));
                            startActivity(intent);

                        }catch (Exception e){
                            e.printStackTrace();
                        }


                    }
                });


                imeDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        HashMap<String,String> doctors;
                        try {
                            doctors =(HashMap<String, String>)  list.get(position);
                            boolean deleted =Db.deleteDoctor(Integer.parseInt(doctors.get("id"))) ;
                            if(deleted){
                                list.remove(position);
                                notifyDataSetChanged();
                            }
                            String message = deleted ?"Successfully Deleted": "Failed to delete";
                            Toast.makeText(getApplicationContext(), "message", Toast.LENGTH_SHORT).show();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });


                return super.getView(position, convertView, parent);
            }
        };
        ListView lv=findViewById(R.id.listViewId);
        lv.setAdapter(sa);
    }

}