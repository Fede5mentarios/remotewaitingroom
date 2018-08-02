package com.federico.d.bernst.provider

import com.federico.d.bernst.model.Empresa
import com.federico.d.bernst.model.Usuario
import com.federico.d.bernst.provider.generic.GenericDAO
import java.util.*

interface EmpresaDAO : GenericDAO<Empresa,Long>{
    fun findByUsuario(usuario: Usuario): Optional<Empresa>
}