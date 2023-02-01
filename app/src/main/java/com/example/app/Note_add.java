package com.example.app;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Note_add extends AppCompatActivity {
    Toolbar toolbar;
    EditText noteTitle,noteDetails;
    Calendar c;
    String todaysdate;
    String currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Nowa notatka");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        noteDetails = findViewById(R.id.noteDetails);
        noteTitle = findViewById(R.id.noteTitle);

        noteTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    getSupportActionBar().setTitle(s);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        c = Calendar.getInstance();
        todaysdate = c.get(Calendar.YEAR)+"/"+c.get(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.DAY_OF_MONTH);
        currentTime = pad(c.get(Calendar.HOUR))+":"+pad(c.get(Calendar.MINUTE));

        Log.d("calendar","Date and Time: " +  todaysdate +" and "+currentTime);
    }

    private String pad(int i) {
        if(i<10){
            return "0"+i;
        }
        return String.valueOf(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.delete){
            Toast.makeText(this, "Nie zapisano", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
        if(item.getItemId() == R.id.save){
            Note note = new Note(noteTitle.getText().toString(),noteDetails.getText().toString(),todaysdate,currentTime);
            NoteDatabase db = new NoteDatabase(this);
            db.addNote(note);
            Toast.makeText(this, "Zapisano", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}