package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.USER_NAME).toString()
        val score = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        val tv_username = findViewById<TextView>(R.id.tv_name)
        val tv_score = findViewById<TextView>(R.id.tv_score)

        tv_username.text = username
        tv_score.text = "Your score is $score out of $totalQuestion"

        val btn_finish = findViewById<Button>(R.id.btn_finish)
        btn_finish.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}