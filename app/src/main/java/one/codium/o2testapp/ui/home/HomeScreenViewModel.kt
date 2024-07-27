package one.codium.o2testapp.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import one.codium.o2testapp.repo.card.CardRepo
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val cardRepo: CardRepo) : ViewModel() {
    val card = cardRepo.getCardFlow()

}
