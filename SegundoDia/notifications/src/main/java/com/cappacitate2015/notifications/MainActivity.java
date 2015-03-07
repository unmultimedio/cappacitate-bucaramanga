package com.cappacitate2015.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


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

    public String noEmpty(String val){
        if(val != null && !val.isEmpty())
            return val;
        else
            return "NO-DATA";
    }

    public void makeNotification(View view){

        String title = ((EditText)findViewById(R.id.title)).getText().toString();
        String content = ((EditText)findViewById(R.id.content)).getText().toString();
        String ticker = ((EditText)findViewById(R.id.ticker)).getText().toString();
        String contentInfo = ((EditText)findViewById(R.id.content_info)).getText().toString();

        title = noEmpty(title);
        content = noEmpty(content);
        ticker = noEmpty(ticker);
        contentInfo = noEmpty(contentInfo);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);

        builder.setSmallIcon(R.drawable.android_icon);
        builder.setContentTitle(title);
        builder.setContentText(content);

        builder.setSound(new Uri.Builder().path("").build());

        builder.setTicker(ticker);
        builder.setContentInfo(contentInfo);
        //builder.setOngoing(true);
        builder.setAutoCancel(true);

        Intent intent = new Intent(this,
                ResponseNotification.class);

        intent.putExtra("title",title);
        intent.putExtra("content",content);
        intent.putExtra("ticker",ticker);
        intent.putExtra("content_info",contentInfo);

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
