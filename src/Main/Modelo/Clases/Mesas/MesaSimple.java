package Modelo.Clases.Mesas;

import Modelo.Interfaces.AccionesMesa;

public class MesaSimple implements AccionesMesa {

	private int capacidad;
	
	public MesaSimple(int capacidad) {
		this.capacidad = capacidad;
	}
	
	@Override public int getCapacidad() {
		return this.capacidad;
	}
	
}
