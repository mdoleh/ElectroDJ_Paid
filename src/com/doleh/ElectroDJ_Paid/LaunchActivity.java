package com.doleh.ElectroDJ_Paid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.doleh.Jukebox.Config;
import com.doleh.Jukebox.MainActivity;

public class LaunchActivity extends Activity
{
    private static final int SPLASH_TIMEOUT = 3000;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (Config.SHOW_SPLASH_SCREEN)
        {
            setContentView(R.layout.splash_screen);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = createIntent();
                    startActivity(i);
                }
            }, SPLASH_TIMEOUT);
        }
        else
        {
            Intent i = createIntent();
            startActivity(i);
        }
    }

    private Intent createIntent()
    {
        Intent i = new Intent(LaunchActivity.this, MainActivity.class);
        i.putExtra(Config.SHOULD_SHOW_ADS_KEY, false);
        i.putExtra(Config.APP_PNAME_KEY, getPackageName());
        i.putExtra(Config.APP_TITLE_KEY, getString(R.string.app_name));
        i.putExtra(Config.APP_PAID_KEY, true);
        i.putExtra(Config.MAX_MESSAGE_COUNT_KEY, 10);
        i.putExtra(Config.AUTO_PLAY_KEY, true);
        return i;
    }
}
