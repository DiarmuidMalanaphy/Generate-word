package com.example.myapplication;

import android.util.Log;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "words")

public class Stord {
    @PrimaryKey(autoGenerate = true)//ID for jokes held within this specific database
    public int uid;

    @ColumnInfo(name = "word")
    public String word;


    @ColumnInfo(name  = "word_ID")
    public int wordID;

    public Stord(String word){
        Log.e("Bean",":");
        this.word = word;
        this.wordID = word.hashCode();

    }
    public String getWord(){
        return(this.word);
    }

}
