package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class adminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void changePassword(){

    }

    public void addWordToDatabase(View v){
        Intent i = new Intent(this,AddWordActivity.class);
        startActivity(i);

    }

    public void editJoke(View v){
        Intent i = new Intent(this,editJokeActivity.class);
        startActivity(i);
    }


}