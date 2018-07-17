package com.federico.d.bernst.koin

import com.federico.d.bernst.controller.service.HomeService
import com.federico.d.bernst.controller.service.HomeServiceImpl
import com.federico.d.bernst.provider.EmpresaDAO
import org.koin.dsl.module.applicationContext
import provider.EmpresaDAOImpl
import javax.persistence.EntityManager
import javax.persistence.Persistence


val serviceModule = applicationContext {
    bean { HomeServiceImpl(get()) as HomeService }
}

val persistenseModule = applicationContext {
    bean { entityManager }
    bean { EmpresaDAOImpl(get()) as EmpresaDAO }
}

val entityManager: EntityManager
    get() = Persistence.createEntityManagerFactory("remotewr").createEntityManager()
