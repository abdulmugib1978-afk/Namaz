package com.namazapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prayer_tracking")
data class PrayerTracking(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val date: String, // YYYY-MM-DD
    val prayerName: String,
    val isPrayed: Boolean = false,
    val praiedTime: String? = null,
    val editedAt: Long = System.currentTimeMillis()
)
