package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class setting extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button buttonLogout;
    private EditText editName;
    private EditText editNumber;
    private EditText editAdd;
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


                UserHelperClass helperClass = new UserHelperClass(Name,Number,Address);

                databaseReference.child(Number).setValue(helperClass);




            }


        }
    }

