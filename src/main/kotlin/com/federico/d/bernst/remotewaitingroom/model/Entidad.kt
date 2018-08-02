package com.federico.d.bernst.remotewaitingroom.model

import java.io.Serializable

interface Entidad<ID : Serializable> {
    val id: ID
}
