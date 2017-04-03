package com.su.shark;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

/**
 * Created by suyoung on 2017. 1. 29..
 */

public class ListActivity extends Activity {
    ArrayList<MyCard> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        MobileAds.initialize(getApplicationContext(), R.string.banner_ad_unit_id + "");

        arr = new ArrayList<>();
        arr.add(new MyCard("파랑몬", R.drawable.win));
        arr.add(new MyCard("분노상어", R.drawable.madshark));
        arr.add(new MyCard("파랑몬", R.drawable.loose));
        arr.add(new MyCard("평상상어", R.drawable.shark2));

        GridView gv = (GridView) findViewById(R.id.grid);
        MyGrid mg = new MyGrid(getApplicationContext(), R.layout.gridrow, arr);
        gv.setAdapter(mg);

        AdView av = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("356432055509926").build();
        av.loadAd(adRequest);

    }//end of onCreate

    class MyCard {
        String name;
        int img;

        public MyCard(String name, int img) {
            this.name = name;
            this.img = img;
        }
    }

    class MyGrid extends BaseAdapter {
        ArrayList<MyCard> arr;
        int layout;
        LayoutInflater lif;

        public MyGrid(Context applicationContext, int gridrow, ArrayList<MyCard> arr) {
            this.layout = gridrow;
            this.arr = arr;
            this.lif = (LayoutInflater) applicationContext.getSystemService(applicationContext.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return arr.size();
        }

        @Override
        public Object getItem(int position) {
            return arr.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = lif.inflate(layout, null);
            }

            ((TextView) convertView.findViewById(R.id.name)).setText(arr.get(position).name);
            ((ImageView) convertView.findViewById(R.id.img)).setImageResource(arr.get(position).img);

            return convertView;
        }
    }
}//end of class
