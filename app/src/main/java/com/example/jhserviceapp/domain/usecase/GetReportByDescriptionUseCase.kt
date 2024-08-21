package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import javax.inject.Inject

data class GetReportByDescriptionUseCase @Inject constructor(
    private val reportDao: ReportDao
) {
    suspend fun getReportByDescription(request: String) = reportDao.getReportByDescription(request)
}