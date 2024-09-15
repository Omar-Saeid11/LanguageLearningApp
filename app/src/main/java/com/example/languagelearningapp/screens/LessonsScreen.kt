package com.example.languagelearningapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.languagelearningapp.data.Lesson
import com.example.languagelearningapp.viewmodel.LanguageViewModel
@Composable
fun LessonsScreen(navController: NavController) {
    val viewModel: LanguageViewModel = hiltViewModel()
    val lessons by viewModel.lessons.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Lessons",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        LazyColumn(
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(lessons) { lesson ->
                LessonCard(lesson, onClick = {
                    navController.navigate("quiz/${lesson.id}")
                })
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { navController.navigate("progress") }) {
                Text("Progress")
            }
            Button(onClick = { navController.navigate("achievements") }) {
                Text("Achievements")
            }
            Button(onClick = { navController.navigate("forum") }) {
                Text("Forum")
            }
        }
    }
}

@Composable
fun LessonCard(lesson: Lesson, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = lesson.title, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = lesson.description, style = MaterialTheme.typography.body1)
        }
    }
}
