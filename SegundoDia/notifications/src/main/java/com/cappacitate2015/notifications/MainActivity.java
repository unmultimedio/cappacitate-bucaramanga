package com.cappacitate2015.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = 0;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void makeNotification(View view){
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);

        builder.setSmallIcon(R.drawable.android_icon);
        builder.setContentTitle("Mi Primera Notificación");
        builder.setContentText("Hola Primera Notificación");

        builder.setTicker("Hola Ticker");
        builder.setContentInfo("12!");
        //builder.setOngoing(true);
        builder.setAutoCancel(true);

        Intent intent = new Intent(this,
                ResponseNotification.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                1,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        builder.setContentIntent(pendingIntent);

        NotificationManager nm =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification myNotification = builder.build();

        nm.notify(counter++, myNotification);
    }
}
