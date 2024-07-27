package one.codium.o2testapp.repo.network.dto

import one.codium.o2testapp.repo.entity.network.GetVersionResponse
import one.codium.o2testapp.repo.entity.network.NetworkResult
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper
interface NetworkMapper {

    fun getVersion(dto: GetVersionResponseDTO): GetVersionResponse

    companion object {
        val instance = Mappers.getMapper(NetworkMapper::class.java)
    }
}
