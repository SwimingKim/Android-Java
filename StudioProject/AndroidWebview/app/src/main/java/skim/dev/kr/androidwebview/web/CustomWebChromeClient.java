package skim.dev.kr.androidwebview.web;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by suyoung on 2018. 3. 9..
 */
public class CustomWebChromeClient extends WebChromeClient {

    private Activity activity;

    public CustomWebChromeClient(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
        AlertDialog alertDialog = new AlertDialog.Builder(activity).setMessage(message).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                result.confirm();
            }
        }).setCancelable(false).create();

        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                result.cancel();
            }
        });

        if (activity.isFinishing()) {
            result.confirm();
        } else {
            alertDialog.show();
        }

        return true;
    }

    @Override
    public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
        AlertDialog alertDialog = new AlertDialog.Builder(activity).setMessage(message).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                result.confirm();
            }
        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                result.cancel();
            }
        }).setCancelable(false).create();

        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                result.cancel();
            }
        });

        if (activity.isFinishing()) {
            result.cancel();

        } else {
            alertDialog.show();
        }

        return true;
    }
}