package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import javax.inject.Inject


class GetAllReportsUseCase @Inject constructor(
    private val reportDao: ReportDao
) {
    suspend fun getReports() = reportDao.getAllReports()
}