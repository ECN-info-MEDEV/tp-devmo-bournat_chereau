@file:OptIn(ExperimentalMaterial3Api::class)

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.piratebay.PirateAppBar
import com.example.piratebay.PirateFilterBar
import com.example.piratebay.PirateScreen
import com.example.piratebay.ui.theme.PirateBayTheme
import java.time.format.TextStyle

/**
 * enum values that represent the screens in the app
 */
enum class CupcakeScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
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
fun ImageList(navController: NavController) {
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
                            .fillMaxSize()// Remplir l'espace disponible dans le conteneur
                            .clickable {
                                // Navigate to another screen when the image is clicked
                                navController.navigate(PirateScreen.Download.name)},
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
        ResearchScreen(rememberNavController())
    }
}



@Composable
fun ResearchScreen( navController: NavController){
    Scaffold (
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
            ImageList(navController)
        }
    }
}


@Preview
@Composable
fun StartOrderPreview() {
    PirateBayTheme {
        ResearchScreen(rememberNavController())
    }
}