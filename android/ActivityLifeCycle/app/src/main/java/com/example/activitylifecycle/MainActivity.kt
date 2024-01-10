package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("myactivity","Creating!")
    }

    override fun onStart() {
        super.onStart()
        Log.i("myactivity","Starting!")
    }

    //    onCreate()    onStart()    onResume()    onPause()   onStop()    onRestart()    onDestroy()
    override fun onResume() {
        super.onResume()
        Log.i("myactivity","Resuming!")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("myactivity","Restarting!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("myactivity","Destroy!!")
    }

    override fun onPause() {
        super.onPause()
        Log.i("myactivity","Pausing!")
    }

    override fun onStop() {
        super.onStop()
        Log.i("myactivity","Stopping!")
    }
}