package one.codium.o2testapp.repo.card

import kotlinx.coroutines.flow.StateFlow
import one.codium.o2testapp.ds.Storage
import one.codium.o2testapp.repo.entity.Card
import one.codium.o2testapp.repo.entity.CardStatus
import java.util.*
import javax.inject.Inject

class CardRepoImpl @Inject constructor(private val storage: Storage): CardRepo {

    override fun cardScratched(uuid: UUID) {
        storage.getCard()?.copy(uuid = uuid, status = CardStatus.SCRATCHED)?.let {
            storage.putCard(it)
        }
    }

    override fun initCard() {
        storage.putCard(Card())
    }

    override fun cardActivated() {
        storage.getCard()?.copy(status = CardStatus.ACTIVATED)?.let {
            storage.putCard(it)
        }
    }

    override fun getCard(): Card? {
        return storage.getCard()
    }

    override fun getCardFlow(): StateFlow<Card?> {
        return storage.getDataFlow()
    }

}
