package com.rogowskibart.zadanior.adapter

import androidx.recyclerview.widget.DiffUtil
import com.rogowskibart.zadanior.model.Task

class TaskDiffCallback(private val before: List<Task>, private val after: List<Task>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = before.size
    override fun getNewListSize(): Int = after.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        before[oldItemPosition].id == after[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        before[oldItemPosition].name == after[oldItemPosition].name &&
                before[oldItemPosition].priority == after[oldItemPosition].priority &&
                before[oldItemPosition].deadline == after[oldItemPosition].deadline &&
                before[oldItemPosition].percentage == after[oldItemPosition].percentage &&
                before[oldItemPosition].timeline == after[oldItemPosition].timeline

}