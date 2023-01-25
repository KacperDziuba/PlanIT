package com.example.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class NoteDatabase extends SQLiteOpenHelper {

    private static final int database_version = 2;
    private static final String database_name = "notedb";
    private static final String database_table = "notesTable";

    private static final String key_id = "id";
    private static final String key_title = "title";
    private static final String key_text = "text";
    private static final String key_data = "data";
    private static final String key_time = "time";


    NoteDatabase(Context context) {
        super(context, database_name,null,database_version);
    }

    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE "+ database_name +"("+key_id+" INT PRIMARY KEY, "+
                key_title + " TEXT, "+
                key_text + " TEXT, "+
                key_data + " TEXT, "+
                key_time + " TEXT"+")";

        db.execSQL(query);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS "+database_table);
        onCreate(db);
    }
}
