package provider

import com.federico.d.bernst.model.Usuario
import com.federico.d.bernst.provider.UsuarioDAO
import com.federico.d.bernst.provider.generic.GenericHibernateDAO
import java.util.*
import javax.persistence.EntityManager

class UsuarioDAOImpl(em: EntityManager) : GenericHibernateDAO<Usuario, Long>(em, Usuario::class.java), UsuarioDAO {

    override fun findByUsernameAndPassword(username: String, pass: String) = Optional.ofNullable(em.createQuery(
            "from Usuario u where u.userName = \'$username\' and u.password = \'$pass\'", Usuario::class.java).singleResult)

    override fun findByUsername(username: String) = Optional.ofNullable(em.createQuery(
            "from Usuario u where u.userName = \"$username\"", Usuario::class.java).singleResult)

}