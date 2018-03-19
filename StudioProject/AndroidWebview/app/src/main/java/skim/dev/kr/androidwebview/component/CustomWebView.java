package skim.dev.kr.androidwebview.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by suyoung on 2018. 3. 9..
 */

public class CustomWebView extends WebView {

    public CustomWebView(Context context) {
        super(context);
        init();
    }

    public CustomWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setLoadWithOverviewMode(true);
//        settings.setUseWideViewPort(true);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(false);
        settings.setDefaultTextEncodingName("UTF-8");

        // Setting Local Storage
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);

        // No Cache
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        setBackgroundColor(Color.argb(0, 1, 1, 1));


    }
}