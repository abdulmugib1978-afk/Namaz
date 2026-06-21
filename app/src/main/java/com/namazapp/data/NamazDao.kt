package com.namazapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NamazDao {
    @Query("SELECT * FROM prayer_times ORDER BY id ASC")
    fun getAllPrayerTimes(): LiveData<List<PrayerTime>>

    @Query("SELECT * FROM prayer_times WHERE prayerName = :name")
    fun getPrayerTimeByName(name: String): LiveData<PrayerTime>

    @Insert
    suspend fun insertPrayerTime(prayer: PrayerTime)

    @Update
    suspend fun updatePrayerTime(prayer: PrayerTime)

    @Query("SELECT * FROM prayer_tracking WHERE date = :date ORDER BY id ASC")
    fun getTodayTracking(date: String): LiveData<List<PrayerTracking>>

    @Query("SELECT * FROM prayer_tracking WHERE date BETWEEN :startDate AND :endDate")
    fun getTrackingRange(startDate: String, endDate: String): LiveData<List<PrayerTracking>>

    @Insert
    suspend fun insertTracking(tracking: PrayerTracking)

    @Update
    suspend fun updateTracking(tracking: PrayerTracking)

    @Query("SELECT * FROM user_settings WHERE id = 1")
    fun getUserSettings(): LiveData<UserSettings>

    @Update
    suspend fun updateSettings(settings: UserSettings)

    @Query("SELECT COUNT(*) FROM prayer_tracking WHERE isPrayed = 1 AND date = :date")
    fun getTodayPrayedCount(date: String): LiveData<Int>
}
