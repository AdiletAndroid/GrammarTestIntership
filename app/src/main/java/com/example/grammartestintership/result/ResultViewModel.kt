package com.example.grammartestintership.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel : ViewModel() {
    private val _totalQuestionsLiveData = MutableLiveData<Int>()
    val totalQuestionsLiveData: LiveData<Int> = _totalQuestionsLiveData

    private val _correctAnswersLiveData = MutableLiveData<Int>()
    val correctAnswersLiveData: LiveData<Int> = _correctAnswersLiveData

    private val _wrongAnswersLiveData = MutableLiveData<Int>()
    val wrongAnswersLiveData: LiveData<Int> = _wrongAnswersLiveData

    private val _timeLiveData = MutableLiveData<String>()
    val timeLiveData: LiveData<String> = _timeLiveData

    fun setTotalQuestions(totalQuestions: Int) {
        _totalQuestionsLiveData.value = totalQuestions
    }

    fun setCorrectAnswers(correctAnswers: Int) {
        _correctAnswersLiveData.value = correctAnswers
    }

    fun setWrongAnswers(wrongAnswers: Int) {
        _wrongAnswersLiveData.value = wrongAnswers
    }

    fun setTime(time: String) {
        _timeLiveData.value = time
    }
}
