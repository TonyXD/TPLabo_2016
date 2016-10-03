package Modelo.DTO.Bebidas;

public class bebidaDTO {

	private int idBebida;
	private String nombre;
	private Double precio;
	private String tipo;

	public bebidaDTO(int idBebida, String nombre, Double precio, String tipo) {
	
		this.idBebida = idBebida;
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

	public int getIdBebida() {
		return idBebida;
	}

	public void setIdBebida(int idBebida) {
		this.idBebida = idBebida;
	}

}
