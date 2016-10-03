package Modelo.DTO.Comidas;

public class platoDTO {
	
	private int idPlato;
	private String nombre;
	private Double precio;
	private String tipo;

	public platoDTO(int idPlato, String nombre, Double precio, String tipo){
		
		this.idPlato = idPlato;
		this.nombre = nombre;
		this.precio = precio;
		this.setTipo(tipo);
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

}
