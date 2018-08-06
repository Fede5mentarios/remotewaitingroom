package com.federico.d.bernst.remotewaitingroom.service.response.estadisticaservice

import java.util.*

data class DataBasicaEstadisticasResponse(
        val descripcionEmpresa: String, //  TODO podria ser un objeto con mas data, todavia no se
        val salas: List<SalasDisponiblesResponse>,
        val opcionesParaEjeY: List<OpcionesEjeYResponse>,
        val inicioParaEjeX: OpcionFechaResponse,
        val finParaEjeX: OpcionFechaResponse)

data class SalasDisponiblesResponse(val codigo: Long,
                                    val descripcion: String,
                                    val color: String,
                                    val seleccionada: Boolean)

data class OpcionesEjeYResponse(val codigo: Long,
                                val descripcion: String,
                                val orden: Int)

data class OpcionFechaResponse(val fecha: Calendar) //TODO ver la mojor firma de pasar esto, así puede elegir en un date-picker las fehcas que quiera
