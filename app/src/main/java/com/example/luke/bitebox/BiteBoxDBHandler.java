package com.example.luke.bitebox;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Luke on 11/08/2017.
 */

public class BiteBoxDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "biteboxDB.db";


    public BiteBoxDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * creates a new database with keys name, dob and hospitalNumber for Patient entries
     * and employeeNumber, userName, log in pass and authType for users.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_USER = "CREATE TABLE " + BiteBoxDBKeys.USER_TABLE + "("
                + BiteBoxDBKeys.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + BiteBoxDBKeys.KEY_userName + " TEXT );";

        String CREATE_TABLE_PARENTAL = "CREATE TABLE " + BiteBoxDBKeys.PARENTAL_TABLE + "("
                + BiteBoxDBKeys.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + BiteBoxDBKeys.KEY_parentalUserName + " TEXT, "
                + BiteBoxDBKeys.KEY_parentalPassword + " TEXT );";

        String CREATE_TABLE_MEAL = "CREATE TABLE " + BiteBoxDBKeys.MEAL_TABLE + "("
                + BiteBoxDBKeys.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + BiteBoxDBKeys.KEY_mealName + " TEXT, "
                + BiteBoxDBKeys.KEY_mealPoints + " INTEGER, "
                + BiteBoxDBKeys.KEY_mealTime + " TEXT, "
                + BiteBoxDBKeys.KEY_mealImage + " BLOB );";

        db.execSQL(CREATE_TABLE_PARENTAL);
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_MEAL);
    }

    /**
     * upgrades database by deleting and creating a new database
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP USER_TABLE IF EXISTS " + BiteBoxDBKeys.USER_TABLE);
        db.execSQL("DROP PARENTAL_TABLE IF EXISTS " + BiteBoxDBKeys.PARENTAL_TABLE);
        db.execSQL("DROP MEAL_TABLE IF EXISTS " + BiteBoxDBKeys.MEAL_TABLE);

        //Create new tables
        onCreate(db);
    }


}
