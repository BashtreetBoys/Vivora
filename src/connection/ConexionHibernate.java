package connection;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import daos.Usuario;

public class ConexionHibernate {

	SessionFactory mFctory;
	Session session;
	
	public ConexionHibernate() {
		try{
			 mFctory = new Configuration().configure().buildSessionFactory();
			session= mFctory.openSession();
			}catch (Throwable ex) { 
			 System.err.println("No se pudo inicializar la session factory. " + ex);
			 throw new ExceptionInInitializerError(ex); 
			}
	}
	
	public void insertar() {
		Usuario nuevo = new Usuario();
		nuevo.setUsername("ddddd");
		nuevo.setPassword("taloko");
		Transaction tx = session.beginTransaction();
		try {

		session.saveOrUpdate(nuevo);
		tx.commit();
		}
		catch(Exception e) {
			tx.rollback();
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public void seleccionar() {
		Query q = session.createQuery("Select u from Usuario u");
		List<Usuario> nuevo = q.getResultList();
		for(Usuario u: nuevo) {
			System.out.println(u);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	/**
	 * 
	 * @param usuario: le pasan el username que inserto en el login
	 * @param pass le pasan la pass que inserto en el login
	 * @return true si existe el usuario con esa pass y se puede loggear, false si no
	 */
	public boolean verSiExiste(String usuario, String pass) {
		Query q = session.createQuery("Select u from Usuario u Where u.username = '" + usuario +"' and u.password = '" + pass+"'");
		Usuario nue = (Usuario) q.getSingleResult();
		if(nue.getUsername().equals(usuario) && nue.getPassword().equals(pass)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param user le pasan el nombre de usuario a registrar
	 * @param pass le pasan la pass a registrar
	 * @return true si ingreso con exito, false si no
	 */
	public boolean registrarUsuario(String user, String pass) {
		Usuario nuevo = new Usuario();
		nuevo.setUsername(user);
		nuevo.setPassword(pass);
		try {
			Transaction tx = session.beginTransaction();
			session.save(nuevo);
			tx.commit();
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	
	
	
	
}
