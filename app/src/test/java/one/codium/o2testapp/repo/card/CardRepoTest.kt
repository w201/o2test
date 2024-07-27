package one.codium.o2testapp.repo.card

import junit.framework.TestCase.*
import one.codium.o2testapp.ds.InMemStorage
import one.codium.o2testapp.repo.entity.CardStatus
import org.junit.Test
import java.util.*

class CardRepoTest {

    @Test
    fun testInitCard() {
        val repo = CardRepoImpl(InMemStorage())
        assertNull(repo.getCard())
        repo.initCard()
        assertNotNull(repo.getCard())
    }

    @Test
    fun testScratchCard() {
        val repo = CardRepoImpl(InMemStorage())
        repo.initCard()
        val uuid = UUID.randomUUID()
        repo.cardScratched(uuid)
        assertEquals(uuid, repo.getCard()?.uuid)
        assertEquals(CardStatus.SCRATCHED, repo.getCard()?.status)
    }

    @Test
    fun testActivateCard() {
        val repo = CardRepoImpl(InMemStorage())
        repo.initCard()
        repo.cardActivated()
        assertEquals(CardStatus.ACTIVATED, repo.getCard()?.status)
    }


}
