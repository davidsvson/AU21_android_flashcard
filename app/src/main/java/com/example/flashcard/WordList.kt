package com.example.flashcard

import android.util.Log

class WordList (){
    private val wordList = mutableListOf<Word>()
   // private val usedWords = mutableListOf<Word>()
   // private var nrOfWordsUsed = 0
/*
    init {
        initializeWords()
    }

    private fun initializeWords() {
        val word = Word("Hello", "Hej")
        wordList.add(word)
        wordList.add(Word("Good bye", "Hej då"))
        wordList.add(Word("Thank you", "Tack"))
        wordList.add(Word("Welcome", "Välkommen"))
        wordList.add(Word("Computer", "Dator"))
    }
*/
    // alternativ 2 -
//    fun getNewWord() : Word {
//        if (nrOfWordsUsed >= wordList.size) {
//            nrOfWordsUsed = 0
//            for(word in wordList) {
//                word.used = false
//            }
//        }
//
//        var newWord : Word? = null
//
//        do {
//            val rnd = (0 until wordList.size).random()
//            newWord = wordList[rnd]
//        } while(newWord!!.used )
//
//        newWord.used = true
//        nrOfWordsUsed++
//
//        return newWord
//    }



    // alternativ 3
    fun getNewWord() : Word {
        if (wordList.isEmpty()) {
            //initializeWords()
        }
        val rnd = (0 until wordList.size).random()

        val newWord = wordList.removeAt(rnd)
        return newWord
    }



    // alternativ 4
//    fun getNewWord() : Word {
//        if (wordList.size == 0) {
//           wordList.addAll(usedWords)
//           usedWords.clear()
//        }
//
//        val rnd = (0 until wordList.size).random()
//
//        val newWord = wordList.removeAt(rnd)
//        usedWords.add(newWord)
//        return newWord
//    }
}

// 1. list av använda ord
// 4st  0st 2. en bool i word-klassen som håller reda på om ordet är använt
// 4st  7st  3. ta bort det använda ordet ur listan

// 3st 6st 4. två stycken listor, flytta använda ord till ny lista
// 5. ta orden i ordning från 0 till så många ord vi har
