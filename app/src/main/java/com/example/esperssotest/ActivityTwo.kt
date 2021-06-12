package com.example.esperssotest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        findViewById<Button>(R.id.btnBack).apply {
            this.setOnClickListener {
                onBackPressed()
            }
        }
    }
}