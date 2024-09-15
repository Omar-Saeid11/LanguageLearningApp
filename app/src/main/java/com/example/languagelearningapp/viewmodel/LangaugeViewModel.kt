package com.example.languagelearningapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.languagelearningapp.data.Achievement
import com.example.languagelearningapp.data.Lesson
import com.example.languagelearningapp.data.Post
import com.example.languagelearningapp.data.Progress
import com.example.languagelearningapp.data.Quiz
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor() : ViewModel() {
    val lessons = MutableStateFlow(
        listOf(
            Lesson(1, "Lesson 1", "Introduction to basic phrases"),
            Lesson(2, "Lesson 2", "Common greetings")
        )
    )

    val progress = MutableStateFlow(Progress(1, 10))
    val achievements = MutableStateFlow(
        listOf(
            Achievement(1, "First Steps", "Complete your first lesson")
        )
    )

    val forumPosts = MutableStateFlow(
        listOf(
            Post(1, "How to learn faster?", "Any tips for quick learning?", "Content here...")
        )
    )

    fun getQuizForLesson(lessonId: Int): Quiz {
        return Quiz(
            1,
            lessonId,
            "What does 'Hello' mean?",
            listOf("Hola", "Bonjour", "Hello"),
            "Hello"
        )
    }
}
