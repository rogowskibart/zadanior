package com.rogowskibart.zadanior.activities

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.rogowskibart.zadanior.database.AppDatabase
import com.rogowskibart.zadanior.databinding.ActivityAddTaskBinding
import com.rogowskibart.zadanior.model.dto.TaskDto
import java.lang.Integer.parseInt
import java.time.LocalDate
import java.time.ZoneOffset
import java.util.*
import kotlin.concurrent.thread

class AddTaskActivity : AppCompatActivity() {
    private val database by lazy { AppDatabase.open(this) }
    private val binding by lazy { ActivityAddTaskBinding.inflate(layoutInflater) }
    private val seekBar by lazy { binding.seekBar }
    private val textViewCompletionPercentage by lazy { binding.textViewCompletionPercentage }
    private val editTextDeadline by lazy { binding.editTextDeadline }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpDeadlineDatePicker()
        setUpSeekBar()
        setUpSaveButton()
    }

    private fun setUpSaveButton() {
        binding.buttonSave.setOnClickListener {
            val task = TaskDto(
                0,
                binding.editTextTaskName.text.toString(),
                binding.ratingBarPriority.numStars,
                Date.from(
                    LocalDate.parse(binding.editTextDeadline.text).atStartOfDay().toInstant(
                        ZoneOffset.UTC
                    )
                ),
                parseInt(binding.textViewCompletionPercentage.text.toString()),
                parseInt(binding.editTextTimeline.text.toString())
            )
            thread {
                database.tasks.insert(task)
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
    }

    private fun setUpDeadlineDatePicker() {
        editTextDeadline.setOnClickListener {
            val calendar = Calendar.getInstance()
            val mYear = calendar[Calendar.YEAR]
            val mMonth = calendar[Calendar.MONTH]
            val mDay = calendar[Calendar.DAY_OF_MONTH]

            //show dialog
            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, month, day ->
                    editTextDeadline.setText(
                        LocalDate.of(year, month, day).toString()
                    )
                },
                mYear,
                mMonth,
                mDay
            )
            datePickerDialog.show()
        }
    }

    private fun setUpSeekBar() {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textViewCompletionPercentage.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
    }
}