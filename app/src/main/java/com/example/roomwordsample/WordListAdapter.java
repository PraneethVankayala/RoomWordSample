package com.example.roomwordsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.recyclerview_item,parent,false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if(mWords!=null){
            Word current= mWords.get(position);
            holder.wordItemView.setText(current.getMword());
        }
        else {
            holder.wordItemView.setText("No Word");
        }
    }

    @Override
    public int getItemCount() {
        if(mWords!=null){
            return mWords.size();
        }
        else{
            return 0;
        }

    }

    void setmWords(List<Word> words){
        mWords=words;
        notifyDataSetChanged();
    }

    class WordViewHolder extends RecyclerView.ViewHolder{

        private final TextView wordItemView;

        private WordViewHolder(View view){
            super(view);
            wordItemView=view.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Word> mWords;

    WordListAdapter(Context context){
        mInflater=LayoutInflater.from(context);
    }
}
