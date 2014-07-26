package com.androidhuman.example.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.androidhuman.example.notifications.R;

public class BridgeActivity extends Activity {

    CheckBox cbBridgeNotification;
    Button btnShowNotification;

    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridge);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        cbBridgeNotification = (CheckBox) findViewById(R.id.cb_activity_bridge);
        btnShowNotification = (Button) findViewById(R.id.btn_activity_bridge_show_notification);
        btnShowNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification notification =
                        new Notification.Builder(BridgeActivity.this)
                                .setSmallIcon(R.drawable.ic_launcher)
                                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.bg_wear_notes))
                                .setContentTitle("Android.com")
                                .setContentText("Check out news from android.com!")
                                .setLocalOnly(!cbBridgeNotification.isChecked())
                                .setAutoCancel(true)
                                .build();

                notificationManager.notify(0, notification);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bridge, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
