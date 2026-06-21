package com.namazapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [PrayerTime::class, PrayerTracking::class, UserSettings::class],
    version = 1,
    exportSchema = false
)
abstract class NamazDatabase : RoomDatabase() {
    abstract fun namazDao(): NamazDao

    companion object {
        @Volatile
        private var INSTANCE: NamazDatabase? = null

        fun getInstance(context: Context): NamazDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    NamazDatabase::class.java,
                    "namaz_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
