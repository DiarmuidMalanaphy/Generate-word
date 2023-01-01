package com.example.myapplication;

import android.util.Log;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

class Collection{

    private LinkedList<Word> linky;

    private Joke nullJoke;
    public Collection(StokeDatabase DB){
        this.linky = new LinkedList<Word>();
        Log.e("Text","Boop");

        this.addAllWords(DB);
        Log.e("Text","Breep");
        this.nullJoke = new Joke("Addy D", 2, "There wasn't", "A joke",false,1);
        
    }

    public void addAllWords(StokeDatabase DB){

        List<Stord> stord =DB.stokeDao().getWords();
        for (Stord temp : stord) {
            Word word = new Word(temp.getWord());
            this.linky.add(word);

        }
        //Log.e("AddingWort",temp.getWord());

    }

    public void addWord(String word){
        Word formattedWord = new Word(word);
        this.linky.addFirst(formattedWord);
    }

    public Joke getRandomJoke(StokeDatabase DB){
        List<Stoke> jokes= DB.stokeDao().getAllJokes();
        Random random = new Random();
        if (jokes.size()!=0){
            Log.d("Text","Pee");
            int upperbound =jokes.size();
            Stoke stoke = jokes.get(random.nextInt(upperbound));
            Joke joke = stoke.convertIntoJoke();
            return(joke);

        }
        return(this.nullJoke);//this logically shouldn't occur
        
    }


    public void initWords(StokeDatabase DB){
        if (DB.stokeDao().getWords().isEmpty() == true ){
            Stord stord = new Stord("Corn");
            Stord stord2 = new Stord("Squirrel");
            Stord stord3 = new Stord("Fan");
            DB.stokeDao().insertSome(stord);
            DB.stokeDao().insertSome(stord2);
            DB.stokeDao().insertSome(stord3);
        }



    }

    public Word getRandomWord(){
        Random random = new Random();
        Log.d("Text",this.linky.getFirst().getWord());
        int upperbound = this.linky.size();
        Log.d("Text","Lot");
        Word word = this.linky.get(random.nextInt(upperbound));
        Log.d("Text","log");
        return(word);

    }

    public Boolean insertData(StokeDatabase DB,String word){
        //
        if (word == ""){
            return false;
        }
        else {
            DB.stokeDao().insertWord(word);
            return true;
        }

    }

    public Word searchForWord(String input, StokeDatabase DB) {
        if (input.charAt(input.length()-1)==(' ')){
            Log.e("Gaoh",input+"1");
            input = input.substring(0, input.length() - 1);
            Log.e("Goah",input+"2");

        }
        List<Stord> stord = DB.stokeDao().getWords();
        ListIterator<Stord> listIterator =stord.listIterator();
        String upperInput= input.toUpperCase();

        if (stord.isEmpty()) {
        } else {
            while (listIterator.hasNext()) {
                Word nextWord = new Word(listIterator.next().getWord());
                if (upperInput.equals(nextWord.getWord().toUpperCase())==true){
                    Log.e("Gaoh", nextWord.getWord());
                    Word word = new Word(nextWord.getWord());
                    return(word);
                }
            }
        }
        return (null);
    }

    public void addJokeToDatabase(Joke joke, Word word,StokeDatabase DB){
        DB.stokeDao().insertJoke(joke.getAuthor(),joke.getJoke(),joke.getPunchline(),joke.getRatingAggregation(),joke.getNumberOfRatings(),(joke.getJoke()+joke.getPunchline()).hashCode(),word.getWord().hashCode());
        }

    public void initPassword(StokeDatabase DB){
        if (DB.stokeDao().getPassword().isEmpty() == true ){
            Stassword stassword = new Stassword("admin".hashCode());
            DB.stokeDao().insertOne(stassword);
        }

    }
    public void initJokes(StokeDatabase DB){
        if(DB.stokeDao().getAllJokes().isEmpty()==true){
            Joke joke = new Joke("Diarmuid",8,"What does a Psychiatrist squirrel bring to work? ", "A nutcase",true,1);
            Word word = new Word("Squirrel");
            addJokeToDatabase(joke,word,DB);
        }
    }

    public Boolean isValidPassword(StokeDatabase DB,String passwordInput){
        Log.e("Pastword","bleep");
        Log.e("Pastword",""+DB.stokeDao().getPassword().get(0).getPasswordHash());
        Log.e("Pastword",""+passwordInput.hashCode());
        if (DB.stokeDao().getPassword().get(0).getPasswordHash() ==passwordInput.hashCode()){
            return true;
        }
        else{
            return false;
        }
    }

    public void changePassword(String Password,int oldPassHash, StokeDatabase DB){
        DB.stokeDao().updatePassword(Password.hashCode(),oldPassHash);
    }

    public LinkedList<Word> getLinky(){
        return(this.linky);
    }


}