package com.example.usuario.ejemploalarmaybroadcastreceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button alarma, cancelar;
    final static int CODIGO_ALARMA = 111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarma = findViewById(R.id.buttonAlarma);
        cancelar = findViewById(R.id.buttonCancelar);
        alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(getApplicationContext(), Alarma.class);

                PendingIntent pendingIntent =
                        PendingIntent.getBroadcast(getApplicationContext(), CODIGO_ALARMA,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),60*1000, pendingIntent);

            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(getApplicationContext(), Alarma.class);

                PendingIntent pendingIntent =
                        PendingIntent.getBroadcast(getApplicationContext(), CODIGO_ALARMA,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.cancel(pendingIntent);

            }
        });
    }
}
