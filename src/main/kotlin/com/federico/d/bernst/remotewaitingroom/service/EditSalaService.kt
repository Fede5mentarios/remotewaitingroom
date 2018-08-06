package com.federico.d.bernst.remotewaitingroom.service

import com.federico.d.bernst.remotewaitingroom.service.received.EditUsuarioReceived
import com.federico.d.bernst.remotewaitingroom.service.response.DataSalaResponse
import com.federico.d.bernst.remotewaitingroom.service.response.DataUsuariosSalaResponse
import com.federico.d.bernst.remotewaitingroom.service.response.DeleteSalaResponse
import com.federico.d.bernst.remotewaitingroom.service.response.EditSalaResponse
import org.springframework.stereotype.Service

@Service
class EditSalaService {
    fun getSala(codSala: Long): DataSalaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun getUsuarios(codSala: Long): DataUsuariosSalaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun editarSala(codSala: Long, editUsuario: EditUsuarioReceived): EditSalaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun deleteSala(codSala: Long): DeleteSalaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
}