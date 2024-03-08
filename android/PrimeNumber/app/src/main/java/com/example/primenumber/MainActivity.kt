package com.example.primenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private lateinit var btnStart:Button
    private lateinit var btnCancel:Button
    private lateinit var txtInput:EditText
    private lateinit var txtOutput:TextView
    private lateinit var progressbar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    btnStart=findViewById(R.id.bStart);btnCancel=findViewById(R.id.bCancel);txtInput=findViewById(R.id.eInput)
    txtOutput=findViewById(R.id.tOutput);progressbar=findViewById(R.id.progressBar)
    lateinit var worker:PrimeFinder
    progressbar.max=100
    btnStart.setOnClickListener {
//txtOutput.text=primeK(txtInput.text.toString().toLong()).toString()
 worker=object:PrimeFinder(txtInput.text.toString().toLong()){
     override fun ShowOutput(k: Long) {
      txtOutput.text=k.toString()
     }

     override fun ShowProgress(progress: Int) {
     this@MainActivity.runOnUiThread { progressbar.progress=progress}
     }
 }
  worker.start()
    }
    btnCancel.setOnClickListener { worker.Cancel() }
    }

    abstract class PrimeFinder(var k:Long):Thread(){
var Running=true
        override fun run() {
            super.run()
            Running=true
         var ans=primeK(k) ;  ShowOutput(ans)
        }
        fun Cancel(){
         Running=false
        }
        abstract fun ShowOutput(k:Long)
        abstract fun ShowProgress(progress:Int)
        fun isPrime(x:Long):Boolean{

            for(i in 2..x-1)
                if ((x%i) == 0L)
                    return false
            return true
        }
        fun primeK(x:Long):Long{
            var i=3L
            var c=0L
            while(Running){
                if(isPrime(i))
                {
                    c++
        ShowProgress(round((c/x.toFloat())*100).toInt())
                    if(c==x)
                        return i
                }
                i++
            }
            return 0
        }
    }


}