package Modelo.Clases.Comidas;

import java.math.BigDecimal;
import java.util.List;

public abstract class Plato {
	
	private String Descripcion;
	private List<Ingredientes> Ingredientes;
	private BigDecimal Precio;
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public List<Ingredientes> getIngredientes() {
		return Ingredientes;
	}
	public void setIngredientes(List<Ingredientes> ingredientes) {
		Ingredientes = ingredientes;
	}
	public BigDecimal getPrecio() {
		return Precio;
	}
	public void setPrecio(BigDecimal precio) {
		Precio = precio;
	}

}
