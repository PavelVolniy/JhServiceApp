package com.example.jhserviceapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jhserviceapp.domain.entity.report.ReportWithArticleAndCount
import com.example.jhserviceapp.domain.usecase.DeleteReportArticleCrossRefUseCase
import com.example.jhserviceapp.domain.usecase.DeleteReportUseCase
import com.example.jhserviceapp.domain.usecase.GetAllReportsUseCase
import com.example.jhserviceapp.domain.usecase.GetLast20ReportsUseCase
import com.example.jhserviceapp.domain.usecase.GetReportByDescriptionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ReportViewModel @Inject constructor(
    private val getLast20ReportsUseCase: GetLast20ReportsUseCase,
    private val deleteReportUseCase: DeleteReportUseCase,
    private val deleteReportArticleCrossRefUseCase: DeleteReportArticleCrossRefUseCase,
    private val getReportByDescriptionUseCase: GetReportByDescriptionUseCase,
    private val getAllReportsUseCase: GetAllReportsUseCase
) : ViewModel() {
    private val _listReport = MutableStateFlow<List<ReportWithArticleAndCount>>(emptyList())
    val listReports get() = _listReport.asStateFlow()

    init {
        viewModelScope.launch {
            updateData()
        }
    }

    fun removeReport(report: ReportWithArticleAndCount) {
        viewModelScope.launch {
            _listReport.value -= report
            report.report.id?.let { deleteReportArticleCrossRefUseCase.deleteCrossRef(reportId = it) }
            deleteReportUseCase.deleteReport(report.report)
        }
    }

    suspend fun filterListByRequest(request: String) {
        if (request == "*") {
            _listReport.value = getAllReportsUseCase.getReports()
        } else {
            _listReport.value = getReportByDescriptionUseCase.getReportByDescription("%$request%")
        }
    }

    suspend fun updateData() {
        _listReport.value = emptyList()
        _listReport.value = getLast20ReportsUseCase.getReports()
    }

}