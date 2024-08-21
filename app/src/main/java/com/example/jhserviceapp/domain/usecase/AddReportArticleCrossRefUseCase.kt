package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import com.example.jhserviceapp.domain.entity.report.ReportArticleCrossRef
import javax.inject.Inject

data class AddReportArticleCrossRefUseCase @Inject constructor(
    private val reportDao: ReportDao
) {
    suspend fun addCrossRef(ref: List<ReportArticleCrossRef>) {
        reportDao.addReportWithArticleCrossRef(ref)
    }
}