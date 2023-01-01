package com.example.myapplication;

class Joke{
    private String author;
    private double rating;
    private String joke;
    private String punchline;
    private int ratingAggregation;
    private int numberOfRatings;
    private boolean isReal;
    private int jokeID;
    public Joke(String author,int ratingAggregation,String joke,String punchline,boolean isReal,int numberOfRatings)
    {
        this.author = author;

        this.joke = joke;
        this.punchline = punchline;
        this.ratingAggregation = ratingAggregation;
        this.numberOfRatings = numberOfRatings;
        this.isReal = isReal;
        this.jokeID = (joke+punchline).hashCode();
        this.rating = ratingAggregation/numberOfRatings;
    }
    public double addRating(int rating,StokeDatabase DB){
        this.numberOfRatings++;
        this.ratingAggregation = (this.ratingAggregation + rating);
        double newRating = this.ratingAggregation/ this.numberOfRatings;
        DB.stokeDao().updateRating(this.ratingAggregation,this.numberOfRatings,this.jokeID);
        this.rating = newRating;
        return newRating;

    }
    public void anonymiseJoke(){
        this.author = "Anonymous";
    }
    public String getAuthor(){
        return (this.author);
    }
    public String getJoke(){
        return(this.joke);
    }
    public String getPunchline(){
        return(this.punchline);
    }
    public double getRating(){
        return (this.rating);
    }
    public boolean checkReal(){
        return(this.isReal);
    }
    public int getRatingAggregation(){
        return this.ratingAggregation;
    }
    public int getNumberOfRatings(){
        return this.numberOfRatings;
    }
}