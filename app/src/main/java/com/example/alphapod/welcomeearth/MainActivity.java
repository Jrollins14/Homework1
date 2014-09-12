package com.example.alphapod.welcomeearth;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;



public class MainActivity extends Activity {

    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySong = MediaPlayer.create(MainActivity.this, R.raw.welcome);
        mySong.start();
        blinkText();
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

    private void blinkText() {

        final Handler handler = new Handler();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    int timeToBlink = 500;
                    try {
                        Thread.sleep(timeToBlink);
                    }
                    catch (Exception e){

                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            TextView txt = (TextView) findViewById(R.id.textView);
                            if(txt.getVisibility()== View.VISIBLE) {
                                txt.setVisibility(View.INVISIBLE);
                            }
                            else {
                                txt.setVisibility(View.VISIBLE);
                            }
                            blinkText();
                        }
                    });
                }
            }).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySong.release();
        finish();
    }
}
