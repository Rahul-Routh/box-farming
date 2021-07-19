package com.bxtrade.boxfarming.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.bxtrade.boxfarming.R;

public class SplashActivity extends AppCompatActivity {

    ImageView splashImg;
    TextView logo_textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashImg = findViewById(R.id.img_splash);
        logo_textView = findViewById(R.id.logo_textView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent  = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

                finish();
            }
        },3000);

    }
}