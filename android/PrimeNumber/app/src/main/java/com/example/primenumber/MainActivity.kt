package com.example.primenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView

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
    var worker:PrimeFinder
    btnStart.setOnClickListener {
//txtOutput.text=primeK(txtInput.text.toString().toLong()).toString()
 worker=object:PrimeFinder(txtInput.text.toString().toLong()){
     override fun ShowOutput(k: Long) {
      txtOutput.text=k.toString()
     }
 }
  worker.start()
    }
    }

    abstract class PrimeFinder(var k:Long):Thread(){
        override fun run() {
            super.run()
         var ans=primeK(k) ;  ShowOutput(ans)
        }
        abstract fun ShowOutput(k:Long)
        fun isPrime(x:Long):Boolean{

            for(i in 2..x-1)
                if ((x%i) == 0L)
                    return false
            return true
        }
        fun primeK(x:Long):Long{
            var i=3L
            var c=0L
            while(true){
                if(isPrime(i))
                {
                    c++
                    if(c==x)
                        return i
                }
                i++
            }
            return 0
        }
    }


}