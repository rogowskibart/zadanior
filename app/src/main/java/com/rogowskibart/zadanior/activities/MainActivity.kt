package com.rogowskibart.zadanior.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rogowskibart.zadanior.App
import com.rogowskibart.zadanior.adapter.TaskAdapter
import com.rogowskibart.zadanior.database.AppDatabase
import com.rogowskibart.zadanior.databinding.ActivityMainBinding

private const val REQUEST_NEW_TASK = 1

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
//    private val database by lazy { (application as App).database }
    private val database by lazy { AppDatabase.open(this) }
//    private lateinit var database: AppDatabase
    private val taskAdapter by lazy { TaskAdapter(database) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        database = application.databaseList()
        setContentView(binding.root)
        setupTaskList()
        setupAddButton()
    }

    private fun setupTaskList() {
        binding.tasksList.apply {
            adapter = taskAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setupAddButton() {
        binding.floatingActionButton.setOnClickListener {
            startActivityForResult(
                Intent(this, AddTaskActivity::class.java),
                REQUEST_NEW_TASK
            )
        }
    }
}