@file:OptIn(ExperimentalMaterial3Api::class)

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.piratebay.R
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.piratebay.ui.theme.gris
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Typography

/**
 * enum values that represent the screens in the app
 */
enum class CupcakeScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
}

//Pour la Top bar
@Composable
fun PirateAppBar(
) {
    TopAppBar(
        title = { Text("test") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = gris
        ),
        actions = {
            Row(
                verticalAlignment = Alignment.CenterVertically, // Align elements vertically
                modifier = Modifier.fillMaxWidth() // Occupy maximum width
            ) {
                // Texte à gauche de la top bar :
                Text("Monke -->")

                // Ajouter un espacement entre le texte et la barre de recherche
                Spacer(modifier = Modifier.width(8.dp))

                // Barre de recherche
                TextField(
                    value = "", // Initial value of the TextField
                    onValueChange = { /* Do something with the new value */ },
                    modifier = Modifier.weight(1f), // Occupy remaining space
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Search
                    ),
                    placeholder = { Text("Search...") }
                )

                // Ajouter un espacement entre la barre de recherche et la photo de profil
                Spacer(modifier = Modifier.width(8.dp))

                // Photo de profil à droite
                Image(
                    painter = painterResource(id = R.drawable.pp), // Specify the logo resource
                    contentDescription = "Logo",
                    modifier = Modifier.width(48.dp) // Adjust width as needed
                )
            }
        }
    )
}


// Définir un modèle pour une entrée d'image avec un titre
data class ImageEntry(val title: String, val imageResource: Int)

// Fonction qui crée une liste d'exemples d'images,
// c'est la qu'on définit les images qu'on veut voir dans notre scroll
private fun generateImageList(): List<ImageEntry> {
    return listOf(
        ImageEntry("Image 1", R.drawable.pp),
        ImageEntry("Image 2", R.drawable.pp),
        ImageEntry("Image 3", R.drawable.pp),
        // Ajoutez autant d'entrées que nécessaire
    )
}

// Fonction qui permet de scroll les différentes images
@Composable
fun ImageList() {
    // D'abord on définit une variable avec notre liste d'images
    val images = generateImageList()

    // LazyColumn ca permet de créer une colonne qu'on peut scroll
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp) // Espacement vertical entre les éléments
    ) {
        // La ligne en dessous veut littéralement dire :
        // pour chaque image dans la liste "images" faire :
        items(images) { image ->

            //Chaque image a un titre, on met les deux dans une colonne
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Dans la colonne, on met d'abord l'image
                Image(
                    painter = painterResource(id = image.imageResource),
                    contentDescription = image.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp), // Hauteur fixe pour les images
                    contentScale = ContentScale.Crop // Echelle d'affichage de l'image
                )
                // On met un espace
                Spacer(modifier = Modifier.height(4.dp))

                //Puis son titre
                Text(text = image.title, color = Color.White, style = MaterialTheme.typography.headlineSmall)


            }
        }
    }
}

@Composable
fun CupcakeApp() {
    Scaffold(
        topBar = {
            PirateAppBar()
        }
    ) { innerPadding ->
        Text(
            text = "Background?",
            color = Color.White,
            modifier = Modifier.padding(innerPadding)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "My Image Gallery",
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
            ImageList()
        }
    }
}

