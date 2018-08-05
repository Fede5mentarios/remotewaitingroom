package com.federico.d.bernst.remotewaitingroom.model

import java.util.*
import javax.persistence.*

@Entity
@Table
data class Usuario(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) override val id: Long = -1,
        val userName: String = "sin nombre",
        val password: String = "sin pass",
        val descipcion: String = "Sin Descripcion",
        @ManyToOne val rol: Rol = Rol(),
        @OneToOne(mappedBy = "usuario") val preguntaRecupero: PreguntaRecupero? = null,
        @OneToMany(mappedBy = "usuario") val permisos: Array<Permiso> = emptyArray()) : Entidad<Long> {

    override fun equals(other: Any?) = this === other || (javaClass == other?.javaClass && id == (other as Usuario).id)
    override fun hashCode() = id.hashCode()

    fun nuevoPermisoEmpresa(empresa: Empresa) = copy(
            permisos = permisos.plus(Permiso(tipoAcceso = TipoAcceso.EMPRESA, codEntidad = empresa.id)))

    fun nuevoPermisoSala(sala: Sala) = copy(
            permisos = permisos.plus(Permiso(tipoAcceso = TipoAcceso.EMPRESA, codEntidad = sala.id)))
}

@Entity
data class Rol(@Id val nombre: String = Rol.DEFAULT,
               val orden: Int = 2,
               val asignable: Boolean = true) {

    companion object {
        val DEFAULT = "DEFAULT"
        val ADMIN = "ADMIN"
        val CLIENT = "CLIENTE"
        val OWNER = "OWNER"
        val EMPLOYEE = "EMPLEADO"
    }
}

@Entity
data class PreguntaRecupero(@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) val id: Long = -1,
                            @OneToOne val usuario: Usuario = Usuario(),
                            val pregunta: String = "",
                            val respuesta: String = "",
                            @Temporal(TemporalType.TIMESTAMP) val fechaModificacion: Calendar = Calendar.getInstance(),
                            @Temporal(TemporalType.TIMESTAMP) val fechaCreacion: Calendar = Calendar.getInstance(),
                            val deleted: Boolean = false)