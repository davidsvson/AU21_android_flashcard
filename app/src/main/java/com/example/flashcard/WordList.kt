package com.example.flashcard

import android.util.Log


class WordList() {
    private val words = mutableListOf<Word>()
    private var currentWord : Word? = null
    private var originalDirection = true

    init {
        initiliaze()
    }

    fun initiliaze() {
        words.add(Word("Hej", "Hello"))
        words.add(Word("Hej då", "Good bye"))
        words.add(Word("Tack", "Thank you"))
    }
        
    private fun getNewWord() : Word {
        val rnd = (0 until words.size).random()
        val word = words.removeAt(rnd)
        return word
    }

    fun changeWord() {
        if (words.isEmpty()) {
            initiliaze()
        }
        val rnd = (0 until words.size).random()
        currentWord = words.removeAt(rnd)
    }

    fun revertTranslateDirection() {
        originalDirection = !originalDirection
    }

    fun getOriginalWord() : String? {
        return if (originalDirection) {
            currentWord?.swedish
        } else {
            currentWord?.english
        }
    }


    fun getTranslatedWord() : String? {
        return if (!originalDirection) {
            currentWord?.swedish
        } else {
            currentWord?.english
        }
    }


}
