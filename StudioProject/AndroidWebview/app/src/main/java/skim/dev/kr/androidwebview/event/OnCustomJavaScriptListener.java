package skim.dev.kr.androidwebview.event;

/**
 * Created by suyoung on 2018. 3. 9..
 */
public interface OnCustomJavaScriptListener {

    void onUpdateKeyword(String keyword);

    void onChangeWebView(String url);

    void hideKeyboard();
}