package Modelo.Negocio;

import java.util.List;

import Modelo.DTO.General.mesaDTO;
import Persistencia.DAO.General.mesaDAO;

public class Restorant {
	
	private mesaDAO mesa;
	
	public Restorant(){
		this.setMesa(new mesaDAO());
	}
	
	
	public void agregarMesa(mesaDTO x) {
		this.mesa.insert(x);
	}
	
	public void borrarMesa(mesaDTO x) {
		this.mesa.delete(x);
	}
	
	public List<mesaDTO> obtenerMesas() {
		return this.mesa.readAll();
	}
	
	public void editarMesa(mesaDTO x) {
		this.mesa.update(x);
	}

	public mesaDAO getMesa() {
		return mesa;
	}

	public void setMesa(mesaDAO mesa) {
		this.mesa = mesa;
	}
	
}
