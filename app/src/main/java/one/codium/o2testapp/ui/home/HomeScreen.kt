package one.codium.o2testapp.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import one.codium.o2testapp.R
import one.codium.o2testapp.nav.Route
import one.codium.o2testapp.repo.entity.Card
import one.codium.o2testapp.repo.entity.CardStatus

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navigate: (Route) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        val card: Card? by viewModel.card.collectAsState(null)
        CardStatus(card?.status)
        Spacer(modifier = Modifier.height(24.dp))
        Button(enabled = card?.status == CardStatus.UNSCRATCHED, onClick = {
            navigate(Route.SCRATCH)
        }) {
            Text(text = stringResource(id = R.string.homeScreen_btnScratch))
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(enabled = card?.status == CardStatus.SCRATCHED, onClick = {
            navigate(Route.ACTIVATION)
        }) {
            Text(text = stringResource(id = R.string.homeScreen_btnActivation))
        }
    }
}

@Composable
private fun CardStatus(status: CardStatus?) {
    Row {
        Text(text = stringResource(id = R.string.homeScreen_statusTitle))
        Spacer(modifier = Modifier.width(4.dp))
        val statusTextId = status?.titleId ?: R.string.status_notDefined
        Text(text = stringResource(id = statusTextId))
    }
}
