package com.example.jhserviceapp.domain.entity.article

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleDTO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("articleId")
    var articleId: Long,
    @ColumnInfo("articleName")
    var articleName: String,
    @ColumnInfo("isDefault")
    var isDefault: Boolean = false
)