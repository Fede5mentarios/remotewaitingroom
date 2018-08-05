package com.federico.d.bernst.remotewaitingroom.service

import com.federico.d.bernst.remotewaitingroom.exception.RequestError
import com.federico.d.bernst.remotewaitingroom.model.*
import com.federico.d.bernst.remotewaitingroom.persistence.EmpresaRepository
import com.federico.d.bernst.remotewaitingroom.persistence.RolRepository
import com.federico.d.bernst.remotewaitingroom.persistence.UsuarioRepository
import com.federico.d.bernst.remotewaitingroom.security.encode
import com.federico.d.bernst.remotewaitingroom.service.received.AltaEmpresaReceived
import com.federico.d.bernst.remotewaitingroom.service.received.OwnerReceived
import com.federico.d.bernst.remotewaitingroom.service.response.AltaEmpresaResponse
import com.federico.d.bernst.remotewaitingroom.service.response.AltaUsuarioResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class AltaService(@Autowired val usuarioRepository: UsuarioRepository,
                  @Autowired val empresaRepository: EmpresaRepository,
                  @Autowired val rolRepository: RolRepository) {

    fun altaUsuarioOwner(ownerReceived: OwnerReceived): AltaUsuarioResponse {
        if (usuarioRepository.findByUnique(ownerReceived.username).isPresent)
            return AltaUsuarioResponse(Optional.empty(), RequestError(descripcion = "El nombre de usuario ya existe"))

        return Optional.of(Usuario(userName = ownerReceived.username,
                password = encode(ownerReceived.password), descipcion = ownerReceived.descripcion))
                .map { usuarioRepository.save(it) }
                .map { agregarPreguntaRecupero(it, ownerReceived) }
                .map { usuarioRepository.save(it) }
                .map { toAltaUsuarioResponse(it) }
                .get()
    }

    fun altaEmpresa(empresaReceived: AltaEmpresaReceived): AltaEmpresaResponse {
        if (empresaRepository.findByUnique(empresaReceived.descripcion).isPresent)
            return AltaEmpresaResponse(Optional.empty(), RequestError(descripcion = "El nombre de la empresa elegido ya existe"))

        return usuarioRepository.findByUnique(empresaReceived.usernameOwner)
                .map { crearEmpresa(empresaReceived, it) }
                .map { empresaRepository.save(it) }
                .map { agregarDatosExtra(it, empresaReceived) }
                .map { empresaRepository.save(it) }
                .map { darPermisosAlOwner(it) }
                .map { toAltaEmpresaResponse(it) }
                .get()
    }

    private fun darPermisosAlOwner(empresa: Empresa): Empresa {
        val user = empresa.owner
        usuarioRepository.save(user.nuevoPermisoEmpresa(empresa))
        return empresa
    }

    private fun agregarDatosExtra(empresa: Empresa, empresaReceived: AltaEmpresaReceived) = empresa.copy(
            datosExtra = empresaReceived.datosExtras
                    .entries.stream()
                    .map {
                        DatoExtra(empresa = empresa,
                                nombreDato = it.key,
                                valor = it.value)
                    }
                    .collect(Collectors.toList())
                    .toTypedArray())

    private fun crearEmpresa(empresaReceived: AltaEmpresaReceived, usuario: Usuario) = Empresa(
            nombreCompleto = empresaReceived.descripcion,
            nombreFantasia = empresaReceived.nombreFantasia,
            owner = usuario)


    private fun toAltaEmpresaResponse(empresaGuardada: Empresa): AltaEmpresaResponse {
        return AltaEmpresaResponse(Optional.of(empresaGuardada))
    }

    private fun agregarPreguntaRecupero(usuario: Usuario, ownerReceived: OwnerReceived) = usuario.copy(
            preguntaRecupero = PreguntaRecupero(usuario = usuario,
                    pregunta = ownerReceived.preguntaDeRecupero,
                    respuesta = ownerReceived.respuestaRecupero),
            rol = rolRepository.findById(Rol.OWNER).orElse(Rol(Rol.OWNER, 2, false)))

    private fun toAltaUsuarioResponse(usuario: Usuario): AltaUsuarioResponse {
        return AltaUsuarioResponse(Optional.of(usuario))
    }
}