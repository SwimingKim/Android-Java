package com.su.shark;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.su.shark.util.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    String list[] = {"사냥하기", "운동하기", "새끼키우기", "휴식하기"};
    private Toolbar toolbar;
    private DrawerLayout dlDrawer;
    private ActionBarDrawerToggle dtToggle;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyAdapter mAdapter;
    private ArrayList<MyData> myDataset;
    public static Context nContext;
    private Intent intent;
    int myWin, myLose;

    final int LICENSE = 1;
    private MyDialog md;


    // 사냥하기 : 기존 버전
    // 운동하기 : 체리마루 런닝머신 게임 응용
    // 새끼키우기 : 밀크쮸쮸 응용
    // 휴식하기 : 집 찾기 혹은 집 맞추기

    // 상어 레벨을 키우게 끔 유도 - 서버로 저장

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        nContext = this;

        myWin = 3;

//        final TelephonyManager tm =(TelephonyManager)getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
//        String deviceid = tm.getDeviceId();
//        Log.d("테스트", deviceid);
        MobileAds.initialize(getApplicationContext(), R.string.banner_ad_unit_id + "");

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        dlDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (null != ab) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        dtToggle = new ActionBarDrawerToggle(this, dlDrawer, R.string.app_name, R.string.app_name);
        dlDrawer.setDrawerListener(dtToggle);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        myDataset = new ArrayList<>();

        myDataset.add(new MyData(list[0] + "", android.R.drawable.ic_menu_mapmode));
        myDataset.add(new MyData(list[1] + "", android.R.drawable.ic_menu_view));
        myDataset.add(new MyData(list[2] + "", android.R.drawable.ic_menu_compass));
        myDataset.add(new MyData(list[3] + "", android.R.drawable.ic_menu_send));

        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "클릭", Toast.LENGTH_SHORT).show();
            }
        });


        NavigationView nv = (NavigationView) findViewById(R.id.navigation_view);
        nv.setNavigationItemSelectedListener(this);

        AdView av = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("356432055509926").build();
        av.loadAd(adRequest);

        intent = new Intent(getApplicationContext(), HunttingActivity.class);
    }//end of onCreate

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        dtToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        dtToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (dtToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.app_email) {
            Uri uri = Uri.parse("mailto:rumex13@naver.com");
            Intent it = new Intent(Intent.ACTION_SENDTO, uri);
            startActivity(it);
        } else if (item.getItemId() == R.id.app_store) {
            Uri uri = Uri.parse("market://details?id=" + getPackageName());
            Intent it = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(it);
        } else if (item.getItemId() == R.id.list) {
            Intent intent = new Intent(getApplicationContext(), ListActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.result) {
            md = new MyDialog();
            md.show(getSupportFragmentManager(), "MYTAG");
        }
        return true;
    }

    public class MyData {
        public String text;
        public int img;

        public MyData(String text, int img) {
            this.text = text;
            this.img = img;
        }
    }

    public static class MyDialog extends DialogFragment {
        TextView msg = null;

        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
            LayoutInflater lif = getActivity().getLayoutInflater();
            View myview = lif.inflate(R.layout.dialog, null);

            myview.findViewById(R.id.title).setBackgroundResource(R.color.brown);
            myview.findViewById(R.id.btn1).setBackgroundResource(R.color.brown);
            myview.findViewById(R.id.btn2).setBackgroundResource(R.color.brown);
            ((TextView) myview.findViewById(R.id.title)).setText("게임소개");
//                ((TextView) myview.findViewById(R.id.title)).setText("게임전적");
            msg = (TextView) myview.findViewById(R.id.message);
            msg.setText("상어를 키우는 게임입니다.\n앞으로도 상어를 키워주세요.\n\n오픈 라이센스\n"
            +"android-ripple-background\nhttps://github.com/skyfishjy/android-ripple-background");
//                msg.setText("당신은 " + myWin + "승 " + myLose + "패하셨습니다.\n앞으로도 상어를 키워주세요.");
            Button mbtn1 = (Button) myview.findViewById(R.id.btn1);
            mbtn1.setText("확인");
            mbtn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });

            Button mbtn2 = (Button) myview.findViewById(R.id.btn2);
            mbtn2.setText("게임종료");
            mbtn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().finish();
                }
            });
            mBuilder.setView(myview);

            return mBuilder.create();
        }

        @Override
        public void onStop() {
            super.onStop();
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id) {
            case 0:
                LayoutInflater lif = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = lif.inflate(R.layout.dialog, null);
                final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                TextView message = (TextView) view.findViewById(R.id.message);
                message.setText("상어가 자랄 수 있도록\n"
                        + "물고기를 많이 잡아주세요.\n"
                        + "30마리 파란 물고기를 잡으면\n상어가 이기고,\n"
                        + "3마리 빨간 물고기를 잡으면\n상어가 패배합니다.\n"
                        + "상어가 이기게 도와주세요!!");
                Button btn1 = (Button) view.findViewById(R.id.btn1);
                btn1.setText("센서모드");
                btn1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        intent.putExtra("모드", "센서");
                        startActivity(intent);
                        finish();
                    }
                });
                Button btn2 = (Button) view.findViewById(R.id.btn2);
                btn2.setText("터치모드");
                btn2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        intent.putExtra("모드", "터치");
                        startActivity(intent);
                        finish();
                    }
                });
                view.findViewById(R.id.title).setBackgroundResource(R.color.brown);
                view.findViewById(R.id.btn1).setBackgroundResource(R.color.brown);
                view.findViewById(R.id.btn2).setBackgroundResource(R.color.brown);
                dialog.setView(view);

                return dialog.create();
            case LICENSE:
                String[] list = {"아", "FAB-Loading"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle("오픈 라이센스").setItems(list, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                return dlg.create();
        }
        return super.onCreateDialog(id);
    }

}//end of class
