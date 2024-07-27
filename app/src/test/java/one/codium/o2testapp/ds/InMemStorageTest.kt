package one.codium.o2testapp.ds

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import one.codium.o2testapp.repo.entity.Card
import org.junit.Test

class InMemStorageTest {

    @Test
    fun testInMemStorage() {
        val storage = InMemStorage()
        assertNull(storage.getCard())
        val card = Card()
        storage.putCard(card)
        assertEquals(card, storage.getCard())
    }
}
