package com.federico.d.bernst.remotewaitingroom.persistence

import com.federico.d.bernst.remotewaitingroom.model.Empresa
import com.federico.d.bernst.remotewaitingroom.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(collectionResourceRel = "Empresa", path = "Empresa")
interface EmpresaRepository : JpaRepository<Empresa, Long> {

    @Query(value = "FROM Empresa WHERE owner.username = :username")
    fun findByUniqueOwner(@Param("username") username: String): Optional<Empresa>

    @Query(value = "FROM Empresa WHERE nombreCompleto = :descripcion")
    fun findByUnique(@Param("descripcion") descripcion: String): Optional<Empresa>
}