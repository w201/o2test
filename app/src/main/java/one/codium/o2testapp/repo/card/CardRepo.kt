package one.codium.o2testapp.repo.card

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import one.codium.o2testapp.repo.entity.Card
import java.util.UUID

interface CardRepo {

    fun cardScratched(uuid: UUID)
    fun initCard()
    fun cardActivated()
    fun getCard(): Card?
    fun getCardFlow(): StateFlow<Card?>

}
