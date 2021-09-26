package com.example.flashcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val wordList = WordList()
    lateinit var textView : TextView
    lateinit var  directionButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        directionButton = findViewById(R.id.directionButton)

        loadQuestion()

        textView.setOnClickListener {
            textView.text = wordList.getTranslatedWord()
        }

        directionButton.setOnClickListener {
            wordList.revertTranslateDirection()
            loadQuestion()
        }
    }


    fun loadQuestion() {
        wordList.changeWord()

        textView.text = wordList.getOriginalWord()
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_UP) {
            loadQuestion()
        }

        return true
    }
}
