package com.rogowskibart.zadanior.adapter

import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.HandlerCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rogowskibart.zadanior.database.AppDatabase
import com.rogowskibart.zadanior.databinding.ItemTaskBinding
import com.rogowskibart.zadanior.model.Task
import kotlin.concurrent.thread

class TaskAdapter(private val database: AppDatabase) : RecyclerView.Adapter<TaskViewHolder>() {
    private val handler = HandlerCompat.createAsync(Looper.getMainLooper())
    private var tasks = mutableListOf<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size

    fun remove(position: Int) {
        if (position !in tasks.indices) return
        val task = tasks.removeAt(position)
        thread { database.tasks.delete(task.id) }
        notifyItemRemoved(position)
    }

    fun reload() = thread {
        val data = database.tasks.getAll().map { it.toTaskModel() }
        notifyChanges(data)
    }

    fun sort() = thread {
        val data = tasks.sortedBy { it.name }
        notifyChanges(data)
    }

    private fun notifyChanges(newData: List<Task>) {
        val callback = TaskDiffCallback(tasks, newData)
        val diffs = DiffUtil.calculateDiff(callback)
        tasks = newData.toMutableList()
        handler.post {
            diffs.dispatchUpdatesTo(this)
        }
    }
}