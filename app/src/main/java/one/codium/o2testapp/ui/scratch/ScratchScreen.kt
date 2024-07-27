package one.codium.o2testapp.ui.scratch

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import one.codium.o2testapp.R

@Composable
fun ScratchScreen(viewModel: ScratchScreenViewModel = hiltViewModel()) {
    val state = viewModel.uiState.value
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(32.dp))
            Button(enabled = !state.inProcess && state.uuid == null,
                onClick = { viewModel.scratchCard() }) {
                Text(text = stringResource(id = R.string.scratchScreen_btnScratch))
            }
            if (state.uuid != null) {
                Text("Assigned UUID: ${state.uuid}")
            }
        }
        if (state.inProcess) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}
