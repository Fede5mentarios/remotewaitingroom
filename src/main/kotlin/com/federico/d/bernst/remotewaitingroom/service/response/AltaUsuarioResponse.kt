package com.federico.d.bernst.remotewaitingroom.service.response

import com.federico.d.bernst.remotewaitingroom.exception.RequestError
import com.federico.d.bernst.remotewaitingroom.model.Usuario
import java.util.*

data class AltaUsuarioResponse(val usuario: Optional<Usuario>, val error: RequestError? = null)