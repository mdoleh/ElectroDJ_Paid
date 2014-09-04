package com.doleh.ElectroDJ_Paid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.doleh.Jukebox.MainActivity;

public class LaunchActivity extends Activity
{
    private static final int SPLASH_TIMEOUT = 3000;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LaunchActivity.this, MainActivity.class);
                i.putExtra(MainActivity.SHOW_ADS, false);
                i.putExtra(MainActivity.APP_PNAME, getPackageName());
                i.putExtra(MainActivity.APP_TITLE, getString(R.string.app_name));
                startActivity(i);
            }
        }, SPLASH_TIMEOUT);
    }
}
