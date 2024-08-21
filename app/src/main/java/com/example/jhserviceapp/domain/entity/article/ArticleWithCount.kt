package com.example.jhserviceapp.domain.entity.article

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ArticleWithCount(
    @Embedded
    val articleDTO: ArticleDTO,
    @Relation(
        parentColumn = "articleId",
        entityColumn = "articleCountId",
        associateBy = Junction(ArticleCountCrossRef::class)
    )
    val articleCount: ArticleCount
)
