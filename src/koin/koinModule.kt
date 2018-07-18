package com.federico.d.bernst.koin

import com.federico.d.bernst.controller.service.HomeService
import com.federico.d.bernst.controller.service.HomeServiceImpl
import com.federico.d.bernst.controller.service.LoginService
import com.federico.d.bernst.controller.service.LoginServiceImpl
import com.federico.d.bernst.provider.EmpresaDAO
import com.federico.d.bernst.provider.UsuarioDAO
import com.federico.d.bernst.security.JWTAuthClass
import org.koin.dsl.module.applicationContext
import provider.EmpresaDAOImpl
import provider.UsuarioDAOImpl
import javax.persistence.EntityManager
import javax.persistence.Persistence


val serviceModule = applicationContext {
    bean { JWTAuthClass.instance }
    bean { HomeServiceImpl(get()) as HomeService }
    bean { LoginServiceImpl(get(), get()) as LoginService }
}

val persistenseModule = applicationContext {
    bean { entityManager }
    bean { EmpresaDAOImpl(get()) as EmpresaDAO }
    bean { UsuarioDAOImpl(get()) as UsuarioDAO }
}


val entityManager: EntityManager
    get() = Persistence.createEntityManagerFactory("remotewr").createEntityManager()
