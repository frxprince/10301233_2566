package com.example.lomocamera

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.util.Calendar

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
     image=result.data!!.extras!!.getParcelable<Bitmap>("data")!!.copy(
         Bitmap.Config.ARGB_8888,true)
     var canvas= Canvas(image!!)
     var paint=Paint()
     paint.setColor(Color.MAGENTA)
     paint.textSize=18f
     paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_OVER))
     canvas.drawBitmap(image!!,0f,0f,paint)
     canvas.drawText(Calendar.getInstance().time.toString(),1f,20f,paint)
     imageView.setImageBitmap(image)
    }
    }
    btnSave.setOnClickListener {
     val file= File(Environment.getExternalStorageDirectory().absolutePath+"/"+
     Environment.DIRECTORY_DCIM+"/mytestimage.png")
     file.createNewFile()
     var bos=ByteArrayOutputStream()
     image!!.compress(Bitmap.CompressFormat.PNG,99,bos)
     var fos=FileOutputStream(file);fos.write(bos.toByteArray());fos.flush();fos.close()
    }
    imageView.setOnClickListener {
    val i= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    cameraRecriver.launch(i)
    }
    }
}