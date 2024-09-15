package com.example.languagelearningapp.data

data class Quiz(
    val id: Int,
    val lessonId: Int,
    val question: String,
    val answers: List<String>,
    val correctAnswer: String
)
