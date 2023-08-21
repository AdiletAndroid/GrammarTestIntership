package com.example.grammartestintership.grammarTest

import androidx.lifecycle.ViewModel
import com.example.grammartestintership.FakeData.FakeQuestion
import com.example.grammartestintership.dialogHelper.DialogHelper

class GrammarTestViewModel : ViewModel() {

    private lateinit var fakeQuestions: List<FakeQuestion>
    var currentQuestionIndex = 0

    fun initializeQuestions(questions: List<FakeQuestion>) {
        fakeQuestions = questions
    }

    fun onAnswerSelected(selectedIndex: Int, callback: DialogHelper.GrammarTestCallback) {
        val selectedQuestion = fakeQuestions[currentQuestionIndex]
        val isAnswerCorrect = selectedQuestion.answers[selectedIndex].isCorrect

        if (isAnswerCorrect) {
            callback.onPositiveAnswer()
        } else {
            callback.onNegativeAnswer()
        }

        currentQuestionIndex++
        if (currentQuestionIndex >= fakeQuestions.size) {
            // Все вопросы пройдены, выполните здесь необходимые действия
        }
    }
}