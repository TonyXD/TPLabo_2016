package Modelo.DTO.General;

import Modelo.DTO.RecursosHumanos.mozoDTO;

public class mesaDTO {
	
	private int idMesa;
	private int capacidad;
	private mozoDTO mozo;
	private estadoDTO estado;
	
	public mesaDTO(int idMesa, int capacidad, mozoDTO mozo , estadoDTO estado){
		this.idMesa = idMesa;
		this.capacidad = capacidad;
		this.mozo = mozo;
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

	public mozoDTO getMozo() {
		return mozo;
	}

	public void setMozo(mozoDTO mozo) {
		this.mozo = mozo;
	}
}
