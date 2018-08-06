package com.federico.d.bernst.remotewaitingroom.service.response.estadisticaservice

data class OpcionesDeltaXResponse(val opciones: List<OpcionDeltaXResponse>)

data class OpcionDeltaXResponse(val codigo: Int, val descripcion: String, val cantPermitida: Int = 0)

val opcionesDeltaXResponse = arrayListOf(
        OpcionDeltaXResponse(1, "Turno a Turno"),
        OpcionDeltaXResponse(2, "cada n Turnos", 1),
        OpcionDeltaXResponse(3, "Por día"),
        OpcionDeltaXResponse(4, "cada n días", 1),
        OpcionDeltaXResponse(5, "Lunes a Domingo"),
        OpcionDeltaXResponse(6, "Mes")
)
