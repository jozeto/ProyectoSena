package com.example.demo.modelo;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "compras")
public class compras {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	  @NotBlank
	private int id;
	 
	  @NotBlank
	  @Size(min=4,max=5)
	private String producto;
	  
	  @NotBlank
	  @Size(min=4,max=5)
	private String precio;
	 
	  @NotBlank
	  @Size(min=4,max=5)
	private String cantidad;
	
	public compras() {
		
		
}
	public compras(int id, String producto, String precio, String cantidad) {
		super();
		this.id = id;
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


}