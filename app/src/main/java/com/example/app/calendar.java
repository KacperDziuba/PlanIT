package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class calendar extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private EditText editText;
    int days;
    int month;
    int year;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Bundle bundle = getIntent().getExtras();
        year = bundle.getInt("year");
        month = bundle.getInt("month");
        days = bundle.getInt("day");
        editText = findViewById(R.id.textView4);
        load(days,month,year);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferences = getApplicationContext().getSharedPreferences("calendar_note",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("year",year);
                editor.putInt("month",month);
                editor.putInt("day",days);
                editor.putString("note",editText.getText().toString());
                editor.apply();

                startActivity(new Intent(calendar.this,Calendar_menu.class));
            }
        });


    }


    public void load(int day, int month, int year){
        sharedPreferences = getApplicationContext().getSharedPreferences("calendar_note",Context.MODE_PRIVATE);
        int syear = sharedPreferences.getInt("year",-1);
        int smonth = sharedPreferences.getInt("month",-1);
        int sday = sharedPreferences.getInt("day",-1);
        if (sday==day&&smonth==month&&syear==year){
            String notka = (sharedPreferences.getString("note","error"));
            editText.setText(notka);
        }


    }




    }


