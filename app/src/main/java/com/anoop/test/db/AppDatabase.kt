package com.anoop.test.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.anoop.test.model.Employee


@Database(entities = [Employee::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "messages"
                ).build()
            }

            return INSTANCE!!
        }
    }


    fun destroyInstance() {
        INSTANCE = null
    }

    abstract fun employeeDao(): EmployeeDao

}
