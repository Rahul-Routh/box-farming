package com.bxtrade.boxfarming.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bxtrade.boxfarming.Adapter.ProductDescriptionAdapter;
import com.bxtrade.boxfarming.R;

import java.util.ArrayList;
import java.util.List;

public class ProductDescriptionActivity extends AppCompatActivity {

    private RecyclerView productDescriptionRecycleView;
    private ProductDescriptionAdapter productDescriptionAdapter;

    private ArrayList<Integer> productDescriptionSellerImageArray;

    private List<String> productDistributorNameArray;
    private List<String> productDistributorAddressArray;
    private List<String> productQuantityArray;
    private List<String> productDistributorPhoneNoArray;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);

        productDescriptionRecycleView = findViewById(R.id.productDescriptionRecycleView);

        productDescription();

        productDescriptionAdapter = new ProductDescriptionAdapter(this,productDescriptionSellerImageArray,
                productDistributorNameArray, productDistributorAddressArray, productQuantityArray, productDistributorPhoneNoArray);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        productDescriptionRecycleView.setLayoutManager(gridLayoutManager);
        productDescriptionRecycleView.setAdapter(productDescriptionAdapter);


//        replyButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ProductDescriptionActivity.this, TraderNameActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        counter++;
        if (counter == 1) {
            Intent intent = new Intent(ProductDescriptionActivity.this, ProductListActivity.class);
            ProductDescriptionActivity.this.startActivity(intent);
            finish();
        }
    }
    public void productDescription(){
        productDescriptionSellerImageArray = new ArrayList<>();
        productDistributorNameArray = new ArrayList<>();
        productDistributorAddressArray = new ArrayList<>();
        productQuantityArray = new ArrayList<>();
        productDistributorPhoneNoArray = new ArrayList<>();

        productDescriptionSellerImageArray.add(R.drawable.tomato);
        productDescriptionSellerImageArray.add(R.drawable.vegetable);
        productDescriptionSellerImageArray.add(R.drawable.celery);
        productDescriptionSellerImageArray.add(R.drawable.mushrooms);
        productDescriptionSellerImageArray.add(R.drawable.cauliflower);
        productDescriptionSellerImageArray.add(R.drawable.tomato);
        productDescriptionSellerImageArray.add(R.drawable.tomato);
        productDescriptionSellerImageArray.add(R.drawable.tomato);

        productDistributorNameArray.add("Tomato Pusa Ruby - Desi");
        productDistributorNameArray.add("Tomato Red Beefsteak - Desi");
        productDistributorNameArray.add("Tomato Green Beefsteak - Desi");
        productDistributorNameArray.add("Tomato Cherry - Desi");
        productDistributorNameArray.add("Tomato Pusa Ruby - Desi");
        productDistributorNameArray.add("Tomato Red Beefsteak - Desi");
        productDistributorNameArray.add("Tomato Green Beefsteak - Desi");
        productDistributorNameArray.add("Tomato Cherry - Desi");

        productDistributorAddressArray.add("Jhargram Raghunathpur");
        productDistributorAddressArray.add("Jhargram New Bus Stand");
        productDistributorAddressArray.add("Jhargram RailWay Station");
        productDistributorAddressArray.add("Jhargram  Chilkigarh");
        productDistributorAddressArray.add("Jhargram Raghunathpur");
        productDistributorAddressArray.add("Jhargram New Bus Stand");
        productDistributorAddressArray.add("Jhargram RailWay Station");
        productDistributorAddressArray.add("Jhargram  Chilkigarh");

        productQuantityArray.add("Quantity - 40 Ton");
        productQuantityArray.add("Quantity - 120 Ton");
        productQuantityArray.add("Quantity - 50 Ton");
        productQuantityArray.add("Quantity - 80 Ton");
        productQuantityArray.add("Quantity - 60 Ton");
        productQuantityArray.add("Quantity - 100 Ton");
        productQuantityArray.add("Quantity - 100 Ton");
        productQuantityArray.add("Quantity - 100 Ton");

        productDistributorPhoneNoArray.add("Contact - 9003157055");
        productDistributorPhoneNoArray.add("Contact - 9003157055");
        productDistributorPhoneNoArray.add("Contact - 9003157055");
        productDistributorPhoneNoArray.add("Contact - 9003157055");
        productDistributorPhoneNoArray.add("Contact - 9003157055");
        productDistributorPhoneNoArray.add("Contact - 9003157055");
        productDistributorPhoneNoArray.add("Contact - 9003157055");
        productDistributorPhoneNoArray.add("Contact - 9003157055");
    }
}