package com.example.esperssotest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class ActivityPickPicture : AppCompatActivity() {

    private lateinit var image:ImageView;
    private lateinit var btnOpenGallery: Button;

    private var someActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result?.data?.let { uri ->
                Glide.with(this)
                    .load(uri)
                    .into(image)
            }
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_picture)

        image = findViewById(R.id.image)
        btnOpenGallery = findViewById(R.id.btnOpenGallery)

        btnOpenGallery.setOnClickListener {
            pickFromGallery()
        }
    }


    private fun pickFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        someActivityResultLauncher.launch(intent)
    }
}