package com.federico.d.bernst.dagger

import com.federico.d.bernst.dagger.module.PersistenceModule
import com.federico.d.bernst.dagger.module.ServiceModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [PersistenceModule::class, ServiceModule::class])
@Singleton
public interface AplicationComponent {

    companion object {
//        fun inject() = DaggerAplicationComponent
    }
}