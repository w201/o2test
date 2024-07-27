package one.codium.o2testapp.ui.activation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import one.codium.o2testapp.di.CoroutineScopeGlobal
import one.codium.o2testapp.repo.card.CardRepo
import one.codium.o2testapp.repo.entity.network.NetworkResult
import one.codium.o2testapp.repo.network.NetworkRepo
import one.codium.o2testapp.usecase.version.ActivationUsecase
import javax.inject.Inject

@OptIn(DelicateCoroutinesApi::class)
@HiltViewModel
class ActivationScreenViewModel
@Inject constructor(
    private val networkRepo: NetworkRepo,
    private val activationUsecase: ActivationUsecase,
    private val cardRepo: CardRepo,
    @CoroutineScopeGlobal
    private val coroutineScope: CoroutineScope
) : ViewModel() {

    private val _uiState = mutableStateOf(ActivationScreenState())
    val uiState: State<ActivationScreenState> = _uiState

    fun activate() {
        // this coroutines will not be cancel if user leave current screen. Will stay alive until Application alive
        _uiState.value = ActivationScreenState(inProgress = true)
        coroutineScope.launch {
            when (val response = networkRepo.getVersion()) {
                is NetworkResult.Error -> _uiState.value = ActivationScreenState(error = response.error.message)
                is NetworkResult.Success -> activateCard(response.data.android)
            }
        }
    }

    private fun activateCard(version: Int?) {
        val isActivationSuccess = activationUsecase.isActivationApproved(version)
        if (isActivationSuccess) {
            cardRepo.cardActivated()
        }
        _uiState.value = ActivationScreenState(success = isActivationSuccess)
    }

    fun dialogShowed() {
        _uiState.value = ActivationScreenState()
    }

}

data class ActivationScreenState(
    val inProgress: Boolean = false,
    val error: String? = null,
    val success: Boolean? = null
)
