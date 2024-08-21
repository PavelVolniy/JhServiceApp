package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import com.example.jhserviceapp.domain.entity.article.ArticleDTO
import javax.inject.Inject

data class DeleteArticlesUseCase @Inject constructor(
    private val reportDao: ReportDao
) {
    suspend fun deleteArticles(listArt: List<ArticleDTO>) {
        reportDao.deleteArticles(listArt)
    }
}