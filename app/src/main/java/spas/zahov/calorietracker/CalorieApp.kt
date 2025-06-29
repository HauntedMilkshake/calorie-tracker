package spas.zahov.calorietracker

import CalorieNavGraph
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import spas.zahov.calorietracker.bottombar.CalorieBottomBar
import spas.zahov.calorietracker.ui.theme.CalorieTrackerTheme

@Composable
fun App() {
    val navController = rememberNavController()

    CalorieTrackerTheme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = { /* TODO() */ },
            bottomBar = {
                CalorieBottomBar(
                    onDashboardClick = { navController.navigate(Dashboard) },
                    onFoodLogClick = { navController.navigate(FoodLog) },
                    onAddFoodClick = { navController.navigate(AddFood) },
                    onStrategyClick = { navController.navigate(Strategy) },
                    onMoreClick = { navController.navigate(More) }
                )
            }) { padding ->
            CalorieNavGraph(
                modifier = Modifier.padding(padding),
                navController = navController
            )
        }
    }
}