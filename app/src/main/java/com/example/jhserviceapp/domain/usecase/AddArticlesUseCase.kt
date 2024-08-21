package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import com.example.jhserviceapp.domain.entity.article.ArticleDTO
import javax.inject.Inject

data class AddArticlesUseCase @Inject constructor(
    private val reportDao: ReportDao
){
    suspend fun addArticles(listArt: List<ArticleDTO>){
        reportDao.addArticles(listArt)
    }
}