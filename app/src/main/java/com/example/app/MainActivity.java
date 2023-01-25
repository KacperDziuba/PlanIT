package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_cal = findViewById(R.id.button_cal);
        Button button_notes = findViewById(R.id.button_note);
        Button button_alarm = findViewById(R.id.button_alarm);

        button_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenCalendar();
            }
        });

        button_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotes();
            }
        });

        button_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenAlarm();
            }
        });
    }
    public void openNotes() {
        Intent intent = new Intent(this, Notes.class);
        startActivity(intent);
    };

    public void OpenCalendar() {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
    }

    public void OpenAlarm() {
        Intent intent = new Intent(this, Alarm.class);
        startActivity(intent);
    }
}