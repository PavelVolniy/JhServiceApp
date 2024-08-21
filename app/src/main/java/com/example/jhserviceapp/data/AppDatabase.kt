package com.example.jhserviceapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jhserviceapp.domain.entity.article.ArticleCount
import com.example.jhserviceapp.domain.entity.article.ArticleCountCrossRef
import com.example.jhserviceapp.domain.entity.article.ArticleDTO
import com.example.jhserviceapp.domain.entity.report.ReportArticleCrossRef
import com.example.jhserviceapp.domain.entity.report.ReportDTO

@Database(
    entities = [ReportDTO::class,
        ArticleDTO::class,
        ReportArticleCrossRef::class,
        ArticleCountCrossRef::class,
        ArticleCount::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun reportDao(): ReportDao
}