package com.idefun.christmaschildren.videochatplay.Christmas;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.idefun.christmaschildren.videochatplay.R;
import com.pesonal.adsdk.AppManage;

public class FourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        AppManage.getInstance(FourActivity.this).loadInterstitialAd(this);
        AppManage.getInstance(FourActivity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
    }

    @Override
    public void onBackPressed() {
        AppManage.getInstance(FourActivity.this).showInterstitialAd(FourActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {

                FourActivity.super.onBackPressed();
                overridePendingTransition(R.anim.back_slide_in, R.anim.back_slide_out);
            }
        }, "", AppManage.app_mainClickCntSwAd);
    }
}