package com.example.testingoutkotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

const val EXTRA_MESSAGE = "com.example.testingoutkotlin.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view:View){
        val editText = findViewById<EditText>(R.id.textBox)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply{
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun startMap(view:View){
        //https://developers.google.com/maps/documentation/urls/android-intents#kotlin_1

        val gmmIntentUri = Uri.parse("geo:37.7749,-122.4194")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        mapIntent.resolveActivity(packageManager)?.let {
            startActivity(mapIntent)
        }?: run{
            Toast.makeText(this, "Install Google Maps to continue", Toast.LENGTH_LONG).show()
        }

    }

    fun zooApp(view: View){
        val zooIntent = Intent(this, ZooApp::class.java).apply {
        }
        startActivity(zooIntent)
    }
}