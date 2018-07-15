package provider

import com.federico.d.bernst.model.Empresa
import com.federico.d.bernst.provider.EmpresaDAO
import com.federico.d.bernst.provider.generic.GenericHibernateDAO
import org.hibernate.Session
import org.hibernate.SessionFactory

class EmpresaDAOImpl(sessionFactory: SessionFactory) : GenericHibernateDAO<Empresa, Long>(sessionFactory, Empresa::class.java), EmpresaDAO