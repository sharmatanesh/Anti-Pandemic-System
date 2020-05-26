package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.eazegraph.lib.utils.Utils;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Check extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    TextView hello,test,perm,ques1,ques2,ques3,ques4,ques5,ques6,ques7,ques8,ques9,ques10,ques11,ques12,ques13,ques14,ques15;
    RadioGroup permans,ques1ans,ques2ans,ques3ans,ques4ans,ques5ans,ques6ans,ques7ans,ques8ans,ques9ans,ques10ans,ques11ans,ques12ans,ques13ans,ques14ans,ques15ans;
    RadioButton permans1,ques1ans1,ques2ans1,ques3ans1,ques4ans1,ques5ans1,ques6ans1,ques7ans1,ques8ans1,ques9ans1,ques10ans1,ques11ans1,ques12ans1,ques13ans1,ques14ans1,ques15ans1, permans2,ques1ans2,ques2ans2,ques3ans2,ques4ans2,ques5ans2,ques6ans2,ques7ans2,ques8ans2,ques9ans2,ques10ans2,ques11ans2,ques12ans2,ques13ans2,ques14ans2,ques15ans2;
    int status;
    boolean ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8,ch9,ch10,ch11,ch12,ch13,ch14,ch15;
    ScrollView scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        bottomNavigationView = findViewById(R.id.nav);
        bottomNavigationView.setSelectedItemId(R.id.botton2);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.botton1:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.botton2:
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
        openDialog("Hello \nThis is very short COVID-19 test\nPress OK to Begin..?");
        scroll = findViewById(R.id.scroll);
        ques1 = findViewById(R.id.ques1);
        ques2 = findViewById(R.id.ques2);
        ques3 = findViewById(R.id.ques3);
        ques4 = findViewById(R.id.ques4);
        ques5 = findViewById(R.id.ques5);
        ques6 = findViewById(R.id.ques6);
        ques7 = findViewById(R.id.ques7);
        ques8 = findViewById(R.id.ques8);
        ques9 = findViewById(R.id.ques9);
        ques10 = findViewById(R.id.ques10);
        ques11 = findViewById(R.id.ques11);
        ques12 = findViewById(R.id.ques12);
        ques13 = findViewById(R.id.ques13);
        ques14 = findViewById(R.id.ques14);
        ques15 = findViewById(R.id.ques15);
        ques1ans1 = findViewById(R.id.ques1ans1);
        ques1ans2 = findViewById(R.id.ques1ans2);
        ques2ans1 = findViewById(R.id.ques2ans1);
        ques2ans2 = findViewById(R.id.ques2ans2);
        ques3ans1= findViewById(R.id.ques3ans1);
        ques3ans2= findViewById(R.id.ques3ans2);
        ques4ans1 = findViewById(R.id.ques4ans1);
        ques4ans2 = findViewById(R.id.ques4ans2);
        ques5ans1 = findViewById(R.id.ques5ans1);
        ques5ans2 = findViewById(R.id.ques5ans2);
        ques6ans1 = findViewById(R.id.ques6ans1);
        ques6ans2 = findViewById(R.id.ques6ans2);
        ques7ans1 = findViewById(R.id.ques7ans1);
        ques7ans2 = findViewById(R.id.ques7ans2);
        ques8ans1 = findViewById(R.id.ques8ans1);
        ques8ans2 = findViewById(R.id.ques8ans2);
        ques9ans1 = findViewById(R.id.ques9ans1);
        ques9ans2 = findViewById(R.id.ques9ans2);
        ques10ans1 = findViewById(R.id.ques10ans1);
        ques10ans2 = findViewById(R.id.ques10ans2);
        ques11ans1 = findViewById(R.id.ques11ans1);
        ques11ans2 = findViewById(R.id.ques11ans2);
        ques12ans1 = findViewById(R.id.ques12ans1);
        ques12ans2 = findViewById(R.id.ques12ans2);
        ques13ans1 = findViewById(R.id.ques13ans1);
        ques13ans2 = findViewById(R.id.ques13ans2);
        ques14ans1 = findViewById(R.id.ques14ans1);
        ques14ans2 = findViewById(R.id.ques14ans2);
        ques15ans1 = findViewById(R.id.ques15ans1);
        ques15ans2 = findViewById(R.id.ques15ans2);
        ques1ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = 1;
                ch1= true;
                ques2ans = findViewById(R.id.ques2ans);
                ques2.setVisibility(View.VISIBLE);
                ques2ans.setVisibility(View.VISIBLE);
                ques1ans1.setChecked(true);
            }
        });
        ques1ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = 0;
                ch1 = false;
                ques2ans = findViewById(R.id.ques2ans);
                ques2.setVisibility(View.VISIBLE);
                ques2ans.setVisibility(View.VISIBLE);
                ques1ans2.setChecked(true);
            }
        });


        ques2ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+1;
                ch2= true;
                ques3ans = findViewById(R.id.ques3ans);
                ques3.setVisibility(View.VISIBLE);
                ques3ans.setVisibility(View.VISIBLE);
                ques2ans1.setChecked(true);
            }
        });
        ques2ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+0;
                ch2 = false;
                ques3ans = findViewById(R.id.ques3ans);
                ques3.setVisibility(View.VISIBLE);
                ques3ans.setVisibility(View.VISIBLE);
                ques2ans2.setChecked(true);
            }
        });

        ques3ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+1;
                ch3= true;
                ques4ans = findViewById(R.id.ques4ans);
                ques4.setVisibility(View.VISIBLE);
                ques4ans.setVisibility(View.VISIBLE);
                ques3ans1.setChecked(true);
            }
        });
        ques3ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+0;
                ch3 = false;
                ques4ans = findViewById(R.id.ques4ans);
                ques4.setVisibility(View.VISIBLE);
                ques4ans.setVisibility(View.VISIBLE);
                ques3ans2.setChecked(true);
            }
        });

        ques4ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+1;
                ch4= true;
                ques5ans = findViewById(R.id.ques5ans);
                ques5.setVisibility(View.VISIBLE);
                ques5ans.setVisibility(View.VISIBLE);
                ques4ans1.setChecked(true);
            }
        });
        ques4ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+0;
                ch4 = false;
                ques5ans = findViewById(R.id.ques5ans);
                ques5.setVisibility(View.VISIBLE);
                ques5ans.setVisibility(View.VISIBLE);
                ques4ans2.setChecked(true);
            }
        });


        ques5ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+1;
                ch5= true;
                ques6ans = findViewById(R.id.ques6ans);
                ques6.setVisibility(View.VISIBLE);
                ques6ans.setVisibility(View.VISIBLE);
                ques5ans1.setChecked(true);
            }
        });
        ques5ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+0;
                ch5 = false;
                ques6ans = findViewById(R.id.ques6ans);
                ques6.setVisibility(View.VISIBLE);
                ques6ans.setVisibility(View.VISIBLE);
                ques5ans2.setChecked(true);
            }
        });

        ques6ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+1;
                ch6= true;
                ques7ans = findViewById(R.id.ques7ans);
                ques7.setVisibility(View.VISIBLE);
                ques7ans.setVisibility(View.VISIBLE);
                ques6ans1.setChecked(true);
            }
        });
        ques6ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+0;
                ch6 = false;
                ques7ans = findViewById(R.id.ques7ans);
                ques7.setVisibility(View.VISIBLE);
                ques7ans.setVisibility(View.VISIBLE);
                ques6ans2.setChecked(true);
            }
        });
        ques7ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+1;
                ch7= true;
                ques8ans = findViewById(R.id.ques8ans);
                ques8.setVisibility(View.VISIBLE);
                ques8ans.setVisibility(View.VISIBLE);
                ques7ans1.setChecked(true);
            }
        });
        ques7ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+0;
                ch7 = false;
                ques8ans = findViewById(R.id.ques8ans);
                ques8.setVisibility(View.VISIBLE);
                ques8ans.setVisibility(View.VISIBLE);
                ques7ans2.setChecked(true);
            }
        });

        ques8ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+1;
                ch8= true;
                ques9ans = findViewById(R.id.ques9ans);
                ques9.setVisibility(View.VISIBLE);
                ques9ans.setVisibility(View.VISIBLE);
                ques8ans1.setChecked(true);
            }
        });
        ques8ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+0;
                ch8 = false;
                ques9ans = findViewById(R.id.ques9ans);
                ques9.setVisibility(View.VISIBLE);
                ques9ans.setVisibility(View.VISIBLE);
                ques8ans2.setChecked(true);
            }
        });

        ques9ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+1;
                ch9= true;
                ques10ans = findViewById(R.id.ques10ans);
                ques10.setVisibility(View.VISIBLE);
                ques10ans.setVisibility(View.VISIBLE);
                ques9ans1.setChecked(true);
            }
        });
        ques9ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+0;
                ch9 = false;
                ques10ans = findViewById(R.id.ques10ans);
                ques10.setVisibility(View.VISIBLE);
                ques10ans.setVisibility(View.VISIBLE);
                ques9ans2.setChecked(true);
            }
        });

        ques10ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+1;
                ch10= true;
                ques11ans = findViewById(R.id.ques11ans);
                ques11.setVisibility(View.VISIBLE);
                ques11ans.setVisibility(View.VISIBLE);
                ques10ans1.setChecked(true);
            }
        });
        ques10ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+0;
                ch10 = false;
                ques11ans = findViewById(R.id.ques11ans);
                ques11.setVisibility(View.VISIBLE);
                ques11ans.setVisibility(View.VISIBLE);
                ques10ans2.setChecked(true);
            }
        });

        ques11ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+1;
                ch11= true;
                ques12ans = findViewById(R.id.ques12ans);
                ques12.setVisibility(View.VISIBLE);
                ques12ans.setVisibility(View.VISIBLE);
                ques11ans1.setChecked(true);
            }
        });
        ques11ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+0;
                ch11 = false;
                ques12ans = findViewById(R.id.ques12ans);
                ques12.setVisibility(View.VISIBLE);
                ques12ans.setVisibility(View.VISIBLE);
                ques11ans2.setChecked(true);
            }
        });

        ques12ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+1;
                ch12= true;
                ques13ans = findViewById(R.id.ques13ans);
                ques13.setVisibility(View.VISIBLE);
                ques13ans.setVisibility(View.VISIBLE);
                ques12ans1.setChecked(true);
            }
        });
        ques12ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+0;
                ch12 = false;
                ques13ans = findViewById(R.id.ques13ans);
                ques13.setVisibility(View.VISIBLE);
                ques13ans.setVisibility(View.VISIBLE);
                ques12ans2.setChecked(true);
            }
        });

        ques13ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+1;
                ch13= true;
                ques14ans = findViewById(R.id.ques14ans);
                ques14.setVisibility(View.VISIBLE);
                ques14ans.setVisibility(View.VISIBLE);
                ques13ans1.setChecked(true);
            }
        });
        ques13ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+0;
                ch13 = false;
                ques14ans = findViewById(R.id.ques14ans);
                ques14.setVisibility(View.VISIBLE);
                ques14ans.setVisibility(View.VISIBLE);
                ques13ans2.setChecked(true);
            }
        });

        ques14ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+1;
                ch14= true;
                ques15ans = findViewById(R.id.ques15ans);
                ques15.setVisibility(View.VISIBLE);
                ques15ans.setVisibility(View.VISIBLE);
                ques14ans1.setChecked(true);
            }
        });
        ques14ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+0;
                ch14 = false;
                ques15ans = findViewById(R.id.ques15ans);
                ques15.setVisibility(View.VISIBLE);
                ques15ans.setVisibility(View.VISIBLE);
                ques14ans2.setChecked(true);
            }
        });

        ques15ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+1;
                ch15= true;
                String result = checkResult();
                openDialog(result);
                Toast.makeText(getApplicationContext(),String.valueOf(status),Toast.LENGTH_SHORT).show();
            }
        });
        ques15ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = (status*10)+0;
                ch15 = false;
                String result = checkResult();
                openDialog(result);
            }
        });
    }

    private String checkResult() {
        String result="";
        if(ch1 && ch15){
            result = "You have symptoms of COVID-19\nDon't Panic, Firstly isolate yourself.\nContact Medical officals";
        }
        else if(ch1 && ch5 || ch1 && ch6){
            result = "You may have COVID-19\nif you have fever for long time\nContact to doctor soon.";
        }
        else if(ch6 && ch7 && ch8 || ch5 && ch7 && ch8){
            result = "If your body temperature rises\nand dry cough continues\nGet in touch with doctor";
        }
        else if(ch5 && ch9 && ch15 || ch6 && ch9 && ch15){
            result = "Don't Panic\nYou have high chances of having COVID-19\nGet isolated and don't get in contact with family or friends";
        }
        else if(ch5 && ch8 && ch12 && ch15 || ch6 && ch8 && ch12 && ch15){
            result = "Don't Panic\nYou have high chances of having COVID-19\nGet isolated and don't get in contact with family or friends";
        }
        else if(ch13 && ch15){
            result = "DON'T PANIC\nYou have COVID-19,\nget in touch of Doctor";
        }
        else if(ch5 && ch11 && ch15 || ch6 && ch11 && ch15){
            result = "You may have COVID-19\nget isolated and contact doctor";
        }
        else if(ch15){
            result = "Shortness of breathing is symptom of COVID-19\nIt is recommended to contact doctor";
        }
        else if(ch2 && ch3){
            result = "Your health is Not good as mentioned by you\ncontact doctor if condition WORSEN";
        }
        else if(ch3){
            result = "You are safe from COVID-19\nBut due to presence of cancer you may have weak immune system\nSo take care";
        }
        else if(ch1){
            result = "Take full body checkup of COVID-19";
        }
        else if(ch4){
            result = "It seems you have weak immune system\nStay Safe";
        }
        else if(ch2){
            result = "Your health is not good as mentioned by you but you are safe from COVID-19";
        }
        else if(ch14){
            result = "You may have COVID-19";
        }
        else if(ch6){
            result = "As you have fever take care of youself";
        }
        else if(ch13){
            result = "Diarrhoea is also symptom of COVID-19\nif condition worsen in addition to fever\ndry cough\nshorten breadth\nthen get contact with doctor";
        }
        else if(ch5 || ch7 || ch8 || ch9 || ch10 || ch11 || ch12 || ch3){
            result = "You are fine take care of youself.";
        }
        return result;
    }

    private void openDialog(String msg) {
        ExampleDialog exampleDialog = new ExampleDialog(msg);
        exampleDialog.show(getSupportFragmentManager(),"example dialog");
    }
}
