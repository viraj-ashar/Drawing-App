package com.example.quizapp

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionsActivity : AppCompatActivity() {
    private var idx = 0;
    private val questionList = Constants.getQuestions()
    private var selectedOption = 0
    private var score = 0
    lateinit var que:TextView
    lateinit var img:ImageView
    lateinit var progressbar: ProgressBar
    lateinit var progress:TextView
    lateinit var op1:TextView
    lateinit var op2:TextView
    lateinit var op3:TextView
    lateinit var op4:TextView
    private var userName: String = ""

    private fun updateQuestion() {
        defaultOptionView()

        val submit = findViewById<Button>(R.id.btn_submit)
        if (idx == questionList.size) {
            submit.text = "FINISH"
        } else {
            submit.text = "SUBMIT"
        }

        que.text = questionList[idx].Question
        img.setImageResource(questionList[idx].image)
        progressbar.progress = progressbar.progress + 1
        progress.text = (idx + 1).toString() + "/" + progressbar.max.toString()
        op1.text = questionList[idx].optionOne
        op2.text = questionList[idx].optionTwo
        op3.text = questionList[idx].optionThree
        op4.text = questionList[idx].optionFour
        idx++;
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>();
        options.add(op1)
        options.add(op2)
        options.add(op3)
        options.add(op4)

        for (i in 0..3) {
            options[i].setTextColor(Color.parseColor("#7A8089"))
            options[i].typeface = Typeface.DEFAULT
            options[i].background =
                ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()

        selectedOption = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                op1.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                op2.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                op3.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                op4.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        que = findViewById<TextView>(R.id.tv_question)
        img = findViewById<ImageView>(R.id.iv_image)
        progressbar = findViewById<ProgressBar>(R.id.progressBar)
        progress = findViewById<TextView>(R.id.tv_progress)
        op1 = findViewById<TextView>(R.id.tv_option_one)
        op2 = findViewById<TextView>(R.id.tv_option_two)
        op3 = findViewById<TextView>(R.id.tv_option_three)
        op4 = findViewById<TextView>(R.id.tv_option_four)

        userName = intent.getStringExtra(Constants.USER_NAME).toString()

        updateQuestion()

        val submit = findViewById<Button>(R.id.btn_submit)

        submit.setOnClickListener {
            if (selectedOption == 0) {
                if (submit.text.toString() == "SUBMIT") {
                    Toast.makeText(this, "Please select atleat 1 option", Toast.LENGTH_SHORT).show()
                } else if (idx < questionList.size) {
                    updateQuestion()
                } else {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(Constants.USER_NAME, userName)
                    intent.putExtra(Constants.CORRECT_ANSWERS, score)
                    intent.putExtra(Constants.TOTAL_QUESTIONS, questionList.size)
                    startActivity(intent)
                    finish()
                }
            } else {
                if (questionList[idx - 1].correctAns != selectedOption) {
                    answerView(selectedOption, R.drawable.wrong_option_border_bg)
                    score--
                }
                score++
                Log.d("score ", "${score}")
                answerView(questionList[idx - 1].correctAns, R.drawable.correct_option_border_bg)

                if (idx == questionList.size) {
                    submit.text = "FINISH"
                } else {
                    submit.text = "Go to next question"
                }
                selectedOption = 0
            }
        }
        op1.setOnClickListener {
            if (submit.text.toString() == "SUBMIT") selectedOptionView(op1, 1)
        }
        op2.setOnClickListener {
            if (submit.text.toString() == "SUBMIT") selectedOptionView(op2, 2)
        }
        op3.setOnClickListener {
            if (submit.text.toString() == "SUBMIT") selectedOptionView(op3, 3)
        }
        op4.setOnClickListener {
            if (submit.text.toString() == "SUBMIT") selectedOptionView(op4, 4)
        }
    }
}