package com.example.jhserviceapp.domain.entity.article

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_count")
data class ArticleCount(
    @PrimaryKey
    @ColumnInfo("articleCountId")
    var articleCountId: Int,
    @ColumnInfo("engineerNumber")
    var engineerNumber: Int,
    @ColumnInfo("isPaid")
    var isPaid: Boolean
)