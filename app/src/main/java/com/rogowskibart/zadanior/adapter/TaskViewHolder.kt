package com.rogowskibart.zadanior.adapter

import android.app.Application
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.rogowskibart.zadanior.databinding.ItemTaskBinding
import com.rogowskibart.zadanior.model.Task

class TaskViewHolder(private val layoutBinding: ItemTaskBinding) : RecyclerView.ViewHolder(layoutBinding.root), View.OnLongClickListener {

    init {
        itemView.setOnLongClickListener(this)
    }

    fun bind(task: Task) = with(layoutBinding) {
        taskNameTv.text = task.name
        taskPriorityTv.text = task.priority.toString()
        taskPercentageTv.text = task.percentage.toString()
        taskDeadlineTv.text = task.deadline.toString()
    }

    override fun onLongClick(view: View): Boolean {
        Toast.makeText(view.context, "long click ${this.layoutBinding.taskNameTv.text}", Toast.LENGTH_SHORT)
            .show()
        return true
    }
}