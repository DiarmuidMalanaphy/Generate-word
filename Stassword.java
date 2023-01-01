package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "password")
public class Stassword {
    @PrimaryKey(autoGenerate = true)//ID for jokes held within this specific database
    public int uid;

    @ColumnInfo(name  = "passwordHash")
    private int passwordHash;

    public Stassword(int passwordHash){
        this.passwordHash = passwordHash;
    }
    public Boolean isRight(String password){
        if (password.hashCode()==this.passwordHash){
            return true;
        }
        else{
            return false;
        }

    }
    public int getPasswordHash(){
        return(passwordHash);
    }

}
