package com.example.apple.tagalong;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2/22/17.
 */

public class DataHandler extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="TagAlong.db";
    public static final int DATABASE_VERSION= 1;

    public static final String TABLE_EVENTS="Events";
    public static final String COLUMN_EVENT_ID="EVENT_ID";
    public static final String COLUMN_EVENT_NAME="EVENT_NAME";
    public static final String COLUMN_EVENT_LOCATION="EVENT_LOCATION";
    public static final String COLUMN_EVENT_DESCRIPTION="EVENT_DESCRIPTION";
    public static final String COLUMN_EVENT_DAY="EVENT_DAY";
    public static final String COLUMN_EVENT_TIME="EVENT_TIME";

    List<String> eventName;
    Cursor mCursor;

    public DataHandler(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_EVENT_TABLE = "CREATE TABLE "
                + TABLE_EVENTS + " (" + COLUMN_EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EVENT_NAME + " VARCHAR(30), " +
                COLUMN_EVENT_DESCRIPTION + " TEXT, " +
                COLUMN_EVENT_LOCATION + " VARCHAR(30), " +
                COLUMN_EVENT_DAY + " DATETIME)";

        System.out.println("SQL"+CREATE_EVENT_TABLE);

        db.execSQL(CREATE_EVENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_EVENTS);

        onCreate(db);

    }

    public void addEvent(Event event){

        ContentValues values = new ContentValues();

        values.put(COLUMN_EVENT_NAME,event.getEventName());
        values.put(COLUMN_EVENT_LOCATION,event.getLocation());
        values.put(COLUMN_EVENT_DESCRIPTION,event.getDesciption());
        //values.put(COLUMN_EVENT_DAY,event.getEventDate().toString());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_EVENTS,null,values);

        System.out.println("DEBUG added");

        db.close();

    }

    public List<String> getEventName(){

        eventName = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();

        mCursor = db.query(TABLE_EVENTS,new String[]{COLUMN_EVENT_NAME},null,null,null,null,null);

        mCursor.moveToFirst();

        if(mCursor != null) {
            while (mCursor.moveToNext()) {

                eventName.add(mCursor.getString(mCursor.getColumnIndex(COLUMN_EVENT_NAME)));
            }
        }

        return eventName;

    }

    public Cursor getEventDetails(){

        SQLiteDatabase db = this.getReadableDatabase();

        mCursor = db.query(TABLE_EVENTS,new String[]{COLUMN_EVENT_NAME,COLUMN_EVENT_DESCRIPTION,COLUMN_EVENT_LOCATION},null,null,null,null,null);

        mCursor.moveToFirst();

        return mCursor;

    }
}
