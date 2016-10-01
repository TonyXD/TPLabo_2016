package Modelo.DTO.General;

import java.sql.Date;
import java.util.ArrayList;

import Modelo.DTO.Bebidas.cafeDTO;
import Modelo.DTO.Bebidas.conAlcoholDTO;
import Modelo.DTO.Bebidas.sinAlcoholDTO;
import Modelo.DTO.Comidas.entradaDTO;
import Modelo.DTO.Comidas.postreDTO;
import Modelo.DTO.Comidas.principalDTO;
import Modelo.DTO.RecursosHumanos.mozoDTO;

public class pedidoDTO {

	private int idPedido;
	private ArrayList<entradaDTO> entrada;
	private ArrayList<principalDTO> principal;
	private ArrayList<postreDTO> postre;
	private ArrayList<conAlcoholDTO> conAlcohol;
	private ArrayList<sinAlcoholDTO> sinAlcohol;
	private ArrayList<cafeDTO> cafe;
	private ArrayList<mozoDTO> mozo;
	private ArrayList<mesaDTO> mesa;
	private estadoDTO estado;
	private Date fecha;

	public pedidoDTO(int idPedido, ArrayList<entradaDTO> entrada, ArrayList<principalDTO> principal,
			ArrayList<postreDTO> postre, ArrayList<conAlcoholDTO> conAlcohol, ArrayList<sinAlcoholDTO> sinAlcohol,
			ArrayList<cafeDTO> cafe, ArrayList<mozoDTO> mozo, ArrayList<mesaDTO> mesa, estadoDTO estado, Date fecha) {

		this.setIdPedido(idPedido);
		this.setEntrada(entrada);
		this.setPrincipal(principal);
		this.setPostre(postre);
		this.setConAlcohol(conAlcohol);
		this.setSinAlcohol(sinAlcohol);
		this.setCafe(cafe);
		this.setMozo(mozo);
		this.setMesa(mesa);
		this.setEstado(estado);
		this.setFecha(fecha);
	}

	public ArrayList<principalDTO> getPrincipal() {
		return principal;
	}

	public void setPrincipal(ArrayList<principalDTO> principal) {
		this.principal = principal;
	}

	public ArrayList<postreDTO> getPostre() {
		return postre;
	}

	public void setPostre(ArrayList<postreDTO> postre) {
		this.postre = postre;
	}

	public ArrayList<conAlcoholDTO> getConAlcohol() {
		return conAlcohol;
	}

	public void setConAlcohol(ArrayList<conAlcoholDTO> conAlcohol) {
		this.conAlcohol = conAlcohol;
	}

	public ArrayList<sinAlcoholDTO> getSinAlcohol() {
		return sinAlcohol;
	}

	public void setSinAlcohol(ArrayList<sinAlcoholDTO> sinAlcohol) {
		this.sinAlcohol = sinAlcohol;
	}

	public ArrayList<cafeDTO> getCafe() {
		return cafe;
	}

	public void setCafe(ArrayList<cafeDTO> cafe) {
		this.cafe = cafe;
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

	public ArrayList<entradaDTO> getEntrada() {
		return entrada;
	}

	public void setEntrada(ArrayList<entradaDTO> entrada) {
		this.entrada = entrada;
	}
}
