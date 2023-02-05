package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Calendar_menu extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        CalendarView calendar = findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                Intent intent = new Intent(Calendar_menu.this,calendar.class);
                Bundle bundle = new Bundle();
                bundle.putInt("year",i);
                bundle.putInt("month",i1);
                bundle.putInt("day",i2);
                intent.putExtras(bundle);

            startActivity(intent);
            }
        });


    }



}