package com.federico.d.bernst.controller.service

import com.federico.d.bernst.controller.response.EmpresasResponse
import java.util.stream.Collectors

interface HomeService {
    fun getEmpresas(): EmpresasResponse
}