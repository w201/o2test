package one.codium.o2testapp.repo.network

import one.codium.o2testapp.repo.entity.network.GetVersionResponse
import one.codium.o2testapp.repo.entity.network.NetworkResult

interface NetworkRepo {
    suspend fun getVersion(): NetworkResult<GetVersionResponse>
}
