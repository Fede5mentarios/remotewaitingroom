package com.federico.d.bernst.koin

import com.federico.d.bernst.controller.service.HomeService
import com.federico.d.bernst.controller.service.HomeServiceImpl
import com.federico.d.bernst.provider.EmpresaDAO
import org.hibernate.SessionFactory
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration
import org.koin.dsl.module.applicationContext
import provider.EmpresaDAOImpl

val serviceModule = applicationContext {
    bean { HomeServiceImpl(get()) as HomeService }
}

val persistenseModule = applicationContext {
    bean { provideSession() }
    bean { EmpresaDAOImpl(get()) as EmpresaDAO }
}

fun provideSession(): SessionFactory {
    val configuration = Configuration().configure()
    val builder = StandardServiceRegistryBuilder().applySettings(configuration.properties)
    return configuration.buildSessionFactory(builder.build())!!
}
