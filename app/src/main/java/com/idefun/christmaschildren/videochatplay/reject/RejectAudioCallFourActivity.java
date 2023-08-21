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
import com.idefun.christmaschildren.videochatplay.play.PlayAudioFourActivity;
import com.pesonal.adsdk.AppManage;

public class RejectAudioCallFourActivity extends AppCompatActivity {
    long k = 0;
    MediaPlayer m;
    String n = "1";
    drf l = new drf(this);
    private View pos;
    MediaPlayer audioPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_reject_audio_call_four);
        AppManage.getInstance(RejectAudioCallFourActivity.this).loadInterstitialAd(this);
        AppManage.getInstance(RejectAudioCallFourActivity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("");

        sb.append(this.l.b());
        this.n = sb.toString();
        this.m = MediaPlayer.create(this, R.raw.fb_messenger_tone);
        this.m.start();
        this.m.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                RejectAudioCallFourActivity.this.m.start();
                RejectAudioCallFourActivity.this.m();
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
        AppManage.getInstance(RejectAudioCallFourActivity.this).showInterstitialAd(RejectAudioCallFourActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {
                pos = view;
                k();
                startActivity(new Intent(view.getContext(), PlayAudioFourActivity.class));
                finish();
            }
        }, "", AppManage.app_mainClickCntSwAd);


    }

    public void reject_call(View view) {
        AppManage.getInstance(RejectAudioCallFourActivity.this).showInterstitialAd(RejectAudioCallFourActivity.this, new AppManage.MyCallback() {
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
            AppManage.getInstance(RejectAudioCallFourActivity.this).showInterstitialAd(RejectAudioCallFourActivity.this, new AppManage.MyCallback() {
                public void callbackCall() {
                    startActivity(new Intent(RejectAudioCallFourActivity.this, DashboardActivity.class));
                }
            }, "", AppManage.app_mainClickCntSwAd);

        } else {
            Toast.makeText(getBaseContext(), "Call will decline if you press again", 0).show();
        }
        this.k = System.currentTimeMillis();
    }

    @SuppressLint("WrongConstant")
    public void a(String str) {
        Toast.makeText(getApplicationContext(), str, 1).show();
    }
}