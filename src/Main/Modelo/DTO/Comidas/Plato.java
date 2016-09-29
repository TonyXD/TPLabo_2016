package Modelo.DTO.Comidas;

import java.math.BigDecimal;

public abstract class Plato {

	private String nombre;
	private BigDecimal precio;

	public Plato(String nombre, BigDecimal precio){
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
