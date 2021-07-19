package com.bxtrade.boxfarming.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.bxtrade.boxfarming.Global.NetworkState;
import com.bxtrade.boxfarming.R;
import com.google.android.material.snackbar.Snackbar;

import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TraderNameActivity extends AppCompatActivity {
    private TextView traderName, cropName, variety, totalQuantity, rate, expectedDate;
    private ImageView galleryImage, traceability;
    private Switch interested;
    private EditText quantityDemand, date_demand;
    private CardView traderNameLayout;

    private int counter = 0;
    private Button submitTradeNameButton;
    private NetworkState networkState;

    AwesomeValidation awesomeValidation;

    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tradername);

        traderNameLayout = (CardView) findViewById(R.id.traderNameLayout);

        traderName = (TextView) findViewById(R.id.traderName);
        cropName = (TextView) findViewById(R.id.cropName);
        variety = (TextView) findViewById(R.id.variety);
        totalQuantity = (TextView) findViewById(R.id.totalQuantity);
        rate = (TextView) findViewById(R.id.rate);
        expectedDate = (TextView) findViewById(R.id.expectedDate);
        galleryImage = (ImageView) findViewById(R.id.galleryImage);
        traceability = (ImageView) findViewById(R.id.traceability);
        interested = (Switch) findViewById(R.id.interested);
        quantityDemand = (EditText) findViewById(R.id.quantityDemand);
        date_demand = (EditText) findViewById(R.id.date_demand);
        submitTradeNameButton = (Button) findViewById(R.id.submitTradeNameButton);

        networkState = new NetworkState();

        calender();

        submitTradeNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(networkState.isNetworkAvailable(TraderNameActivity.this)) {
                    if (quantityDemand.length() == 0) {
                        quantityDemand.setError("Enter Demand Value");
                    } else if (date_demand.length() == 0) {
                        date_demand.setError("Enter Date");
                    } else {
                        Intent intent = new Intent(TraderNameActivity.this, RespondsListActivity.class);
                        TraderNameActivity.this.startActivity(intent);
                    }
                }else{
                    Toast.makeText(TraderNameActivity.this, "Please connect to internet", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        counter++;
        if (counter == 1) {
            Intent intent = new Intent(TraderNameActivity.this, ProductDescriptionActivity.class);
            TraderNameActivity.this.startActivity(intent);
            finish();
        }
    }
    public void calender(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        date_demand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        TraderNameActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        date_demand.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
    }
}