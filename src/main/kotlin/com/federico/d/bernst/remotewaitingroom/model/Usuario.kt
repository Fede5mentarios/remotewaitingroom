package com.federico.d.bernst.remotewaitingroom.model

import javax.persistence.*

@Entity
@Table
data class Usuario(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) override val id: Long = -1,
        val userName: String = "sin nombre",
        val password: String = "sin pass",
        val descipcion: String = "Sin Descripcion",
        @ManyToOne val rol: Rol = Rol(),
        val permisos: Array<Permiso> = emptyArray()) : Entidad<Long> {

    override fun equals(other: Any?) = this === other || (javaClass == other?.javaClass && id == (other as Usuario).id)
    override fun hashCode() = id.hashCode()
}

@Entity
data class Rol(@Id val nombre: String = Rol.DEFAULT, val orden: Int = 2, val asignable: Boolean = true) {
    companion object {
        val DEFAULT = "DEFAULT"
        val ADMIN = "ADMIN"
        val CLIENT = "CLIENTE"
        val OWNER = "OWNER"
        val EMPLOYEE = "EMPLEADO"
    }
}
