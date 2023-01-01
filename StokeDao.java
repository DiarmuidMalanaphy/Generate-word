package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao

public interface StokeDao {
    @Insert
    void insertAll(Stoke... stokes);

    @Insert
    void insertSome(Stord... stords);

    @Insert
    void insertOne(Stassword... stasswords);

    @Query("SELECT * FROM words")
    List<Stord> getWords();

    @Query("SELECT * FROM jokes")
    List<Stoke> getAllJokes();

    @Query("SELECT * FROM words WHERE word_ID == :wordID")
    List<Stord> getWord(int wordID);

    @Query("INSERT INTO words (word) VALUES (:word)")
    void insertWord(String word);

    @Query("INSERT INTO jokes (author,joke,punchline,rating_Aggregation,number_Of_Ratings,joke_ID,word_ID) VALUES (:author,:joke ,:punchline, :ratingAggregation,:numberOfRatings,:jokeID,:wordID)")
    void insertJoke(String author,String joke,String punchline,int ratingAggregation,int numberOfRatings,int jokeID,int wordID);

    @Query("DELETE FROM words")
    void deleteAllWords();

    @Query("SELECT * FROM jokes WHERE word_ID == :wordID ORDER BY (rating_aggregation/number_of_ratings) DESC" )
    List<Stoke> getJokes(int wordID);

    @Query ("UPDATE jokes SET joke = :joke, punchline =:punchline, joke_ID = :newJokeID WHERE uid == :ID ")
    void updateJoke(String joke,String punchline,int newJokeID, int ID);

    @Query("UPDATE jokes SET rating_Aggregation = :newRatingAggregation, number_Of_Ratings = :numberOfRatings WHERE joke_ID == :JokeID")
    void updateRating(int newRatingAggregation,int numberOfRatings,int JokeID);

    @Query ("UPDATE password SET passwordHash =:newPasswordHash WHERE passwordHash == :prevPasswordHash")
    void updatePassword(int newPasswordHash,int prevPasswordHash);

    @Query("SELECT * from password")
    List<Stassword> getPassword();

}
