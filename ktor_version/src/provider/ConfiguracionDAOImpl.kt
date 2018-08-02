package provider

import com.federico.d.bernst.model.Configuracion
import com.federico.d.bernst.model.PKConfig
import com.federico.d.bernst.provider.ConfiguracionDAO
import com.federico.d.bernst.provider.generic.GenericHibernateDAO
import javax.persistence.EntityManager

class ConfiguracionDAOImpl(em: EntityManager) : GenericHibernateDAO<Configuracion, PKConfig>(em, Configuracion::class.java), ConfiguracionDAO
