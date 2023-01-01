package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class genJokeActivity extends AppCompatActivity {
    private Collection collection;
    private Word word;
    private Joke splatJoke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_joke);
        StokeDatabase DB = StokeDatabase.getInstance(this);
        this.collection = new Collection(DB);
        Log.e("Diabo","Pee");
        this.splatJoke=this.collection.getRandomJoke(DB);
        ((TextView)findViewById(R.id.jokeLine)).setText(this.splatJoke.getJoke());

        ((TextView)findViewById(R.id.Author)).setText(this.splatJoke.getAuthor());
        ((TextView)findViewById(R.id.Rating)).setText(""+this.splatJoke.getRating());


    }
    public void getNewJoke(View v){
        Intent i = new Intent(this,genJokeActivity.class);
        startActivity(i);
    }
    public void revealPunchline(View v){
        ((TextView)findViewById(R.id.punchlineLine)).setText(this.splatJoke.getPunchline());
    }
    public void editRating(View v){
        RatingBar r = (RatingBar) findViewById(R.id.ratingBar2);
        float ratingInput  = r.getRating();
        ratingInput = ratingInput*2;
        int intRatingInput = java.lang.Math.round(ratingInput);
        StokeDatabase DB = StokeDatabase.getInstance(this);
        this.splatJoke.addRating(intRatingInput,DB);
        Button b = (Button) v;
        b.setEnabled(false);
        ((TextView)findViewById(R.id.Rating)).setText(""+this.splatJoke.getRating());
    }

}