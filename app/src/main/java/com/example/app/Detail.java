package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

public class Detail extends AppCompatActivity {
    long id;
    NoteDatabase db;
    Note note;
    EditText noteTitle,noteDetails;
    Calendar c;
    String todaysDate;
    String currentTime;
    long nId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        id = i.getLongExtra("ID", 2);
        db = new NoteDatabase(this);

        note = db.getNote(id);
        getSupportActionBar().setTitle(note.getTitle());
        noteDetails = findViewById(R.id.editNoteDetails);
        noteTitle = findViewById(R.id.editNoteTitle);
        noteTitle.setText(note.getTitle());
        noteDetails.setText(note.getContent());
        noteDetails.setMovementMethod(new ScrollingMovementMethod());


        c = Calendar.getInstance();
        todaysDate = c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.DAY_OF_MONTH);
        currentTime = pad(c.get(Calendar.HOUR))+":"+pad(c.get(Calendar.MINUTE));
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.delete){
            Toast.makeText(this, "Usunięto", Toast.LENGTH_SHORT).show();
            db.deleteNote(note.getId());
            startActivity(new Intent(getApplicationContext(),Notes.class));
        }
        if(item.getItemId() == R.id.save){

            note.setTitle(noteTitle.getText().toString());
            note.setContent(noteDetails.getText().toString());
            db = new NoteDatabase(getApplicationContext());
            long id = db.editNote(note);
            goToMain();
            Toast.makeText(this,"Zmieniono",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),Notes.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private String pad(int i) {
        if(i<10){
            return "0"+i;
        }
        return String.valueOf(i);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void goToMain() {
        Intent i = new Intent(this,Notes.class);
        startActivity(i);
    }
}

