package com.example.jhserviceapp.di

import android.content.Context
import android.content.SharedPreferences
import com.example.jhserviceapp.App
import dagger.Module
import dagger.Provides

@Module
object SharedPrefModule {
    @Provides
    fun provideSharedPref(context: Context): SharedPreferences =
        context.getSharedPreferences(App.SHARED_PREF_NAME, Context.MODE_PRIVATE)
}