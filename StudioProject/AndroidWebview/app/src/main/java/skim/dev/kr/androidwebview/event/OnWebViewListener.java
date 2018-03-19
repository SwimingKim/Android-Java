package skim.dev.kr.androidwebview.event;

/**
 * Created by suyoung on 2018. 3. 9..
 */
public interface OnWebViewListener {

    void onFinish(String url);

    void onUrlChange(String url);
}