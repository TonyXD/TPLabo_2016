package Modelo.DTO.General;

import java.sql.Date;
import java.util.ArrayList;

import Modelo.DTO.Bebidas.bebidaDTO;
import Modelo.DTO.Comidas.menuDTO;
import Modelo.DTO.Comidas.platoDTO;
import Modelo.DTO.RecursosHumanos.mozoDTO;

public class pedidoDTO {

	private int idPedido;
	private ArrayList<platoDTO> platos;
	private ArrayList<bebidaDTO> bebidas;
	private ArrayList<menuDTO> menus;
	private ArrayList<mozoDTO> mozo;
	private ArrayList<mesaDTO> mesa;
	private estadoDTO estado;
	private Date fecha;

	public pedidoDTO(int idPedido, ArrayList<platoDTO> platos, ArrayList<bebidaDTO> bebidas, ArrayList<menuDTO> menus,
			ArrayList<mozoDTO> mozo, ArrayList<mesaDTO> mesa, estadoDTO estado, Date fecha) {

		this.setIdPedido(idPedido);
		this.setPlatos(platos);
		this.setBebidas(bebidas);
		this.setMenus(menus);
		this.setMozo(mozo);
		this.setMesa(mesa);
		this.setEstado(estado);
		this.setFecha(fecha);
	}

	public ArrayList<mozoDTO> getMozo() {
		return mozo;
	}

	public void setMozo(ArrayList<mozoDTO> mozo) {
		this.mozo = mozo;
	}

	public ArrayList<mesaDTO> getMesa() {
		return mesa;
	}

	public void setMesa(ArrayList<mesaDTO> mesa) {
		this.mesa = mesa;
	}

	public estadoDTO getEstado() {
		return estado;
	}

	public void setEstado(estadoDTO estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public ArrayList<platoDTO> getPlatos() {
		return platos;
	}

	public void setPlatos(ArrayList<platoDTO> platos) {
		this.platos = platos;
	}

	public ArrayList<bebidaDTO> getBebidas() {
		return bebidas;
	}

	public void setBebidas(ArrayList<bebidaDTO> bebidas) {
		this.bebidas = bebidas;
	}

	public ArrayList<menuDTO> getMenus() {
		return menus;
	}

	public void setMenus(ArrayList<menuDTO> menus) {
		this.menus = menus;
	}
}
