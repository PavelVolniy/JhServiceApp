package com.example.jhserviceapp

import android.app.Application
import com.example.jhserviceapp.di.DaggerAppComponent
import com.example.jhserviceapp.domain.entity.User

class App : Application() {
    val appComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    companion object{
        const val USER_NAME = "user_name"
        const val USER_NUMBER = "user_number"
        const val SHARED_PREF_NAME = "shared_pref_name"
        const val EDITABLE_REPORT = "editable_report"
    }
}