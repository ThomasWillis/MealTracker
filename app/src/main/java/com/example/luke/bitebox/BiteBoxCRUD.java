package com.example.luke.bitebox;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static com.example.luke.bitebox.BiteBoxDBKeys.USER_TABLE;

/**
 * Created by Luke on 11/08/2017.
 */

public class BiteBoxCRUD {

    private BiteBoxDBHandler dbHandler;
    private long id;
    private BiteBoxDBKeys keys;

    public BiteBoxCRUD(Context context){
        dbHandler = new BiteBoxDBHandler(context);
        this.id = 0;
    }



    public void insertUser(User user){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BiteBoxDBKeys.KEY_userName, user.getName());
        db.insert(USER_TABLE, null, values);
        db.close();
    }

    public void insertParental(Parental parental){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(BiteBoxDBKeys.KEY_parentalUserName, parental.getParentUserName());
        values.put(BiteBoxDBKeys.KEY_parentalPassword, parental.getParentPassword());
        db.insert(BiteBoxDBKeys.PARENTAL_TABLE, null, values);
        db.close();
    }

    public void insertMeal(Food food){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BiteBoxDBKeys.KEY_mealName, food.name);
        values.put(BiteBoxDBKeys.KEY_mealPoints, food.points);
        values.put(BiteBoxDBKeys.KEY_mealTime, food.mealTime);
        values.put(BiteBoxDBKeys.KEY_mealImage, food.mealImage);
        db.close();
    }

    public User returnUser(){
        String selectQuery = "SELECT * FROM " + USER_TABLE;
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor!=null){
            cursor.moveToFirst();
            cursor.getString(0);
            
        }


    }







}
