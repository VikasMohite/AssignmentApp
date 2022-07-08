package com.example.turtlemintassignment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [IssuesData::class, CommentsData::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun issueDao(): IssuesDataDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDbInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "Issue_Database"
                ).allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }
    }
}