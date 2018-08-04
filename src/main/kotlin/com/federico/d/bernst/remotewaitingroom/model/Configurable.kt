package com.federico.d.bernst.remotewaitingroom.model

import com.federico.d.bernst.remotewaitingroom.persistence.ConfiguracionRepository
import com.google.gson.Gson
import java.sql.Time
import java.util.*

abstract class Configurable : Entidad<Long> {

    abstract val tipoEntidad: TipoEntidad
    abstract val padre: Entidad<Long>?

    protected fun configuracionDe(key: String, dao: ConfiguracionRepository): Optional<Configuracion> {
        return dao.findById(PKConfig(tipoEntidad, id, key))
                .flatMap {
                    if (it == null && tipoEntidad.next != null) {
                        return@flatMap dao.findById(PKConfig(tipoEntidad.next!!, padre!!.id, key))
                    } else {
                        return@flatMap Optional.ofNullable(it)
                    }
                }
    }

    public fun getEntregaTurnosInicio(dao: ConfiguracionRepository): Optional<Time> {
        return configuracionDe("TiempoPromedioEspera", dao)
                .map {
                    if (it != null) {
                        return@map Gson().fromJson(it.valorGson, Time::class.java)
                    } else {
                        return@map null
                    }
                }
    }

    public fun getEntregaTurnosFin(dao: ConfiguracionRepository): Optional<Time> {
        return configuracionDe("EntregaTurnosInicio", dao)
                .map {
                    if (it != null) {
                        return@map Gson().fromJson(it.valorGson, Time::class.java)
                    } else {
                        return@map null
                    }
                }
    }

    public fun getDiasAtencion(dao: ConfiguracionRepository): Optional<Array<Int>> {
        return configuracionDe("DiasAtencion", dao)
                .map {
                    if (it != null) {
                        return@map Gson().fromJson(it.valorGson, Array<Int>::class.java)
                    } else {
                        return@map null
                    }
                }
    }

    public fun getHoraDeLimpiezaTurnos(dao: ConfiguracionRepository): Optional<Time> {
        return configuracionDe("HoraDeLimpiezaTurnos", dao)
                .map {
                    if (it != null) {
                        return@map Gson().fromJson(it.valorGson, Time::class.java)
                    } else {
                        return@map null
                    }
                }
    }

    public fun getDiasLimpiezaTurnos(dao: ConfiguracionRepository): Optional<Array<Int>> {
        return configuracionDe("DiasLimpiezaTurnos", dao)
                .map {
                    if (it != null) {
                        return@map Gson().fromJson(it.valorGson, Array<Int>::class.java)
                    } else {
                        return@map null
                    }
                }
    }

    public fun getTurnosEntregables(dao: ConfiguracionRepository): Optional<Int> {
        return configuracionDe("TurnosEntregables", dao)
                .map {
                    if (it != null) {
                        return@map Gson().fromJson(it.valorGson, Int::class.java)
                    } else {
                        return@map null
                    }
                }
    }

    public fun getTurnosEnAntencion(dao: ConfiguracionRepository): Int {
        return configuracionDe("TurnosEnAntencion", dao)
                .map {
                    if (it != null) {
                        return@map Gson().fromJson(it.valorGson, Int::class.java)
                    } else {
                        return@map 1
                    }
                }.orElseGet { 1 }
    }

}