package Hibernate;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.schema.internal.ExceptionHandlerLoggedImpl;

public class HibernateApp {

	
	Configuration cfg;
	SessionFactory factory;
	Session session;
	Transaction tx;
	//@SuppressWarnings("checked")

	public HibernateApp() {
		 cfg = new Configuration().configure();
		//cfg.configure("./src/hibernate.cfg.xml");
		ServiceRegistry sR = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		factory = cfg.buildSessionFactory(sR);
		session = factory.openSession();
		
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException
	{
	    tx.rollback();
	    throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
	}
	
	public boolean registrarUsuario(ContactoDao nuevo) throws Exception {
		
		tx = session.beginTransaction();
		System.out.println("registrarUsuario llamado");
		try {
			session.save(nuevo);
			tx.commit();
		}
		catch (HibernateException e) {
			System.err.println("Problemas agregando al nuevo usuario");
			manejaExcepcion(e);
			return false;
		}
		finally
		{
			session.close();
		}
		return true;
	}
	
	public boolean consultarUsuario(ContactoDao user) {
		Query q;
		ContactoDao u = null;
		try {
		 
			q = session.createQuery("Select u from usuario u where u.username = " + user.getUsername()+ " and u.contraseña = " + user.getContraseña());
			u = (ContactoDao) q.getSingleResult();
		}
		catch(HibernateException e){
			System.out.println("Error buscando el usuario");
			manejaExcepcion(e);
		}
		
		if(!u.equals(null)) {
			return true;
		}
		return false;
	}
	
	
}
