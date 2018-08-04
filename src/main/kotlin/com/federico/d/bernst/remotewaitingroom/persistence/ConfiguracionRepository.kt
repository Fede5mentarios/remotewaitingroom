package com.federico.d.bernst.remotewaitingroom.persistence

import com.federico.d.bernst.remotewaitingroom.model.Configuracion
import com.federico.d.bernst.remotewaitingroom.model.PKConfig
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "configuracion", path = "configuracion")
interface ConfiguracionRepository : JpaRepository<Configuracion, PKConfig> {

}