package com.bxtrade.boxfarming.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.bxtrade.boxfarming.Global.NetworkState;
import com.bxtrade.boxfarming.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    private TextView gotoSignIn;
    private Spinner category,state,district;
    private EditText mobileNo_editText;
    private Button registration_button;

    private NetworkState networkState;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        gotoSignIn = (TextView) findViewById(R.id.gotoSignIn);
        category = (Spinner) findViewById(R.id.category);
        state = (Spinner) findViewById(R.id.state);
        district = (Spinner) findViewById(R.id.district);
        mobileNo_editText = (EditText) findViewById(R.id.mobileNo_editText);
        registration_button = (Button) findViewById(R.id.registration_button);

        networkState = new NetworkState();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ProfileActivity.this,
                R.layout.list_selected_font, getResources().getStringArray(R.array.category));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(ProfileActivity.this,
                R.layout.list_selected_font, getResources().getStringArray(R.array.state));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(adapter2);


        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(ProfileActivity.this,
                R.layout.list_selected_font, getResources().getStringArray(R.array.district));
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        district.setAdapter(adapter3);

        //Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //mobile no
        awesomeValidation.addValidation(this,R.id.mobileNo_editText,
                "[5-9]{1}[0-9]{9}$",R.string.invalid_mobile);


//
//        Spinner category = (Spinner) findViewById(R.id.category);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ProfileActivity.this,
//                R.layout.list_selected_font, getResources().getStringArray(R.array.category));
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        category.setAdapter(adapter);
//
//        Spinner state = (Spinner) findViewById(R.id.state);
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(ProfileActivity.this,
//                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.state));
//        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        state.setAdapter(adapter2);
//
//        Spinner district = (Spinner) findViewById(R.id.district);
//        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(ProfileActivity.this,
//                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.district));
//        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        district.setAdapter(adapter3);

        registration_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validName();
            }
        });

        navigation();

        gotoSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignIn();
            }
        });
    }

    public void validName(){
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

    public void SignIn(){
        if(networkState.isNetworkAvailable(this)) {
            Intent intent = new Intent(this, LoginActivity.class);
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