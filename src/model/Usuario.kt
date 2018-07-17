package com.federico.d.bernst.model

import com.federico.d.bernst.provider.generic.Entidad
import javax.persistence.*

@Entity
@Table
data class Usuario (
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) override val id: Long = -1,
        val userName: String = "sin nombre", val password: String = "sin pass"): Entidad<Long>