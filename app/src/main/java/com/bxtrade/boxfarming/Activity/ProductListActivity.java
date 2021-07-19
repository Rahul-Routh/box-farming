package com.bxtrade.boxfarming.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.bxtrade.boxfarming.Adapter.ProductListAdapter;
import com.bxtrade.boxfarming.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {
    private RecyclerView productListRecycleView;
    private ArrayList<Integer> productImagesArray;
    private ArrayList<String> productNameArray;
    private ArrayList<String> productPriceArray;
    private ProductListAdapter productListAdapter;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        navigation();

        productListRecycleView = findViewById(R.id.productListRecycleView);

        productList();

        productListAdapter = new ProductListAdapter(this,productNameArray,productImagesArray,productPriceArray);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        productListRecycleView.setLayoutManager(gridLayoutManager);
        productListRecycleView.setAdapter(productListAdapter);

    }

    @Override
    public void onBackPressed() {
        counter++;
        if (counter == 1){
            Snackbar.make(productListRecycleView,"Do you really want back",Snackbar.LENGTH_LONG).show();
        }else if (counter == 2){
            finish();
//            Intent intent = new Intent(ProductListActivity.this, MainActivity.class);
//            ProductListActivity.this.startActivity(intent);
        }
    }
    public void productList(){
        productNameArray = new ArrayList<>();
        productImagesArray = new ArrayList<>();
        productPriceArray = new ArrayList<>();

        productNameArray.add("Cauliflower");
        productNameArray.add("Tomato");
        productNameArray.add("Celery");
        productNameArray.add("Green Chili Peppers");
        productNameArray.add("Mushrooms");
        productNameArray.add("Red Chili");
        productNameArray.add("Tomato");
        productNameArray.add("Cauliflower");
        productNameArray.add("Celery");
        productNameArray.add("Green Chili Peppers");
        productNameArray.add("Mushrooms");
        productNameArray.add("Red Chili");

        productImagesArray.add(R.drawable.cauliflower);
        productImagesArray.add(R.drawable.tomato);
        productImagesArray.add(R.drawable.celery);
        productImagesArray.add(R.drawable.greenchilipeppers);
        productImagesArray.add(R.drawable.mushrooms);
        productImagesArray.add(R.drawable.vegetable);
        productImagesArray.add(R.drawable.tomato);
        productImagesArray.add(R.drawable.cauliflower);
        productImagesArray.add(R.drawable.celery);
        productImagesArray.add(R.drawable.greenchilipeppers);
        productImagesArray.add(R.drawable.mushrooms);
        productImagesArray.add(R.drawable.vegetable);

        productPriceArray.add("Rs. 30/KG");
        productPriceArray.add("Rs. 80/KG");
        productPriceArray.add("Rs. 150/KG");
        productPriceArray.add("Rs. 160/KG");
        productPriceArray.add("Rs. 224/KG");
        productPriceArray.add("Rs. 110/KG");
        productPriceArray.add("Rs. 40/KG");
        productPriceArray.add("Rs. 15/Pic");
        productPriceArray.add("Rs. 150/KG");
        productPriceArray.add("Rs. 160/KG");
        productPriceArray.add("Rs. 224/KG");
        productPriceArray.add("Rs. 110/KG");
    }

    public void navigation(){
        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.gallery);

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