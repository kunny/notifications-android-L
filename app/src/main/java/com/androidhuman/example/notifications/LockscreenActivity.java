package com.androidhuman.example.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.androidhuman.example.notifications.R;

public class LockscreenActivity extends Activity implements View.OnClickListener{

    Button btnPublic;
    Button btnPrivate;
    Button btnPrivateWithCustomPublic;
    Button btnSecret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockscreen);

        btnPublic = (Button) findViewById(R.id.btn_activity_lockscreen_public);
        btnPrivate = (Button) findViewById(R.id.btn_activity_lockscreen_private);
        btnPrivateWithCustomPublic = (Button) findViewById(R.id.btn_activity_lockscreen_private_custompublic);
        btnSecret = (Button) findViewById(R.id.btn_activity_lockscreen_secret);

        btnPublic.setOnClickListener(this);
        btnPrivate.setOnClickListener(this);
        btnPrivateWithCustomPublic.setOnClickListener(this);
        btnSecret.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lockscreen, menu);
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
        builder.setSmallIcon(R.drawable.ic_action_web_site);

        NotificationManager mng = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        switch(view.getId()){
            case R.id.btn_activity_lockscreen_public:
                builder.setContentTitle("Public notification")
                        .setContentText("Public notification content")
                        .setVisibility(Notification.VISIBILITY_PUBLIC)
                        .setColor(Color.argb(1, 0, 153, 204));
                mng.notify(0, builder.build());
                break;
            case R.id.btn_activity_lockscreen_private:
                builder.setContentTitle("Private notification")
                        .setContentText("Private notification content")
                        .setVisibility(Notification.VISIBILITY_PRIVATE)
                        .setColor(Color.argb(1, 204, 0, 0));
                mng.notify(1, builder.build());
                break;
            case R.id.btn_activity_lockscreen_private_custompublic:
                builder.setContentTitle("Private notification")
                        .setContentText("Private notification content")
                        .setVisibility(Notification.VISIBILITY_PRIVATE)
                        .setColor(Color.argb(1, 204, 0, 0))
                        .setPublicVersion(
                                new Notification.Builder(this)
                                        .setColor(Color.argb(1, 0, 153, 204))
                                        .setSmallIcon(R.drawable.ic_action_web_site)
                                        .setContentText("Public version of private content")
                                        .setContentTitle("Public version")
                                        .build());
                mng.notify(2, builder.build());
                break;
            case R.id.btn_activity_lockscreen_secret:
                // Setting visibility to secret also hides notification
                // from notification bar - it's a bug
                // https://code.google.com/p/android-developer-preview/issues/detail?id=93
                builder.setContentTitle("Secret notification")
                        .setContentText("Secret notification content")
                        .setVisibility(Notification.VISIBILITY_SECRET);
                mng.notify(3, builder.build());
                break;
        }
    }

}
