package one.codium.o2testapp.repo.network.dto

import com.google.gson.annotations.SerializedName

data class GetVersionResponseDTO(
    @SerializedName("android")
    val android: String?
)
