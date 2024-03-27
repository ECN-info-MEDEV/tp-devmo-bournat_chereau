package com.example.piratebay

import ResearchScreen
import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.piratebay.ui.theme.gris
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.piratebay.download.ImageScreen
import com.example.piratebay.download.TelScreen


//Pour la Top bar
@OptIn(ExperimentalMaterial3Api::class)
/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@Composable
fun PirateAppBar1(
    modifier: Modifier = Modifier
)
{
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

//Pour la Top bar
@OptIn(ExperimentalMaterial3Api::class)
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

/**
 * enum values that represent the screens in the app
 */
enum class PirateScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Download(title = R.string.download)
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun PirateBayApp(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = PirateScreen.valueOf(
        backStackEntry?.destination?.route ?: PirateScreen.Start.name
    )
        NavHost(
            navController = navController,
            startDestination = PirateScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .padding()
        ) {
            composable(route = PirateScreen.Start.name) {
                Column(modifier = Modifier.padding()) {
                    ResearchScreen(navController)
                }
            }
            composable(route = PirateScreen.Download.name) {
                TelScreen(navController)
            }
        }
    }


