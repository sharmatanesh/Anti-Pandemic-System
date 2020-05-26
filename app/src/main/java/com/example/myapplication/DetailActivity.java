package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private int positionCountry;
    TextView tvCountry1,tvTotalCases1,tvTodayCases1,tvDeaths1,tvTodaysDeaths1,tvRecoverd1,tvActive1,tvCritical1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        positionCountry = intent.getIntExtra("position",0);
        tvCountry1 = findViewById(R.id.tvCountry1);
        tvTotalCases1=findViewById(R.id.tvTotalCases1);
        tvTodayCases1=findViewById(R.id.tvTodayCases1);
        tvDeaths1 = findViewById(R.id.tvDeaths1);
        tvTodaysDeaths1=findViewById(R.id.tvTodaysDeaths1);
        tvRecoverd1 = findViewById(R.id.tvRecoverd1);
        tvActive1 = findViewById(R.id.tvActive1);
        tvCritical1 = findViewById(R.id.tvCritical1);

        tvCountry1.setText(AffectedCountries.countryModelList.get(positionCountry).getCountry());
        tvTodayCases1.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayCases());
        tvTotalCases1.setText(AffectedCountries.countryModelList.get(positionCountry).getCases());
        tvDeaths1.setText(AffectedCountries.countryModelList.get(positionCountry).getDeaths());
        tvTodaysDeaths1.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayDeaths());
        tvRecoverd1.setText(AffectedCountries.countryModelList.get(positionCountry).getRecoverd());
        tvActive1.setText(AffectedCountries.countryModelList.get(positionCountry).getActive());
        tvCritical1.setText(AffectedCountries.countryModelList.get(positionCountry).getCritical());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
