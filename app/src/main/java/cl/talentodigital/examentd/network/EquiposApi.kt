package cl.talentodigital.examentd.network

import cl.talentodigital.examentd.network.data.DetalleEquipos
import cl.talentodigital.examentd.network.data.Equipos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EquiposApi {

    @GET("products/")
    fun equipos() : Call<List<Equipos>>

    @GET("details/{id}")
    fun detalleEquipo(
        @Path("id") id:Int):Call<DetalleEquipos>

}