package one.codium.o2testapp.repo.entity

import java.util.*

data class Card(
    val id: String = UUID.randomUUID().toString(),
    val uuid: UUID? = null,
    val status: CardStatus = CardStatus.UNSCRATCHED
)
