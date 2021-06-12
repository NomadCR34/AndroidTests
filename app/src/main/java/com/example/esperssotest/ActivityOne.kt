package com.example.esperssotest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class ActivityOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        val button: Button = findViewById<Button>(R.id.testButton).apply {
            this.setOnClickListener {
                Log.i("MYLOG", "onCreate: ")
                val intent = Intent(this@ActivityOne, ActivityTwo::class.java)
                startActivity(intent)
            }
        }

    }
}