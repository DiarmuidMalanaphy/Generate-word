package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "jokes")

public class Stoke {
    @PrimaryKey(autoGenerate = true)//ID for jokes held within this specific database
    public int uid;

    @ColumnInfo(name  = "word_ID")
    public int wordID;

    @ColumnInfo(name = "author")
    public String author;

    @ColumnInfo(name = "joke")
    public String joke;

    @ColumnInfo(name = "punchline")
    public String punchline;

    //@ColumnInfo(name = "rating")
    //public double rating;
    //Fuck it we're not storing rating, every time we re call the thing we can do a calculation
    // rating = ratingAggregation/numberOfRatings

    @ColumnInfo(name = "rating_aggregation")
    public int ratingAggregation;

    @ColumnInfo(name = "number_of_ratings")
    public int numberOfRatings;

    @ColumnInfo(name = "joke_ID")//ID for a specific joke across any database, I'm not sure which one i'll use since UID is already inbuilt
    public int jokeID;

    public Stoke(String author,String joke,String punchline,int ratingAggregation,int numberOfRatings,int jokeID,int wordID){
        this.author = author;
        this.joke = joke;
        this.punchline = punchline;
        this.ratingAggregation = ratingAggregation;
        this.numberOfRatings = numberOfRatings;
        this.jokeID = jokeID;
        this.wordID = wordID;

    }
    public Joke convertIntoJoke(){
        Joke joke = new Joke(this.author,this.ratingAggregation,this.joke,this.punchline,true,this.numberOfRatings);
        return(joke);
    }

    public String getAuthor(){
        return(this.author);
    }
    public String getJoke(){
        return(this.joke);
    }
    public String getPunchline(){
        return(this.punchline);
    }
    public int getRatingAggregation(){
        return(this.ratingAggregation);
    }
    public int getWordID(){
        return(this.wordID);
    }
    public int getJokeID(){
        return(this.jokeID);
    }
    public int getNumberOfRatings(){
        return(this.numberOfRatings);
    }
}

