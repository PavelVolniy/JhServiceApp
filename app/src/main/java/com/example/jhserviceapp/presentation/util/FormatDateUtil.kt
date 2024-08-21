package com.example.jhserviceapp.presentation.util

import java.text.SimpleDateFormat
import java.util.Locale

object FormatDateUtil {
    private const val DATE_PATTERN_DDMMYY = "dd.MM.yy"
    private const val DATE_PATTERN_YYMMDD = "yyyyMMdd"
    fun getDateToStringDDMMYY(date: Long): String =
        SimpleDateFormat(DATE_PATTERN_DDMMYY, Locale.US).format(date)

    fun getDateToStringYYYYMMDD(date: Long): String =
        SimpleDateFormat(DATE_PATTERN_YYMMDD, Locale.US).format(date)
}