package com.federico.d.bernst.model

import org.hibernate.annotations.Table
import javax.persistence.*

@Entity
//@Table(schema = "public")
@Table(appliesTo = "empresa")
data class Empresa (
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) val id: Long,
        val nombre: String, val usuario: Usuario)