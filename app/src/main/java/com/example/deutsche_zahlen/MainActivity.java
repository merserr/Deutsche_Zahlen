package com.example.deutsche_zahlen;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.security.SecureRandom;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener {

    private static final String LOG_TAG = "==anfang_zahlen==";
    String zahlenstring = "";
    String[] zahlen= {"21","24","32","33","35","39","43","44","45","51","53","54","55","57","68","69","73","76","78","84","89","93","95","123","139","245","249","273","284","332","356","382","458","461","545","589","627","646","742","778","869","935","943"};
    int total = zahlen.length;
    TextView work_stroke1;
    TextView work_stroke2;
    TextView textscore1;
    TextView textscore2;
    android.widget.CheckBox CheckBox;
    CheckBox CheckBox1;
    CheckBox CheckBox2;
    int index;
    String zahl = "s";
    int resID;
    MediaPlayer mediaPlayer;
    int score_ok;
    int score_not_ok;
    boolean first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_main);

        CheckBox = (CheckBox) findViewById(R.id.checkBox);
        CheckBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox2 = (CheckBox) findViewById(R.id.checkBox2);
        work_stroke1 = (TextView) findViewById(R.id.workstroke);
        textscore1 = (TextView) findViewById(R.id.score1);
        textscore2 = (TextView) findViewById(R.id.score2);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button button0 = (Button) findViewById(R.id.button10);
        Button button11 = (Button) findViewById(R.id.button11);
        Button button12 = (Button) findViewById(R.id.button12);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        work_stroke1.setOnClickListener(this);

        Random random = new Random();
        index = random.nextInt(40 + 1);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button1:
                Log.d(LOG_TAG, String.valueOf("--1--"));
                zahlenstring = zahlenstring + "1";
                work_stroke1.setText(zahlenstring);
                vibr();
                break;
            case R.id.button2:
                Log.d(LOG_TAG, "--2--");
                zahlenstring = zahlenstring + "2";
                work_stroke1.setText(zahlenstring);
                vibr();
                break;
            case R.id.button3:
                Log.d(LOG_TAG, "--3--");
                zahlenstring = zahlenstring + "3";
                work_stroke1.setText(zahlenstring);
                vibr();
                break;
            case R.id.button4:
                Log.d(LOG_TAG, "--4--");
                zahlenstring = zahlenstring + "4";
                work_stroke1.setText(zahlenstring);
                vibr();
                break;
            case R.id.button5:
                Log.d(LOG_TAG, "--5--");
                zahlenstring = zahlenstring + "5";
                work_stroke1.setText(zahlenstring);
                vibr();
                break;
            case R.id.button6:
                Log.d(LOG_TAG, "--6--");
                zahlenstring = zahlenstring + "6";
                work_stroke1.setText(zahlenstring);
                vibr();
                break;
            case R.id.button7:
                Log.d(LOG_TAG, "--7--");
                zahlenstring = zahlenstring + "7";
                work_stroke1.setText(zahlenstring);
                vibr();
                break;
            case R.id.button8:
                Log.d(LOG_TAG, "--8--");
                zahlenstring = zahlenstring + "8";
                work_stroke1.setText(zahlenstring);
                vibr();
                break;
            case R.id.button9:
                Log.d(LOG_TAG, "--- Insert in mytable: ---");
                zahlenstring = zahlenstring + "9";
                work_stroke1.setText(zahlenstring);
                vibr();
                break;
            case R.id.button10:
                Log.d(LOG_TAG, "--9--");
                zahlenstring = zahlenstring + "0";
                work_stroke1.setText(zahlenstring);
                vibr();
                break;
            case R.id.button11:
                Log.d(LOG_TAG, "==Button C==");
                //zahlenstring = zahlenstring + "2";
                zahlenstring = "";
                work_stroke1.setText(zahlenstring);
                vibr();
                break;

            case R.id.button12:
                Log.d(LOG_TAG, "==Button_NEXT==");
                Log.d(LOG_TAG, zahlenstring);
                Log.d(LOG_TAG, zahlen[index]);
                vibr();

                if((zahlen[index]).equals(zahlenstring)){
                    score_ok = score_ok + 1;
                    textscore1.setText(String.valueOf(score_ok));
                    work_stroke1.setTextColor(Color.GREEN);
                    play();

                }else{
                    if(first&&!CheckBox2.isChecked()) {
                        score_not_ok = score_not_ok + 1;
                        textscore2.setText(String.valueOf(score_not_ok));
                        work_stroke1.setTextColor(Color.RED);
                    }
                    work_stroke1.setText(zahlen[index]);
                    play();

                }

                if(!first){
                    work_stroke1.setTextColor(Color.WHITE);

                    SecureRandom  random = new SecureRandom();
                    index = random.nextInt(total);
                    zahl = "s" + zahlen[index];
                    Log.d(LOG_TAG, zahl);
                    play();

                    if(CheckBox2.isChecked()){
                        work_stroke1.setText(zahlen[index]);
                    }else{
                        work_stroke1.setText("---");
                    }
                    zahlenstring = "";
                    first = true;
                }else{

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            //--------------------------------------------------------
                            work_stroke1.setTextColor(Color.WHITE);

                            SecureRandom  random = new SecureRandom ();
                            index = random.nextInt(total);
                            zahl = "s" + zahlen[index];
                            Log.d(LOG_TAG, zahl);


                            if(CheckBox2.isChecked()){
                                work_stroke1.setText(zahlen[index]);

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        play();
                                    }
                                }, 4000);
                            }else{
                                work_stroke1.setText("---");
                                play();
                            }
                            zahlenstring = "";

                            //--------------------------------------------------------
                        }
                    }, 4000);
                }

//;;;;;;;;;;;;;

                break;
            case R.id.workstroke:
                play();
                break;

        }


    }
    void play(){
        //  if(mediaPlayer.){mediaPlayer.release();}

        releaseMP();
        resID=getResources().getIdentifier(zahl, "raw", getPackageName());
        mediaPlayer=MediaPlayer.create(this,resID);
        mediaPlayer.setOnCompletionListener((MediaPlayer.OnCompletionListener) this);
        mediaPlayer.start();
        //      mediaPlayer.setOnCompletionListener(this);
    }
    private void releaseMP() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
                mediaPlayer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    void vibr(){
        int vibrmillis = 60;
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(vibrmillis);
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }
}