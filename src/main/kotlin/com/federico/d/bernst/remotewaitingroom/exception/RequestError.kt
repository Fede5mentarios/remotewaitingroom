package com.federico.d.bernst.remotewaitingroom.exception

data class RequestError(val errorCode: Int? = null, val descripcion: String, val exception: Exception? = null)