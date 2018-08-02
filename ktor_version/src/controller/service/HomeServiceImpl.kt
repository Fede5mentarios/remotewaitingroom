package com.federico.d.bernst.controller.service

import com.federico.d.bernst.controller.response.EmpresasResponse
import com.federico.d.bernst.provider.EmpresaDAO
import java.util.stream.Collectors
import javax.inject.Inject


class HomeServiceImpl @Inject constructor(val empresaDAO: EmpresaDAO) : HomeService {

    override fun getEmpresas() = EmpresasResponse(empresaDAO.findAll().parallelStream().map { empresa -> empresa.nombre }.collect(Collectors.toList()))
}