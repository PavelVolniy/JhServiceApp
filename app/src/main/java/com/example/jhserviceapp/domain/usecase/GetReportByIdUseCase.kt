package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import javax.inject.Inject

class GetReportByIdUseCase @Inject constructor(
    private val reportDao: ReportDao
) {
    suspend fun getReportById(id: Long) = reportDao.getReportById(id)
}