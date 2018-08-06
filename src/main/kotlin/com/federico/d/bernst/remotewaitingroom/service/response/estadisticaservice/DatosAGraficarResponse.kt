package com.federico.d.bernst.remotewaitingroom.service.response.estadisticaservice

data class DatosAGraficarResponse(val map: Map<SalaGraficoResponse, PuntoGraficoResponse>,
                                  val valoresY: List<String>,
                                  val valoresX: List<String>,
                                  val promedio: String?,
                                  val mejor: String?,
                                  val peor: String?)    //  TODO los ultimos 3 los voy a dejar para un futuro

data class PuntoGraficoResponse(val x: String,
                                val y: String)

data class SalaGraficoResponse(val codigo: Long,
                               val descripcion: String,
                               val color: String)

