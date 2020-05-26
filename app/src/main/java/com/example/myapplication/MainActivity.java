package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.models.PieModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    TextView infected,recovered,deaths,status,news1,news2;
    SimpleArcLoader mainloader;
    LinearLayout la;
    public static List<CountryModel> countryModelList = new ArrayList<>();
    CountryModel countryModel;
    MyCustomAdapter myCustomAdapter;
    String countryName1 = null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.nav);
        bottomNavigationView.setSelectedItemId(R.id.botton1);
        news1 = findViewById(R.id.news1);
        news2 = findViewById(R.id.news2);
        status = findViewById(R.id.status);
        status.setSelected(true);
        news1.setSelected(true);
        news2.setSelected(true);
        mainloader = findViewById(R.id.mainloader);
        infected = findViewById(R.id.infected);
        recovered = findViewById(R.id.reoverd);
        deaths = findViewById(R.id.deaths);
        la = findViewById(R.id.la);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.botton1:
                        return true;
                    case R.id.botton2:
                        startActivity(new Intent(getApplicationContext(),Check.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.botton3:
                        startActivity(new Intent(getApplicationContext(),Stat.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.botton4:
                        startActivity(new Intent(getApplicationContext(),MapActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.botton5:
                        startActivity(new Intent(getApplicationContext(),setting.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        LocationManager locationManager = (LocationManager)getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        Geocoder geocoder = new Geocoder(getApplicationContext());
        for(String provider:locationManager.getAllProviders()){
            @SuppressWarnings("ResourceType")Location location = locationManager.getLastKnownLocation(provider);
            if(location!=null){
                try {
                    List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                    if(addresses != null && addresses.size()>0){
                        countryName1 = addresses.get(0).getCountryName();
                        break;
                    }
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        fetchData();
    }
    public void symptoms(View view) {
        Intent intent = new Intent(MainActivity.this, SympDet.class);
        startActivity(intent);
    }

    public void precaution(View view) {
        Intent intent = new Intent(MainActivity.this,PrecDet.class);
        startActivity(intent);
    }
    private void fetchData() {
        String url = "https://corona.lmao.ninja/v2/all";
        mainloader.start();
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    infected.setText(jsonObject.getString("cases"));
                    recovered.setText(jsonObject.getString("recovered"));
                    deaths.setText(jsonObject.getString("deaths"));
                    mainloader.stop();
                    mainloader.setVisibility(View.GONE);
                    la.setVisibility(View.VISIBLE);

                } catch (JSONException e) {
                    e.printStackTrace();
                    mainloader.stop();
                    mainloader.setVisibility(View.GONE);
                    la.setVisibility(View.VISIBLE);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mainloader.stop();
                mainloader.setVisibility(View.GONE);
                la.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
