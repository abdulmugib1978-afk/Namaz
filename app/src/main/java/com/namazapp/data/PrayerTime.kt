package com.namazapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prayer_times")
data class PrayerTime(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val prayerName: String, // Fajr, Dhuhr, Asr, Maghrib, Isha
    val prayerTime: String, // HH:mm
    val endTime: String,
    val alarmMinutesBefore: Int = 10,
    val alarmSound: String = "azan",
    val isEnabled: Boolean = true,
    val lastUpdated: Long = System.currentTimeMillis()
)
