package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import javax.inject.Inject

class GetDefaultArticlesUseCase @Inject constructor(
    private val reportDao: ReportDao
) {
    suspend fun getDefaultArticles() = reportDao.getDefaultArticles()
}