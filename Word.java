package com.example.myapplication;

import android.util.Log;

import androidx.room.Entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
class Word{
    private LinkedList<Joke> linky;
    private String word;
    private Joke nullJoke;
    public Word(String word){
        this.linky = new LinkedList<Joke>();
        this.word = word;  
        this.nullJoke = new Joke("Addy D", 2, "There wasn't", "A joke",false,1);
    }

    public void addJoke(String author,int rating,String joke,String punchline){
        //default joke only has one rating so number of ratings will be one
        Joke bigJoke = new Joke(author, rating, joke, punchline,true,1);
        this.linky.add(bigJoke);
    }
    public Joke getRandomJoke(){
        if (this.linky.size()==0){
            return(this.nullJoke);
        }
        Random random = new Random();
        int upperbound = this.linky.size();
        Joke joke = this.linky.get(random.nextInt(upperbound));
        return(joke);

    }
    public Joke getBestJoke() {
        if (this.linky.size() == 0) {
            return (this.nullJoke);
        }
        return (this.linky.getFirst());
    }

    public void attachJokesToWord(StokeDatabase DB){
        int wordID = this.word.hashCode();
        List<Stoke> stoke =DB.stokeDao().getJokes(wordID);
        //String author,int rating,String joke,String punchline,boolean isReal
        for (Stoke temp : stoke) {
            Joke joke = new Joke(temp.getAuthor(),temp.getRatingAggregation(),temp.getJoke(),temp.getPunchline(),
                    true,temp.getNumberOfRatings());
            this.linky.add(joke);
            Log.e("AddingWort",temp.getJoke());
        }
    }

    public boolean compareWord(String word){
        if (word == this.word){
            return(true);
        }
        return(false);
    }

    public String getWord(){
        return(this.word);
    }

    public void setLinky(LinkedList<Joke> linky) {
        this.linky = linky;
    }

    public void setNullJoke(Joke nullJoke) {
        this.nullJoke = nullJoke;
    }
}