package com.federico.d.bernst.provider.generic

import org.hibernate.LockMode
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.criterion.Criterion
import java.io.Serializable

open class GenericHibernateDAO<T, ID : Serializable>(private val sessionFactory: SessionFactory, private val persistentClass: Class<T>) : GenericDAO<T, ID> {

    val session: Session
        get() {
            if (sessionFactory.isClosed)
                return sessionFactory.openSession()
            return sessionFactory.currentSession
        }


    fun getPersistentClass(): Class<T> {
        return persistentClass
    }

    override fun findById(id: ID, lock: Boolean): T {
        val entity: T
        if (lock)
            entity = session.load(getPersistentClass(), id, LockMode.UPGRADE)
        else
            entity = session.load(getPersistentClass(), id)
        session.close()
        return entity
    }

    override fun findAll(): MutableList<T> {
        return findByCriteria()!!
    }

    override fun save(entity: T): T {
        session.saveOrUpdate(entity)
        return entity
    }

    override fun delete(entity: T) {
        session.delete(entity)
        session.close()
    }

    override fun flush() {
        session.flush()
        session.close()
    }

    override fun clear() {
        session.clear()
        session.close()
    }

    /**
     * Use this inside subclasses as a convenience method.
     */
    protected fun findByCriteria(vararg criterion: Criterion): MutableList<T>? {
        val crit = session.createCriteria(getPersistentClass())
        for (c in criterion) {
            crit.add(c)
        }
        return crit.list() as MutableList<T>?
    }
}