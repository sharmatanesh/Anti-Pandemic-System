package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase rootNode;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(),Login.class));
        }
        progressDialog=new ProgressDialog(this);
        buttonRegister = findViewById(R.id.buttonRegister);
        editTextEmail= findViewById(R.id.editTextEmail);
        editTextPassword= findViewById(R.id.editTextPassword);
        textViewSignin= findViewById(R.id.textViewSignup);

        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);

    }
    private void registerUser()
    {
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();
        if(TextUtils.isEmpty(email))
        {
            //email is empty

            Toast.makeText(this, "Please Enter email", Toast.LENGTH_SHORT).show();
            //stop the function for executing further
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            //password is empty
            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_SHORT).show();
            //stop the function for executing further

            return;
        }
        progressDialog.setMessage("Registration in Process");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else{
                            Toast.makeText(Register.this," You failed to Register ....Please try again",Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });


    }
    @Override
    public void onClick(View v) {

        if(v==buttonRegister)
        {
            registerUser();

        }
        if(v==textViewSignin)
        {
            //will open login activity

            finish();
            startActivity(new Intent(getApplicationContext(),Login.class));
        }

    }
}
