package com.androidhuman.example.notifications;

import android.app.Activity;
import android.app.RemoteInput;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class VoiceInputResultActivity extends Activity {

    public static final String KEY_VOICE_INPUT = "voice_input";

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_input_result);

        tvResult = (TextView) findViewById(R.id.tv_activity_voice_input_result);

        Bundle remoteInput = RemoteInput.getResultsFromIntent(getIntent());
        if(remoteInput!=null){
            CharSequence result = remoteInput.getCharSequence(KEY_VOICE_INPUT);
            tvResult.setText(result);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.voice_input_result, menu);
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
