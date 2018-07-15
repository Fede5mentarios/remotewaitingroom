package com.federico.d.bernst.provider.generic

import java.io.Serializable

interface GenericDAO<T, ID : Serializable> {
    fun findById(id: ID, lock: Boolean): T
    fun findAll(): MutableList<T>
    fun save(entity: T): T
    fun delete(entity: T)
    fun flush()
    fun clear()
}