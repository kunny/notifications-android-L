package com.androidhuman.example.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class ColorActivity extends Activity implements View.OnClickListener{

    Button btnColoredIconBackground;
    Button btnWithLargeIcon;
    Button btnInvalidIconAsset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        btnColoredIconBackground = (Button) findViewById(R.id.btn_activity_color_icon_background_color);
        btnWithLargeIcon = (Button) findViewById(R.id.btn_activity_color_icon_background_color_withlargeicon);
        btnInvalidIconAsset = (Button) findViewById(R.id.btn_activity_color_icon_invalid_icon);

        btnColoredIconBackground.setOnClickListener(this);
        btnWithLargeIcon.setOnClickListener(this);
        btnInvalidIconAsset.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.color, menu);
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
        NotificationManager mng = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        switch(view.getId()){
            case R.id.btn_activity_color_icon_background_color:
                builder.setSmallIcon(R.drawable.ic_action_web_site)
                        .setColor(Color.argb(1, 0, 153, 204))
                        .setContentTitle("Colored notification")
                        .setContentText("Hello color!");
                mng.notify(0, builder.build());
                break;
            case R.id.btn_activity_color_icon_background_color_withlargeicon:
                builder.setSmallIcon(R.drawable.ic_action_web_site)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.bg_wear_notes))
                        .setColor(Color.argb(1, 0, 153, 204))
                        .setContentTitle("Colored notification")
                        .setContentText("Now with large icon");
                mng.notify(1, builder.build());
                break;
            case R.id.btn_activity_color_icon_invalid_icon:
                builder.setSmallIcon(R.drawable.ic_action_web_site_green)
                        .setColor(Color.argb(1, 0, 153, 204))
                        .setContentTitle("Invalid icon asset")
                        .setContentText("Supports only white icon with transparent background");
                mng.notify(2, builder.build());
                break;
        }

    }
}
