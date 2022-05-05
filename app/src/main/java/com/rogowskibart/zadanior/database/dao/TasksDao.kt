package com.rogowskibart.zadanior.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rogowskibart.zadanior.model.dto.TaskDto

@Dao
interface TasksDao {

    @Insert
    fun insert(taskDto: TaskDto)

    @Query("DELETE FROM taskdto WHERE id = :taskId")
    fun delete(taskId: Long)

    @Query("SELECT * FROM taskdto")
    fun getAll(): List<TaskDto>
}