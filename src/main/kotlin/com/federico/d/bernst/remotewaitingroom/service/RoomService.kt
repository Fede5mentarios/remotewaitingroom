package com.federico.d.bernst.remotewaitingroom.service

import com.federico.d.bernst.remotewaitingroom.security.LoguedUser
import com.federico.d.bernst.remotewaitingroom.service.response.roomservice.*
import org.springframework.stereotype.Service

@Service
class RoomService {

    fun crearSala(user: LoguedUser?): NuevaSalaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
    fun getSala(user: LoguedUser?): SalaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun sigiente(user: LoguedUser?): SiguienteResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
    fun anterior(user: LoguedUser?): AnteriorResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
    fun asignarTurnoFisico(user: LoguedUser?): TurnoFisicoResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun verQR(): QRResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
    fun generarQR(): QRResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
    fun descargarQR(): QRResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun atencionOK(user: LoguedUser?): AtencionOkResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
    fun atencionExcepcional(user: LoguedUser?, excepcionID: Long?): AtencionExcepcionalResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
    fun pasarDeSala(user: LoguedUser?, salaID: Long): PasoSalaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun abrirSala(user: LoguedUser?): EstadoSalaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
    fun pausarSala(user: LoguedUser?): EstadoSalaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
    fun retomarSala(user: LoguedUser?): EstadoSalaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
    fun cerrarSala(user: LoguedUser?, salaID: Long): EstadoSalaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun borrarSala(user: LoguedUser?, salaID: Long): BorradoSalaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
}