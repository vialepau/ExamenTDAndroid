package cl.talentodigital.examentd.network.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface EquiposDao {
    @Query("SELECT * FROM nombres_equipos")
    fun getEquiposSimple() : LiveData<List<Equipos>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregaListadoEquipos(listadoEquipos : List<Equipos>)

    @Query("SELECT * FROM detalle_equipos WHERE id=:id")
    fun getEquiposDetalle(id:Int) : LiveData<DetalleEquipos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregaDetalleEquipos(detalleEquipos: DetalleEquipos)
}