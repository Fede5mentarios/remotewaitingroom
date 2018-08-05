package com.federico.d.bernst.remotewaitingroom.service.response

import com.federico.d.bernst.remotewaitingroom.exception.RequestError
import com.federico.d.bernst.remotewaitingroom.model.Empresa
import java.util.*

data class AltaEmpresaResponse(val empresa: Optional<Empresa>,
                               val error: RequestError? = null)
