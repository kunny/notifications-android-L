package com.androidhuman.example.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class PagingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.drawable.ic_action_web_site)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.bg_wear_notes))
                .setContentTitle("Paging notification")
                .setContentText("Main content");

        Notification secondPage = new Notification.Builder(this)
                .setStyle(new Notification.BigTextStyle()
                        .setBigContentTitle("Android")
                        .bigText("Android powers hundreds of millions of mobile devices in more than 190 countries around the world. It's the largest installed base of any mobile platform and growing fast—every day another million users power up their Android devices for the first time and start looking for apps, games, and other digital content."))
                .build();

        Notification thirdPage = new Notification.Builder(this)
                .extend(new Notification.WearableExtender().setHintShowBackgroundOnly(true))
                .setStyle(new Notification.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.img_gaejugi)))
                .build();

        Notification pagingNotification = new Notification.WearableExtender()
                .addPage(secondPage)
                .addPage(thirdPage)
                .extend(builder).build();

        NotificationManager mng = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mng.notify(0, pagingNotification);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.paging, menu);
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
