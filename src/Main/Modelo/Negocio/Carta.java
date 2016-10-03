package Modelo.Negocio;

import java.util.List;

import Modelo.DTO.Bebidas.bebidaDTO;
import Modelo.DTO.Comidas.menuDTO;
import Modelo.DTO.Comidas.platoDTO;
import Persistencia.DAO.Bebida.bebidaDAO;
import Persistencia.DAO.Comida.menuDAO;
import Persistencia.DAO.Comida.platoDAO;

public class Carta {
	
//	private entradaDAO entrada;
//	private principalDAO principal;
//	private postreDAO postre;
//	private conAlcoholDAO conAlcohol;
//	private sinAlcoholDAO sinAlcohol;
//	private cafeDAO cafe;
	
	private platoDAO plato;
	private bebidaDAO bebida;
	
	private menuDAO menu;

	public Carta() {

//		this.entrada = new entradaDAO();
//		this.principal = new principalDAO();
//		this.postre = new postreDAO();
//		this.conAlcohol = new conAlcoholDAO();
//		this.sinAlcohol = new sinAlcoholDAO();
//		this.cafe = new cafeDAO();
		
		this.plato = new platoDAO();
		this.bebida = new bebidaDAO();
		this.menu = new menuDAO();
	}

//	public void agregarEntrada(entradaDTO x) {
//		this.entrada.insert(x);
//	}
//
//	public void agregarPrincipal(principalDTO x) {
//		this.principal.insert(x);
//	}
//
//	public void agregarPostre(postreDTO x) {
//		this.postre.insert(x);
//	}
//
//	public void agregarConAlcohol(conAlcoholDTO x) {
//		this.conAlcohol.insert(x);
//	}
//
//	public void agregarSinAlcohol(sinAlcoholDTO x) {
//		this.sinAlcohol.insert(x);
//	}
//
//	public void agregarCafe(cafeDTO x) {
//		this.cafe.insert(x);
//	}
//
//	public void borrarEntrada(entradaDTO x) {
//		this.entrada.delete(x);
//	}
//
//	public void borrarPrincipal(principalDTO x) {
//		this.principal.delete(x);
//	}
//
//	public void borrarPostre(postreDTO x) {
//		this.postre.delete(x);
//	}
//
//	public void borrarConAlcohol(conAlcoholDTO x) {
//		this.conAlcohol.delete(x);
//	}
//
//	public void borrarSinAlcohol(sinAlcoholDTO x) {
//		this.sinAlcohol.delete(x);
//	}
//
//	public void borrarCafe(cafeDTO x) {
//		this.cafe.delete(x);
//	}
//
//	public List<entradaDTO> obtenerEntradas() {
//		return this.entrada.readAll();
//	}
//
//	public List<principalDTO> obtenerPrincipales() {
//		return this.principal.readAll();
//	}
//
//	public List<postreDTO> obtenerPostres() {
//		return this.postre.readAll();
//	}
//
//	public List<conAlcoholDTO> obtenerConAlcoholes() {
//		return this.conAlcohol.readAll();
//	}
//
//	public List<sinAlcoholDTO> obtenerSinAlcoholes() {
//		return this.sinAlcohol.readAll();
//	}
//
//	public List<cafeDTO> obtenerCafes() {
//		return this.cafe.readAll();
//	}
//	
//	public void editarEntrada(entradaDTO x) {
//		this.entrada.update(x);
//	}
//	
//	public void editarPrincipal(principalDTO x) {
//		this.principal.update(x);
//	}
//	
//	public void editarPostre(postreDTO x) {
//		this.postre.update(x);
//	}
//	
//	public void editarConAlcohol(conAlcoholDTO x) {
//		this.conAlcohol.update(x);
//	}
//	
//	public void editarSinAlcohol(sinAlcoholDTO x) {
//		this.sinAlcohol.update(x);
//	}
//	
//	public void editarCafe(cafeDTO x) {
//		this.cafe.update(x);
//	}
	
	
	
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
