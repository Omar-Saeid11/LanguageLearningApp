package com.example.languagelearningapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.languagelearningapp.data.Achievement
import com.example.languagelearningapp.viewmodel.LanguageViewModel

@Composable
fun AchievementsScreen(navController: NavController) {
    val viewModel: LanguageViewModel = hiltViewModel()
    val achievements by viewModel.achievements.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Achievements", style = MaterialTheme.typography.h4)

        LazyColumn(
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(achievements) { achievement ->
                AchievementCard(achievement)
            }
        }

        Button(onClick = { navController.popBackStack() }) {
            Text("Back to Lessons")
        }
    }
}

@Composable
fun AchievementCard(achievement: Achievement) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.Star, contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = achievement.title, style = MaterialTheme.typography.h6)
                Text(text = achievement.description, style = MaterialTheme.typography.body2)
            }
        }
    }
}
