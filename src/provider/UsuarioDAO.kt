package com.federico.d.bernst.provider

import com.federico.d.bernst.model.Usuario
import com.federico.d.bernst.provider.generic.GenericDAO
import java.util.*

interface UsuarioDAO : GenericDAO<Usuario,Long>{

    fun findByUsername(username:String):Optional<Usuario>
}