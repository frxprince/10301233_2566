package com.example.binaryprefix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)
        val btnkiB=findViewById<Button>(R.id.bkiB)
        val btnMiB=findViewById<Button>(R.id.bMiB)
        val btnGiB=findViewById<Button>(R.id.bGiB)
        val btnTiB=findViewById<Button>(R.id.bTiB)
        val i= Intent()
        btnkiB.setOnClickListener {
            i.putExtra("iec",Math.pow(2.0,10.0));i.putExtra("name","kiB")
            setResult(RESULT_OK,i);finish()
        }
        btnMiB.setOnClickListener {
            i.putExtra("iec",Math.pow(2.0,20.0));i.putExtra("name","MiB")
            setResult(RESULT_OK,i);finish()
        }
        btnGiB.setOnClickListener {
            i.putExtra("iec",Math.pow(2.0,30.0));i.putExtra("name","GiB")
            setResult(RESULT_OK,i);finish()
        }
        btnTiB.setOnClickListener {
            i.putExtra("iec",Math.pow(2.0,40.0));i.putExtra("name","TiB")
            setResult(RESULT_OK,i);finish()
        }
    }
}