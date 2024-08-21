package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import com.example.jhserviceapp.domain.entity.report.ReportDTO
import com.example.jhserviceapp.domain.entity.report.ReportWithArticleAndCount
import javax.inject.Inject

class DeleteReportUseCase @Inject constructor(
    private val reportDao: ReportDao
) {
    suspend fun deleteReport(report: ReportDTO) {
        reportDao.deleteReport(report)
    }
}