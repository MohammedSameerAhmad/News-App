package com.sameerapps.newsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
Created by Mohammed Sameer Ahmad Android learning
 */

@HiltAndroidApp
class NewsApp(): Application() {
    override fun onCreate() {
        super.onCreate()
    }
}