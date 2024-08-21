package com.example.jhserviceapp.domain.entity.report

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "report_article_cross_ref")
data class ReportArticleCrossRef(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("crossRefId")
    val crossRefId: Long? = null,
    @ColumnInfo("reportId")
    val reportId: Long,
    @ColumnInfo("articleId")
    val articleId: Long
)