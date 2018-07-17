package com.federico.d.bernst.controller.service

import com.federico.d.bernst.model.Usuario
import com.federico.d.bernst.provider.UsuarioDAO
import controller.response.LoginResultResponse
import java.util.*
import javax.inject.Inject


class LoginServiceImpl @Inject constructor(val usuarioDAO: UsuarioDAO) : LoginService {

    override fun authToken(userName: String, password: String): LoginResultResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUsuario(userName: String?, token: String?): Optional<Usuario> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}