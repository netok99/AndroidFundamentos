package com.androidfundamentos;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public class Alarme {

    private Context context;
    private PendingIntent mAlarmSender;

    public Alarme(Context context) {
        this.context = context;
        mAlarmSender = PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0);
    }

    public void startAlarm(int seconds){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, seconds);
        long firstTime = c.getTimeInMillis();

        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, firstTime, mAlarmSender);
    }

    public void cancelAlarm(){
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.cancel(mAlarmSender);
    }

}
