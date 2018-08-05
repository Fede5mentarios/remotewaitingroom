package com.federico.d.bernst.remotewaitingroom.service.received

data class OwnerReceived(val username: String, val password: String,
                         val descripcion: String,
                         val nombreRol: String?,
                         val preguntaDeRecupero: String,
                         val respuestaRecupero: String)
