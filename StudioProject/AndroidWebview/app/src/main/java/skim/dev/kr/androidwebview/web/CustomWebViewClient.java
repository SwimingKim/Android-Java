package skim.dev.kr.androidwebview.web;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import skim.dev.kr.androidwebview.event.OnWebViewListener;

/**
 * Created by suyoung on 2018. 3. 9..
 */
public class CustomWebViewClient extends WebViewClient {

    private OnWebViewListener listener;

    public CustomWebViewClient(OnWebViewListener listener) {
        this.listener = listener;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Log.d("TAG", "request : " + request.getUrl());
        shouldOverrideUrlLoading(view, request.getUrl().toString());
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.d("TAG", "request : " + url);
        if (listener != null) {
            listener.onUrlChange(url);
        }
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        Log.d("TAG", "url : " + url);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        Log.e("TAG", "url " + url);
        if (listener != null) {
            listener.onFinish(url);
        }
        super.onPageFinished(view, url);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);

        Log.i("TAG", "error number : " + error.getErrorCode());
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        Log.i("TAG", "error number : " + errorCode);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        super.onReceivedHttpError(view, request, errorResponse);

        Log.d("TAG", "onReceivedHttpError " + errorResponse.getStatusCode());
    }
}