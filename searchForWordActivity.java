package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class searchForWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_word);
    }
    public void search(View v){
        TextView t = findViewById(R.id.source);
        String input = t.getText().toString();
        Button b = (Button) v;
        StokeDatabase DB = StokeDatabase.getInstance(this);
        Stord stord = new Stord(input);

        //DB.stokeDao().insertSome(stord);

        //DB.stokeDao().deleteAllWords();

        Collection collection = new Collection(DB);
        Word word = collection.searchForWord(input,DB);

        if (word == null){
            b.setText("Null");
        }
        else{
            Intent i = new Intent(this,addJokeActivity.class);
            i.putExtra("Word",word.getWord());
            startActivity(i);
        }








        //Log.d(tag:"info",newInput);
    }
}