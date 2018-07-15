package com.federico.d.bernst.model

import javax.persistence.*

@Entity
@Table(schema = "public")
data class Usuario (
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) val id: Long,
        val userName: String, val password: String,
        @OneToOne val empresa: Empresa )