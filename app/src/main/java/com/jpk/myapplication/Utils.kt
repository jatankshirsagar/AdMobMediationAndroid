package com.jpk.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.ads.mediation.facebook.FacebookAdapter
import com.google.ads.mediation.inmobi.InMobiAdapter
import com.google.ads.mediation.inmobi.InMobiNetworkKeys
import com.google.ads.mediation.inmobi.InMobiNetworkValues
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.mopub.mobileads.dfp.adapters.MoPubAdapter
import com.vungle.mediation.VungleExtrasBuilder
import com.vungle.mediation.VungleInterstitialAdapter


object Utils {

    fun loadBannerAd(view: View) {
        // Sample adapter banner.
        val mAdapterAdView: AdView = view as AdView
        val mopubExtras = MoPubAdapter.BundleBuilder()
                .build()
        val facebookExtras = FacebookAdapter.FacebookExtrasBundleBuilder()
                .setNativeAdChoicesIconExpandable(false)
                .build()

        val inMobiExtras = Bundle()
        inMobiExtras.putString(InMobiNetworkKeys.AGE_GROUP,
                InMobiNetworkValues.BETWEEN_35_AND_54)

        // build network extras bundle
        val vungleExtras = VungleExtrasBuilder()
                .setUserId("userId")
                .setSoundEnabled(false)
                .build()

        val bannerAdRequest = AdRequest.Builder()
                .addNetworkExtrasBundle(FacebookAdapter::class.java, facebookExtras)
                .addNetworkExtrasBundle(MoPubAdapter::class.java, mopubExtras)
                .addNetworkExtrasBundle(InMobiAdapter::class.java, inMobiExtras)
                .addNetworkExtrasBundle(VungleInterstitialAdapter::class.java, vungleExtras)
                .build()

        mAdapterAdView.loadAd(bannerAdRequest)
    }

    fun loadInterstitialAd(context: Context) {
        val mInterstitialAd = InterstitialAd(context)
        mInterstitialAd.adUnitId = context.getString(R.string.admob_id)

        val vungleExtras = VungleExtrasBuilder()
                .setUserId("userId")
                .setSoundEnabled(false)
                .build()

        val adRequest = AdRequest.Builder()
                .addNetworkExtrasBundle(VungleInterstitialAdapter::class.java, vungleExtras)
                .addTestDevice("BD2B6EA9B18672FF166D0E9CB70B9C26")
                .build()
        mInterstitialAd.loadAd(adRequest)

        mInterstitialAd.adListener = object : AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i("Ads", "onAdLoaded")
                mInterstitialAd.show()
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
                Log.i("Ads", "onAdFailedToLoad")
            }

            override fun onAdOpened() {
                // Code to be executed when the ad is displayed.
                Log.i("Ads", "onAdOpened")
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i("Ads", "onAdLeftApplication")
            }

            override fun onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                Log.i("Ads", "onAdClosed")
            }
        }
    }
}
