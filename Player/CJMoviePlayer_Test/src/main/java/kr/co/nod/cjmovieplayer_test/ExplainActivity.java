package kr.co.nod.cjmovieplayer_test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.GridView;

import kr.co.nod.cjmovieplayerlib.NPlayerProcessor;

/**
 * Created by NOD_DEV_004 on 2017-11-11.
 */

public class ExplainActivity extends Activity {

    NPlayerProcessor player = null;
    Button btn_play = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(kr.co.nod.cjmovieplayerlib.R.layout.activity_player_explain);

        player = new NPlayerProcessor(this);
        player.PlayerPath("http://www.imystudy.co.kr/release/media/chunjae/A9dseb_k2212_b03_600k.mp4", "", 0, "");
        player.MediaStart();

        String[] strs = {"1", "2", "3"};
        GridView gv = (GridView)findViewById(R.id.layout_gridview);
        CustomAdatper adatper = new CustomAdatper( getApplicationContext(), R.layout.row_basicquiz, strs );
        gv.setAdapter( adatper );

    }

    //background에서 foreground로 전환 시 호출
    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();

        player.onRestart();
    }

    //background 상태로 전환 시
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        player.onPause();
    }
    //Activity onStop 시
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        player.onStop();
    }

    //Activity 종료 시
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        player.onDestroy();
    }


}
