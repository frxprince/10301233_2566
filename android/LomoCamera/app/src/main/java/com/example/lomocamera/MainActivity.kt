package com.example.lomocamera

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView=findViewById<ImageView>(R.id.imageView)
        val btnSave=findViewById<Button>(R.id.bSave)
        var image: Bitmap?=null
    val cameraRecriver=registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
    result:ActivityResult->if (result.resultCode== RESULT_OK){
     if(image!=null)image?.recycle()
     image=result.data!!.extras!!.getParcelable<Bitmap>("data")
     imageView.setImageBitmap(image)
    }
    }
    imageView.setOnClickListener {
    val i= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    cameraRecriver.launch(i)
    }
    }
}