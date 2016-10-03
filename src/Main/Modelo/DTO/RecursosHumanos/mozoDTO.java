package Modelo.DTO.RecursosHumanos;

public class mozoDTO {
	
	private int idMozo;
	private String nombre;
	
	public mozoDTO(int idMozo, String nombre){
		this.setIdMozo(idMozo);
		this.setNombre(nombre);
	}

	public int getIdMozo() {
		return idMozo;
	}

	public void setIdMozo(int idMozo) {
		this.idMozo = idMozo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
