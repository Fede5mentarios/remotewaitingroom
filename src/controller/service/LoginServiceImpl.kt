package com.federico.d.bernst.controller.service

import com.federico.d.bernst.controller.response.AuthResponse
import com.federico.d.bernst.excepcion.FailAuthException
import com.federico.d.bernst.provider.UsuarioDAO
import com.federico.d.bernst.security.JWTAuthClass
import javax.inject.Inject


class LoginServiceImpl @Inject constructor(val usuarioDAO: UsuarioDAO, val JWTAuthClass: JWTAuthClass) : LoginService {

    override fun login(username: String, password: String) = getUsuario(username, password)
            .map { AuthResponse(JWTAuthClass.sign(it.userName)) }
            .orElseThrow { throw FailAuthException("Invalid credentials") }

    fun getUsuario(userName: String, password: String) = usuarioDAO.findByUsernameAndPassword(userName, password)
}