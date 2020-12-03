package com.example.pertemuan5mobile;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends Activity {


            // Splash screen time in milliseconds
            private static final long LOADING_TIME = 2000;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_splash_screen);

                Thread timer = new Thread() {
                    public void run() {
                        try {
                            sleep(LOADING_TIME);
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        } finally {
                            Intent openMainActivity = new Intent(SplashScreenActivity.this, MainActivity.class);
                            startActivity(openMainActivity);
                            SplashScreenActivity.this.finish();
                        }
                    }
                };

                timer.start();
            }
        }
