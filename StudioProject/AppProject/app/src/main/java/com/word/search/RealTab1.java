package com.word.search;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.word.search.com.word.search.util.ActivityHostFragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-11-14.
 */

public class RealTab1 extends Activity {

    static RecyclerView wordList;
    RecyclerView.LayoutManager layoutManager;
    static WordAdapter wordAdapter;
    static ArrayList<WordData> myDataset;
    static List<String> resultList;
    static String[] sResult;
    static String line;
    static BufferedReader br;
    static String strItem0, strItem1, strItem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tab1);

        wordList = (RecyclerView) findViewById(R.id.word_list);
        wordList.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        wordList.setLayoutManager(layoutManager);
        wordList.setHasFixedSize(true);


        myDataset = new ArrayList<>();
        wordAdapter = new WordAdapter(myDataset);
        wordList.setAdapter(wordAdapter);

        wordList.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

        InputStream is = null;
        try {
            is = getAssets().open("eng_word.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(new InputStreamReader(is, Charset.forName("EUC-KR")));
        line = "";
        resultList = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) {
                resultList.add(line);   // add Arraylist
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // String[] -> Arraylist
//        resultList = new ArrayList<String>(Arrays.asList(sResult));
        for (int i = 0; i < resultList.size(); i++) {
            // ArrayList get String
            strItem0 = resultList.get(i).split(",#,")[0];
            strItem0 = strItem0.replace("\"", "");
            strItem1 = resultList.get(i).split(",#,")[1];
            strItem1 = strItem1.replace("\"", "");
            strItem2 = resultList.get(i).split(",#,")[2];
            strItem2 = strItem2.replace("\"", "");
            myDataset.add(new WordData(strItem0, strItem1, strItem2));
        }

        // Arraylist -> String[] for search
        sResult = resultList.toArray(new String[resultList.size()]);
        // String[] get String
//        for (int i = 0; i < sResult.length; i++) {
//            String search1 = sResult[i].split(",#,")[0];
//            String search2 = sResult[i].split(",#,")[1];
//            String search3 = sResult[i].split(",#,")[2];
//            myDataset.add(new WordData(search1, search2, search3));
//        }


    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

}
