package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
    }
    public void addWord(View v){
        TextView t = findViewById(R.id.Word);
        String input = t.getText().toString();

        StokeDatabase DB = StokeDatabase.getInstance(this);
        Stord stord = new Stord(input);
        Log.d("Bals",stord.getWord());

        DB.stokeDao().insertSome(stord);

    }
}