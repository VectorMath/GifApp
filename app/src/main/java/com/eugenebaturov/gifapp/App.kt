package com.eugenebaturov.gifapp

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        AppRepository.initialize(this)
    }
}