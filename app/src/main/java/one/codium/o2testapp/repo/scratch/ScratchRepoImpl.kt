package one.codium.o2testapp.repo.scratch

import kotlinx.coroutines.delay
import java.util.UUID

class ScratchRepoImpl: ScratchRepo {

    override suspend fun scratchingOff():UUID {
        delay(2000)
        return UUID.randomUUID()
    }

}
