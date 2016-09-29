package Modelo.DTO.Bebidas;

import java.math.BigDecimal;

public abstract class Bebida {

	private String nombre;
	private BigDecimal precio;
	
	public Bebida(String nombre, BigDecimal precio){
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}
