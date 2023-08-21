package com.example.grammartestintership.grammarTest

import android.widget.Button
import com.example.grammartestintership.FakeData.FakeQuestion
import com.example.grammartestintership.R
import com.example.grammartestintership.dialogHelper.DialogHelper

class GrammarTestManager(
    private val optionsButtons: List<Button>,
    private val answerButton: Button,
    private val callback: DialogHelper.GrammarTestCallback,
    private val fakeQuestions: List<FakeQuestion>,
    private val viewModel: GrammarTestViewModel
) {

    private val optionButtonBackground = R.drawable.option_button_bg
    private val answerButtonBackground = R.drawable.answer_button_bg
    fun setButtonColors() {
        optionsButtons.forEachIndexed { index, button ->
            button.setBackgroundResource(optionButtonBackground)

            button.setOnClickListener {
                optionsButtons.forEach { btn ->
                    btn.alpha = if (btn == button) 1.0f else 0.5f
                }

                answerButton.setBackgroundResource(
                    if (button == answerButton) optionButtonBackground else answerButtonBackground
                )

                viewModel.onAnswerSelected(index, callback)
            }
        }
    }
}