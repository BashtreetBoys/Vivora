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

public class HibernateApp {

	
	Configuration cfg;
	SessionFactory factory;
	Session session;
	@SuppressWarnings("checked")

	public HibernateApp() {
		 cfg = new Configuration().configure();
		//cfg.configure("./src/hibernate.cfg.xml");
		ServiceRegistry sR = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		factory = cfg.buildSessionFactory(sR);
		session = factory.openSession();
		
	}
	
	public boolean registrarUsuario(Usuario nuevo) {
		
		Transaction tx = session.beginTransaction();
		System.out.println("Hola");

		try {
			session.save(nuevo);
			tx.commit();
		}
		catch (HibernateException e) {
			System.out.println("Problemas agregando al nuevo usuario");
			return false;
		}
		return true;
	}
	
	public boolean consultarUsuario(Usuario user) {
		Query q;
		Usuario u = null;
		try {
		 
			q = session.createQuery("Select u from usuario u where u.username = " + user.getUsername()+ " and u.contraseña = " + user.getContraseña());
			u = (Usuario) q.getSingleResult();
		}
		catch(HibernateException e){
			System.out.println("Error buscando el usuario");
		}
		
		if(!u.equals(null)) {
			return true;
		}
		return false;
	}
	
	
}
