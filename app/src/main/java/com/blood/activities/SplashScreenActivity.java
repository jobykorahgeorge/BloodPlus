package com.blood.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.blood.MainActivity;
import com.blood.R;
import com.blood.utilities.PublicValues;

/**
 * Created by Anooj on 01-Nov-17.
 */

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
//                    SharedPreferences sharedPref = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
//                    if(sharedPref.getString(PublicValues.FACEBOOK_USER_ID," ").isEmpty()){
                    Intent intent = new Intent(SplashScreenActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
//                    }
//                    else {
//                        Intent intent=new Intent(SplashScreenActivity.this,OTPActivity.class);
//                        startActivity(intent);
//                    }
                }
            }
        };
        timerThread.start();
    }
    }

