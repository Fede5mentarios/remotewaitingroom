package com.federico.d.bernst.remotewaitingroom.service

import com.federico.d.bernst.remotewaitingroom.exception.RequestError
import com.federico.d.bernst.remotewaitingroom.model.Usuario
import com.federico.d.bernst.remotewaitingroom.persistence.UsuarioRepository
import com.federico.d.bernst.remotewaitingroom.service.received.LoginReceived
import com.federico.d.bernst.remotewaitingroom.service.response.LoginResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.security.auth.message.AuthException

@Service
class LoginService(@Autowired val usuarioRepository: UsuarioRepository) {
    fun login(received: LoginReceived): LoginResponse {
        return toLoginResponse(usuarioRepository.findByUnique(received.username)
                .filter { it.password == encripted(received.password) })
    }

    private fun toLoginResponse(usuario: Optional<Usuario>): LoginResponse {
        return LoginResponse(usuario.isPresent, usuario,
                armarToken(usuario), usuario.map { user: Usuario? ->
            if (user != null)
                return@map null
            else
                return@map RequestError(444, "Usuario o contraseña invalido",
                        AuthException("Usuario o contraseña invalido"))
        })
    }

    private fun armarToken(usuario: Optional<Usuario>): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun encripted(password: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}