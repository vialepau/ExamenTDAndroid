package cl.talentodigital.examentd.network

import cl.talentodigital.examentd.network.data.DetalleEquipos
import cl.talentodigital.examentd.network.data.Equipos
import cl.talentodigital.examentd.network.pojo.DetalleEquipo
import cl.talentodigital.examentd.network.pojo.Equipo

fun equipoMapper(phoneList: List<Equipos>): List<Equipos> {
    return phoneList.map { equipo ->
        Equipos(
            equipo.id,
            equipo.image,
            equipo.price,
            equipo.name
        )
    }
}

fun detalleMapper(detalle: DetalleEquipo): DetalleEquipos{
    return DetalleEquipos(
        detalle.id,
        detalle.image,
        detalle.price,
        detalle.name,
        detalle.description,
        detalle.lastPrice,
        detalle.credit
    )
}