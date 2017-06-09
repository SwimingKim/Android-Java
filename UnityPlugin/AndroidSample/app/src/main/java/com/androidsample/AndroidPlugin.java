package com.androidsample;

/**
 * Created by suyoung on 2017. 6. 9..
 */

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class AndroidPlugin{

//    public static void showDialog(final Activity activity, final String title, final String msg, final String objName, final String funcName) {
//
//        activity.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                final AlertDialog.Builder ab = new AlertDialog.Builder(activity);
//                final EditText editText = new EditText(activity);
//
//                editText.setText("메시지를 입력하세요");
//

//                ab.setTitle(title)
//                .setMessage(msg)
//                .setView(editText)
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        String text = editText.getText().toString();
//                        Toast toast = Toast.makeText(activity.getApplicationContext(), text, Toast.LENGTH_SHORT);
//                        toast.show();
//                        UnityPlayer.UnitySendMessage(objName, funcName, text);
//                        dialog.dismiss();
//                    };
//                });
//
//                Log.v("UnityPlugin", "Create AlertDialog!!");
//                ab.create();
//                ab.show();
//
//            }
//        });
//    }

    public Activity mUnityActivity = null;
    public String  strMessage = null;

    public void setUnityActivity(Activity obj) {
        mUnityActivity = obj;
    }

    public void showToast(final String strMessage) {
        this.strMessage = strMessage;

        mUnityActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mUnityActivity, strMessage, Toast.LENGTH_LONG).show();
                Log.d("Unity", "Toast 출력");
            }
        });
    }

    public void showDialog(final String title, final String msg, final String objName, final String funcName) {
        mUnityActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("Unity", "Create AlertDialog!!");

//                final android.support.v7.app.AlertDialog.Builder ab = new AlertDialog.Builder(mUnityActivity);
//                final EditText editText = new EditText(mUnityActivity);
//
//                editText.setText("메시지를 입력하세요");
//
//                ab.setTitle(title);
//                ab.setMessage(msg);
//                ab.setView(editText);
//                ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        String text = editText.getText().toString();
//                        Toast toast = Toast.makeText(mUnityActivity.getApplicationContext(), text, Toast.LENGTH_SHORT);
//                        toast.show();
//                        // UnityPlayer.UnitySendMessage("프리팹이름", "함수이름", "매개변수");
//                        UnityPlayer.UnitySendMessage(objName, funcName, text);
//                        dialog.dismiss();
//                    };
//                });
//                ab.create();
//                ab.show();

                // UnityPlayer.UnitySendMessage("프리팹이름", "함수이름", "매개변수");
                UnityPlayer.UnitySendMessage(objName, funcName, "Hello");

            }
        });
    }

}
