package com.su.shark;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

/**
 * Created by suyoung on 2017. 1. 29..
 */

public class LicenseActivity extends Activity{
    ArrayList<MySet> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        MobileAds.initialize(getApplicationContext(), R.string.banner_ad_unit_id + "");

        arr = new ArrayList<>();
        arr.add(new MySet("android-ripple-background", "https://github.com/skyfishjy/android-ripple-background"));
        arr.add(new MySet("분노상어", "주소"));

        GridView gv = (GridView) findViewById(R.id.grid);
        MyList mg = new MyList(getApplicationContext(), R.layout.listrow, arr);
        gv.setAdapter(mg);

        AdView av = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("356432055509926").build();
        av.loadAd(adRequest);

    }//end of onCreate

    class MySet {
        String name;
        String detail;

        public MySet(String name, String detail) {
            this.name = name;
            this.detail = detail;
        }
    }

    class MyList extends BaseAdapter {
        ArrayList<MySet> arr;
        int layout;
        LayoutInflater lif;

        public MyList(Context applicationContext, int gridrow, ArrayList<MySet> arr) {
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
            ((TextView) convertView.findViewById(R.id.img)).setText(arr.get(position).detail);

            return convertView;
        }
    }
}
