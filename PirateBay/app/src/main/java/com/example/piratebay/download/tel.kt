package com.example.piratebay.download

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.piratebay.R
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.piratebay.PirateAppBar
import com.example.piratebay.PirateScreen
import com.example.piratebay.ui.theme.PirateBayTheme


@Composable
fun ImageScreen() {
    // État pour suivre quelle section est active
    var selectedSection by remember { mutableStateOf(Section.Description) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Image en haut
        Image(
            painter = painterResource(id = R.drawable.casapapel1), // Remplacez "your_image" par votre image
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        // Boutons pour la description et les commentaires
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = { selectedSection = Section.Description }) {
                Text(text = "Description")
            }
            Button(onClick = { selectedSection = Section.Comment }) {
                Text(text = "Comment")
            }
        }

        // Afficher la section correspondante en fonction de l'état
        when (selectedSection) {
            Section.Description -> DescriptionSection()
            Section.Comment -> CommentSection()
        }
        DownloadButton()
    }
}

// Composables pour la description et les commentaires
@Composable
fun DescriptionSection() {
    Text(text = "Description section content")
}

@Composable
fun CommentSection() {
    Text(text = "Comment section content")
}

// Composable pour le bouton de téléchargement
@Composable
fun DownloadButton() {
    // État pour suivre si le téléchargement a été effectué
    val (isDownloaded, setIsDownloaded) = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Black, shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                // Changer l'état du téléchargement lorsque le bouton est cliqué
                setIsDownloaded(true)
            },
            modifier = Modifier.size(200.dp)
        ) {
            // Afficher "Téléchargement OK" si le téléchargement a été effectué
            // Sinon, afficher "Téléchargement"
            Text(text = if (isDownloaded) "Téléchargement OK" else "Téléchargement", color = Color.White)
        }
    }
}

// Enum pour les sections
enum class Section {
    Description,
    Comment
}

@Preview
@Composable
fun ImageScreenPreview() {
    ImageScreen()
}