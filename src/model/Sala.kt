package com.federico.d.bernst.model

import java.sql.Date
import javax.persistence.*

@Entity
@Table(schema = "public")
data class Sala (
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) val id: Long,
        @OneToOne val empresa: Empresa?,
        val url: String, val habilitado: Boolean,
        val cantidad: Int, val promedioMS: Long,
        @Temporal(TemporalType.TIME) val fechaCreacion: Date)