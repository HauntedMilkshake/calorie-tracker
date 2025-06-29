import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import spas.zahov.calorietracker.Dashboard
import androidx.navigation.compose.composable
import spas.zahov.calorietracker.AddFood
import spas.zahov.calorietracker.FoodLog
import spas.zahov.calorietracker.More
import spas.zahov.calorietracker.Strategy

@Composable
fun CalorieNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Dashboard
    ) {
        composable<Dashboard> { /* TODO() */ }
        composable<FoodLog> { /* TODO() */ }
        composable<AddFood> { /* TODO() */ }
        composable<Strategy> { /* TODO() */ }
        composable<More> { /* TODO() */ }
    }
}