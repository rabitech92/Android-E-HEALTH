package com.example.e_health.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.e_health.model.Doctors;

import java.util.ArrayList;
import java.util.HashMap;

public class db  extends SQLiteOpenHelper {

    public db(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public db(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

//    public db(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
//        super(context, name, version, openParams);
//    }

    private  static final String TABLE_NAME = "user";
    private  static final String ID_COL = "id";
    private  static final String USER_NAME = "userName";
    private  static final String DESCRIPTION = "description";
    private  static final String PASSWORD = "password";

    //DOCTORS
    private  static final String TABLE = "Doctors";
    private  static final String id = "id";
    private  static final String name = "doctorName";
    private  static final String address= "doctorAddress";
    private  static final String email = "email";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query ="CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "userName TEXT,"+
                "description TEXT,"+
                "password TEXT)";
        sqLiteDatabase.execSQL(query);

        // Doctors table

        String query2 ="CREATE TABLE doctors (id INTEGER PRIMARY KEY AUTOINCREMENT,"+

                "doctorName TEXT,"+
                "doctorAddress TEXT,"+
                "email TEXT)";
        sqLiteDatabase.execSQL(query2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addNewUser( String userName, String description, String password){
        SQLiteDatabase Db =this.getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put(USER_NAME, userName);
        values.put(DESCRIPTION,description );
        values.put(PASSWORD,password);

        Db.insert(TABLE_NAME,null, values);
        Db.close();
    }

//    doctor add method start
    public void addDoctor(Doctors doc){
        SQLiteDatabase Db =this.getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put("doctorName", doc.getDoctorName());
        values.put("doctorAddress",doc.getDoctorAddress() );
        values.put("email",doc.getEmail());

        Db.insert("Doctors",null, values);
        Db.close();
    }
    //    doctor add method End
    public  int login(String userName, String password){
        String [] arr = new String [2];
        arr[0] =userName;
        arr[1] =password;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from user where userName=? and password =? ", arr);
        if (c.moveToFirst()){
            return 1;
        }
        return  0;
    }

    public ArrayList<HashMap<String ,String>> getDoctors(){
        HashMap<String,String> doctor;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from doctors ",null);
        ArrayList<HashMap<String, String>> doctorList =new ArrayList<>(c.getCount());
        if (c.moveToFirst()){
            do {
                doctor =new HashMap<>();
                doctor.put("id",c.getString(0));
                doctor.put("userName",c.getString(1));
                doctor.put("address",c.getString(2));
                doctor.put("Email",c.getString(3));
                doctorList.add(doctor);

            }while (c.moveToFirst());
        }
        db.close();
        return doctorList;

    }
    public boolean deleteDoctor(int id){
        SQLiteDatabase db =this.getWritableDatabase();
        int rowCount =db.delete("doctors","id", new String[]{id+""});
        db.close();
        return rowCount>0;
    }

}
