package com.federico.d.bernst.provider.generic

import provider.generic.Entidad
import java.io.Serializable
import java.util.*
import javax.persistence.EntityManager

open class GenericHibernateDAO<T : Entidad<ID>, ID : Serializable>(protected val em: EntityManager, private val persistentClass: Class<T>) : GenericDAO<T, ID> {

    override fun findById(id: ID): Optional<T> {
        return Optional.ofNullable(em.find(persistentClass, id))
    }

    override fun findAll(): MutableList<T> {
        return em.createQuery("FROM " + persistentClass.name)
                .resultList.toMutableList() as MutableList<T>
    }

    override fun saveOrUpdate(entity: T): T {
        if (findById(entity.id).isPresent) {
            em.merge(entity)
        } else {
            em.persist(entity)
        }
        return entity
    }

    override fun delete(entity: T) {
        em.remove(entity)
    }

    override fun delete(id: ID) {
        findById(id).ifPresent { em.remove(it) }
    }

    override fun flush() {
        em.flush()
    }

    override fun clear() {
        em.clear()
    }
}