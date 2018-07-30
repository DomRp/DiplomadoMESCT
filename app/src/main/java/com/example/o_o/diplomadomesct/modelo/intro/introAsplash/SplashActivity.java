package com.example.o_o.diplomadomesct.modelo.intro.introAsplash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.o_o.diplomadomesct.R;
import com.example.o_o.diplomadomesct.modelo.intro.introSwipes.IntroActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView ivLogoMESCyT = findViewById(R.id.ivLogoDescripMESCyT);
        Animation splashAnim = AnimationUtils.loadAnimation(this, R.anim.splash_transition);

        ivLogoMESCyT.startAnimation(splashAnim);

        final Intent i = new Intent(this, IntroActivity.class);

        Thread timer = new Thread() {

            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
