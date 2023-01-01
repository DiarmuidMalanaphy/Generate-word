package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class settingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    public void launchCryActivity(View v){//It's semantics don't worry about it launching the wrong thing.
        Intent i = new Intent(this,BeSadActivity.class);
        startActivity(i);
    }
    public void launchAdminCheck(View v){
        Intent i = new Intent(this,enterPasswordActivity.class);
        startActivity(i);
    }

}