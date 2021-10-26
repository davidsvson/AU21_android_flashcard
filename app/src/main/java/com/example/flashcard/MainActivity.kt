package com.example.flashcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity() : AppCompatActivity(), CoroutineScope {

    private lateinit var job : Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    lateinit var wordTextView: TextView
    val wordList = WordList()
    var currentWord : Word? = null
    lateinit var db : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        job = Job()

        db = AppDatabase.getInstance(this)
/*
        addNewWord(Word(0, "welcome", "Välkommen"))
        addNewWord(Word(0, "Hej", "Hello"))
*/
        wordTextView = findViewById(R.id.textView)

      //  loadNewWord()

        wordTextView.setOnClickListener {
           revealTranslation()
        }

    }

    fun addNewWord(word: Word) {

        launch(Dispatchers.IO) {
            db.wordDao.insert(word)
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











