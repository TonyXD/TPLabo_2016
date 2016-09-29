package Modelo.Negocio;

import java.util.List;

import Modelo.DTO.Bebidas.cafeDTO;
import Modelo.DTO.Bebidas.conAlcoholDTO;
import Modelo.DTO.Bebidas.sinAlcoholDTO;
import Modelo.DTO.Comidas.entradaDTO;
import Modelo.DTO.Comidas.postreDTO;
import Modelo.DTO.Comidas.principalDTO;
import Persistencia.DAO.Bebida.cafeDAO;
import Persistencia.DAO.Bebida.conAlcoholDAO;
import Persistencia.DAO.Bebida.sinAlcoholDAO;
import Persistencia.DAO.Comida.entradaDAO;
import Persistencia.DAO.Comida.postreDAO;
import Persistencia.DAO.Comida.principalDAO;

public class Carta {
	private entradaDAO entrada;
	private principalDAO principal;
	private postreDAO postre;
	private conAlcoholDAO conAlcohol;
	private sinAlcoholDAO sinAlcohol;
	private cafeDAO cafe;

	public Carta() {

		this.entrada = new entradaDAO();
		this.principal = new principalDAO();
		this.postre = new postreDAO();
		this.conAlcohol = new conAlcoholDAO();
		this.sinAlcohol = new sinAlcoholDAO();
		this.cafe = new cafeDAO();
	}

	public void agregarEntrada(entradaDTO x) {
		this.entrada.insert(x);
	}

	public void agregarPrincipal(principalDTO x) {
		this.principal.insert(x);
	}

	public void agregarPostre(postreDTO x) {
		this.postre.insert(x);
	}

	public void agregarConAlcohol(conAlcoholDTO x) {
		this.conAlcohol.insert(x);
	}

	public void agregarSinAlcohol(sinAlcoholDTO x) {
		this.sinAlcohol.insert(x);
	}

	public void agregarCafe(cafeDTO x) {
		this.cafe.insert(x);
	}

	public void borrarEntrada(entradaDTO x) {
		this.entrada.delete(x);
	}

	public void borrarPrincipal(principalDTO x) {
		this.principal.delete(x);
	}

	public void borrarPostre(postreDTO x) {
		this.postre.delete(x);
	}

	public void borrarConAlcohol(conAlcoholDTO x) {
		this.conAlcohol.delete(x);
	}

	public void borrarSinAlcohol(sinAlcoholDTO x) {
		this.sinAlcohol.delete(x);
	}

	public void borrarCafe(cafeDTO x) {
		this.cafe.delete(x);
	}

	public List<entradaDTO> obtenerEntradas() {
		return this.entrada.readAll();
	}

	public List<principalDTO> obtenerPrincipales() {
		return this.principal.readAll();
	}

	public List<postreDTO> obtenerPostres() {
		return this.postre.readAll();
	}

	public List<conAlcoholDTO> obtenerConAlcoholes() {
		return this.conAlcohol.readAll();
	}

	public List<sinAlcoholDTO> obtenerSinAlcoholes() {
		return this.sinAlcohol.readAll();
	}

	public List<cafeDTO> obtenerCafes() {
		return this.cafe.readAll();
	}
}
