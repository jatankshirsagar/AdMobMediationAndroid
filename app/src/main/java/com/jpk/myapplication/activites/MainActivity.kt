package com.jpk.myapplication.activites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.view.View
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.jpk.myapplication.R
import com.jpk.myapplication.Utils


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this, getString(R.string.admob_id))
        val mAdapterAdView: AdView = findViewById(R.id.adView)
        Utils.loadBannerAd(mAdapterAdView)

        val btnLoadAd: AppCompatButton = findViewById(R.id.btnLoadAd)
        btnLoadAd.setOnClickListener(View.OnClickListener { Utils.loadBannerAd(mAdapterAdView) })

        val btnLoadInterstitialAd: AppCompatButton = findViewById(R.id.btnLoadInterstitialAd)
        btnLoadInterstitialAd.setOnClickListener(View.OnClickListener { Utils.loadInterstitialAd(this) })
    }

}
