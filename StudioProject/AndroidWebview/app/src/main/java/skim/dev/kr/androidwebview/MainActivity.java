package skim.dev.kr.androidwebview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebViewClient;
import android.widget.EditText;

import skim.dev.kr.androidwebview.component.CustomWebView;
import skim.dev.kr.androidwebview.event.OnCustomJavaScriptListener;
import skim.dev.kr.androidwebview.event.OnWebViewListener;
import skim.dev.kr.androidwebview.web.CustomJavaScript;
import skim.dev.kr.androidwebview.web.CustomWebViewClient;

/**
 * Created by suyoung on 2018. 3. 9..
 */

public class MainActivity extends Activity {

    private CustomJavaScript customJavaScript;
    private CustomWebView webView;
    EditText etKeyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = getIntent();
//        Log.d("!!", intent.getStringExtra("!!"));


        webView = (CustomWebView) findViewById(R.id.view_web);
        webView.loadUrl("file:///android_asset/testjavascript.html");
        webView.setWebViewClient(new CustomWebViewClient(new OnWebViewListener() {
            @Override
            public void onFinish(String url) {

            }

            @Override
            public void onUrlChange(String url) {
                Log.d("!!!", url);
            }
        }));

        webView.setWebViewClient(new WebViewClient());

        customJavaScript = new CustomJavaScript(this);
        customJavaScript.setOnCustomJavascriptListener(new OnCustomJavaScriptListener() {
            @Override
            public void onUpdateKeyword(final String keyword) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        etKeyword.setText(keyword);
                        Log.d("!!", keyword);
                    }
                });
            }

            @Override
            public void onChangeWebView(String url) {
                webView.loadUrl(url);
                Log.d("!!", url);
            }

            @Override
            public void hideKeyboard() {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(webView.getWindowToken(), 0);

            }
        });
        webView.addJavascriptInterface(customJavaScript, "Android");

        etKeyword = (EditText) findViewById(R.id.et_keyword);

    }

}
