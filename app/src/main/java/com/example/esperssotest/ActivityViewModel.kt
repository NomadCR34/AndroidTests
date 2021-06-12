package com.example.esperssotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class ActivityViewModel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        val viewModel:MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        val textView = findViewById<TextView>(R.id.txtText)
        val button:Button = findViewById<Button>(R.id.btnAction).apply {
            this.setOnClickListener {
                viewModel.getData()
            }
            return@apply
        }

        viewModel.liveData.observe(this, Observer {
            textView.text = it
        })

    }
}