package com.federico.d.bernst.remotewaitingroom.service

import com.federico.d.bernst.remotewaitingroom.security.LoguedUser
import com.federico.d.bernst.remotewaitingroom.service.received.EditEmpresaReceived
import com.federico.d.bernst.remotewaitingroom.service.response.DataEmpresaResponse
import com.federico.d.bernst.remotewaitingroom.service.response.DeleteEmpresaResponse
import com.federico.d.bernst.remotewaitingroom.service.response.EditEmpresaResponse
import com.federico.d.bernst.remotewaitingroom.service.response.PartesEmpresaResponse
import org.springframework.stereotype.Service

@Service
class EmpresaService {

    fun getEmpresa(user: LoguedUser?): DataEmpresaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun getPartesEmpresa(user: LoguedUser?): PartesEmpresaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun editarEmpresa(user: LoguedUser?, editEmpresa: EditEmpresaReceived): EditEmpresaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")

    fun deleteEmpresa(user: LoguedUser?): DeleteEmpresaResponse = TODO("Falta implementar, estoy armando la estructura por ahora")
}