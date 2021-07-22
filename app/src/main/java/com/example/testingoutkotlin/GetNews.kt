package com.example.testingoutkotlin


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GetNews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_news)


    }
//    private fun getRes(context: Context) {
//        var json: String? = null
//        val textView3 = findViewById<TextView>(R.id.textView3)
//        try {
////            var json = JSONObject(assets.open("newsApiToken.json").bufferedReader().use { it.readText() }) //Reading the Token in assets directory
//
//            url = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=" + json["newsApiToken"].toString()
//            url = "https://newsapi.org/v2/"
//        }catch(ex : IOException) {
////            text = "Error Getting the News Updates"
//        }

//    }
}