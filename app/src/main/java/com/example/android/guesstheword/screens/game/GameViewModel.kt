package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){

    // The current word
    var word = MutableLiveData<String>()

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    //the current score
    var score = MutableLiveData<Int>()

    init {
        Log.i("GameViewModel","GameViewModel created")
        word.value = ""
        score.value = 0
        resetList()
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel","GameViewModel destroyed")
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    private fun nextWord() {
        if (wordList.isNotEmpty()) {
            //Select and remove a word from the list
            word.value = wordList.removeAt(0)
        }
    }


    /** Methods for buttons presses **/

    fun onSkip() {
        score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        score.value = (score.value)?.plus(1)
        nextWord()
    }
}