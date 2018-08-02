package provider

import com.federico.d.bernst.model.Empresa
import com.federico.d.bernst.model.Usuario
import com.federico.d.bernst.provider.EmpresaDAO
import com.federico.d.bernst.provider.generic.GenericHibernateDAO
import java.util.*
import javax.persistence.EntityManager

class EmpresaDAOImpl(em: EntityManager) : GenericHibernateDAO<Empresa, Long>(em, Empresa::class.java), EmpresaDAO {

    override fun findByUsuario(usuario: Usuario) = Optional.ofNullable(em.createQuery(
            "from empresa where usuario = $usuario", Empresa::class.java).singleResult)
}