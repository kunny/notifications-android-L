package com.androidhuman.example.notifications;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.widget.Button;

import com.androidhuman.example.notifications.R;

public class PriorityActivity extends Activity implements View.OnClickListener {

    Button btnMax;
    Button btnHigh;
    Button btnDefault;
    Button btnLow;
    Button btnMin;
    Button btnHun;
    Button btnFullscreenIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_priority);

        btnMax = (Button) findViewById(R.id.btn_activity_priority_max);
        btnHigh = (Button) findViewById(R.id.btn_activity_priority_high);
        btnDefault = (Button) findViewById(R.id.btn_activity_priority_default);
        btnLow = (Button) findViewById(R.id.btn_activity_priority_low);
        btnMin = (Button) findViewById(R.id.btn_activity_priority_min);
        btnHun = (Button) findViewById(R.id.btn_activity_priority_hun_with_actions);
        btnFullscreenIntent = (Button) findViewById(R.id.btn_activity_priority_fullscreen_intent);

        btnMax.setOnClickListener(this);
        btnHigh.setOnClickListener(this);
        btnDefault.setOnClickListener(this);
        btnLow.setOnClickListener(this);
        btnMin.setOnClickListener(this);
        btnHun.setOnClickListener(this);
        btnFullscreenIntent.setOnClickListener(this);
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            // TODO: If Settings has multiple levels, Up should navigate up
            // that hierarchy.
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Notification.Builder builder =
                new Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_action_web_site)
                        .setContentText("Notification text");

        NotificationManager mng = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        switch(view.getId()){
            case R.id.btn_activity_priority_max:
                builder.setPriority(Notification.PRIORITY_MAX)
                        .setContentTitle("Max priority")
                        .setDefaults(Notification.DEFAULT_VIBRATE);
                mng.notify(0, builder.build());
                break;
            case R.id.btn_activity_priority_high:
                builder.setPriority(Notification.PRIORITY_HIGH)
                        .setContentTitle("High priority")
                        .setDefaults(Notification.DEFAULT_VIBRATE);
                mng.notify(1, builder.build());
                break;
            case R.id.btn_activity_priority_default:
                builder.setPriority(Notification.PRIORITY_DEFAULT)
                        .setContentTitle("Default priority")
                        .setDefaults(Notification.DEFAULT_VIBRATE);
                mng.notify(2, builder.build());
                break;
            case R.id.btn_activity_priority_low:
                builder.setPriority(Notification.PRIORITY_LOW)
                        .setContentTitle("Low priority")
                        .setDefaults(Notification.DEFAULT_VIBRATE);
                mng.notify(3, builder.build());
                break;
            case R.id.btn_activity_priority_min:
                builder.setPriority(Notification.PRIORITY_MIN)
                        .setContentTitle("Minimum priority")
                        .setDefaults(Notification.DEFAULT_VIBRATE);
                mng.notify(4, builder.build());
                break;
            case R.id.btn_activity_priority_hun_with_actions:
                builder.setPriority(Notification.PRIORITY_HIGH)
                        .setContentTitle("GDG Korea Android Conference")
                        .setContentText("Today, 13:00")
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .addAction(
                                new Notification.Action.Builder(
                                        android.R.drawable.ic_menu_directions, "View in maps",
                                        PendingIntent.getActivity(this, 0,
                                                new Intent(Intent.ACTION_VIEW)
                                                        .setData(Uri.parse("geo:37.495411,127.038833")), 0))
                                        .build());
                mng.notify(5, builder.build());
                break;

            case R.id.btn_activity_priority_fullscreen_intent:
                PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://android.com")), 0);
                builder.setFullScreenIntent(pi, true)
                        .setContentIntent(pi)
                        .setContentTitle("Notification with Fullscreen Intent")
                        .setContentText("Content text");
                mng.notify(6, builder.build());
                break;

        }
    }
}
