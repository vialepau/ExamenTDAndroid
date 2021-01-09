package cl.talentodigital.examentd.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cl.talentodigital.examentd.network.Repository
import cl.talentodigital.examentd.network.pojo.DetalleEquipo
import cl.talentodigital.examentd.network.pojo.Equipo

class EquiposViewModel (application: Application) : AndroidViewModel(application){

    var repositorio :Repository = Repository(application)
    var detalleSimple = repositorio.listaEquipos

    lateinit var resultado : LiveData<DetalleEquipo>

    init {
        repositorio = Repository(application)
        repositorio.datosApi()
    }

    private val equipoElegido = MutableLiveData<Equipo>()

    fun seleccion(equipo: Equipo){
        equipoElegido.value =equipo
        repositorio.cargaDetalles(equipo.id)
        resultado = repositorio.getDetalleEquipo(equipo.id)
    }


}