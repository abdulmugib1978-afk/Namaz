package com.namazapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_settings")
data class UserSettings(
    @PrimaryKey val id: Int = 1,
    val location: String = "Dhaka, Bangladesh",
    val latitude: Double = 23.8103,
    val longitude: Double = 90.4125,
    val timeZone: String = "Asia/Dhaka",
    val language: String = "bn",
    val theme: String = "light",
    val notificationEnabled: Boolean = true,
    val lastBackup: Long = 0
)
