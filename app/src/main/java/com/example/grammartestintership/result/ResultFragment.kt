package com.example.grammartestintership.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.grammartestintership.R
import com.example.grammartestintership.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    companion object {
        private const val ARG_TOTAL_QUESTIONS = "total_questions"
        private const val ARG_CORRECT_ANSWERS = "correct_answers"
        private const val ARG_WRONG_ANSWERS = "wrong_answers"
        private const val ARG_TIME = "time"

        fun newInstance(
            totalQuestions: Int,
            correctAnswers: Int,
            wrongAnswers: Int,
            time: String
        ): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle()
            args.putInt(ARG_TOTAL_QUESTIONS, totalQuestions)
            args.putInt(ARG_CORRECT_ANSWERS, correctAnswers)
            args.putInt(ARG_WRONG_ANSWERS, wrongAnswers)
            args.putString(ARG_TIME, time)
            fragment.arguments = args
            return fragment
        }
    }

    private val viewModel: ResultViewModel by viewModels()
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val totalQuestions = arguments?.getInt(ARG_TOTAL_QUESTIONS) ?: 0
        val correctAnswers = arguments?.getInt(ARG_CORRECT_ANSWERS) ?: 0
        val wrongAnswers = arguments?.getInt(ARG_WRONG_ANSWERS) ?: 0
        val time = arguments?.getString(ARG_TIME) ?: ""

        binding.textViewTotalQuestions.text = "Всего вопросов: $totalQuestions"
        binding.textViewCorrectAnswers.text = "Правильно: $correctAnswers"
        binding.textViewWrongAnswers.text = "Ошибся: $wrongAnswers"
        binding.textViewTime.text = "Время: $time"
        binding.buttonToMain.setBackgroundResource(R.drawable.option_button_bg)

        viewModel.setTotalQuestions(totalQuestions)
        viewModel.setCorrectAnswers(correctAnswers)
        viewModel.setWrongAnswers(wrongAnswers)
        viewModel.setTime(time)

        viewModel.totalQuestionsLiveData.observe(viewLifecycleOwner) { totalQuestions ->
            binding.textViewTotalQuestions.text = "Всего вопросов: $totalQuestions"
        }
        viewModel.correctAnswersLiveData.observe(viewLifecycleOwner) { correctAnswers ->
            binding.textViewCorrectAnswers.text = "Правильно: $correctAnswers"
        }
        viewModel.wrongAnswersLiveData.observe(viewLifecycleOwner) { wrongAnswers ->
            binding.textViewWrongAnswers.text = "Ошибся: $wrongAnswers"
        }
        viewModel.timeLiveData.observe(viewLifecycleOwner) { time ->
            binding.textViewTime.text = "Время: $time"
        }
    }
}
