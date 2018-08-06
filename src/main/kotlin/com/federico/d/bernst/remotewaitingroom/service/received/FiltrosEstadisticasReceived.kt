package com.federico.d.bernst.remotewaitingroom.service.received

data class FiltrosEstadisticasReceived(val salas: List<SalaSeleccionadaReceived>?,
                                       val opcionEjeY: OpcionEjeYReceived?,
                                       val rango: RangoFechasReceived?,
                                       val opcionEjeX: OpcionEjeXReceived?)

data class SalaSeleccionadaReceived(val codigo: Long, val color: String)

data class OpcionEjeYReceived(val codigo: Long)

data class OpcionEjeXReceived(val codigo: Long, val cantidad: Int? = null)