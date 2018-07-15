package com.federico.d.bernst.dagger.module

import com.federico.d.bernst.controller.service.HomeServiceImpl
import com.federico.d.bernst.provider.EmpresaDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Singleton
class ServiceModule {

    @Provides
    public fun provideHomeService(empresaDAO: EmpresaDAO): HomeServiceImpl = HomeServiceImpl(empresaDAO)
}