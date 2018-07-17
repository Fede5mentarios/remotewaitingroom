package com.federico.d.bernst.model

import com.federico.d.bernst.provider.generic.Entidad
import javax.persistence.*

@Entity(name = "empresa")
@Table(name = "empresa")
data class Empresa(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) override val id: Long = -1,
        val nombre: String = "sin nombre",
        @OneToOne
        val usuario: Usuario = Usuario()) : Entidad<Long>
