package com.example.jhserviceapp.domain.entity.article

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_count_cross_ref")
data class ArticleCountCrossRef(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("artCountCrossRefId")
    val artCountCrossRefId: Long? = null,
    @ColumnInfo("articleId")
    val articleId: Long,
    @ColumnInfo("articleCountId")
    val articleCountId: Int,
    @ColumnInfo("byReportId")
    val byReportId: Long
)