package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class setting extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button buttonLogout;
    private EditText editName;
    private EditText editNumber;
    private EditText editAdd,editEmail,editStatus,editLat,editLang;
    private Button buttonSubmit;
    private FirebaseDatabase rootNode;
    private DatabaseReference databaseReference;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        bottomNavigationView = findViewById(R.id.nav);
        bottomNavigationView.setSelectedItemId(R.id.botton5);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.botton1:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.botton2:
                        startActivity(new Intent(getApplicationContext(), Check.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.botton3:
                        startActivity(new Intent(getApplicationContext(), Stat.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.botton4:
                        startActivity(new Intent(getApplicationContext(), MapActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.botton5:
                        return true;
                }
                return false;
            }
        });
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, Login.class));
        }

        databaseReference = FirebaseDatabase.getInstance().getReference();


        FirebaseUser user = firebaseAuth.getCurrentUser();
        textViewUserEmail = findViewById(R.id.textViewUserEmail);
        buttonLogout = findViewById(R.id.buttonLogout);
        textViewUserEmail.setText("Welcome " + user.getEmail());
        editName = findViewById(R.id.editName);
        editNumber = findViewById(R.id.editNumber);
        editAdd = findViewById(R.id.editAdd);
        editEmail = findViewById(R.id.editEmail);
        editEmail.setText(user.getEmail());
        editStatus = findViewById(R.id.status);
        editLat = findViewById(R.id.editLat);
        editLang = findViewById(R.id.editLang);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonLogout.setOnClickListener(this);
        buttonSubmit.setOnClickListener(this);
    }
        @Override
        public void onClick(View v) {
            if(v==buttonLogout)
            {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
            if (v==buttonSubmit)
            {
                rootNode=FirebaseDatabase.getInstance();
                databaseReference=rootNode.getReference("users");

                // Get all the values
                String Name=editName.getText().toString();
                String Number=editNumber.getText().toString();
                String Address=editAdd.getText().toString();
                String Email = editEmail.getText().toString();
                UserHelperClass helperClass = new UserHelperClass(Email,Name,Number,Address);
                databaseReference.setValue(helperClass);
            }


        }
    }

