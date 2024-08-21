package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import com.example.jhserviceapp.domain.entity.article.ArticleCount
import javax.inject.Inject

class AddArticleCountsUseCase @Inject constructor(
    private val reportDao: ReportDao
) {
    suspend fun addArtCounts(list: List<ArticleCount>){
        reportDao.addArticleCounts(list)
    }
}