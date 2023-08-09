package com.example.nyaay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper1 extends SQLiteOpenHelper {
    public static final String DBNAME = "Login1.db";

    public DBHelper1(Context context) {
        super(context, "Login1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("Create Table users1(email TEXT primary key,username TEXT,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users1");
    }
    public Boolean insertData(String email,String username,String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = MyDB.insert("users1",null,contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkemail(String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users1 where email = ?",new String[]{email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkusernamepassemail(String email,String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users1 where email = ? and  password = ?",new String[]{email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
