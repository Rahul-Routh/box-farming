package com.bxtrade.boxfarming.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bxtrade.boxfarming.R;

public class NotificationActivity extends AppCompatActivity {
   // TextView notificationTextView;
    //String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        TextView notificationTextView = findViewById(R.id.notificationTextView);
        String message = getIntent().getStringExtra("message");
        notificationTextView.setText(message);

    }
}