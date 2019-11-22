package com.example.roomwordsample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WordViewModel wordViewModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        final WordListAdapter adapter=new WordListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        wordViewModel= ViewModelProviders.of(this).get(WordViewModel.class);
        wordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                adapter.setmWords(words);
            }
        });
        FloatingActionButton fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NewWordActivity.class);
                startActivityForResult(intent,NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==NEW_WORD_ACTIVITY_REQUEST_CODE &&resultCode==RESULT_OK){
            Word word=new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
            wordViewModel.insert(word);

        }
        else {
            Toast.makeText(getApplicationContext(),R.string.empty_not_saved,Toast.LENGTH_LONG).show();

        }
    }
}
