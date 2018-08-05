package com.federico.d.bernst.remotewaitingroom.service.received

data class AltaEmpresaReceived(val usernameOwner: String,
                               val descripcion: String,
                               val nombreFantasia: String?,
                               val datosExtras: Map<String, String>)
