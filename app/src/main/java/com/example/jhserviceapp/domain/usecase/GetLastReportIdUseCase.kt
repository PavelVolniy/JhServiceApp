package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import javax.inject.Inject

class GetLastReportIdUseCase @Inject constructor(
    private val reportDao: ReportDao
) {
    suspend fun getLastReportId(): Long = reportDao.getLastReportId()
}