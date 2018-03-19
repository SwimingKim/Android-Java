package skim.dev.kr.firstapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import skim.dev.kr.firstapp.R;

/**
 * Created by suyoung on 2018. 2. 25..
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.Holder> {

    private List<Pair<String, String>> cities;

    public CityAdapter() {
        cities = new ArrayList<>();
        cities.add(Pair.create("Seoul", "SEO"));
        cities.add(Pair.create("Tokyo", "TOK"));
        cities.add(Pair.create("Mountain View", "MTV"));
        cities.add(Pair.create("Singapore", "SIN"));
        cities.add(Pair.create("New York", "NYC"));
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(parent);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Pair<String, String> item = cities.get(position);

        holder.cityName.setText(item.first);
        holder.cityCode.setText(item.second);
    }

    @Override
    public int getItemCount() {
        return null != cities ? cities.size() : 0;
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView cityName;
        TextView cityCode;

        public Holder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, parent, false));

            cityName = (TextView)itemView.findViewById(R.id.tv_city_name);
            cityCode = (TextView)itemView.findViewById(R.id.tv_city_code);
        }
    }
}
