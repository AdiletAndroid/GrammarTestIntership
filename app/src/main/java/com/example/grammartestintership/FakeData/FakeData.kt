package com.example.grammartestintership.FakeData

object FakeData {
    val fakeQuestions: List<FakeQuestion> = listOf(
        FakeQuestion(
            text = "Как образуется отрицание во Future Simple?",
            answers = listOf(
                FakeAnswer("will not", isCorrect = true),
                FakeAnswer("did not", isCorrect = false),
                FakeAnswer("have not", isCorrect = false),
                FakeAnswer("am not", isCorrect = false)
            )
        ),
        FakeQuestion(
            text = "Выберите правильное местоимение в объектном падеже.",
            answers = listOf(
                FakeAnswer("I", isCorrect = false),
                FakeAnswer("my", isCorrect = false),
                FakeAnswer("me", isCorrect = true),
                FakeAnswer("mine", isCorrect = false)
            )
        )
    )
}

data class FakeAnswer(
    val text: String,
    val isCorrect: Boolean
)

data class FakeQuestion(
    val text: String,
    val answers: List<FakeAnswer>
)

//data class FakeRank(
//    val rankName: String,
//    val rankImageResId: Int
//)
//
//data class FakeProfile(
//    val userName: String,
//    val lastLoginDate: String,
//    val wordsInDictionary: Int,
//    val experiencePoints: Int,
//    val rank: FakeRank
//)