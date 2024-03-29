package com.example.piratebay.download

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.piratebay.PirateAppBar
import com.example.piratebay.PirateFilterBar
import com.example.piratebay.PirateScreen
import com.example.piratebay.ui.theme.PirateBayTheme
import com.example.piratebay.ui.theme.gris


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PirateTelBar(navController: NavController
) {
    TopAppBar(
        title = { Text("test") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = gris
        ),
        actions = {
            Column () {

                Row(
                    verticalAlignment = Alignment.CenterVertically, // Align elements vertically
                    modifier = Modifier
                        .fillMaxWidth() // Occupy maximum width

                ) {
                    Icon(
                        Icons.Outlined.Menu,
                        contentDescription = "Menu",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(5.dp)
                    )
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .background(
                                color = Color.White,
                                shape = CircleShape
                            )
                            .border(
                                width = 2.dp, // Épaisseur du contour
                                color = Color.DarkGray, // Couleur du contour
                                shape = CircleShape // Forme du contour (ici, un cercle)
                            )
                            .clickable {
                                // Navigate to another screen when the image is clicked
                                navController.navigate(PirateScreen.Start.name)}
                    ) {
                        Icon(
                            Icons.Outlined.ArrowBack,
                            contentDescription = "Return",
                            modifier = Modifier
                                .size(60.dp)
                                .padding(5.dp)
                        )
                    }

                    // Ajouter un espacement entre le texte et la barre de recherche
                    Spacer(modifier = Modifier.width(8.dp))

                    // Barre de recherche (INNUTILISÉ SUR CET ÉCRAN)
                    /*
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                    ) {

                        TextField(
                            value = "", // Valeur initiale du TextField
                            onValueChange = { /* Faites quelque chose avec la nouvelle valeur */ },
                            modifier = Modifier
                                .border(
                                    width = 2.dp,
                                    color = Color.DarkGray,
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .clip(RoundedCornerShape(20.dp)),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Search
                            ),
                            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Left),
                            placeholder = {
                                Text(
                                    "Search...",
                                    textAlign = TextAlign.Center,
                                )


                            }
                        )


                    } */


                // Ajouter un espacement entre la barre de recherche et la photo de profil
                Spacer(modifier = Modifier.width(185.dp))

                // Photo de profil à droite
                Image(
                    painter = painterResource(id = R.drawable.pp), // Specify the logo resource
                    contentDescription = "Logo",
                    modifier = Modifier.width(48.dp) // Adjust width as needed
                )


                }

            }
        }
    )
}

@Composable
fun TelScreen(navController: NavController){
    Scaffold (
        topBar = {
            Column {
                PirateTelBar(navController)
            }
        }
    ) {innerPadding ->
        // ImageScreen() n'est plus enveloppé par une colonne inutile
        ImageScreen(innerPadding)
    }
}

@Composable
fun ImageScreen(innerPadding: PaddingValues) {
    var selectedSection by remember { mutableStateOf(Section.Description) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
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

        // BOutons descriptoion / comment
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

        when (selectedSection) {
            Section.Description -> DescriptionSection()
            Section.Comment -> CommentSection()
        }
            DownloadButton()
            ReportButton()

    }
}

// Composables pour la description et les commentaires
@Composable
fun DescriptionSection() {
    Column {
        Text(
            text = "Proposed by MyMonke :",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Huit voleurs font une prise d'otages dans la Maison royale de la Monnaie d'Espagne, tandis qu'un génie du crime manipule la police pour mettre son plan à exécution",
            color = Color.White
        )
    }
}

@Composable
fun CommentSection() {
    Text(text = "Comment section content",
         color = Color.White)
}

@Composable
fun DownloadButton() {
    // État pour suivre si le téléchargement a été effectué
    val (isDownloaded, setIsDownloaded) = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Black, shape = RoundedCornerShape(8.dp)),

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

// Composable pour le bouton de report
@Composable
fun ReportButton() {
    val (isReported, setIsReported) = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Black, shape = RoundedCornerShape(8.dp)),

    ) {
        Button(
            onClick = {
                setIsReported(true)
                // Gérer le clic sur le bouton de rapport
            },
            modifier = Modifier.size(200.dp)
        ) {
            Text(text = if (isReported) "Report OK" else "Report", color = Color.White)
        }
    }
}
// Enum pour les sections
enum class Section {
    Description,
    Comment
}

@Preview (showBackground = true)
@Composable
fun ImageScreenPreview() {
    TelScreen(rememberNavController())
}