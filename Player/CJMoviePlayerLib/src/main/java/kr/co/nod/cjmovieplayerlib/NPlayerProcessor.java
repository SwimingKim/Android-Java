package kr.co.nod.cjmovieplayerlib;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.coden.nplayerplus.NPlayerView;
import com.coden.nplayerplus.define.PLAYER_ENUM;
import com.coden.nplayerplus.define.PLAYER_NOTIFY_VALUE;
import com.coden.nplayerplus.outinterface.OnLoadingDlgListener;
import com.coden.nplayerplus.outinterface.PlayerListener;

/**
 * Created by suyoung on 2017. 11. 12..
 */

public class NPlayerProcessor {

    private static final String API_KEY = "c1eb45d679814459a6cded32643be9a9";
    private static final String DOMAIN = "coden.co.kr";

    private Activity m_pMainAct;
    private NPlayerView player;

    private Boolean mIsSoftOnly = false;

    public NPlayerProcessor(Activity pMainAct) {
        m_pMainAct = pMainAct;
        String strPermission = Manifest.permission.READ_PHONE_STATE;

        int nOsVer = Build.VERSION.SDK_INT;
        if (nOsVer >= Build.VERSION_CODES.M) {
            int result =  ContextCompat.checkSelfPermission(m_pMainAct, strPermission);

            if (ContextCompat.checkSelfPermission(m_pMainAct, strPermission)
                    != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(m_pMainAct, strPermission)) {
                    // Show an expanation to the user *asynchronously* -- don't block

                } else {
                    ActivityCompat.requestPermissions(m_pMainAct, new String[]{strPermission}, 1);
                }
            }
        }

        player = (NPlayerView) m_pMainAct.findViewById(R.id.playerView);
        player.Auth.init_data(m_pMainAct, API_KEY, DOMAIN, "");
        player.NMediaPlayer.setPlayerListener(playerlistener);

        PLAYER_ENUM.E_DECODER_MODE decoder_mode = PLAYER_ENUM.E_DECODER_MODE.AUTO;
        if (nOsVer > 22) {
//             decoder_mode = PLAYER_ENUM.E_DECODER_MODE.SOFTWARE;
        }

//        player.NMediaPlayer.setCodecMode(decoder_mode, PLAYER_ENUM.E_RENDERER_MODE.AUTO); //비디오 코덱 및 렌더러 설정
        player.NMediaPlayer.setSpeedRange(0.6f, 2.0f);
//        player.NMediaPlayer.setCaptionTextView((TextView) m_pMainAct.findViewById(R.id.tv_caption));

        //로딩 및 seek 시 로딩 다이얼로그 출력
        player.NMediaPlayer.setOnLoadingDlgListener(new OnLoadingDlgListener() {

            @Override
            public void onCancel() {
                // 로딩 취소 시 이벤트

            }

        });
    }

    public void onRestart() {
        if (player != null)
            player.onRestart();
    }

    public void onPause() {
        if (player != null)
            player.onPause();
    }

    public void onStop() {
        if (player != null)
            player.onStop();
    }

    public void onDestroy() {
        if (player != null)
            player.onDestroy();
    }


    public void PlayerPath(String filepath, String CaptionPath, int nStartPos, String session_id) {
        boolean isLocal = true;

        if (filepath.substring(0, 7).equals("http://"))
            isLocal = false;

        player.NMediaPlayer.setMediaPath(filepath, isLocal);
        player.NMediaPlayer.setCaptionPath(CaptionPath);
        player.NMediaPlayer.setMediaStartTime(nStartPos);
        player.Auth.setSession_id(session_id);
    }

    public void MediaStart() {
        if (player != null)
            CheckNetWork(true);
    }

    public void MediaResume() {
        if (player != null)
            CheckNetWork(false);
    }

    public void MediaPause() {
        if (player != null)
            player.NMediaPlayer.pause();
    }

    public void MediaPrevSeek() {
        if (player != null)
            player.NMediaPlayer.previousSeek(10);
    }

    public void MediaNextSeek() {
        if (player != null)
            player.NMediaPlayer.nextSeek(10);
    }

    public void speedChange(float speed) {
        if (player != null)
            player.NMediaPlayer.speedChange(speed);
    }

    public float getSpeedValue() {
        float value = 1;
        if (player != null)
            value = player.NMediaPlayer.getSpeedValue();

        return value;
    }

    public PLAYER_ENUM.E_PLAYER_STATUS getPlayState() {
        return player.NMediaPlayer.getPlayState();
    }

    public void MediaVideoScreenModeChange() {
        if (player == null)
            return;

        if (player.NMediaPlayer.getVideoScreenMode() == PLAYER_ENUM.E_VIDEO_SCREEN_MODE.RATIO)
            player.NMediaPlayer.setVideoScreenModeChange(PLAYER_ENUM.E_VIDEO_SCREEN_MODE.FULL);
        else player.NMediaPlayer.setVideoScreenModeChange(PLAYER_ENUM.E_VIDEO_SCREEN_MODE.RATIO);
    }


    private void CheckNetWork(boolean isStart) {
        PLAYER_ENUM.E_NETWORK_STATE network_state = player.NMediaPlayer.getNetWorkState();
        if (network_state == PLAYER_ENUM.E_NETWORK_STATE.CONNECTED_WIFI) {
            if (isStart)
                player.NMediaPlayer.start();
            else player.NMediaPlayer.resume();
        } else {
            if (network_state == PLAYER_ENUM.E_NETWORK_STATE.CONNECTED_3G) {
                Set3GNetWorkMessageBoxUSE(isStart);
            } else {
                SetNetWorkMessageBox("네트워크 연결을 확인해 주세요.", isStart);
            }
        }
    }

    private void SetNetWorkMessageBox(String strMessage, final boolean isStart) {
        new AlertDialog.Builder(m_pMainAct)
                .setTitle("확인")
                .setCancelable(false)
                .setMessage(strMessage)

                // 확인버튼
                .setPositiveButton("다시 시도하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (isStart)
                            MediaStart();
                        else MediaResume();
                    }
                })
                .setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_pMainAct.finish();
                    }
                })
                .show();
    }

    private void Set3GNetWorkMessageBoxUSE(final boolean isStart) {


        new AlertDialog.Builder(m_pMainAct)
                .setTitle("3G/4G이용안내")
                .setCancelable(false)
                .setMessage("이동통신사 무선인터넷(3G/4G)을 이용하실 경우 가입하신 요금제에 따라 데이터 요금이 추가 될 수 있습니다.")

                .setNeutralButton("재생하기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (isStart)
                            MediaStart();
                        else MediaResume();
                    }
                })
                .setNegativeButton("종료하기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        m_pMainAct.finish();
                        return;
                    }
                })
                .show();
    }

    private PlayerListener playerlistener = new PlayerListener() {
        @Override
        public void onNetWorkStateNotify(PLAYER_ENUM.E_NETWORK_STATE arg0) {
            // TODO Auto-generated method stub
            Log.e("onNetWorkStateNotify", arg0 + "");

            if (arg0 == PLAYER_ENUM.E_NETWORK_STATE.NOT_CONNECTED) {
                if (getPlayState() == PLAYER_ENUM.E_PLAYER_STATUS.PLAY
                        && !player.NMediaPlayer.isLocalFile()) {
                    MediaPause();
                }
            }
        }

        @Override
        public void onPlayErrorNotify(final PLAYER_NOTIFY_VALUE.E_ERROR_NOTIFY arg0, final String msg) {
            // TODO Auto-generated method stub

            m_pMainAct.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    Toast.makeText(m_pMainAct, arg0 + ":" + msg, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onPlayStatusNotify(final PLAYER_NOTIFY_VALUE.E_PLAY_NOTIFY arg0) {
            // TODO Auto-generated method stub

            m_pMainAct.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    /*if(arg0 == E_PLAY_NOTIFY.PLAY_NOTIFY_PAUSE)
                        ((PlayerActivity)m_pMainAct).btn_play.setText("재생");
					else if(arg0 == E_PLAY_NOTIFY.PLAY_NOTIFY_PLAY || arg0 == E_PLAY_NOTIFY.PLAY_NOTIFY_LOADING_COMPLETE)
						((PlayerActivity)m_pMainAct).btn_play.setText("일시정지");
					*/
                    //Toast.makeText(m_pMainAct, arg0+"", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onPlayTimeNotify(float currentTime, float duration) {
            // TODO Auto-generated method stub
            Log.e("onPlayTimeNotify", currentTime + "/" + duration);
        }


    };

}
