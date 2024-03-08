package com.example.primefinder2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    lateinit var txtInput:EditText
    lateinit var txtOutput:TextView
    lateinit var btnStart:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
  txtInput=findViewById(R.id.eInput);txtOutput=findViewById(R.id.tOutput)
  btnStart=findViewById(R.id.bStart)
  btnStart.setOnClickListener {worker() }
    }
fun worker()= runBlocking {
 val deferredResult:Deferred<Long> = async{
    primeK(txtInput.text.toString().toLong())
}
val ans=deferredResult.await()
txtOutput.text=ans.toString()
}

    fun isPrime(x:Long):Boolean{

        for(i in 2..x-1)
            if ((x%i) == 0L)
                return false
        return true
    }

    suspend fun primeK(x:Long):Long{
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