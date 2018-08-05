package com.federico.d.bernst.remotewaitingroom.service.response

import com.federico.d.bernst.remotewaitingroom.exception.RequestError
import com.federico.d.bernst.remotewaitingroom.model.Usuario
import java.util.*

data class LoginResponse(val resultado: Boolean, val usuario: Optional<Usuario>,
                         val token: String?, val error: Optional<RequestError>) {
    val tokenType: String = "Bearer"
}