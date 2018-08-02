package com.federico.d.bernst.model

import com.federico.d.bernst.provider.generic.Entidad
import org.hibernate.validator.constraints.UniqueElements
import java.util.*
import javax.persistence.*

@Entity
@Table
data class Empresa(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) override val id: Long = -1,
        @UniqueElements val nombre: String = "sin nombre",
        @OneToMany(mappedBy = "empresa") @OrderColumn var datosExtra: Array<DatoExtra> = emptyArray(),
        @OneToOne val owner: Usuario = Usuario(),
        @Temporal(TemporalType.TIMESTAMP) val fechaModificacion: Calendar = Calendar.getInstance(),
        @Temporal(TemporalType.TIMESTAMP) val fechaCreacion: Calendar = Calendar.getInstance(),
        override val tipoEntidad: TipoEntidad = TipoEntidad.EMPRESA,
        @Transient override val padre: Entidad<Long>? = null) : Configurable() {

    override fun equals(other: Any?) = this === other || (javaClass == other?.javaClass && id == (other as Usuario).id)
    override fun hashCode() = id.hashCode()
}