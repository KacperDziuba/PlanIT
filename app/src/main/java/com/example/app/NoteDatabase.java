package com.example.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


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

        String query = "CREATE TABLE "+ database_table +"("+key_id+" INT PRIMARY KEY, "+
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

    public long addNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(key_title,note.getTitle());
        c.put(key_text,note.getContent());
        c.put(key_data,note.getDate());
        c.put(key_time,note.getTime());

        long ID = db.insert(database_table,null,c);
        Log.d("Inserted","ID => "+ID);
        return ID;
    }

    public Note getNote(long id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=  db.query(database_table,new String[]{key_id,key_title,key_text,key_data,key_time},key_id+"=?",
                new String[] {String.valueOf(id)},null,null,null);
        if(cursor != null)
            cursor.moveToFirst();

        return new Note(
                cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));
    }

    public List<Note> getAllNotes(){

        SQLiteDatabase db = this.getReadableDatabase();
        List<Note> allNotes = new ArrayList<>();

        String query = "SELECT * FROM "+database_table;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor != null) {
            do {
                Note note = new Note();
                note.setId(cursor.getLong(0));
                note.setTitle(cursor.getString(1));
                note.setContent(cursor.getString(2));
                note.setDate(cursor.getString(3));
                note.setTime(cursor.getString(4));

                allNotes.add(note);
            }
            while (cursor.moveToNext());

        }
        return allNotes;
    }
}
