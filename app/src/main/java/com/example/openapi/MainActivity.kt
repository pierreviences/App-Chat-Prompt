package com.example.openapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {

    private val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val etQuestion = findViewById<EditText>(R.id.etQuestion)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val txtResponse = findViewById<TextView>(R.id.txtResponse)

        val question = etQuestion.text.toString()
        btnSubmit.setOnClickListener {
            Toast.makeText(this, question.toString(), Toast.LENGTH_SHORT).show()
            getResponse(question){
                response ->
                runOnUiThread{
                    txtResponse.text = response
                }
            }
        }

    }

    fun getResponse(question: String, callback: (String) -> Unit){
        val apikey = "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"
        val url = "https://api.openai.com/v1/completions"
    }
}