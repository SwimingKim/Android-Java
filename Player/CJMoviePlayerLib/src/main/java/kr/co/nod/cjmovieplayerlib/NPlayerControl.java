package kr.co.nod.cjmovieplayerlib;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.coden.nplayerplus.NPlayerController;
import com.coden.nplayerplus.NPlayerView;
import com.coden.nplayerplus.define.PLAYER_ENUM;
import com.coden.nplayerplus.define.PLAYER_NOTIFY_VALUE;
import com.coden.nplayerplus.outinterface.CaptionListener;
import com.coden.nplayerplus.outinterface.OnLoadingDlgListener;
import com.coden.nplayerplus.outinterface.PLAYER_EVENT;
import com.coden.nplayerplus.outinterface.PlayerEventListener;
import com.coden.nplayerplus.outinterface.PlayerListener;

/**
 * Created by suyoung on 2017. 11. 12..
 */

public class NPlayerControl {

    // 천재 교육 api_key "8f227b892ffd4292bcf9f2ab3d583db3"
    private static final String API_KEY = "c1eb45d679814459a6cded32643be9a9";//사이트 고유 키값
    // 천재 교육 domain "hbstudy.co.kr"
    private static final String DOMAIN = "coden.co.kr";//도메인 주소

    private Activity m_pMainAct;
    private NPlayerView player; //MediaPlayer
    private NPlayerController playerCtl = null; //MediaPlayer Control

    private FrameLayout.LayoutParams pPlayerNormalScreenParam = null; //MediaPlayer 크기 및 위치 저장 용
    private FrameLayout.LayoutParams pPlayerCtrlNormalScreenParam = null; //MediaPlayer Control 크기 및 위치 저장 용
    private PLAYER_EVENT.E_SCREEN_CHG ScreenMode = PLAYER_EVENT.E_SCREEN_CHG.NORMAL; //MediaPlayer 화면 크기 모드(전체화면/기본화면)
    private PLAYER_EVENT.E_LOCK_CHG LockMode = PLAYER_EVENT.E_LOCK_CHG.UNLOCK; //MediaPlayer 컨트롤 락 기능

    //동영상 변경 이벤트 리스너
    private PlayChgListener playChgLintener = null;

    public PlayChgListener getPlayChgLintener() {
        return playChgLintener;
    }

    public void setPlayChgLintener(PlayChgListener playChgLintener) {
        this.playChgLintener = playChgLintener;
    }

    public interface PlayChgListener {
        public void onPlayNextEventNotify();

        public void onPlayPreviousEventNofify();
    }


    public PLAYER_EVENT.E_SCREEN_CHG getScreenMode() {
        return ScreenMode;
    }

    public void setScreenMode(PLAYER_EVENT.E_SCREEN_CHG ScreenMode) {
        this.ScreenMode = ScreenMode;
    }

    public PLAYER_EVENT.E_LOCK_CHG getLockMode() {
        return LockMode;
    }

    public void setLockMode(PLAYER_EVENT.E_LOCK_CHG lockMode) {
        LockMode = lockMode;
    }

    public NPlayerControl(Activity pMainAct) {
        m_pMainAct = pMainAct;

        player = (NPlayerView) m_pMainAct.findViewById(R.id.playerView);

        player.Auth.init_data(m_pMainAct, API_KEY, DOMAIN, "");    //MediaPlayer 인증 값 전달
        player.NMediaPlayer.setPlayerListener(playerlistener); //MediaPlayer 리스너 등록

        PLAYER_ENUM.E_DECODER_MODE decoder_mode = PLAYER_ENUM.E_DECODER_MODE.AUTO;
        int nOsVer = Build.VERSION.SDK_INT;
        if (nOsVer > 22) {
            decoder_mode = PLAYER_ENUM.E_DECODER_MODE.SOFTWARE;
        }

        player.NMediaPlayer.setCodecMode(decoder_mode, PLAYER_ENUM.E_RENDERER_MODE.AUTO); //비디오 코덱 및 렌더러 설정

        player.NMediaPlayer.setCaptionListener(captionlistener);

        player.NMediaPlayer.setSpeedRange(0.6f, 2.0f); //배속 범위 지정
        //로딩 및 seek 시 로딩 다이얼로그 출력
        player.NMediaPlayer.setOnLoadingDlgListener(new OnLoadingDlgListener() {

            @Override
            public void onCancel() {
                // 로딩 취소 시 이벤트

            }

        });
        //전체 화면 시 MediaPlayer Control 숨기기
        player.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (getScreenMode() == PLAYER_EVENT.E_SCREEN_CHG.FULL) {
                        if (playerCtl.getVisibility() == View.VISIBLE) {
                            playerCtl.setVisibility(View.GONE);
                        } else {
                            playerCtl.setVisibility(View.VISIBLE);
                        }
                    }
                }

                return false;
            }
        });

//        //MediaPlayer Control 가져오기
//        playerCtl = (NPlayerController) m_pMainAct.findViewById(R.id.playerCtrl);
//        //MediaPlayer Control 리스너 등록
//        playerCtl.setPlayerEventListener(playerEventlistener);


    }

    //background에서 foreground로 전환 시 호출
    public void onRestart() {
        if (player != null)
            player.onRestart();
    }

    //background 상태로 전환 시
    public void onPause() {
        if (player != null)
            player.onPause();
    }

    //Activity 종료 시
    public void onDestroy() {
        if (player != null)
            player.onDestroy();
    }

    //Activity onStop 시
    public void onStop() {
        if (player != null)
            player.onStop();
    }

    //Play할 동영상 경로, 재생 시작 시간(초단위), 세션 id 입력
    public void PlayerPath(String filepath, int nStartPos, String session_id) {
        boolean isLocal = true;

        if (filepath.substring(0, 7).equals("http://"))
            isLocal = false;

        player.NMediaPlayer.setMediaPath(filepath, isLocal);
        player.NMediaPlayer.setMediaStartTime(nStartPos);
        player.Auth.setSession_id(session_id);

    }

    //재생 시작
    public void MediaStart() {
        if (player != null)
            CheckNetWork(true);
    }

    //재 시작
    public void MediaResume() {
        if (player != null)
            CheckNetWork(false);
    }

    //일시정지
    public void MediaPause() {
        if (player != null)
            player.NMediaPlayer.pause();
    }

    //앞으로 10초 이동
    public void MediaPrevSeek() {
        if (player != null)
            player.NMediaPlayer.previousSeek(10);
    }

    //뒤로 10초 이동
    public void MediaNextSeek() {
        if (player != null)
            player.NMediaPlayer.nextSeek(10);
    }

    //재생 이동(초단위)
    public void MediaSeek(int nSec) {
        if (player != null)
            player.NMediaPlayer.seekTo(nSec);
    }

    //배속 조절
    public void speedChange(float speed) {
        if (player != null)
            player.NMediaPlayer.speedChange(speed);
    }

    //현재 배속 값 전달
    public float getSpeedValue() {
        float value = 1;
        if (player != null)
            value = player.NMediaPlayer.getSpeedValue();

        return value;
    }

    //MediaPlayer 현재 상태 값 전달
    public PLAYER_ENUM.E_PLAYER_STATUS getPlayState() {
        return player.NMediaPlayer.getPlayState();
    }

    //비디오 화면 비율 조절
    public void MediaVideoScreenModeChange() {
        if (player == null)
            return;

        if (player.NMediaPlayer.getVideoScreenMode() == PLAYER_ENUM.E_VIDEO_SCREEN_MODE.RATIO)
            player.NMediaPlayer.setVideoScreenModeChange(PLAYER_ENUM.E_VIDEO_SCREEN_MODE.FULL);
        else player.NMediaPlayer.setVideoScreenModeChange(PLAYER_ENUM.E_VIDEO_SCREEN_MODE.RATIO);
    }

    // 미디어 전체 재생 시간
    public float getMediaDuration() {
        if (player == null)
            return 0;

        return player.NMediaPlayer.getMediaDuration();
    }

    //현재 재생 시간
    public float getMediaCurrentTime() {
        if (player == null)
            return 0;

        return player.NMediaPlayer.getMediaCurrentTime();
    }

    /*네트워크 체크 후 재생
     *  isStart : true -> 처음 재생 시
     *  isStart : false -> 일시 정지 후 재 시작 시
     */
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

    //네트워크 연결이 되어 있지 않을 경우 메시지 처리
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

    //네트워크가 3g/let로 연결이 되어 있을 경우 메시지 처리
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

    //MediaPlayer 리스너
    private PlayerListener playerlistener = new PlayerListener() {
        //네트워크 상태 콜백 함수
        @Override
        public void onNetWorkStateNotify(PLAYER_ENUM.E_NETWORK_STATE network_state) {
            // TODO Auto-generated method stub
            Log.e("onNetWorkStateNotify", network_state + "");

            if (network_state == PLAYER_ENUM.E_NETWORK_STATE.NOT_CONNECTED) {
                if (getPlayState() == PLAYER_ENUM.E_PLAYER_STATUS.PLAY
                        && !player.NMediaPlayer.isLocalFile()) {
                    MediaPause();
                }
            }
        }

        //MediaPlayer Error 콜백 함수
        @Override
        public void onPlayErrorNotify(final PLAYER_NOTIFY_VALUE.E_ERROR_NOTIFY error_code, final String msg) {
            // TODO Auto-generated method stub

            m_pMainAct.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    playerCtl.mediaplayercontrol.setMediaDuration(0);
                    playerCtl.mediaplayercontrol.setMediaCurrentTime(0);
                    playerCtl.mediaplayercontrol.onPause();
                    Toast.makeText(m_pMainAct, error_code + ":" + msg, Toast.LENGTH_SHORT).show();
                }
            });
        }

        //MediaPayer 상태 콜백 함수
        @Override
        public void onPlayStatusNotify(final PLAYER_NOTIFY_VALUE.E_PLAY_NOTIFY play_state) {
            // TODO Auto-generated method stub

            m_pMainAct.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    if (play_state == PLAYER_NOTIFY_VALUE.E_PLAY_NOTIFY.PLAY_NOTIFY_PAUSE)
                        playerCtl.mediaplayercontrol.onPause();
                    else if (play_state == PLAYER_NOTIFY_VALUE.E_PLAY_NOTIFY.PLAY_NOTIFY_PLAY || play_state == PLAYER_NOTIFY_VALUE.E_PLAY_NOTIFY.PLAY_NOTIFY_LOADING_COMPLETE) {

                        if (play_state == PLAYER_NOTIFY_VALUE.E_PLAY_NOTIFY.PLAY_NOTIFY_LOADING_COMPLETE) {
                            playerCtl.mediaplayercontrol.setMediaDuration((int) getMediaDuration());
                            playerCtl.mediaplayercontrol.setMediaCurrentTime((int) getMediaCurrentTime());
                            playerCtl.mediaplayercontrol.setSpeedRate(String.format("%.1f", getSpeedValue()));
                        }

                        playerCtl.mediaplayercontrol.onPlay();
                    } else if (play_state == PLAYER_NOTIFY_VALUE.E_PLAY_NOTIFY.PLAY_NOTIFY_STOP || play_state == PLAYER_NOTIFY_VALUE.E_PLAY_NOTIFY.PLAY_NOTIFY_PLAY_COMPLETE) {
                        playerCtl.mediaplayercontrol.setMediaDuration(0);
                        playerCtl.mediaplayercontrol.setMediaCurrentTime(0);
                        playerCtl.mediaplayercontrol.onPause();
                    }

                    //Toast.makeText(m_pMainAct, play_state+"", Toast.LENGTH_SHORT).show();
                }
            });
        }

        //재생 시간 반환 콜백 함수(현재 재생 시간, 미디어 전체 재생 시간)
        @Override
        public void onPlayTimeNotify(float currentTime, float duration) {
            // TODO Auto-generated method stub
            Log.e("onPlayTimeNotify", currentTime + "/" + duration);

            playerCtl.mediaplayercontrol.setMediaCurrentTime((int) currentTime);
        }


    };

    //MediaPlayer Control 리스너
    private PlayerEventListener playerEventlistener = new PlayerEventListener() {

        //락 버튼 클릭 이벤트  콜백 함수
        @Override
        public void onLockEventNotify(PLAYER_EVENT.E_LOCK_CHG code) {
            // TODO Auto-generated method stub
            if (code == PLAYER_EVENT.E_LOCK_CHG.LOCK) {
                Log.e("lock", "lock");
                setLockMode(PLAYER_EVENT.E_LOCK_CHG.LOCK);
            } else if (code == PLAYER_EVENT.E_LOCK_CHG.UNLOCK) {
                setLockMode(PLAYER_EVENT.E_LOCK_CHG.UNLOCK);
                Log.e("lock", "unlock");
            }
        }

        //이전/다음 동영상 재생 버튼 클릭 이벤트 콜백 함수
        @Override
        public void onPlayChgEventNotify(PLAYER_EVENT.E_PLAY_CHG code) {
            // TODO Auto-generated method stub
            if (code == PLAYER_EVENT.E_PLAY_CHG.PREVIOUS) {
                if (getPlayChgLintener() != null)
                    getPlayChgLintener().onPlayPreviousEventNofify();
            } else if (code == PLAYER_EVENT.E_PLAY_CHG.NEXT) {
                if (getPlayChgLintener() != null)
                    getPlayChgLintener().onPlayNextEventNotify();
            }
        }

        //MediaPlayer Control 버튼 클릭 이벤트 콜백 함수
        @Override
        public void onPlayEventNotify(PLAYER_EVENT.E_PLAYER_EVENT code) {
            // TODO Auto-generated method stub
            if (code == PLAYER_EVENT.E_PLAYER_EVENT.PLAY) {
                MediaResume();
            } else if (code == PLAYER_EVENT.E_PLAYER_EVENT.PAUSE) {
                MediaPause();
            } else if (code == PLAYER_EVENT.E_PLAYER_EVENT.SEEK_PREV) {
                MediaPrevSeek();
            } else if (code == PLAYER_EVENT.E_PLAYER_EVENT.SEEK_NEXT) {
                MediaNextSeek();
            }
        }

        //SeekBar 이벤트 콜백 함수
        @Override
        public void onPlaySeekEventNotify(PLAYER_EVENT.E_SEEK code, int value) {
            // TODO Auto-generated method stub
            if (code == PLAYER_EVENT.E_SEEK.SEEKING)
                playerCtl.mediaplayercontrol.setMediaSeekingTime(value);
            else if (code == PLAYER_EVENT.E_SEEK.SEEKED)
                MediaSeek(value);
        }

        //전체 화면 클릭 이벤트 콜백 함수
        @Override
        public void onScreenChgEventNotify(PLAYER_EVENT.E_SCREEN_CHG code) {
            // TODO Auto-generated method stub

            ScreenChg(code);

        }

        //배속 버튼 클릭 이벤트 콜백 함수
        @Override
        public void onSpeedChgEventNotify(PLAYER_EVENT.E_SPEED_CHG code) {
            // TODO Auto-generated method stub
            float speedvalue = getSpeedValue();
            if (code == PLAYER_EVENT.E_SPEED_CHG.DOWN) {
                float rate = speedvalue - 0.1f;
                speedChange(rate);
            } else {
                float rate = speedvalue + 0.1f;
                speedChange(rate);
            }

            playerCtl.mediaplayercontrol.setSpeedRate(String.format("%.1f", getSpeedValue()));
        }
    };

    //전체화면 설정 함수
    public void ScreenChg(PLAYER_EVENT.E_SCREEN_CHG value) {
        final FrameLayout.LayoutParams pPlayerParam;
        final FrameLayout.LayoutParams pPlayerCtrlParam;
        if (value == PLAYER_EVENT.E_SCREEN_CHG.FULL) {
            setScreenMode(PLAYER_EVENT.E_SCREEN_CHG.FULL);
            playerCtl.mediaplayercontrol.setScreenMode(PLAYER_EVENT.E_SCREEN_CHG.FULL);
            pPlayerNormalScreenParam = (FrameLayout.LayoutParams) player.getLayoutParams();
            pPlayerCtrlNormalScreenParam = (FrameLayout.LayoutParams) playerCtl.getLayoutParams();

            pPlayerParam = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
            pPlayerParam.gravity = Gravity.CENTER;

            pPlayerCtrlParam = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
            pPlayerCtrlParam.gravity = Gravity.CENTER;
        } else {
            setScreenMode(PLAYER_EVENT.E_SCREEN_CHG.NORMAL);
            playerCtl.mediaplayercontrol.setScreenMode(PLAYER_EVENT.E_SCREEN_CHG.NORMAL);
            pPlayerParam = pPlayerNormalScreenParam;
            pPlayerCtrlParam = pPlayerCtrlNormalScreenParam;
        }

        player.setLayoutParam(pPlayerParam);

        playerCtl.setLayoutParams(pPlayerCtrlParam);
        playerCtl.setVisibility(View.VISIBLE);
    }

    //자막 이벤트
    private CaptionListener captionlistener = new CaptionListener() {

        @Override
        public void onCaptionCompleteNotify() {
            // TODO Auto-generated method stub
            m_pMainAct.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // 자막 파싱이 완료 되었을때,
                    player.NMediaPlayer.setCaptionShow(true);
                }
            });
        }

        @Override
        public void onCaptionErrorNotify(final String msg) {
            // TODO Auto-generated method stub
            m_pMainAct.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    //Toast.makeText(m_pMainAct, msg, Toast.LENGTH_SHORT).show();
                    // 자막 로드가 실패 하였을때.
                }
            });
        }

    };

    //자막경로설정
    public void setCaptionPath(String captionURL) {
        player.NMediaPlayer.setCaptionPath(captionURL);
    }

    //자막 TextView설정
    public void setCaptionTextView(TextView tv) {
        player.NMediaPlayer.setCaptionTextView(tv);
    }


    // 자막 on/off체크
    public void CaptionOn_Off() {
        if (player.NMediaPlayer.isCaptionShow()) {
            player.NMediaPlayer.setCaptionShow(false);
        } else {
            player.NMediaPlayer.setCaptionShow(true);
        }
    }
}
