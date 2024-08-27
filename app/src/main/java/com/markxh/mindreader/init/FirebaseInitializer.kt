package com.markxh.mindreader.init

import android.content.Context
import androidx.startup.Initializer
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics

class FirebaseInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        // Initialize Firebase
        FirebaseApp.initializeApp(context)

        // Set up Firebase Analytics
        val firebaseAnalytics = FirebaseAnalytics.getInstance(context)

        // Log app open event
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, null)
    }

    override fun dependencies() = emptyList<Class<out Initializer<*>>>()
}