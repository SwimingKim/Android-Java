package com.word.search;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static com.word.search.RealTab1.myDataset;
import static com.word.search.RealTab1.resultList;
import static com.word.search.RealTab1.sResult;
import static com.word.search.RealTab1.strItem0;
import static com.word.search.RealTab1.strItem1;
import static com.word.search.RealTab1.strItem2;
import static com.word.search.RealTab1.wordAdapter;
import static com.word.search.RealTab1.wordList;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost mTabHost;
    private ViewPager pager;
    private MyPagerAdapter adapter;
    private MenuItem searchMenuItem;
    public SearchView searchView;
    private Toast to;
    private ArrayList<String> searchWord;
    private ListView drawerList1;
    private ArrayList<String> aTOz;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayShowTitleEnabled(true);
        ab.setDisplayUseLogoEnabled(false);
        ab.setHomeButtonEnabled(true);

        pager = (ViewPager) findViewById(R.id.viewpager);
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, Tab1.class.getName()));
        fragments.add(Fragment.instantiate(this, Tab2.class.getName()));
        fragments.add(Fragment.instantiate(this, Tab3.class.getName()));
        adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);

        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(fragments.size());

        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("단어",
                getResources().getDrawable(R.drawable.abc_ic_menu_copy_mtrl_am_alpha)),
                Tab1.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("숙어",
                getResources().getDrawable(R.drawable.abc_ic_menu_share_mtrl_alpha)),
                Tab2.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("추가",
                getResources().getDrawable(R.drawable.abc_ic_voice_search_api_mtrl_alpha)),
                Tab3.class, null);


        mTabHost.getTabWidget().getChildAt(0).setOnClickListener(tabClick);
        mTabHost.getTabWidget().getChildAt(1).setOnClickListener(tabClick);
        mTabHost.getTabWidget().getChildAt(2).setOnClickListener(tabClick);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                mTabHost.setCurrentTab(arg0);
                searchView.onActionViewCollapsed();
                if (arg0 == 0) {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                } else {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList1 = (ListView) findViewById(R.id.drawer_list);

        aTOz = new ArrayList<String>();
        char charAlpha = 'a';
        String strAlpha = "";
        aTOz.add("all");
        do {
            strAlpha = String.valueOf(charAlpha);
            aTOz.add(strAlpha);
            charAlpha = (char) (charAlpha + 1);
        } while (charAlpha <= 'z');
        ArrayAdapter<String> alphaAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, aTOz);
        drawerList1.setAdapter(alphaAdapter);
        drawerList1.setOnItemClickListener(new DrawerItemClickListener());

    }//end of onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);

        searchMenuItem = menu.findItem(R.id.search_btn);
        searchView = (SearchView) MenuItemCompat.getActionView(searchMenuItem);
        searchView.setQueryHint("영어 단어를 입력해주세요");

        // SearchView 검색어 입력/검색 이벤트 처리
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                searchView.setQuery("", false);
//                searchView.onActionViewCollapsed();
//                to.cancel();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                to = Toast.makeText(getApplicationContext(), newText, Toast.LENGTH_SHORT);
//                to.show();

                myDataset.clear();
                if (newText.toString().length() > 0) {
                    searchWord = new ArrayList<String>();
                    for (String search : sResult) {
                        if (search.contains(newText)) {
                            searchWord.add(search);
                        }
                    }
                    wordAdapter = new WordAdapter(myDataset);
                    wordList.setAdapter(wordAdapter);
                    for (int i = 0; i < searchWord.size(); i++) {
                        strItem0 = searchWord.get(i).split(",#,")[0];
                        strItem0 = strItem0.replace("\"", "");
                        strItem1 = searchWord.get(i).split(",#,")[1];
                        strItem1 = strItem1.replace("\"", "");
                        strItem2 = searchWord.get(i).split(",#,")[2];
                        strItem2 = strItem2.replace("\"", "");
                        myDataset.add(new WordData(strItem0, strItem1, strItem2));
                    }
                } else {
                    wordAdapter = new WordAdapter(myDataset);
                    wordList.setAdapter(wordAdapter);
                    resultList = new ArrayList<String>(Arrays.asList(sResult));
                    for (int i = 0; i < resultList.size(); i++) {
                        strItem0 = resultList.get(i).split(",#,")[0];
                        strItem0 = strItem0.replace("\"", "");
                        strItem1 = resultList.get(i).split(",#,")[1];
                        strItem1 = strItem1.replace("\"", "");
                        strItem2 = resultList.get(i).split(",#,")[2];
                        strItem2 = strItem2.replace("\"", "");
                        myDataset.add(new WordData(strItem0, strItem1, strItem2));
                    }
                }

                return true;
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener tabClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == mTabHost.getTabWidget().getChildAt(0)) {
                pager.setCurrentItem(0);
            } else if (view == mTabHost.getTabWidget().getChildAt(1)) {
                pager.setCurrentItem(1);
            } else if (view == mTabHost.getTabWidget().getChildAt(2)) {
                pager.setCurrentItem(2);
            }
        }
    };

    public class MyPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public MyPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int arg0) {
            // TODO Auto-generated method stub
            return this.fragments.get(arg0);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return this.fragments.size();
        }

    }

    private class DrawerItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String strSelect = (String) parent.getAdapter().getItem(position);
            myDataset.clear();
            drawerLayout.closeDrawer(drawerList1);

            if (strSelect.equals("all")) {
                wordAdapter = new WordAdapter(myDataset);
                wordList.setAdapter(wordAdapter);
                resultList = new ArrayList<String>(Arrays.asList(sResult));
                for (int i = 0; i < resultList.size(); i++) {
                    strItem0 = resultList.get(i).split(",#,")[0];
                    strItem0 = strItem0.replace("\"", "");
                    strItem1 = resultList.get(i).split(",#,")[1];
                    strItem1 = strItem1.replace("\"", "");
                    strItem2 = resultList.get(i).split(",#,")[2];
                    strItem2 = strItem2.replace("\"", "");
                    myDataset.add(new WordData(strItem0, strItem1, strItem2));
                }
            } else {
                searchWord = new ArrayList<String>();
                for (String search : sResult) {
                    String firstWord = search.split(",#,")[1];
                    if (firstWord.startsWith(strSelect)) {
                        searchWord.add(search);
                    }
                }

                wordAdapter = new WordAdapter(myDataset);
                wordList.setAdapter(wordAdapter);
                for (int i = 0; i < searchWord.size(); i++) {
                    Log.i("check", strItem1);
                    strItem0 = searchWord.get(i).split(",#,")[0];
                    strItem0 = strItem0.replace("\"", "");
                    strItem1 = searchWord.get(i).split(",#,")[1];
                    strItem1 = strItem1.replace("\"", "");
                    strItem2 = searchWord.get(i).split(",#,")[2];
                    strItem2 = strItem2.replace("\"", "");
                    myDataset.add(new WordData(strItem0, strItem1, strItem2));
                }
            }
        }
    }

}