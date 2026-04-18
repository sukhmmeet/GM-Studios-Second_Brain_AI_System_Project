package com.dhaliwal.secondbrainaisystem.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Util {
    fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("dd MMM, HH:mm", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}