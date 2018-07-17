package controller.response

import com.federico.d.bernst.excepcion.ResponseException

data class LoginResultResponse(val resultado: Boolean, val mensaje: String, val exception: ResponseException?)
