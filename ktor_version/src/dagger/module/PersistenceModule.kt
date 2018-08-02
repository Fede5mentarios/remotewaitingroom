package com.federico.d.bernst.dagger.module

import com.federico.d.bernst.provider.EmpresaDAO
import dagger.Module
import dagger.Provides
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration
import provider.EmpresaDAOImpl
import javax.inject.Singleton

@Module
@Singleton
class PersistenceModule {

    @Provides
    public fun provideSession(): SessionFactory? {
        val configuration = Configuration().configure()
        val builder = StandardServiceRegistryBuilder().applySettings(configuration.properties)
        return configuration.buildSessionFactory(builder.build())
    }

//    @Provides
//    public fun provideEmplesaDAO(sessionFactory: SessionFactory): EmpresaDAO = EmpresaDAOImpl(sessionFactory)
}