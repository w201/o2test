package one.codium.o2testapp.repo.network

import one.codium.o2testapp.repo.entity.network.GetVersionResponse
import one.codium.o2testapp.repo.network.dto.GetVersionResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface O2API {

    @GET("version")
    suspend fun getVersion(): Response<GetVersionResponseDTO>

}
