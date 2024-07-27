package one.codium.o2testapp.ds

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import one.codium.o2testapp.repo.entity.Card

class InMemStorage: Storage {
    private var storage: Card? = null
    private val flow = MutableStateFlow<Card?>(storage)

    override fun putCard(value: Card) {
        storage = value
        flow.value = value
    }

    override fun getCard(): Card? {
        return storage
    }

    override fun getDataFlow(): StateFlow<Card?> {
        return flow
    }

}
