package com.dhaliwal.secondbrainaisystem.data.local

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val tags: List<String>,
    val createdAt: Long
)