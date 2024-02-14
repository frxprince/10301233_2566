package com.example.textfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
   val txtMessage=findViewById<EditText>(R.id.eText)
   val btnResource=findViewById<Button>(R.id.bResource)
   val btnAssets=findViewById<Button>(R.id.bAssets)
   val btnSaveSD=findViewById<Button>(R.id.bSDcard)
   val btnReadSD=findViewById<Button>(R.id.bReadSDCARD)

   btnResource.setOnClickListener {
val file=resources.openRawResource(R.raw.genesis01)
var lines=file.bufferedReader(Charsets.UTF_8).readLines()
var txt=""
for(line in lines)txt=txt+"\n"+line
txtMessage.setText(txt)
   }
btnAssets.setOnClickListener {
    var file=assets.open("textfile/pangram.txt")
    var lines=file.bufferedReader(Charsets.UTF_8).readLines()
    var txt=""
    for(line in lines)txt=txt+"\n"+line
    txtMessage.setText(txt)
}
  btnSaveSD.setOnClickListener {
  val file= File(Environment.getExternalStorageDirectory().absolutePath+
  "/"+Environment.DIRECTORY_DOCUMENTS+"/test.txt")
   file.createNewFile()
  var outputfile=FileOutputStream(file)
  outputfile.write(txtMessage.text.toString().toByteArray())
  outputfile.flush()
  outputfile.close()
  }
  btnReadSD.setOnClickListener {
      val file= File(Environment.getExternalStorageDirectory().absolutePath+
              "/"+Environment.DIRECTORY_DOCUMENTS+"/test.txt")
      var lines=file.bufferedReader(Charsets.UTF_8).readLines()
      var txt=""
      for(line in lines)txt=txt+"\n"+line
      txtMessage.setText(txt)
  }
    }
}