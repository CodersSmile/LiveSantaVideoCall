package com.idefun.christmaschildren.videochatplay.reject;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.idefun.christmaschildren.videochatplay.R;
import com.idefun.christmaschildren.videochatplay.activity.DashboardActivity;
import com.idefun.christmaschildren.videochatplay.drf;
import com.idefun.christmaschildren.videochatplay.play.PlayVideoNewTwoActivity;
import com.pesonal.adsdk.AppManage;

public class RejectVideoCallTwoActivity extends AppCompatActivity {
    long k = 0;
    drf l = new drf(this);
    MediaPlayer m;
    String n = "1";
    private View pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_reject_video_call_two);
        AppManage.getInstance(RejectVideoCallTwoActivity.this).loadInterstitialAd(this);
        AppManage.getInstance(RejectVideoCallTwoActivity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.l.b());
        this.n = sb.toString();
        this.m = MediaPlayer.create(this, R.raw.fb_messenger_tone);
        this.m.start();
        this.m.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                RejectVideoCallTwoActivity.this.m.start();
                RejectVideoCallTwoActivity.this.m();
            }
        });
        m();
    }


    public void k() {
        MediaPlayer mediaPlayer = this.m;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.m.stop();
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        Window window = getWindow();
        window.addFlags(4194304);
        window.addFlags(524288);
        window.addFlags(2097152);
    }


    public void accept_call(View view) {
        AppManage.getInstance(RejectVideoCallTwoActivity.this).showInterstitialAd(RejectVideoCallTwoActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {
                pos = view;
                k();
                startActivity(new Intent(view.getContext(), PlayVideoNewTwoActivity.class));
                finish();
            }
        }, "", AppManage.app_mainClickCntSwAd);


    }

    public void reject_call(View view) {
        AppManage.getInstance(RejectVideoCallTwoActivity.this).showInterstitialAd(RejectVideoCallTwoActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {
                k();
                finish();
            }
        }, "", AppManage.app_mainClickCntSwAd);


    }

    @SuppressLint("WrongConstant")
    public void onBackPressed() {

        if (this.k + 2000 > System.currentTimeMillis()) {
            k();
            finish();
            startActivity(new Intent(RejectVideoCallTwoActivity.this, DashboardActivity.class));
        } else {
            Toast.makeText(getBaseContext(), "Call will decline if you press again", 0).show();
        }
        this.k = System.currentTimeMillis();
//            } else {
//                if (this.k + 2000 > System.currentTimeMillis()) {
//                    k();
//                    finish();
//                    super.onBackPressed();
//                } else {
//                    Toast.makeText(getBaseContext(), "Call will decline if you press again", 0).show();
//                }
//                this.k = System.currentTimeMillis();
//            }
//        } else {
//            if (this.k + 2000 > System.currentTimeMillis()) {
//                k();
//                finish();
//                super.onBackPressed();
//            } else {
//                Toast.makeText(getBaseContext(), "Call will decline if you press again", 0).show();
//            }
//            this.k = System.currentTimeMillis();
//        }
    }

    @SuppressLint("WrongConstant")
    public void a(String str) {
        Toast.makeText(getApplicationContext(), str, 1).show();
    }
}
