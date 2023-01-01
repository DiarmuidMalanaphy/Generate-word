package com.example.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Stoke.class,Stord.class,Stassword.class},version = 2)

public abstract class StokeDatabase extends RoomDatabase {


    private static StokeDatabase database;
    private static String DATABASE_NAME = "Collection";
    public synchronized static StokeDatabase getInstance(Context context){
        if (database == null){
            database = Room.databaseBuilder(context.getApplicationContext(),
                    StokeDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return database;
    }
    public abstract StokeDao stokeDao();
}
