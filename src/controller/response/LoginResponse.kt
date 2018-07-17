package com.federico.d.bernst.controller.response

data class LoginResponse(val resultado: Boolean = false, val mensaje: String, val exception: String?){
    companion object {
        val textOnError = "Usuario o Contraseña invalido"
    }
}
