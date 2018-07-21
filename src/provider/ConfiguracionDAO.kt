package com.federico.d.bernst.provider

import com.federico.d.bernst.model.Configuracion
import com.federico.d.bernst.model.Empresa
import com.federico.d.bernst.model.PKConfig
import com.federico.d.bernst.model.Usuario
import com.federico.d.bernst.provider.generic.Entidad
import com.federico.d.bernst.provider.generic.GenericDAO
import java.util.*

interface ConfiguracionDAO : GenericDAO<Configuracion,PKConfig>