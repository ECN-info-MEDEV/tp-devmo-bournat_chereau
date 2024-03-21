@file:OptIn(ExperimentalMaterial3Api::class)

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Typography
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.piratebay.ui.theme.PirateBayTheme
import java.time.format.TextStyle

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
                    ) {
                        Icon(
                            Icons.Outlined.Search,
                            contentDescription = "Menu",
                            modifier = Modifier
                                .size(60.dp)
                                .padding(5.dp)
                        )
                    }

                    // Ajouter un espacement entre le texte et la barre de recherche
                    Spacer(modifier = Modifier.width(8.dp))

                    // Barre de recherche
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
                    }

                    /* (Inutilisé pour l'instant)
                // Ajouter un espacement entre la barre de recherche et la photo de profil
                Spacer(modifier = Modifier.width(8.dp))

                // Photo de profil à droite
                Image(
                    painter = painterResource(id = R.drawable.pp), // Specify the logo resource
                    contentDescription = "Logo",
                    modifier = Modifier.width(48.dp) // Adjust width as needed
                )
             */

                }

            }
        }
    )
}

//Barre de filtre (****A TERMINER****)
@Composable
fun PirateFilterBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
            .height(40.dp)
            .padding(all = 2.dp),

        ) {
        Box(
            modifier = Modifier
                .padding(all = 2.dp)
        ) {
            Row(){
                Text(
                    text = "Trier par",
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    Icons.Outlined.KeyboardArrowRight,
                    contentDescription = "Open filter",
                    modifier = Modifier
                        .size(60.dp)
                        .padding(5.dp),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Catégorie",
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    Icons.Outlined.KeyboardArrowRight,
                    contentDescription = "Open filter",
                    modifier = Modifier
                        .size(60.dp)
                        .padding(5.dp),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Langue",
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    Icons.Outlined.KeyboardArrowRight,
                    contentDescription = "Open filter",
                    modifier = Modifier
                        .size(60.dp)
                        .padding(5.dp),
                    tint = Color.White
                )

            }

        }

    }
}
// Classe qui regroupe L'image + sa "description" (type de téléchargement, nom, poids, pays)
data class ImageEntry(
    val imageResource: Int,
    val type: String,
    val titre: String,
    val size: String,
    val flagResource: Int // Ajoutez une propriété pour l'image du drapeau
)

// Fonction qui crée une liste d'exemples d'images,
// c'est la qu'on définit les images qu'on veut voir dans notre scroll
private fun generateImageList(): List<ImageEntry> {
    return listOf(
        ImageEntry( R.drawable.casapapel1,
            "Série",
            "La casa de papel s1 e1",
            "251 Mb",
            R.drawable.france),

        ImageEntry( R.drawable.casapapel2,
            "Jeu",
            "La casa de papel : le jeu",
            "1 Gb",
            R.drawable.france),

        ImageEntry( R.drawable.casapapel3,
            "Film",
            "La casa de papel la pelicula",
            "524 Mb",
            R.drawable.espagne),

        ImageEntry( R.drawable.casapapel3,
            "Film",
            "La casa de papel le film",
            "518 Mb",
            R.drawable.france),
        // Ajoutez autant d'entrées que nécessaire
    )
}

@Composable
fun getColorForType(type: String): Color {
    // fonction de logique qui définit la couleur du petit cercle devant la catégorie
    return when (type) {
        "Film" -> Color.Yellow
        "Série" -> Color.Red
        "Jeu" -> Color.Magenta
        else -> Color.Gray
    }
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
                // Dans la colonne, on met d'abord l'image (dans une boite pour le centrage et les marges)
                Spacer(modifier = Modifier.height(40.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp) //Hauteur fixe pour les images
                        .padding(all = 8.dp) // Ajouter une marge de 8dp à droite et à gauche
                ) {
                    Image(
                        painter = painterResource(id = image.imageResource),
                        contentDescription = image.titre,
                        modifier = Modifier
                            .fillMaxSize(), // Remplir l'espace disponible dans le conteneur
                        contentScale = ContentScale.Crop // Echelle d'affichage de l'image
                    )
                }
                // On met un espace
                Spacer(modifier = Modifier.height(4.dp))

                // Puis la description avec le drapeau
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .background(
                                color = getColorForType(image.type),
                                shape = CircleShape
                            )
                    )
                    Text(
                        text = image.type,
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                        color = Color.White
                    )
                    Text(
                        text = image.titre,
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                        color = Color.White
                    )
                    Text(
                        text = image.size,
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                        color = Color.White
                    )
                    Image(
                        painter = painterResource(id = image.flagResource),
                        contentDescription = "French Flag",
                        modifier = Modifier.size(24.dp) // Ajustez la taille de l'image selon vos besoins
                    )
                }



            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewPirateBay() {
    PirateBayTheme {
        CupcakeApp()
    }
}


@Composable
fun CupcakeApp() {
    Scaffold(
        topBar = {
            Column {
                PirateAppBar()
                PirateFilterBar()
            }


        }
    ) { innerPadding ->
        Text(
            text = "",
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

