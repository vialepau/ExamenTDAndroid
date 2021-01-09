package cl.talentodigital.examentd.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.examentd.R
import cl.talentodigital.examentd.network.pojo.Equipo
import com.squareup.picasso.Picasso

class EquiposAdapter (private var equiposData : MutableList<Equipo>):RecyclerView.Adapter<EquiposAdapter.EquiposViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquiposViewHolder {
        val vista= LayoutInflater.from(parent.context).inflate(R.layout.listado_equipos,parent,false)
    }

    override fun getItemCount(): Int {
        return equiposData.size
    }
    val seleccion = MutableLiveData<Equipo>()
    override fun onBindViewHolder(holder: EquiposViewHolder, position: Int) {
        //holder.nombreEquipo.text = equiposData.get(position).name
        //holder.precioEquipo.text = equiposData.get(position).price
        //Picasso.get().load(equiposData.get(position).image).into(holder.imagen)

        holder.itemView.setOnClickListener{
            seleccion.value =  equiposData.get(position)
        }
    }
    class EquiposViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        //var nombreEquipo = itemView.nombre_equipo
        //var precioEquipo = itemViewiew.precio_equipo
        //var imagen = itemView.imagen
    }

    fun actualizar (it: List<Equipo>){
        equiposData.clear()
        equiposData.addAll(it)
        notifyDataSetChanged()
    }
}