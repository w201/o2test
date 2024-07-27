package one.codium.o2testapp.repo.network

import kotlinx.coroutines.delay
import one.codium.o2testapp.repo.entity.network.GetVersionResponse
import one.codium.o2testapp.repo.entity.network.NetworkResult
import one.codium.o2testapp.repo.network.dto.NetworkMapper

class NetworkRepoImpl(private val api: O2API) : NetworkRepo {

    override suspend fun getVersion(): NetworkResult<GetVersionResponse> {
        return try {
            delay(3000)
            val result = api.getVersion()
            val resultBody = result.body()
            if (result.isSuccessful && resultBody != null) {
                NetworkResult.Success(NetworkMapper.instance.getVersion(resultBody))
            } else {
                NetworkResult.Error(Throwable(result.errorBody().toString()))
            }
        } catch (e: Exception) {
            NetworkResult.Error(e)
        }
    }

}
