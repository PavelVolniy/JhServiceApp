package com.example.jhserviceapp.di

import android.content.Context
import androidx.room.Room
import com.example.jhserviceapp.data.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ReportModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "db"
    ).build()

    @Singleton
    @Provides
    fun provideReportDao(db: AppDatabase) = db.reportDao()
}