package com.federico.d.bernst.model

import com.federico.d.bernst.provider.generic.Entidad
import java.io.Serializable
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity

@Entity
data class Configuracion(
        @EmbeddedId override val id: PKConfig,
        val valorGson: String) : Entidad<PKConfig>

@Embeddable
data class PKConfig(val tipoEntidad: TipoEntidad,
                    val idEntidad: Long,
                    val key: String) : Serializable

enum class TipoEntidad(val next: TipoEntidad?) { EMPRESA(null), SALA(EMPRESA) }

val configuracionesPosibles = arrayListOf(
        "TiempoPromedioEspera",
        "EntregaTurnosInicio",
        "EntregaTurnosFin",
        "DiasAtencion",
        "HoraDeLimpiezaTurnos",
        "DiasLimpiezaTurnos",
        "TurnosEntregables",
        "TurnosEnAntencion")
