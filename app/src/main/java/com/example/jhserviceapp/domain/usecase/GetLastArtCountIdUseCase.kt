package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import javax.inject.Inject

data class GetLastArtCountIdUseCase @Inject constructor(
    private val reportDao: ReportDao
) {
//    suspend fun getLastId() = reportDao.getLastArticleCount()
}