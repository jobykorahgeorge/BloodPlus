package com.blood.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anooj on 01-Nov-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION=1;
    private static final String DATABASE_NAME="BloodPlus";
    private static final String TABLE_NAME="userdata";

    public static final String NAME = "name";
    public static final String FB_ID = "facebookid";
    public static final String USER_ID = "userid";
    public static final String PASSWORD = "password";
    public static final String EMAIL_ID = "email";
    public static final String DATE_OF_BIRTH = "dob";
    public static final String GENDER = "gender";
    public static final String MOBILE_NUMBER = "mobile";
    public static final String BLOOD_GROUP = "bloodgroup";
    public static final String WEIGHT = "weight";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
