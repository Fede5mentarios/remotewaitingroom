package com.federico.d.bernst.controller.service

import controller.response.LoginResultResponse
import com.federico.d.bernst.model.Usuario
import java.util.*

interface LoginService {

    fun authToken(userName: String, password: String): LoginResultResponse
    fun getUsuario(userName: String?, token: String?): Optional<Usuario>

}