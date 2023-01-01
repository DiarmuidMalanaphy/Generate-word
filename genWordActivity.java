package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class genWordActivity extends AppCompatActivity {
    private Collection collection;
    private Word word;
    private Joke bestJoke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_word);
        StokeDatabase DB = StokeDatabase.getInstance(this);

        this.collection = new Collection(DB);
        this.word = this.collection.getRandomWord();

        String string = this.word.getWord();
        ((TextView)findViewById(R.id.wordText)).setText(string);
        word.attachJokesToWord(DB);
        this.bestJoke = this.word.getBestJoke();
        ((TextView)findViewById(R.id.jokeText)).setText(this.bestJoke.getJoke());
        ((TextView)findViewById(R.id.author_name)).setText(this.bestJoke.getAuthor());


    }




    public void rerollWord(View v){
        Intent i = new Intent(this,genWordActivity.class);
        startActivity(i);

    }
    public void revealPunchline(View v){
        ((TextView)findViewById(R.id.punchlineText)).setText(this.bestJoke.getPunchline());
    }

}