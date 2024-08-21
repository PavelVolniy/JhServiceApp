package com.example.jhserviceapp.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "working_week")
data class WorkingWeek(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "week_id")
    val weekId: Long? = null,
    @ColumnInfo(name = "date_start")
    val dateStart: Long,
    @ColumnInfo(name = "date_end")
    val dateEnd: Long
)