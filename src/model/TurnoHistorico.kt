package com.federico.d.bernst.model

import com.federico.d.bernst.provider.generic.Entidad
import java.util.*
import javax.persistence.*

@Entity
@Table
data class TurnoHistorico(
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) override val id: Long = -1,
        @ManyToOne
        val sala: Sala = Sala(),
        @ManyToOne
        val empresa: Empresa = Empresa(),

        val numero: Int = 0,
        val tiempoEsperado: Long = 0,
        val tiempoAlAnterior: Long = 0,

        val motivoPartida: String?,
        val opinion: String?,
        val puntuacion: Double?,

        val turnoFisico: Boolean = false,
        val turnoRemoto: Boolean = false,

        /** En caso de que se haya tardado muy poco o demasiado por una razón extraña      */
        val motivoExcepcion: String?,
        val tiempoAlSuiguiente: Long = 0,

        @Temporal(TemporalType.TIMESTAMP) val momentoCreacion: Calendar = Calendar.getInstance(),
        @Temporal(TemporalType.TIMESTAMP) val momentoAtencion: Calendar = Calendar.getInstance()
) : Entidad<Long>