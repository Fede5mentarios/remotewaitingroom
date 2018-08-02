package com.federico.d.bernst.model

import com.federico.d.bernst.provider.generic.Entidad
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table
data class Turno(
        @EmbeddedId override val id: PKTurno = PKTurno(),
        @OneToOne val anterior: Turno?,
        @OneToOne val siguiente: Turno?,
        val antendido: Boolean,
        val tiempoEsperaInicial: Long = 0,
//        val owner: String,    TODO    Acá va el dato de la sesión del cliente, todavia no se modelarlo. Debería ser único, tengo que lograr que haya la menor cantidad de posibilidades de que se pierda, y que si se pierde, el sistema siga funcionando
        /** Cancelado por el recepcionista, puede ser por razones varias*/
        val cancelado: Boolean,
        @Temporal(TemporalType.TIMESTAMP) val fechaModificacion: Calendar = Calendar.getInstance(),
        @Temporal(TemporalType.TIMESTAMP) val fechaCreacion: Calendar = Calendar.getInstance()) : Entidad<PKTurno>

@Embeddable
data class PKTurno(@ManyToOne val empresa: Sala = Sala(),
                   val numero: Int = 0) : Serializable