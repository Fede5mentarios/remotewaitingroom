package com.federico.d.bernst.remotewaitingroom.model

import javax.persistence.*

@Entity
@Table
data class Permiso(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) override val id: Long = -1,
        val tipoAcceso: TipoAcceso = TipoAcceso.NONE,
        val codEntidad: Long = -1) : Entidad<Long>

enum class TipoAcceso { NONE, EMPRESA, SALA, HISTORICO_EMPRESA, HISTORICO_SALA, ADMIN }