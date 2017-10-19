package com.jpk.myapplication.activites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
        Utils.loadAds(mAdapterAdView)
    }

    /*fun loadAd() {
        // Sample adapter banner.
        val mAdapterAdView: AdView = findViewById(R.id.adView)
        val mopubExtras = MoPubAdapter.BundleBuilder()
                .build()
        val facebookExtras = FacebookAdapter.FacebookExtrasBundleBuilder()
                .setNativeAdChoicesIconExpandable(false)
                .build()

        val inMobiExtras = Bundle()
        inMobiExtras.putString(InMobiNetworkKeys.AGE_GROUP,
                InMobiNetworkValues.BETWEEN_35_AND_54)

        val bannerAdRequest = AdRequest.Builder()
                .addNetworkExtrasBundle(FacebookAdapter::class.java, facebookExtras)
                .addNetworkExtrasBundle(MoPubAdapter::class.java, mopubExtras)
                .addNetworkExtrasBundle(InMobiAdapter::class.java, inMobiExtras)
                .build()
        mAdapterAdView.loadAd(bannerAdRequest)
    }*/

    override fun onPause() {
        super.onPause()
        System.exit(1)
    }
}
