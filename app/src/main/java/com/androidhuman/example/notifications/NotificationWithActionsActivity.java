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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class NotificationWithActionsActivity extends Activity implements View.OnClickListener{

    Button btnActions;
    Button btnActionForWear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_with_actions);

        btnActions = (Button) findViewById(R.id.btn_activity_notification_withactions_actions);
        btnActionForWear = (Button) findViewById(R.id.btn_activity_notification_withactions_wearonly);

        btnActions.setOnClickListener(this);
        btnActionForWear.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.notification_with_actions, menu);
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

    @Override
    public void onClick(View view) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.drawable.ic_action_web_site)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.bg_wear_notes))
                .setAutoCancel(true)
                .setContentTitle("Notification with action")
                .setContentText("Notification content");
        NotificationManager mng = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent pi = PendingIntent.getActivity(this, 0,
                new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://android.com")),
                PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Action viewAction =
                new Notification.Action.Builder(R.drawable.ic_action_web_site, "View", pi).build();
        builder.addAction(viewAction);

        switch(view.getId()){
            case R.id.btn_activity_notification_withactions_actions:
                mng.notify(0, builder.build());
                break;
            case R.id.btn_activity_notification_withactions_wearonly:
                // Create wear only action
                PendingIntent piw = PendingIntent.getActivity(this, 0,
                        new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://android.com/wear")),
                        PendingIntent.FLAG_UPDATE_CURRENT);
                Notification.Action wearOnlyAction =
                        new Notification.Action.Builder(R.drawable.ic_action_web_site, "Wear only", piw).build();

                builder.extend(new Notification.WearableExtender().addAction(wearOnlyAction));
                mng.notify(1, builder.build());
                break;
        }
    }
}
