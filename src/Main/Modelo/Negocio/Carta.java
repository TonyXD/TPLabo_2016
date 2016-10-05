package Modelo.Negocio;

import java.util.List;

import Modelo.DTO.Bebidas.bebidaDTO;
import Modelo.DTO.Comidas.menuDTO;
import Modelo.DTO.Comidas.platoDTO;
import Persistencia.DAO.Bebida.bebidaDAO;
import Persistencia.DAO.Comida.menuDAO;
import Persistencia.DAO.Comida.platoDAO;

public class Carta {
	
	private platoDAO plato;
	private bebidaDAO bebida;
	
	private menuDAO menu;

	public Carta() {
		
		this.plato = new platoDAO();
		this.bebida = new bebidaDAO();
		this.menu = new menuDAO();
	}	
	
	public menuDAO getMenu() {
		return menu;
	}

	public void setMenu(menuDAO menu) {
		this.menu = menu;
	}
	
	public void agregarBebida(bebidaDTO x) {
		this.bebida.insert(x);
	}
	
	public void borrarBebida(bebidaDTO x) {
		this.bebida.delete(x);
	}
	
	public List<bebidaDTO> obtenerBebidas() {
		return this.bebida.readAll();
	}
	
	public void editarBebida(bebidaDTO x) {
		this.bebida.update(x);
	}
	
	public void agregarPlato(platoDTO x) {
		this.plato.insert(x);
	}
	
	public void borrarPlato(platoDTO x) {
		this.plato.delete(x);
	}
	
	public List<platoDTO> obtenerPlatos() {
		return this.plato.readAll();
	}
	
	public void editarPlato(platoDTO x) {
		this.plato.update(x);
	}
	
	public void agregarMenu(menuDTO x) {
		this.menu.insert(x);
	}
	
	public void borrarMenu(menuDTO x) {
		this.menu.delete(x);
	}
	
	public List<menuDTO> obtenermenus() {
		return this.menu.readAll();
	}
	
	public void editarMenu(menuDTO x) {
		this.menu.update(x);
	}
}
