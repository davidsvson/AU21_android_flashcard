package com.example.flashcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var wordTextView: TextView
    val wordList = WordList()
    var currentWord : Word? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordTextView = findViewById(R.id.wordTextView)

        loadNewWord()

        wordTextView.setOnClickListener {
           revealTranslation()
        }

    }

    fun revealTranslation() {
        wordTextView.text = currentWord?.english
    }

    fun loadNewWord() {
        currentWord = wordList.getNewWord()
        wordTextView.text = currentWord?.swedish
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if( event?.action == MotionEvent.ACTION_UP) {
            loadNewWord()
        }

        return true
    }


}











