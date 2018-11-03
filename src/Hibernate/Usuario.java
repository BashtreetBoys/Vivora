package Hibernate;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private String username;
	private String contrase�a;
	
	public Usuario(String username, String contrase�a) {
		this.username = username;
		this.contrase�a = contrase�a;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
		
}
