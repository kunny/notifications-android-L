package com.androidhuman.example.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class StackActivity extends Activity {

    private static final String GROUP_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);

        Notification noti1 = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_action_web_site)
                .setContentTitle("John Doe")
                .setContentText("Lorem ipsum dolor sit amet")
                .setGroup(GROUP_MESSAGE)
                .build();

        Notification noti2 = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_action_web_site)
                .setContentTitle("Nam lobortis")
                .setContentText("Duis sodales tortor in diam")
                .setGroup(GROUP_MESSAGE)
                .build();

        NotificationManager mng = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mng.notify(0, noti1);
        mng.notify(1, noti2);

        Notification summary = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_action_web_site)
                .setContentTitle("Messages")
                .setContentText("2 new messages")
                .setStyle(new Notification.InboxStyle()
                    .addLine("John Doe   Lorem ipsum dolor sit amet")
                    .addLine("Nam lobortis   Duis sodales tortor in diam")
                    .setBigContentTitle("2 messages")
                    .setSummaryText("your@account.com"))
                .setGroup(GROUP_MESSAGE)
                .setGroupSummary(true)
                .extend(new Notification.WearableExtender()
                        .setBackground(BitmapFactory.decodeResource(
                                getResources(), R.drawable.img_gaejugi)))
                .build();

        mng.notify(3, summary);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.stack, menu);
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
