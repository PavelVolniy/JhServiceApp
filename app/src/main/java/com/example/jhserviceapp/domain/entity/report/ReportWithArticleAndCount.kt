package com.example.jhserviceapp.domain.entity.report

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.jhserviceapp.domain.entity.article.ArticleDTO
import com.example.jhserviceapp.domain.entity.article.ArticleWithCount


data class ReportWithArticleAndCount(
    @Embedded
    val report: ReportDTO,
    @Relation(
        entity = ArticleDTO::class,
        parentColumn = "reportId",
        entityColumn = "articleId",
        associateBy = Junction(ReportArticleCrossRef::class)
    )
    val articles: List<ArticleWithCount>,
)