package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import com.example.jhserviceapp.domain.entity.report.ReportDTO
import javax.inject.Inject

class AddReportUseCase @Inject constructor(
    private val reportDao: ReportDao
) {
    suspend fun addReport(report: ReportDTO) {
        reportDao.addReport(report)
    }
}