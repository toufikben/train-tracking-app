package com.example.traintracking

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TrainTrackingApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize app-level dependencies
    }
}