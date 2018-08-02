package com.federico.d.bernst.model

import com.federico.d.bernst.provider.generic.Entidad
import java.util.*
import javax.persistence.*

@Entity
@Table
data class Sala(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) override val id: Long = -1,
        @ManyToOne val empresa: Empresa = Empresa(),
        val url: String = "sin URL", val habilitado: Boolean = true,
        val cantidad: Int = -1, val promedioMS: Long = 0,
        @Temporal(TemporalType.TIMESTAMP) val fechaModificacion: Calendar = Calendar.getInstance(),
        @Temporal(TemporalType.TIMESTAMP) val fechaCreacion: Calendar = Calendar.getInstance(),
        override val tipoEntidad: TipoEntidad = TipoEntidad.SALA,
        @Transient
        override val padre: Entidad<Long>? = empresa) : Configurable()