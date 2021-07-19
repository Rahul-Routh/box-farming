package com.bxtrade.boxfarming.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.bxtrade.boxfarming.Adapter.CustomerChatAdapter;
import com.bxtrade.boxfarming.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class CustomerChatActivity extends AppCompatActivity {

    private RecyclerView customerChatRecycleView;
    private CustomerChatAdapter customerChatAdapter;

    private List<String> respondCodeArray;
    private List<String> cropNameArray;
    private List<String> productQuantityArray;
    private List<String> rateArray;
    private List<String> expectedDateArray;
    private List<String> farmer_nameArray;
    private List<String> productDistributorPhoneNoArray;

    private List<String> offerRateArray;
    private List<String> demandQuantityArray;
    private List<String> date_demandArray;

    private List<String> repeatArray;
    private List<String> modifyArray;
    private List<String> respondArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_chat);

        customerChatRecycleView = findViewById(R.id.customerChatRecycleView);
        navigation();
        customerChat();

        customerChatAdapter = new CustomerChatAdapter(this,
                respondCodeArray, cropNameArray, productQuantityArray, rateArray,expectedDateArray, farmer_nameArray, productDistributorPhoneNoArray,
                offerRateArray, demandQuantityArray, date_demandArray, repeatArray, modifyArray, respondArray);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        customerChatRecycleView.setLayoutManager(gridLayoutManager);
        customerChatRecycleView.setAdapter(customerChatAdapter);

    }

    private void customerChat(){
        respondCodeArray = new ArrayList<>();
        cropNameArray = new ArrayList<>();
        productQuantityArray = new ArrayList<>();
        rateArray = new ArrayList<>();
        expectedDateArray = new ArrayList<>();
        farmer_nameArray = new ArrayList<>();
        productDistributorPhoneNoArray = new ArrayList<>();

        offerRateArray = new ArrayList<>();
        demandQuantityArray = new ArrayList<>();
        date_demandArray = new ArrayList<>();

        repeatArray = new ArrayList<>();
        modifyArray = new ArrayList<>();
        respondArray = new ArrayList<>();

        respondCodeArray.add("QT-2000077BM");
        cropNameArray.add("Tomato-Desi");
        productQuantityArray.add("200 Ton");
        rateArray.add("240 Per/Ton");
        expectedDateArray.add("Feb 2020");
        farmer_nameArray.add("Amit Kumar");
        productDistributorPhoneNoArray.add("3120001055");

        offerRateArray.add("200 Per/Ton");
        demandQuantityArray.add("50 Ton");
        date_demandArray.add("22 Dec 2020");

        repeatArray.add("REPEAT");
        modifyArray.add("MODIFY");
        respondArray.add("RESPOND");

    }




    public void navigation(){
        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.chat);

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
                        startActivity(new Intent(getApplicationContext(),
                                ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}