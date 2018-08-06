package com.federico.d.bernst.remotewaitingroom.service

import com.federico.d.bernst.remotewaitingroom.security.LoguedUser
import com.federico.d.bernst.remotewaitingroom.service.received.FiltrosEstadisticasReceived
import com.federico.d.bernst.remotewaitingroom.service.received.RangoFechasReceived
import com.federico.d.bernst.remotewaitingroom.service.response.estadisticaservice.DataBasicaEstadisticasResponse
import com.federico.d.bernst.remotewaitingroom.service.response.estadisticaservice.DatosAGraficarResponse
import com.federico.d.bernst.remotewaitingroom.service.response.estadisticaservice.OpcionesDeltaXResponse
import org.springframework.stereotype.Service

@Service
class EstadisticaService {

    fun getDatosBasicos(user: LoguedUser?): DataBasicaEstadisticasResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun getOpcionesDeltaX(rangoFechasElejido: RangoFechasReceived): OpcionesDeltaXResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun getDatosAGraficar(filtros: FiltrosEstadisticasReceived): DatosAGraficarResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
}