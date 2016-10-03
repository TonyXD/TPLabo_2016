package Modelo.DTO.General;

public class mesaDTO {
	
	private int idMesa;
	private int numero;
	private int capacidad;
	private int piso;
	private String sector;
	private estadoDTO estado;
	
	public mesaDTO(int idMesa, int numero, int capacidad, int piso, String sector, estadoDTO estado){
		this.idMesa = idMesa;
		this.numero = numero;
		this.capacidad = capacidad;
		this.piso = piso;
		this.sector = sector;
		this.estado = estado;
	}
	
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public estadoDTO getEstado() {
		return estado;
	}
	public void setEstado(estadoDTO estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}
}
