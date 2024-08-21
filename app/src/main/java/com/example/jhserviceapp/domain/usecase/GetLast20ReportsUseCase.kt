package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import javax.inject.Inject


class GetLast20ReportsUseCase @Inject constructor(
    private val reportDao: ReportDao
) {
    suspend fun getReports() = reportDao.getLast20Reports()
}