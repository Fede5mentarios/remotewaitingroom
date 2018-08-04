package com.federico.d.bernst.remotewaitingroom.exception

data class RequestError(val errorCode: Int, val descripcion: String, val exception: Exception)