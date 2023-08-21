package com.example.grammartestintership.grammarTest

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.grammartestintership.FakeData.FakeData
import com.example.grammartestintership.FakeData.FakeQuestion
import com.example.grammartestintership.databinding.FragmentGrammarTestBinding
import com.example.grammartestintership.dialogHelper.DialogHelper

class GrammarTestFragment : Fragment(), DialogHelper.GrammarTestCallback {

    private val binding by viewBinding(FragmentGrammarTestBinding::bind)
    private lateinit var grammarTestManager: GrammarTestManager
    private lateinit var viewModel: GrammarTestViewModel
    private val fakeQuestions: List<FakeQuestion> = FakeData.fakeQuestions

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val optionsButtons = listOf(
            binding.buttonOption1,
            binding.buttonOption2,
            binding.buttonOption3,
            binding.buttonOption4
        )
        val answerButton = binding.buttonAnswer

        viewModel.initializeQuestions(fakeQuestions)

        grammarTestManager =
            GrammarTestManager(optionsButtons, answerButton, this, fakeQuestions, viewModel)
        grammarTestManager.setButtonColors()

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onPositiveAnswer() {
        val dialogHelper = DialogHelper(requireContext())
        dialogHelper.showAlertDialog(
            "Идём дальше?",
            "Конечно!",
            "На сегодня хватит",
            {
                viewModel.onAnswerSelected(viewModel.currentQuestionIndex, this@GrammarTestFragment)
            },
            {
                // Код для негативного ответа
            }
        )
    }

    override fun onNegativeAnswer() {
        val dialogHelper = DialogHelper(requireContext())
        dialogHelper.showAlertDialog(
            "Попробуем еще раз?",
            "Конечно",
            "На сегодня хватит",
            {
                viewModel.onAnswerSelected(viewModel.currentQuestionIndex, this@GrammarTestFragment)
            },
            {
                // Код для негативного ответа
            }
        )
    }
}