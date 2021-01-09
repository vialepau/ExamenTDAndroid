package cl.talentodigital.examentd.network.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "nombres_equipos")
data class Equipos(
    @SerializedName("id")
    @PrimaryKey val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("price")
    val price: Int,

    @SerializedName("image")
    val image: String,



)
