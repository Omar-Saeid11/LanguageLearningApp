package com.example.languagelearningapp.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.languagelearningapp.screens.AchievementsScreen
import com.example.languagelearningapp.screens.ForumScreen
import com.example.languagelearningapp.screens.LessonsScreen
import com.example.languagelearningapp.screens.ProgressScreen
import com.example.languagelearningapp.screens.QuizScreen

@Composable
fun LanguageLearningApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "lessons") {
        composable("lessons") { LessonsScreen(navController) }
        composable("quiz/{lessonId}") { backStackEntry ->
            val lessonId = backStackEntry.arguments?.getString("lessonId")?.toInt() ?: 1
            QuizScreen(navController, lessonId)
        }
        composable("progress") { ProgressScreen(navController) }
        composable("achievements") { AchievementsScreen(navController) }
        composable("forum") { ForumScreen(navController) }
    }
}
