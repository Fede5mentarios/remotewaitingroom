package com.federico.d.bernst.remotewaitingroom.model

import java.util.*
import javax.persistence.*

@Entity
@Table
data class DatoExtra(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) override val id: Long = -1,
        @ManyToOne val empresa: Empresa = Empresa(),
        val nombreDato: String = "Sin Nombre",
        val valor: String = "Sin Valor",
        val orden: Int = 0,
        @Temporal(TemporalType.TIMESTAMP) val fechaModificacion: Calendar = Calendar.getInstance(),
        @Temporal(TemporalType.TIMESTAMP) val fechaCreacion: Calendar = Calendar.getInstance()) : Entidad<Long>