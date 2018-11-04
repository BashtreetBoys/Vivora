package Hibernate;

import java.io.Serializable;

public class ContactoDao implements Serializable {
	
	private String username;
	private String contraseña;
	
	public ContactoDao() {
		
	}
	
	public ContactoDao(String username, String contraseña) {
		this.username = username;
		this.contraseña = contraseña;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
		
}
