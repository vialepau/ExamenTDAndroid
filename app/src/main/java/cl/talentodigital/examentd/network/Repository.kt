package cl.talentodigital.examentd.network

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import cl.talentodigital.examentd.network.Retrofit.Companion.crearRetrofit
import cl.talentodigital.examentd.network.data.DetalleEquipos
import cl.talentodigital.examentd.network.data.Equipos
import cl.talentodigital.examentd.network.data.EquiposDB
import cl.talentodigital.examentd.network.pojo.DetalleEquipo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Repository(context : Context) {

    var equiposDB = EquiposDB.getDatos(context)
    var listaEquipos = equiposDB.getEquipoDao().getEquiposSimple()

    fun datosApi(){
        val llamada=RetrofitC.creaRetrofit().equipos()

        llamada.enqueue(object :Callback<List<Equipos>> {
            override fun onError(call: Call<List<Equipos>>, thr: Throwable) {
                Log.d("LLAMADA", "ERROR")
                Log.d("LLAMADA", thr.message.toString())
            }

            override fun onSuccess(call: Call<List<Equipos>>, res: Response<List<Equipos>>) {
                Log.d("SUCCESS", "${res.body()}")
                Log.d("SUCCESS", "${res.code()}")
                if (res.isSuccessful) {
                    ingresaListado(equipoMapper(res.body()!!))
                } else {
                    Log.d("SUCCESS", "${llamada.request().url}")
                }

            }
        })

    }

    fun cargaDetalles(id:Int) {

        val call = RetrofitC.crearRetrofit().detalleEquipos(id)

        call.enqueue(object : Callback<DetalleEquipos> {
            override fun onSuccess(call: Call<DetalleEquipos>, res: Response<DetalleEquipos>) {
                Log.d("REPO_DETAIL", "${res.code()}")
                Log.d("REPO_DETAIL", "${res.body()}")
                if (res.isSuccessful) {
                    detallesBD(detalleMapper(res.body()!!))
                } else {
                    Log.d("REPO", "${call.request().url}")
                }
            }

            override fun onError(call: Call<DetalleEquipos>, t: Throwable) {
                Log.d("CALL_DETAIL", "LOAD ERROR")
                Log.d("CALL_DETAIL", t.message.toString())
            }

        })
    }
    fun detallesBD(detalleEquipos: DetalleEquipos){
        CoroutineScope(Dispatchers.IO).launch {
            equiposDB.getEquipoDao().agregaDetalleEquipos(detalleEquipos)
        }
    }
    fun ingresaListado(listadoEquipos: List<Equipos>) {
        CoroutineScope(Dispatchers.IO).launch {
            equiposDB.getEquipoDao().agregaListadoEquipos(listadoEquipos)
        }
    }
    fun getDetalleEquipo(id: Int): LiveData<DetalleEquipo> {
        return equiposDB.getEquipoDao().getEquiposDetalle(id)
    }
}
}