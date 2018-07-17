package com.federico.d.bernst.model

import provider.generic.Entidad
import java.util.*
import javax.persistence.*

@Entity
@Table
data class Historico(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) override val id: Long = -1,
        @ManyToOne
        val empresa: Empresa = Empresa(),
        val url: String = "sin URL",
        val habilitado: Boolean = false, val cantidad: Int = -1,
        val tiempoRespuesta: Long = 0,
        @Temporal(TemporalType.TIMESTAMP) val fechaCreacion: Calendar?) : Entidad<Long>