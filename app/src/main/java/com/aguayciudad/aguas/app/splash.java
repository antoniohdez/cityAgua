package com.aguayciudad.aguas.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import java.util.Timer;
import java.util.TimerTask;


public class splash extends Activity {

    private static final long splashTime = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /*Code for splash*/
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// For setting portrait orientation
        requestWindowFeature(Window.FEATURE_NO_TITLE); //For hiding the title bar
        setContentView(R.layout.activity_splash);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent().setClass(splash.this, MapsActivity.class);
                startActivity(intent);
                finish();
            }
        };

        /*Timer*/
        Timer timer = new Timer();
        timer.schedule(task, splashTime);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
