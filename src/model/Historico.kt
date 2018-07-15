package com.federico.d.bernst.model

import java.sql.Date
import javax.persistence.*

@Entity
@Table(schema = "public")
data class Historico (
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) val id: Long,
        val empresa: Empresa?, val url: String,
        val habilitado: Boolean, val cantidad: Int,
        val tiempoRespuesta: Long,
        @Temporal(TemporalType.TIME) val fechaCreacion: Date)