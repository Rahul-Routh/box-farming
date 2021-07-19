package com.bxtrade.boxfarming.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.bxtrade.boxfarming.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Initialize variable
   // private GoogleMap map;
    GoogleMap mMap;
    private int counter = 0;
    CoordinatorLayout mainLayout;

    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;
    SearchView searchView;
    BottomSheetBehavior bottomSheetBehavior;
    BottomNavigationView bottom_navigation;
    LinearLayout bottomSheetLayout;
    ImageView vegTomato,vegCauliflower,vegRedChili,vegGreenChiliPeppers;


    //array
    ArrayList<LatLng> arrayList = new ArrayList<LatLng>();
    LatLng Tomato = new LatLng(22.441682, 86.989388);
    LatLng Cauliflower = new LatLng(22.439159, 86.995204);
    LatLng RedChili = new LatLng(22.441521, 87.000608);
    LatLng GreenChiliPepper = new LatLng(22.444238, 86.995630);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (CoordinatorLayout) findViewById(R.id.mainLayout);
        bottom_navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        //Assign variable
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.google_map);
        searchView = findViewById(R.id.search_location);
        bottomSheetLayout = findViewById(R.id.bottom_sheet);

        vegTomato = findViewById(R.id.tomato);
        vegCauliflower = findViewById(R.id.cauliflower);
        vegRedChili = findViewById(R.id.redChili);
        vegGreenChiliPeppers = findViewById(R.id.greenChiliPeppers);

        vegTomato.setOnClickListener( this);
        vegCauliflower.setOnClickListener((View.OnClickListener) this);
        vegRedChili.setOnClickListener((View.OnClickListener) this);
        vegGreenChiliPeppers.setOnClickListener((View.OnClickListener) this);





        //Initialize fused location
        client = LocationServices.getFusedLocationProviderClient(this);


        //Check permission
        if(ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //When the permission granted
            //call method
            getCurrentLocation();

            navigation();
            //search
            search();
            arrayList.add(Tomato);
            arrayList.add(Cauliflower);
            arrayList.add(RedChili);
            arrayList.add(GreenChiliPepper);

        }else {
            //when permission denied
            //request permission
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
        }
    }

    private void getCurrentLocation() {
        //Initialize task location
        @SuppressLint("MissingPermission") Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                //when success
                if (location != null) {
                    //sync map
                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            mMap = googleMap;
                            //initialize lat lng
                            LatLng latLng = new LatLng(location.getLatitude()
                                    ,location.getLongitude());
                            //create marker options
                            MarkerOptions options = new MarkerOptions().position(latLng).title("I am here")
                                    .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.current_location));

                            for(int i=0;i<arrayList.size();i++) {
                                if(i==0){
                                    mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Tomato").
                                            icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.shop_icon)));
                                }else if(i==1){
                                    mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("CauliFlower").
                                            icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.shop_icon)));
                                }else if(i==2){
                                mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("RedChili").
                                        icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.shop_icon)));
                            } else{
                                    mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("GreenChiliPepper").
                                            icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.shop_icon)));
                                }
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
                            }
                            //Zoom map
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                            //Add marker on map
                            googleMap.addMarker(options);
                        }
                    });
                }
            }
        });
    }

    private void search(){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String location = searchView.getQuery().toString();
                List<Address> addressList = null;

                if(location != null || !location.equals("")){
                    Geocoder geocoder = new Geocoder(MainActivity.this);
                    try {
                        addressList = geocoder.getFromLocationName(location,1);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    Address address = addressList.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
     // supportMapFragment.getMapAsync((OnMapReadyCallback) this);
    }


    private BitmapDescriptor bitmapDescriptorFromVector(Context context,int vectorResId){
        Drawable vectorDrawable = ContextCompat.getDrawable(context,vectorResId);
        vectorDrawable.setBounds(0,0,vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 44){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //when permission grated
                //call method
                getCurrentLocation();
            }
        }
    }
    @Override
    public void onBackPressed() {
        counter++;
        if (counter == 1){
            Snackbar.make(mainLayout,"Do you really want to close",Snackbar.LENGTH_LONG).show();
        }else if (counter == 2){
            finish();
        }
    }

    public void navigation(){
        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //perform itemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
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
                        startActivity(new Intent(getApplicationContext(),
                                ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {

        for(int i=0;i<arrayList.size();i++) {
            switch (v.getId()) {
                case R.id.tomato:
                    mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Tomato").
                            icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.shop_icon)));
                    break;
                case R.id.greenChiliPeppers:
                    mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("GreenChiliPeppers").
                            icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.shop_icon)));
                    break;
                case R.id.cauliflower:
                    mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Cauliflower").
                            icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.shop_icon)));
                    break;
                case R.id.redChili:
                    mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("RedChili").
                            icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.shop_icon)));
                    break;
            }
        }
        }
    }