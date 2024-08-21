package com.example.jhserviceapp.domain.usecase

import com.example.jhserviceapp.data.ReportDao
import javax.inject.Inject

class DeleteArticleWithCrossRef @Inject constructor(
    private val reportDao: ReportDao
) {

    suspend fun deleteArticleWithCrossRef(id: Long) = reportDao.delArticleWithCountCrossRef(id)
}