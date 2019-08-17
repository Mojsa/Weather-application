package com.cicko.weatheraoplication

import android.app.Application

class App : Application(){

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
           // private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}