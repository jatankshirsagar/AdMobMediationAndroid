package com.jpk.myapplication

import android.os.Bundle
import android.view.View
import com.google.ads.mediation.facebook.FacebookAdapter
import com.google.ads.mediation.inmobi.InMobiAdapter
import com.google.ads.mediation.inmobi.InMobiNetworkKeys
import com.google.ads.mediation.inmobi.InMobiNetworkValues
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.mopub.mobileads.dfp.adapters.MoPubAdapter


object Utils {

    fun loadAds(view: View) {
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

        val bannerAdRequest = AdRequest.Builder()
                .addNetworkExtrasBundle(FacebookAdapter::class.java, facebookExtras)
                .addNetworkExtrasBundle(MoPubAdapter::class.java, mopubExtras)
                .addNetworkExtrasBundle(InMobiAdapter::class.java, inMobiExtras)
                .build()
        mAdapterAdView.loadAd(bannerAdRequest)
    }
}
