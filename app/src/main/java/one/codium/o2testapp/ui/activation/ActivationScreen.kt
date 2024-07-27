package one.codium.o2testapp.ui.activation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import one.codium.o2testapp.R

@Composable
fun ActivationScreen(viewModel: ActivationScreenViewModel = hiltViewModel()) {
    val state = viewModel.uiState.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(32.dp))
            Button(
                enabled = state.success != true && !state.inProgress,
                modifier = Modifier.testTag("Activate"),
                onClick = { viewModel.activate() }) {
                Text(text = stringResource(id = R.string.activationScreen_btnActivate))
            }
            state.success?.let {
                if (state.success) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Card activation successfully")
                } else {
                    ActivationErrorDialog {
                        viewModel.dialogShowed()
                    }
                }
            }

            state.error?.let {
                Text(text = it)
            }
        }

        if (state.inProgress) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}


@Composable
fun ActivationErrorDialog(dismissed: () -> Unit) {
    AlertDialog(
        text = { Text(stringResource(id = R.string.activationScreen_activationDialog_message)) },
        title = { Text(stringResource(id = R.string.activationScreen_activationDialog_title)) },
        confirmButton = {
            Button(onClick = { dismissed.invoke() }) {
                Text(stringResource(id = R.string.activationScreen_activationDialog_btnOk))
            }
        },
        onDismissRequest = { dismissed.invoke() },
    )
}
