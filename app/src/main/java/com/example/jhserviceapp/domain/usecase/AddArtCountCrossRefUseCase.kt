package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import com.example.jhserviceapp.domain.entity.article.ArticleCountCrossRef
import javax.inject.Inject

data class AddArtCountCrossRefUseCase @Inject constructor(
    private val reportDao: ReportDao
) {
    suspend fun addCrossRef(crossRef: List<ArticleCountCrossRef>) =
        reportDao.addArticleWithCountCrossRef(crossRef)
}