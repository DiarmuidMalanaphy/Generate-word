package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class editJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_joke);
    }
    public void editAll(Joke joke, String word,StokeDatabase DB){


    }

    public void editJoke(String joke,String word,StokeDatabase DB,int jokeID){

    }

    public void editPunchline(String punchline,String word,StokeDatabase DB,int jokeID){

    }

    public void editAuthor(String author,String word,StokeDatabase DB,int jokeID){

    }



}