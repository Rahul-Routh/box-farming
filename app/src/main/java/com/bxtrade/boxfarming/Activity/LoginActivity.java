package com.bxtrade.boxfarming.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.bxtrade.boxfarming.Global.NetworkState;
import com.bxtrade.boxfarming.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoginActivity extends AppCompatActivity {

    private EditText mobileNo_editText,otp_editText;
    private Button login_button;
    private TextView gotoSignUp;

    private NetworkState networkState;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mobileNo_editText = (EditText) findViewById(R.id.mobileNo_editText);
        otp_editText = (EditText) findViewById(R.id.otp_editText);
        login_button = (Button) findViewById(R.id.login_button);
        gotoSignUp = (TextView) findViewById(R.id.gotoSignUp);
        networkState = new NetworkState();

        //Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //mobile no
        awesomeValidation.addValidation(this,R.id.mobileNo_editText,
                "[5-9]{1}[0-9]{9}$",R.string.invalid_mobile);


        navigation();

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        gotoSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp();
            }
        });
    }

    public void Login() {
        if(networkState.isNetworkAvailable(this)) {
            if(awesomeValidation.validate()){
                Toast.makeText(getApplicationContext(),"Validation Successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ProductListActivity.class);
                this.startActivity(intent);
            }else {
                Toast.makeText(getApplicationContext(),"Validation Failed.",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this,"Please connect to internet", Toast.LENGTH_SHORT).show();
        }
        
    }
    public void SignUp(){
        if(networkState.isNetworkAvailable(this)) {
            Intent intent = new Intent(this, ProfileActivity.class);
            this.startActivity(intent);
        }else {
            Toast.makeText(this,"Please connect to internet", Toast.LENGTH_SHORT).show();
        }
    }

    public void navigation(){
        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.profile);

        //perform itemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),
                                MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.chat:
                        startActivity(new Intent(getApplicationContext(),
                                CustomerChatActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.gallery:
                        startActivity(new Intent(getApplicationContext(),
                                ProductListActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.favourite:
                        startActivity(new Intent(getApplicationContext(),
                                FavoriteActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        return true;
                }
                return false;
            }
        });
    }
}