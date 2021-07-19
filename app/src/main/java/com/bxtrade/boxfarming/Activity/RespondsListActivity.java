package com.bxtrade.boxfarming.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.bxtrade.boxfarming.Adapter.RespondsListAdapter;
import com.bxtrade.boxfarming.R;

import java.util.ArrayList;
import java.util.List;

public class RespondsListActivity extends AppCompatActivity {

    private RecyclerView respondsListRecycleView;
    private RespondsListAdapter respondsListAdapter;

    private List<String> respondCodeArray;
    private List<String> dateRespondsArray;
    private List<String> itemNameArray;
    private List<String> quantityArray;
    private List<String> sellerNameArray;
    private List<String> sellerContactArray;
    private List<String> respondedOrNotRespondedArray;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responds_list);

        respondsListRecycleView = findViewById(R.id.respondsListRecycleView);


        respondsList();


        respondsListAdapter = new RespondsListAdapter(this,
                respondCodeArray,dateRespondsArray,itemNameArray,quantityArray,
                sellerNameArray,sellerContactArray,respondedOrNotRespondedArray);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        respondsListRecycleView.setLayoutManager(gridLayoutManager);
        respondsListRecycleView.setAdapter(respondsListAdapter);
    }

    @Override
    public void onBackPressed() {
        counter++;
        if (counter == 1) {
            Intent intent = new Intent(RespondsListActivity.this, TraderNameActivity.class);
            RespondsListActivity.this.startActivity(intent);
            finish();
        }
    }

    private void respondsList() {
        respondCodeArray = new ArrayList<>();
        dateRespondsArray = new ArrayList<>();
        itemNameArray = new ArrayList<>();
        quantityArray = new ArrayList<>();
        sellerNameArray = new ArrayList<>();
        sellerContactArray = new ArrayList<>();
        respondedOrNotRespondedArray = new ArrayList<>();

        respondCodeArray.add("QT-299788FV");
        respondCodeArray.add("QT-309978KH");
        respondCodeArray.add("QT-338879DH");
        respondCodeArray.add("QT-342072BN");
        respondCodeArray.add("QT-299788FV");
        respondCodeArray.add("QT-309978KH");
        respondCodeArray.add("QT-338879DH");
        respondCodeArray.add("QT-342072BN");

        dateRespondsArray.add("24 Jan 2020");
        dateRespondsArray.add("26 Jun 2020");
        dateRespondsArray.add("28 Jun 2020");
        dateRespondsArray.add("05 July 2020");
        dateRespondsArray.add("24 Jan 2020");
        dateRespondsArray.add("26 Jun 2020");
        dateRespondsArray.add("28 Jun 2020");
        dateRespondsArray.add("05 July 2020");

        itemNameArray.add("Tomato - Desi");
        itemNameArray.add("Radish - Desi");
        itemNameArray.add("Bottle ground - Desi");
        itemNameArray.add("Brinjal - Desi");
        itemNameArray.add("Tomato - Desi");
        itemNameArray.add("Radish - Desi");
        itemNameArray.add("Bottle ground - Desi");
        itemNameArray.add("Brinjal - Desi");

        quantityArray.add("200 Ton");
        quantityArray.add("120 Ton");
        quantityArray.add("220 Ton");
        quantityArray.add("160 Ton");
        quantityArray.add("200 Ton");
        quantityArray.add("120 Ton");
        quantityArray.add("220 Ton");
        quantityArray.add("160 Ton");

        sellerNameArray.add("Amit Kumar");
        sellerNameArray.add("Prabhat Kumar");
        sellerNameArray.add("Jai Prakash Yadav");
        sellerNameArray.add("Bina Manjhi Devi");
        sellerNameArray.add("Amit Kumar");
        sellerNameArray.add("Prabhat Kumar");
        sellerNameArray.add("Jai Prakash Yadav");
        sellerNameArray.add("Bina Manjhi Devi");

        sellerContactArray.add("9009001234");
        sellerContactArray.add("9009002888");
        sellerContactArray.add("2200865520");
        sellerContactArray.add("9900880055");
        sellerContactArray.add("9009001234");
        sellerContactArray.add("9009002888");
        sellerContactArray.add("2200865520");
        sellerContactArray.add("9900880055");

        respondedOrNotRespondedArray.add("Responded");
        respondedOrNotRespondedArray.add("Not Responded yet");
        respondedOrNotRespondedArray.add("Responded");
        respondedOrNotRespondedArray.add("Responded");
        respondedOrNotRespondedArray.add("Responded");
        respondedOrNotRespondedArray.add("Not Responded yet");
        respondedOrNotRespondedArray.add("Responded");
        respondedOrNotRespondedArray.add("Responded");
    }
}