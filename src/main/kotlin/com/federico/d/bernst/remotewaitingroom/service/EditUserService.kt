package com.federico.d.bernst.remotewaitingroom.service

import com.federico.d.bernst.remotewaitingroom.security.LoguedUser
import com.federico.d.bernst.remotewaitingroom.service.received.EditEmpresaReceived
import com.federico.d.bernst.remotewaitingroom.service.received.EditUsuarioReceived
import com.federico.d.bernst.remotewaitingroom.service.response.*
import org.springframework.stereotype.Service

@Service
class EditUserService {

    fun getUser(codUsuario: Long): DataUsuarioResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun getSalas(codUsuario: Long): DataSalasUsuarioResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun editarUsuario(codUsuario: Long, editUsuario: EditUsuarioReceived): EditUsuarioResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun deleteUsuario(codUsuario: Long): DeleteUsuarioResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
}