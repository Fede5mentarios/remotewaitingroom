package com.federico.d.bernst.remotewaitingroom.persistence.custom

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


abstract class GenericRepositoryImpl {
    @PersistenceContext
    lateinit var em: EntityManager
}