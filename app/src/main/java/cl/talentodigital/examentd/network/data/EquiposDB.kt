package cl.talentodigital.examentd.network.data

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room

@Database(entities = [Equipos::class, DetalleEquipos::class],version = 1)
abstract class EquiposDB : RoomDatabase(){

    abstract fun getEquipoDao():EquiposDao

    companion object{
        @Volatile
        private var TRAER_DATOS :EquiposDB? = null
        fun getDatos(context: Context) : EquiposDB{
            val tempInstance = TRAER_DATOS
            if (tempInstance !=null){
                return tempInstance
            }
            synchronized(this){
                val traeDatos = Room.databaseBuilder(
                    context.applicationContext,
                    EquiposDB::class.java,"equipos_db")
                    .build()
                TRAER_DATOS =traeDatos
                return traeDatos
            }
        }


    }
}