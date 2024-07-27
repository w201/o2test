package one.codium.o2testapp.ui.scratch

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import one.codium.o2testapp.repo.card.CardRepo
import one.codium.o2testapp.repo.scratch.ScratchRepo
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ScratchScreenViewModel @Inject constructor(
    private val scratchRepo: ScratchRepo,
    private val cardRepo: CardRepo
) : ViewModel() {

    private val _uiState = mutableStateOf(ScratchScreenState())
    val uiState: State<ScratchScreenState> = _uiState

    fun scratchCard() {
        //coroutines will be cancelled once user exit from screen
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = _uiState.value.copy(true)
            val uuid = scratchRepo.scratchingOff()
            cardRepo.cardScratched(uuid)
            _uiState.value = _uiState.value.copy(uuid = uuid, inProcess = false)
        }
    }
}

data class ScratchScreenState(
    val inProcess: Boolean = false,
    val uuid: UUID? = null
)
