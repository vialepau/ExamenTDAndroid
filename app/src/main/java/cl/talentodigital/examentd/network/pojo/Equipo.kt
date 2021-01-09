package cl.talentodigital.examentd.network.pojo

import com.google.gson.annotations.SerializedName

data class Equipo(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("price")
    val price: Int,

    @SerializedName("image")
    val image: String

)