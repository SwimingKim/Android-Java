package com.su.shark.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.su.shark.MainActivity;
import com.su.shark.R;

import java.util.ArrayList;

/**
 * Created by suyoung on 2017. 1. 27..
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<MainActivity.MyData> mDataset;
    public static int HUTTING = 0;
    public static int RUNNING = 1;
    public static int BREEDING = 2;
    public static int RELAXING = 3;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mTextView;

        public ViewHolder(final View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image);
            mTextView = (TextView) itemView.findViewById(R.id.textview);

            itemView.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                        v.findViewById(R.id.card).setBackgroundResource(R.color.yellow);
                    } else {
                        v.findViewById(R.id.card).setBackgroundResource(R.color.red);
                    }
                    return false;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ("사냥하기".equals(mTextView.getText().toString())) {
                        ((MainActivity) MainActivity.nContext).showDialog(HUTTING);
                    } else {
                        Toast.makeText(v.getContext(), "업데이트 예정입니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }

    }

    public MyAdapter(ArrayList<MainActivity.MyData> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position).text);
        holder.mImageView.setImageResource(mDataset.get(position).img);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
