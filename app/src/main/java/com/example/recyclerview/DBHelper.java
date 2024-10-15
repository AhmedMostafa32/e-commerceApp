package com.example.recyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="Login.db";
    //constract class DV
    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users (email_field Text primary key,pass_field Text,fullname_field Text )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }
    public Boolean insertData (String email_field, String pass_field, String fullname_field){
        SQLiteDatabase MyDB =this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("email_field", (email_field));
        contentValues.put("pass_field", (pass_field));
        contentValues.put("fullname_field",(fullname_field));
        long result =MyDB.insert("users",null,contentValues );
        if (result==-1)
            return false;
        else
            return true;
    }
    public Boolean checkuseremail(String email_field){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where email_field =?",new String[] {email_field});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkusernameemailpassword(String pass_field,String fullname_field){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor =MyDB.rawQuery("Select * from users where pass_field = ? and fullname_field = ? " ,new String[] {pass_field,fullname_field});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
