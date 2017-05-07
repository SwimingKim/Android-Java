package com.word.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-11-07.
 */

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder>{

    private ArrayList<WordData> mDataset;

    public WordAdapter(ArrayList<WordData> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public WordAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_word, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(WordAdapter.ViewHolder holder, int position) {
        holder.searchWord.setText(mDataset.get(position).search_word);
        holder.wordMean.setText(mDataset.get(position).word_mean);
        holder.containWords.setText(mDataset.get(position).contain_words);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView searchWord;
        public TextView wordMean;
        public TextView containWords;
        public ViewHolder(View itemView) {
            super(itemView);
            searchWord = (TextView)itemView.findViewById(R.id.search_word);
            wordMean = (TextView)itemView.findViewById(R.id.word_mean);
            containWords = (TextView)itemView.findViewById(R.id.contain_words);
        }
    }

}

class WordData {
    public String search_word;
    public String word_mean;
    public String contain_words;
    public WordData(String search_word, String word_mean, String contain_words) {
        this.search_word = search_word;
        this.word_mean = word_mean;
        this.contain_words = contain_words;
    }
}