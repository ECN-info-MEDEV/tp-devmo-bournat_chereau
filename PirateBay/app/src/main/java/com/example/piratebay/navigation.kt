package com.example.piratebay

import ResearchScreen
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable


//Pour la Top bar
@OptIn(ExperimentalMaterial3Api::class)
/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@Composable
fun PirateAppBar(
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

/**
 * enum values that represent the screens in the app
 */
enum class PirateScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Download(title = R.string.download)
}

@Composable
fun CupcakeApp(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = PirateScreen.valueOf(
        backStackEntry?.destination?.route ?: PirateScreen.Start.name
    )
    Scaffold(
        topBar = {
            PirateAppBar()
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = PirateScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = PirateScreen.Start.name) {
                Column(modifier = Modifier.padding(innerPadding)) {
                    ResearchScreen()
                }
            }
            composable(route = PirateScreen.Download.name) {
                ResearchScreen()
            }
        }
    }
}


