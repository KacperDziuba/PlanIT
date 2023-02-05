package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button_notes = findViewById(R.id.button_note);
        Button button_alarm = findViewById(R.id.button_alarm);
        Button button_stopwatch = findViewById(R.id.button_stopwatch);
        Button button_timer = findViewById(R.id.button_timer);
        Button button_cal = findViewById(R.id.button_cal);

        button_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { OpenCalendar();
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

        button_stopwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenStopwatch();
            }
        });

        button_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenTimer();
            }

        });
    }
    public void openNotes() {
        Intent intent = new Intent(this, Notes.class);
        startActivity(intent);
    }

    public void OpenCalendar() {
        Intent intent = new Intent(this, Calendar_menu.class);
        startActivity(intent);
    }

    public void OpenAlarm() {
        Intent intent = new Intent(this, Alarm.class);
        startActivity(intent);
    }

    public void OpenStopwatch() {
        Intent intent = new Intent(this, Stopwatch.class);
        startActivity(intent);
    }

    public void OpenTimer() {
        Intent intent = new Intent(this, Timer .class);
        startActivity(intent);
    }




}