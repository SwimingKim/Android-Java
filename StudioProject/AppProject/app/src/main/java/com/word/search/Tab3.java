package com.word.search;

import android.app.Activity;

import com.word.search.com.word.search.util.ActivityHostFragment;

/**
 * Created by SuYoung on 2016-11-04.
 */
public class Tab3 extends ActivityHostFragment {

    @Override
    protected Class<? extends Activity> getActivityClass() {
        return RealTab3.class;
    }

}
