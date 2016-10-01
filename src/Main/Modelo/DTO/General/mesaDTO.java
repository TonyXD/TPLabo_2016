package Modelo.DTO.General;

public class mesaDTO {
	
	private int idMesa;
	private int capacidad;
	private estadoDTO estado;
	
	public mesaDTO(int idMesa, int capacidad, estadoDTO estado){
		this.idMesa = idMesa;
		this.capacidad = capacidad;
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
}
