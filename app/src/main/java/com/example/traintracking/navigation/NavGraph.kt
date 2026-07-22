package com.example.traintracking.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.traintracking.data.model.Train
import com.example.traintracking.ui.screen.AddTrainScreen
import com.example.traintracking.ui.screen.HomeScreen
import com.example.traintracking.ui.screen.MapScreen
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
object HomeRoute

@Serializable
data class MapRoute(val train: String) // JSON serialized train

@Serializable
object AddTrainRoute

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> {
            HomeScreen(
                onTrainClick = { train ->
                    val trainJson = Json.encodeToString(train)
                    navController.navigate(MapRoute(trainJson))
                },
                onAddTrainClick = {
                    navController.navigate(AddTrainRoute)
                }
            )
        }

        composable<MapRoute> { backStackEntry ->
            val trainJson = backStackEntry.arguments?.getString("train") ?: return@composable
            val train = try {
                Json.decodeFromString<Train>(trainJson)
            } catch (e: Exception) {
                return@composable
            }
            MapScreen(
                train = train,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable<AddTrainRoute> {
            AddTrainScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}