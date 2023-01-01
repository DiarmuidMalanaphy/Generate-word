package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class addJokeActivity extends AppCompatActivity {
    private String word;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_joke);
        Intent i = getIntent();
        this.word = i.getStringExtra("Word");
        String completePhrase = "Joke for "+this.word;
        ((TextView)findViewById(R.id.JokeText)).setText(completePhrase);



    }
    public void addJoke(View v){
        TextView t = findViewById(R.id.sub_author);
        String authorInput = t.getText().toString();
        t = findViewById(R.id.sub_punchline);
        String punchlineInput =t.getText().toString();
        t = findViewById(R.id.sub_joke);
        String jokeInput = t.getText().toString();
        RatingBar r = (RatingBar) findViewById(R.id.ratingBar);
        float ratingInput  = r.getRating();
        ratingInput = ratingInput*2;
        int intRatingInput = java.lang.Math.round(ratingInput);
        StokeDatabase DB = StokeDatabase.getInstance(this);
        Collection collection = new Collection(DB);

        if (authorInput.equals("Author")||( punchlineInput.equals("Punchline")) || (jokeInput.equals("Joke"))){
            Button b = (Button) v;
            b.setText("Fill in all fields");
        }
        else {
            Joke joke = new Joke(authorInput,intRatingInput,jokeInput,punchlineInput,true,1);
            Word word = new Word(this.word);
            collection.addJokeToDatabase(joke,word,DB);
        }



    }
}