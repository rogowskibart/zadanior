package com.rogowskibart.zadanior.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rogowskibart.zadanior.R
import com.rogowskibart.zadanior.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

    }
}