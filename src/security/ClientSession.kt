package com.federico.d.bernst.security

data class ClientSession(val idSesion: String, val token: String?){
    companion object {
        val sessionName = "clientSession"
    }
}