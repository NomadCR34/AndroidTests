package com.example.esperssotest

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity



const val KEY_IMAGE_DATA = "data"
class ActivityCamera : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        findViewById<Button>(R.id.btnCamera).setOnClickListener {
            dispatchCameraIntent()
        }
    }

    private var someActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            if(result?.data?.extras == null){
                return@registerForActivityResult
            }
            result.data?.extras.let {
                val imageBitmap = it?.get(KEY_IMAGE_DATA) as Bitmap?
                findViewById<ImageView>(R.id.image).setImageBitmap(imageBitmap)
            }

        }
    }


    private fun dispatchCameraIntent() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        someActivityResultLauncher.launch(intent)
    }
}