package one.codium.o2testapp.ds

import kotlinx.coroutines.flow.StateFlow
import one.codium.o2testapp.repo.entity.Card

interface Storage {
    fun putCard(value: Card)
    fun getCard(): Card?
    fun getDataFlow(): StateFlow<Card?>
}
