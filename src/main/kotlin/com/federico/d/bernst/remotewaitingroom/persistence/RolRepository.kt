package com.federico.d.bernst.remotewaitingroom.persistence

import com.federico.d.bernst.remotewaitingroom.model.Empresa
import com.federico.d.bernst.remotewaitingroom.model.Rol
import com.federico.d.bernst.remotewaitingroom.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(collectionResourceRel = "Rol", path = "Rol")
interface RolRepository : JpaRepository<Rol, String> {

}