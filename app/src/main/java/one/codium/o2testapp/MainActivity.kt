package one.codium.o2testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import one.codium.o2testapp.nav.Route
import one.codium.o2testapp.ui.activation.ActivationScreen
import one.codium.o2testapp.ui.home.HomeScreen
import one.codium.o2testapp.ui.scratch.ScratchScreen
import one.codium.o2testapp.ui.theme.O2TestAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            O2TestAppTheme {
                val navController = rememberNavController()
                var canPop by remember {
                    mutableStateOf(false)
                }
                DisposableEffect(navController) {
                    val listener = NavController.OnDestinationChangedListener { controller, _, _ ->
                        canPop = controller.previousBackStackEntry != null
                    }
                    navController.addOnDestinationChangedListener(listener)
                    onDispose {
                        navController.removeOnDestinationChangedListener(listener)
                    }
                }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text(stringResource(id = R.string.app_name)) },
                            navigationIcon = {
                                if (canPop) {
                                    IconButton(onClick = { navController.navigateUp() }) {
                                        Icon(
                                            imageVector = Icons.Default.ArrowBack,
                                            contentDescription = "back"
                                        )
                                    }
                                }
                            }
                        )
                    },

                    ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        NavHost(navController = navController, startDestination = Route.HOME.route) {
                            composable(Route.HOME.route) {
                                HomeScreen {
                                    navController.navigate(it.route)
                                }
                            }

                            composable(Route.ACTIVATION.route) {
                                ActivationScreen()
                            }

                            composable(Route.SCRATCH.route) {
                                ScratchScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}
