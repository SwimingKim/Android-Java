package skim.dev.kr.androidwebview.web;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import skim.dev.kr.androidwebview.event.OnCustomJavaScriptListener;

/**
 * Created by suyoung on 2018. 3. 9..
 */

public class CustomJavaScript {

    Context mContext;
    private OnCustomJavaScriptListener listener;

    /** Instantiate the interface and set the context */
    public CustomJavaScript(Context c) {
        mContext = c;
    }

    public void setOnCustomJavascriptListener(OnCustomJavaScriptListener listener) {
        this.listener = listener;
    }

    @JavascriptInterface
    public void updateKeyword(String keyword) {
        if (listener != null) {
            listener.onUpdateKeyword(keyword);
        }
    }

    @JavascriptInterface
    public void changeWebView(String url) {
        if (listener != null) {
            listener.onChangeWebView(url);
        }
    }

    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

}
