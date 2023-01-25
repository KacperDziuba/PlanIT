package com.example.app;


import android.os.Bundle;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Note_add extends AppCompatActivity {
    Toolbar toolbar;
    EditText noteTitle,noteDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        noteDetails = findViewById(R.id.noteDetails);
        noteTitle = findViewById(R.id.noteTitle);

    }
}