package Modelo.DTO.Comidas;

import java.util.ArrayList;
import java.util.List;

import Modelo.DTO.Bebidas.bebidaDTO;

public class menuDTO {
	
	
	private int idMenu;
	private String nombre;
	private Double precio;

	private List<platoDTO> platos;
	private List<bebidaDTO> bebidas;

	public menuDTO(int idMenu, String nombre, Double precio, List<platoDTO> platos, List<bebidaDTO> bebidas) {
		
		this.idMenu = idMenu;
		this.nombre = nombre;
		this.precio = precio;
		this.platos = platos;
		this.bebidas = bebidas;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<bebidaDTO> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<bebidaDTO> bebidas) {
		this.bebidas = bebidas;
	}

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public List<platoDTO> getPlatos() {
		return platos;
	}

	public void setPlatos(List<platoDTO> platos) {
		this.platos = platos;
	}
}
