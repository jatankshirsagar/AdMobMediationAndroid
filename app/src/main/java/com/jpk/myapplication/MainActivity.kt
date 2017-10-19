package com.jpk.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.ads.mediation.facebook.FacebookAdapter
import com.google.ads.mediation.inmobi.InMobiAdapter
import com.google.ads.mediation.inmobi.InMobiNetworkKeys
import com.google.ads.mediation.inmobi.InMobiNetworkValues
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.mopub.mobileads.dfp.adapters.MoPubAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this, getString(R.string.admob_id))
        loadAd()
    }

    fun loadAd() {
        // Sample adapter banner.
        val mAdapterAdView: AdView = findViewById(R.id.adView)
        val bundle = MoPubAdapter.BundleBuilder()
                .setPrivacyIconSize(15)
                .build()
        val extras = FacebookAdapter.FacebookExtrasBundleBuilder()
                .setNativeAdChoicesIconExpandable(true)
                .build()

        val inMobiExtras = Bundle()
        inMobiExtras.putString(InMobiNetworkKeys.AGE_GROUP,
                InMobiNetworkValues.BETWEEN_35_AND_54)
        inMobiExtras.putString(InMobiNetworkKeys.AREA_CODE, "12345")

        val bannerAdRequest = AdRequest.Builder()
                .addNetworkExtrasBundle(FacebookAdapter::class.java, extras)
                .addNetworkExtrasBundle(MoPubAdapter::class.java, bundle)
                .addNetworkExtrasBundle(InMobiAdapter::class.java, inMobiExtras)
                //.addTestDevice(Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID))
                .build()
        mAdapterAdView.loadAd(bannerAdRequest)
    }
}
