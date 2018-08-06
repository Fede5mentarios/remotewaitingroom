package com.federico.d.bernst.remotewaitingroom.service

import com.federico.d.bernst.remotewaitingroom.service.response.DataEmpresaResponse
import com.federico.d.bernst.remotewaitingroom.service.response.turnservice.*
import org.springframework.stereotype.Service

@Service
class TurnService {
    fun getTurno(): TurnoResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun activateNotification(): NotificationResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun salirDeEspera(): SalidaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun datosEspera(): EsperaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun datosEmpresa(): DataEmpresaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
}