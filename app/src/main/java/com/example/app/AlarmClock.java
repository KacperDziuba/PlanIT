package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Date;

public class AlarmClock extends AppCompatActivity implements View.OnClickListener {

    private TimePicker timePicker;
    private Button buttonSet;
    Calendar cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_clock);

        buttonSet = findViewById(R.id.set_alarm);
        timePicker = findViewById(R.id.time);
        buttonSet.setOnClickListener(this);

    }

    public void onClick (View view) {

        cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH),
                timePicker.getHour(),
                timePicker.getMinute(),0);
        Alarm_set(cal.getTimeInMillis());
    }

    private void Alarm_set(long timeInMillis) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,Alarm.class);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,(int)cal.getTimeInMillis(),intent,0);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pendingIntent);
        } else {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pendingIntent);
        }

        Toast.makeText(this,"Ustawiono alarm",Toast.LENGTH_SHORT).show();
    }

}