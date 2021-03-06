package com.rogowskibart.zadanior.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rogowskibart.zadanior.database.dao.TasksDao
import com.rogowskibart.zadanior.model.dto.TaskDto

private const val DATABASE_FILENAME = "tasks"

@Database(entities = [TaskDto::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val tasks: TasksDao

    companion object {
        fun open(context: Context): AppDatabase =
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DATABASE_FILENAME
            )
//                .createFromAsset("tasks.db")
                .build()
    }
}