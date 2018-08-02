package com.federico.d.bernst.remotewaitingroom.persistence

import com.federico.d.bernst.remotewaitingroom.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(collectionResourceRel = "usuario", path = "usuario")
interface UsuarioRepository : JpaRepository<Usuario, Long> {

    @Query(value = "from Usuario where username = :username")
    fun findByUnique(@Param("username") username: String): Optional<Usuario>
}