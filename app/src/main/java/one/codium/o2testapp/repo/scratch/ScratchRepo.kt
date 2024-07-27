package one.codium.o2testapp.repo.scratch

import java.util.*

interface ScratchRepo {

    suspend fun scratchingOff(): UUID

}
