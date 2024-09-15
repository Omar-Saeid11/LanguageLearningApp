package com.example.languagelearningapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.languagelearningapp.viewmodel.LanguageViewModel

@Composable
fun QuizScreen(navController: NavController, lessonId: Int) {
    val viewModel: LanguageViewModel = hiltViewModel()
    val quiz = viewModel.getQuizForLesson(lessonId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = quiz.question, style = MaterialTheme.typography.h5, modifier = Modifier.padding(bottom = 16.dp))

        quiz.answers.forEach { answer ->
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(Color.Cyan)
            ) {
                Text(text = answer)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Back to Lessons")
        }
    }
}
