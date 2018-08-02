package com.federico.d.bernst.provider.generic

import java.io.Serializable
import java.util.*

interface GenericDAO<T : Entidad<ID>, ID : Serializable> {
    fun findById(id: ID): Optional<T>
    fun findAll(): MutableList<T>
    fun saveOrUpdate(entity: T): T
    fun delete(entity: T)
    fun delete(id: ID)
    fun flush()
    fun clear()
}