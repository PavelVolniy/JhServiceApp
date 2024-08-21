package com.example.jhserviceapp.domain.entity.report

import androidx.room.Embedded
import androidx.room.Relation
import com.example.jhserviceapp.domain.entity.WorkingWeek

data class WeekWithReports(
    @Embedded
    val week: WorkingWeek,
    @Relation(
        parentColumn = "week_id",
        entityColumn = "report_id"
    )
    val reports: List<ReportDTO>
)