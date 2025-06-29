package spas.zahov.calorietracker.bottombar


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import spas.zahov.calorietracker.R


private enum class BottomBarLocations(
    val iconResource: Int,
    val contentDescriptionResource: Int
) {
    DASHBOARD(
        iconResource = R.drawable.ic_dashboard,
        contentDescriptionResource = R.string.btn_bar_dashboard_icon
    ),
    FOOD_LOG(
        iconResource = R.drawable.ic_food_log,
        contentDescriptionResource = R.string.btn_bar_food_log_icon
    ),
    ADD_FOOD(
        iconResource = R.drawable.ic_add_food,
        contentDescriptionResource = R.string.btn_bar_add_food_icon
    ),
    STRATEGY(
        iconResource = R.drawable.ic_strategy,
        contentDescriptionResource = R.string.btn_bar_strategy_icon
    ),
    MORE(iconResource = R.drawable.ic_more, contentDescriptionResource = R.string.btn_bar_more_icon)
}

@Composable
fun CalorieBottomBar(
    onDashboardClick: () -> Unit,
    onFoodLogClick: () -> Unit,
    onAddFoodClick: () -> Unit,
    onStrategyClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    CalorieBottomBarContent(
        onDashboardClick = onDashboardClick,
        onFoodLogClick = onFoodLogClick,
        onAddFoodClick = onAddFoodClick,
        onStrategyClick = onStrategyClick,
        onMoreClick = onMoreClick
    )
}

@Composable
fun CalorieBottomBarContent(
    onDashboardClick: () -> Unit,
    onFoodLogClick: () -> Unit,
    onAddFoodClick: () -> Unit,
    onStrategyClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    BottomAppBar(
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomBarLocations.entries.forEach { location ->
                    val text = stringResource(location.contentDescriptionResource)
                    CalorieBottomBarItem(
                        onClick = {
                            when (location) {
                                BottomBarLocations.DASHBOARD -> onDashboardClick()
                                BottomBarLocations.FOOD_LOG -> onFoodLogClick()
                                BottomBarLocations.ADD_FOOD -> onAddFoodClick()
                                BottomBarLocations.STRATEGY -> onStrategyClick()
                                BottomBarLocations.MORE -> onMoreClick()
                            }
                        },
                        painter = painterResource(location.iconResource),
                        text = text,
                        contentDescriptionResource = text
                    )
                }
            }
        }
    )
}

@Composable
private fun CalorieBottomBarItem(
    onClick: () -> Unit,
    text: String,
    painter: Painter,
    contentDescriptionResource: String? = null,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(
            modifier = modifier,
            onClick = onClick
        ) {
            Icon(
                painter = painter,
                contentDescription = contentDescriptionResource,
                modifier = modifier
            )

        }
        CalorieBottomBarText(text)

    }
}

@Composable
private fun CalorieBottomBarText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier,
        style = MaterialTheme.typography.labelMedium
    )
}

@Preview
@Composable
private fun CalorieBottomBarItemPreview(
    painter: Painter = painterResource(R.drawable.ic_dashboard),
    text: String = stringResource(R.string.btn_bar_dashboard_icon),
    contentDescriptionResource: String? = stringResource(R.string.btn_bar_dashboard_icon)
) {
    CalorieBottomBarItem(
        painter = painter,
        text = text,
        contentDescriptionResource = contentDescriptionResource,
        onClick = { },
    )
}

@Preview
@Composable
private fun CalorieBottomBarPreview() {
    CalorieBottomBar(
        onDashboardClick = { },
        onFoodLogClick = { },
        onAddFoodClick = { },
        onStrategyClick = { },
        onMoreClick = { }
    )
}
