package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String usuario;
	private String correo;
	private String contrasena;
	private int rool;
	
	public Login() {
		
	}

	public Login(int id, String usuario, String correo, String contrasena, int rool) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.correo = correo;
		this.contrasena = contrasena;
		this.rool = rool;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getRool() {
		return rool;
	}

	public void setRool(int rool) {
		this.rool = rool;
	}

	

	

}
