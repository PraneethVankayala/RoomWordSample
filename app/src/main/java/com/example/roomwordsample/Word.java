package com.example.roomwordsample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="word")
    private String mword;

    public Word(@NonNull String mword){
        this.mword=mword;
    }

    public String getMword(){
        return this.mword;
    }

    public void setMword(String mword){
        this.mword=mword;
    }

}
