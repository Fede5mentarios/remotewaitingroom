package com.federico.d.bernst.remotewaitingroom.service.response

data class PartesEmpresaResponse(val estadisticas: List<EstadisticaOverviewResponse>,
                                 val salas: List<SalaOverviewResponse>,
                                 val puedeCrearSala: Boolean,
                                 val usuarios: List<UsuarioOverviewResponse>,
                                 val puedeCrearUsuario: Boolean)

data class SalaOverviewResponse(val id: Long, val descripcion: String,
                                val corriendo: Boolean, val activa: Boolean,
                                val puedeEntrar: Boolean,
                                val datosAMostrar: List<DatosAMostrarResponse>)

data class UsuarioOverviewResponse(val id: Long, val descripcion: String,
                                   val corriendo: Boolean, val activa: Boolean,
                                   val puedeEntrar: Boolean,
                                   val datosAMostrar: List<DatosAMostrarResponse>)

data class DatosAMostrarResponse(val descripcion: String, val valor: String)

class EstadisticaOverviewResponse
