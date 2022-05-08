package com.rogowskibart.zadanior.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rogowskibart.zadanior.adapter.TaskAdapter
import com.rogowskibart.zadanior.database.AppDatabase
import com.rogowskibart.zadanior.databinding.ActivityMainBinding
import com.rogowskibart.zadanior.model.dto.TaskDto
import java.time.LocalDate
import java.time.Month
import java.time.ZoneOffset
import java.util.*
import kotlin.concurrent.thread

private const val REQUEST_NEW_TASK = 1

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val database by lazy { AppDatabase.open(this) }
    private val taskAdapter by lazy { TaskAdapter(database) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        prepareData()
        setupTaskList()
        setupTotal()
        setupAddButton()
    }

    private fun prepareData() {
        thread {
            database.tasks.deleteAll()
            database.tasks.insert(TaskDto(0,"sprzątanie",1, Date.from(LocalDate.of(2022, Month.MAY,  1).atStartOfDay().toInstant(ZoneOffset.UTC)),25,5))
            database.tasks.insert(TaskDto(0,"pranie",3, Date.from(LocalDate.of(2022, Month.MAY,  2).atStartOfDay().toInstant(ZoneOffset.UTC)),11,5))
            database.tasks.insert(TaskDto(0,"spacerowanie",1, Date.from(LocalDate.of(2022, Month.MAY,  3).atStartOfDay().toInstant(ZoneOffset.UTC)),56,5))
            database.tasks.insert(TaskDto(0,"programowanie",1, Date.from(LocalDate.of(2022, Month.MAY,  4).atStartOfDay().toInstant(ZoneOffset.UTC)),73,5))
            database.tasks.insert(TaskDto(0,"podlewanie kwiatów",2, Date.from(LocalDate.of(2022, Month.MAY,  5).atStartOfDay().toInstant(ZoneOffset.UTC)),86,5))
            database.tasks.insert(TaskDto(0,"wybieranie ubrań",2, Date.from(LocalDate.of(2022, Month.MAY,  6).atStartOfDay().toInstant(ZoneOffset.UTC)),23,5))
            database.tasks.insert(TaskDto(0,"rowerowanie",3, Date.from(LocalDate.of(2022, Month.MAY,  7).atStartOfDay().toInstant(ZoneOffset.UTC)),14,5))
            database.tasks.insert(TaskDto(0,"chodzenie",2, Date.from(LocalDate.of(2022, Month.MAY,  8).atStartOfDay().toInstant(ZoneOffset.UTC)), 5,5))
            database.tasks.insert(TaskDto(0,"zakupy",1, Date.from(LocalDate.of(2022, Month.MAY,  9).atStartOfDay().toInstant(ZoneOffset.UTC)),47,5))
            database.tasks.insert(TaskDto(0,"ogród",2, Date.from(LocalDate.of(2022, Month.MAY, 10).atStartOfDay().toInstant(ZoneOffset.UTC)),38,5))
            database.tasks.insert(TaskDto(0,"samochód",3, Date.from(LocalDate.of(2022, Month.MAY, 11).atStartOfDay().toInstant(ZoneOffset.UTC)),90,5))
            database.tasks.insert(TaskDto(0,"jedzenie",3, Date.from(LocalDate.of(2022, Month.MAY, 12).atStartOfDay().toInstant(ZoneOffset.UTC)),86,5))
            database.tasks.insert(TaskDto(0,"mycie podłóg",2, Date.from(LocalDate.of(2022, Month.MAY, 13).atStartOfDay().toInstant(ZoneOffset.UTC)),74,5))
            database.tasks.insert(TaskDto(0,"tankowanie",1, Date.from(LocalDate.of(2022, Month.MAY, 14).atStartOfDay().toInstant(ZoneOffset.UTC)),64,5))
            database.tasks.insert(TaskDto(0,"odkurzanie",1, Date.from(LocalDate.of(2022, Month.MAY, 15).atStartOfDay().toInstant(ZoneOffset.UTC)),52,5))
            database.tasks.insert(TaskDto(0,"koszenie trawy",2, Date.from(LocalDate.of(2022, Month.MAY, 16).atStartOfDay().toInstant(ZoneOffset.UTC)),42,5))
            database.tasks.insert(TaskDto(0,"malowanie ścian",3, Date.from(LocalDate.of(2022, Month.MAY, 17).atStartOfDay().toInstant(ZoneOffset.UTC)),37,5))
            database.tasks.insert(TaskDto(0,"golenie owiec",2, Date.from(LocalDate.of(2022, Month.MAY, 18).atStartOfDay().toInstant(ZoneOffset.UTC)),29,5))
            database.tasks.insert(TaskDto(0,"naprawa tarasu",3, Date.from(LocalDate.of(2022, Month.MAY, 19).atStartOfDay().toInstant(ZoneOffset.UTC)),18,5))
            database.tasks.insert(TaskDto(0,"szlifowanie szafy",1, Date.from(LocalDate.of(2022, Month.MAY, 20).atStartOfDay().toInstant(ZoneOffset.UTC)), 1,5))
            database.tasks.insert(TaskDto(0,"kupienie chleba",1, Date.from(LocalDate.of(2022, Month.MAY, 21).atStartOfDay().toInstant(ZoneOffset.UTC)),76,5))
            database.tasks.insert(TaskDto(0,"ścielenie łóżka",3, Date.from(LocalDate.of(2022, Month.MAY, 22).atStartOfDay().toInstant(ZoneOffset.UTC)),83,5))
            database.tasks.insert(TaskDto(0,"kończenie zadania",3, Date.from(LocalDate.of(2022, Month.MAY, 23).atStartOfDay().toInstant(ZoneOffset.UTC)),81,5))
            database.tasks.insert(TaskDto(0,"rozmowa z kolegą",1, Date.from(LocalDate.of(2022, Month.MAY, 24).atStartOfDay().toInstant(ZoneOffset.UTC)),94,5))
            database.tasks.insert(TaskDto(0,"czytanie książki",2, Date.from(LocalDate.of(2022, Month.MAY, 25).atStartOfDay().toInstant(ZoneOffset.UTC)),46,5))
            database.tasks.insert(TaskDto(0,"wymiana telefonu",2, Date.from(LocalDate.of(2022, Month.MAY, 26).atStartOfDay().toInstant(ZoneOffset.UTC)),56,5))
            database.tasks.insert(TaskDto(0,"ładowanie baterii",1, Date.from(LocalDate.of(2022, Month.MAY, 27).atStartOfDay().toInstant(ZoneOffset.UTC)),61,5))
            database.tasks.insert(TaskDto(0,"głaskanie kota",2, Date.from(LocalDate.of(2022, Month.MAY, 28).atStartOfDay().toInstant(ZoneOffset.UTC)),42,5))
            database.tasks.insert(TaskDto(0,"bieganie",1, Date.from(LocalDate.of(2022, Month.MAY, 29).atStartOfDay().toInstant(ZoneOffset.UTC)),15,5))
            database.tasks.insert(TaskDto(0,"puszczanie latawca",3, Date.from(LocalDate.of(2022, Month.MAY, 30).atStartOfDay().toInstant(ZoneOffset.UTC)),52,5))
            database.tasks.insert(TaskDto(0,"łapanie motyli",1, Date.from(LocalDate.of(2022, Month.MAY, 31).atStartOfDay().toInstant(ZoneOffset.UTC)),67,5))
        }
        taskAdapter.reload()
    }

    private fun setupTotal() {
        thread {
            binding.textViewTotalNumber.text = database.tasks.getCount().toString()
        }
    }

    private fun setupTaskList() {
        binding.tasksList.apply {
            adapter = taskAdapter
            layoutManager = LinearLayoutManager(context)
        }

        taskAdapter.sort()
        taskAdapter.reload()

        binding.swipe.let {
            it.setOnRefreshListener {
                taskAdapter.reload()
                it.isRefreshing = false
            }
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_NEW_TASK && resultCode == Activity.RESULT_OK) {
            taskAdapter.reload()
        } else super.onActivityResult(requestCode, resultCode, data)
    }

}