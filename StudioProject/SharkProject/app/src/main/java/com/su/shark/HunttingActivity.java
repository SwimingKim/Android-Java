package com.su.shark;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static com.su.shark.R.layout.dialog;

class EdWard {
    int x, y;
    int dx, dy;
    ImageView iv;

    public EdWard(int x, int y, int dx, int dy, ImageView iv) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.iv = iv;
    }
}

class Kakao {
    int x, y;
    int dx, dy;
    ImageView iv;

    public Kakao(int x, int y, int dx, int dy, ImageView iv) {
        super();
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.iv = iv;
    }
}

public class HunttingActivity extends Activity {
    SensorManager sm;
    Sensor sensor;
    Random ran;
    private ImageView sally;
    AbsoluteLayout al;
    AnimationDrawable ad_ed;
    AnimationDrawable ad_ka;

    int count = 0;
    int chance = 1;
    String heart = "♥♥♥";
    final int MAX_ED_NUM = 20;
    final int MAX_KA_NUM = 5;
    ArrayList<EdWard> list = new ArrayList<EdWard>();
    ArrayList<Kakao> rival = new ArrayList<Kakao>();

    int state = -1;

    int level;

    private Intent intent;
    Handler handler = new Handler(Looper.getMainLooper());
    Runnable r_ed = new Runnable() {//에드워드와 카카오톡 생성
        public void run() {
            // 카카오톡 생성
            if (list.size() < MAX_ED_NUM) {
                ImageView iv = new ImageView(getApplicationContext());
                iv.setBackgroundResource(R.drawable.frame_chink);
                ad_ed = (AnimationDrawable) iv.getBackground();
                ad_ed.start();
                al.addView(iv, 100, 100);

                int x = (ran.nextInt(2) == 0) ? 0 : w - sally.getWidth();
                int y = (ran.nextInt(2) == 0) ? 0 : h - sally.getHeight() - 200;

                int dx = ((ran.nextInt(2) == 0) ? 1 : (-1)) * (ran.nextInt(5) + 1);
                int dy = ((ran.nextInt(2) == 0) ? 1 : (-1)) * (ran.nextInt(5) + 1);

                list.add(new EdWard(x, y, dx, dy, iv));

                up.bringToFront();
                down.bringToFront();
                left.bringToFront();
                right.bringToFront();
                tv_level.bringToFront();
                tv_fish.bringToFront();
                tv_chance.bringToFront();
                sally.bringToFront();
            }


            for (int i = list.size() - 1; i >= 0; i--) {
                EdWard ed = list.get(i);
                ed.x += ed.dx;
                ed.y += ed.dy;

                float xd = Math.abs(ed.x - (sally.getX() + 0.3f * level - 0.3f * (chance - 1)));
                float yd = Math.abs(ed.y - (sally.getY() + 0.3f * level - 0.3f * (chance - 1)));

                if (state == -1) {
                    if (ed.x < 0 || ed.x > al.getWidth() || ed.y < 0 || ed.y > al.getHeight()) {
                        al.removeView(ed.iv);
                        list.remove(i);
                    } else if (xd < (sally.getWidth()) / 2
                            && yd < (sally.getHeight()) / 2) {
                        if (count == 10) {
                            count = 0;
                            level++;
                            tv_level.setText("Level : " + level);
                            sally.setScaleX(sally.getScaleX() + 0.3f);
                            sally.setScaleY(sally.getScaleY() + 0.3f);
                            Toast.makeText(getApplicationContext(), "Level Up", Toast.LENGTH_SHORT).show();
                            if (level == 3) {
                                chance = -1;
                                level = 4;
                                Timer timer = new Timer();
                                TimerTask task = new TimerTask() {
                                    public void run() {
                                        state = 0;
                                        handler.removeCallbacks(r_finish);
                                        new DialogThread().run();
                                    }
                                };
                                timer.schedule(task, 3000);
                                sally.setBackgroundResource(R.drawable.smileshark);
                                ad_ka.stop();
                                ad.stop();
                                handler.post(r_finish);
                                sm.unregisterListener(sc, sensor);
                            }

                        } else {
                            tv_fish.setText("Catch : " + count);
                            al.removeView(ed.iv);
                            list.remove(i);
                            count++;
                        }
                    } else {
                        ed.iv.setX(ed.x);
                        ed.iv.setY(ed.y);
                    }
                }

            }


            // 카카오톡 관리
            if (rival.size() < MAX_KA_NUM) {
                ImageView iv_ka = new ImageView(getApplicationContext());
                iv_ka.setBackgroundResource(R.drawable.frame_ka);
                ad_ka = (AnimationDrawable) iv_ka.getBackground();
                ad_ka.start();
                al.addView(iv_ka, 100, 100);

                int x = ran.nextInt(w);
                int y = ran.nextInt(h);

                int dx = ((ran.nextInt(2) == 0) ? 1 : (-1)) * (ran.nextInt(5) + 1);
                int dy = ((ran.nextInt(2) == 0) ? 1 : (-1)) * (ran.nextInt(5) + 1);

                rival.add(new Kakao(x, y, dx, dy, iv_ka));

                up.bringToFront();
                down.bringToFront();
                left.bringToFront();
                right.bringToFront();
                tv_level.bringToFront();
                tv_fish.bringToFront();
                tv_chance.bringToFront();
                sally.bringToFront();
            }


            for (int i = rival.size() - 1; i >= 0; i--) {
                Kakao ka = rival.get(i);
                ka.x += ka.dx;
                ka.y += ka.dy;

                float xd = Math.abs(ka.x - (sally.getX() + 0.3f * level - 0.3f * (chance - 1)));
                float yd = Math.abs(ka.y - (sally.getY() + 0.3f * level - 0.3f * (chance - 1)));

                if (state == -1) {
                    if (ka.x < 0 || ka.x > al.getWidth() || ka.y < 0 || ka.y > al.getHeight()) {
                        al.removeView(ka.iv);
                        rival.remove(i);
                    } else if (xd < (sally.getWidth()) / 2
                            && yd < (sally.getHeight()) / 2) {
                        if (chance == 4) {
                            level = 4;
                            chance++;
                            sally.setBackgroundResource(R.drawable.madshark);
                            ad_ed.stop();
                            ad.stop();
                            handler.post(r_finish);
                            sm.unregisterListener(sc, sensor);
                            TimerTask task = new TimerTask() {
                                public void run() {
                                    state = 1;
                                    handler.removeCallbacks(r_finish);
                                    new DialogThread().run();
                                }
                            };
                            Timer timer = new Timer();
                            timer.schedule(task, 3000);
                        } else {
                            Toast.makeText(getApplicationContext(), "Chance lose", Toast.LENGTH_SHORT).show();
                            sally.setScaleX(sally.getScaleX() - 0.3f);
                            sally.setScaleY(sally.getScaleY() - 0.3f);
                            al.removeView(ka.iv);
                            rival.remove(i);
                            if (chance != 5) {
                                tv_chance.setText("Chance : " + heart.substring(chance));
                                chance++;
                            }
                        }
                    } else {
                        ka.iv.setX(ka.x);
                        ka.iv.setY(ka.y);
                    }
                }

            }

            handler.postDelayed(r_ed, 40);
        }
    };
    Runnable r_finish = new Runnable() {
        float a = 3;

        public void run() {
            sally.setScaleX(a);
            sally.setScaleY(a);
            a += 0.5f;
            handler.postDelayed(r_finish, 300);
        }
    };

    Handler han = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            showDialog(state);
        }
    };

    class DialogThread extends Thread {
        @Override
        public void run() {
            Message msg = han.obtainMessage();
            han.sendMessage(msg);
        }
    }

    private String str;
    private SensorClass sc;
    private int w;
    private int h;
    private AnimationDrawable ad;
    private TextView tv_level;
    private TextView tv_fish;
    private TextView tv_chance;
    private Button up;
    private Button down;
    private Button left;
    private Button right;
    private long backKeyPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hutting);
        MobileAds.initialize(getApplicationContext(), R.string.banner_ad_unit_id + "");

        al = (AbsoluteLayout) findViewById(R.id.layout);

        tv_level = (TextView) findViewById(R.id.level);
        tv_fish = (TextView) findViewById(R.id.fish);
        tv_chance = (TextView) findViewById(R.id.chance);

        tv_level.setText("Level : " + 0);
        tv_fish.setText("Catch : " + 0);
        tv_chance.setText("Chance : " + "♥♥♥");

        up = (Button) findViewById(R.id.up);
        down = (Button) findViewById(R.id.down);
        left = (Button) findViewById(R.id.left);
        right = (Button) findViewById(R.id.right);

        Intent pri = getIntent();
        str = pri.getStringExtra("모드");
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sc = new SensorClass();

        if ("센서".equals(str)) {
            up.setVisibility(View.GONE);
            down.setVisibility(View.GONE);
            left.setVisibility(View.GONE);
            right.setVisibility(View.GONE);
            sensor = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        } else if ("터치".equals(str)) {
            sm.unregisterListener(sc);
        }

        intent = new Intent(getApplicationContext(), LastActivity.class);
        ran = new Random();

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display dp = wm.getDefaultDisplay();
        Point p = new Point();
        dp.getSize(p);
        w = p.x;
        h = p.y;

        sally = new ImageView(getApplicationContext());
        sally.setBackgroundResource(R.drawable.frame_sally);
        ad = (AnimationDrawable) sally.getBackground();
        al.addView(sally, 200, 180);
        sally.setX(500);
        sally.setY(700);

        handler.post(r_ed);

        up.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                float py = sally.getY() - 15;
                if (py < 0) {
                    py = 0;
                }
                sally.setY(py);
                ad.start();
                return false;
            }
        });
        down.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                float py = sally.getY() + 15;
                if (py > h - sally.getHeight() - 200) {
                    py = h - sally.getHeight() - 200;
                }
                sally.setY(py);
                ad.start();
                return false;
            }
        });
        left.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                float px = sally.getX() - 15;
                if (px < 0) {
                    px = 0;
                }
                sally.setX(px);
                ad.start();
                return false;
            }
        });
        right.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                float px = sally.getX() + 15;
                if (px > w - sally.getWidth()) {
                    px = w - sally.getWidth();
                }
                sally.setX(px);
                ad.start();
                return false;
            }
        });


        AdView av = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("356432055509926").build();
        av.loadAd(adRequest);

    }//end of onCreate

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(sc, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(sc, sensor);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(r_ed);
        handler.removeCallbacks(r_finish);
    }

    class SensorClass implements SensorEventListener {
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        public void onSensorChanged(SensorEvent event) {
            if (event.values != null) {
                ad.start();
                float px = sally.getX() - event.values[2] * 0.5f;
                float py = sally.getY() - event.values[1] * 0.5f;

                if (px < 0) px = 0;
                if (px > w - sally.getWidth()) px = w - sally.getWidth();

                if (py < 0) py = 0;
                if (py > h - sally.getHeight() - 200) py = h - sally.getHeight() - 200;

                sally.setX(px);
                sally.setY(py);
            }
        }

    }

    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(getApplicationContext(), "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish();
        }
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
            case 1:
                LayoutInflater lif = (LayoutInflater) getApplicationContext().getSystemService(getApplicationContext().LAYOUT_INFLATER_SERVICE);
                View view = lif.inflate(dialog, null);
                AlertDialog.Builder dialog1 = new AlertDialog.Builder(this);
                String result = (id == 0) ? "승리" : "패배";
                ((TextView) (view.findViewById(R.id.title))).setText("게임" + result);
                ((TextView) (view.findViewById(R.id.message))).setText("게임에서 " + result + "했습니다.\n다시 게임을 시작하시겠습니까?");
                if (id == 0) {
                    view.findViewById(R.id.title).setBackgroundResource(R.color.blue);
                    view.findViewById(R.id.btn1).setBackgroundResource(R.color.blue);
                    view.findViewById(R.id.btn2).setBackgroundResource(R.color.blue);
                }
                view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), HunttingActivity.class);
                        intent.putExtra("모드", str);
                        startActivity(intent);
                        finish();
                    }
                });
                view.findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                dialog1.setView(view);
                return dialog1.create();
        }
        return super.onCreateDialog(id);
    }
}//end of class
