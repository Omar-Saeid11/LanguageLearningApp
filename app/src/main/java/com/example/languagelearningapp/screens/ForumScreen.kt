package com.example.languagelearningapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
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
import com.example.languagelearningapp.data.Post
import com.example.languagelearningapp.viewmodel.LanguageViewModel

@Composable
fun ForumScreen(navController: NavController) {
    val viewModel: LanguageViewModel = hiltViewModel()
    val forumPosts by viewModel.forumPosts.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Community Forum", style = MaterialTheme.typography.h4)

        LazyColumn(
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(forumPosts) { post ->
                PostCard(post)
            }
        }

        Button(onClick = { navController.popBackStack() }) {
            Text("Back to Lessons")
        }
    }
}

@Composable
fun PostCard(post: Post) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = post.title, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = post.excerpt, style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { }) {
                Text(text = "Read More")
            }
        }
    }
}
