package com.rogowskibart.zadanior.adapter

import androidx.recyclerview.widget.RecyclerView

class ItemDeleter(private val taskAdapter: TaskAdapter) {
    fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }


}