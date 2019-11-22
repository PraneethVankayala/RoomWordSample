package com.example.roomwordsample;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mWordRepository;

    private LiveData<List<Word>> mAllWords;

    public  WordViewModel(Application application){
        super(application);
        mWordRepository=new WordRepository(application);
        mAllWords=mWordRepository.getAllWords();
    }

    LiveData<List<Word>> getAllWords(){return mAllWords;}

    public void insert(Word word){mWordRepository.insert(word);}
}
