package com.androidhuman.example.notifications;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{

    Button btnPriority;
    Button btnLockscreen;
    Button btnColor;

    Button btnBridge;
    Button btnActions;
    Button btnVoiceInput;
    Button btnPaging;
    Button btnStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPriority = (Button) findViewById(R.id.btn_activity_main_priority);
        btnLockscreen = (Button) findViewById(R.id.btn_activity_main_lockscreen);
        btnColor = (Button) findViewById(R.id.btn_activity_main_color);
        btnBridge = (Button) findViewById(R.id.btn_activity_main_bridge_notification);
        btnActions = (Button) findViewById(R.id.btn_activity_main_notification_withaction);
        btnVoiceInput = (Button) findViewById(R.id.btn_activity_main_voice_input);
        btnPaging = (Button) findViewById(R.id.btn_activity_main_notification_paging);
        btnStack = (Button) findViewById(R.id.btn_activity_main_notification_stacking);

        btnPriority.setOnClickListener(this);
        btnLockscreen.setOnClickListener(this);
        btnColor.setOnClickListener(this);
        btnBridge.setOnClickListener(this);
        btnActions.setOnClickListener(this);
        btnVoiceInput.setOnClickListener(this);
        btnPaging.setOnClickListener(this);
        btnStack.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    public void onClick(View v) {
        Intent intent = new Intent();
        switch(v.getId()){
            case R.id.btn_activity_main_priority:
                intent.setClass(this, PriorityActivity.class);
                break;
            case R.id.btn_activity_main_lockscreen:
                intent.setClass(this, LockscreenActivity.class);
                break;
            case R.id.btn_activity_main_color:
                intent.setClass(this, ColorActivity.class);
                break;
            case R.id.btn_activity_main_bridge_notification:
                intent.setClass(this, BridgeActivity.class);
                break;
            case R.id.btn_activity_main_notification_withaction:
                intent.setClass(this, NotificationWithActionsActivity.class);
                break;
            case R.id.btn_activity_main_voice_input:
                intent.setClass(this, VoiceInputActivity.class);
                break;
            case R.id.btn_activity_main_notification_paging:
                intent.setClass(this, PagingActivity.class);
                break;
            case R.id.btn_activity_main_notification_stacking:
                intent.setClass(this, StackActivity.class);
                break;
        }
        startActivity(intent);
    }
}
