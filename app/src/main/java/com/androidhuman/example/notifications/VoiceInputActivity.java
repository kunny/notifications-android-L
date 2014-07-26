package com.androidhuman.example.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class VoiceInputActivity extends Activity implements View.OnClickListener{

    Button btnBasicInput;
    Button btnPredefinedInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_input);

        btnBasicInput = (Button) findViewById(R.id.btn_activity_voice_input_basic);
        btnPredefinedInput = (Button) findViewById(R.id.btn_activity_voice_input_pre_defined);

        btnBasicInput.setOnClickListener(this);
        btnPredefinedInput.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.voice_input, menu);
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

        PendingIntent pi = PendingIntent.getActivity(this, 0,
                new Intent(this, VoiceInputResultActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteInput remoteInput = null;
        int notificationId = -1;

        NotificationManager mng = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        switch(view.getId()){
            case R.id.btn_activity_voice_input_basic:
                remoteInput = new RemoteInput.Builder(VoiceInputResultActivity.KEY_VOICE_INPUT)
                        .setLabel("Say message")
                        .build();
                notificationId = 0;
                break;
            case R.id.btn_activity_voice_input_pre_defined:
                remoteInput = new RemoteInput.Builder(VoiceInputResultActivity.KEY_VOICE_INPUT)
                        .setLabel("Say message")
                        .setChoices(getResources().getStringArray(R.array.reply_choices))
                        .build();
                notificationId = 1;
                break;
        }

        Notification.Action replyAction =
                new Notification.Action.Builder(R.drawable.ic_action_web_site, "Reply", pi)
                        .addRemoteInput(remoteInput).build();

        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_action_web_site)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.img_gaejugi))
                .setAutoCancel(true)
                .setContentTitle("John Doe")
                .setContentText("Lunch?")
                .extend(new Notification.WearableExtender().addAction(replyAction));

        mng.notify(notificationId, builder.build());
    }
}
