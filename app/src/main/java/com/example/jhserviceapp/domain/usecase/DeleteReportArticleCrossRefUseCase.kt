package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import javax.inject.Inject

data class DeleteReportArticleCrossRefUseCase @Inject constructor(
    private val reportDao: ReportDao
) {
    suspend fun deleteCrossRef(reportId: Long) =
        reportDao.deleteReportArticleCrossRef(reportId)
}