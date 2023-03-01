package com.example.e_health.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query ="CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "userName TEXT,"+
                "description TEXT,"+
                "password TEXT)";
        sqLiteDatabase.execSQL(query);


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
}
