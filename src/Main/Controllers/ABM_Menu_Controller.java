package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.DTO.Bebidas.Bebida;
import Modelo.DTO.Bebidas.cafeDTO;
import Modelo.DTO.Bebidas.conAlcoholDTO;
import Modelo.DTO.Bebidas.sinAlcoholDTO;
import Modelo.DTO.Comidas.entradaDTO;
import Modelo.DTO.Comidas.postreDTO;
import Modelo.DTO.Comidas.principalDTO;
import Modelo.Negocio.Carta;
import Vistas.Vistas_AM.ABM_Menu;
import Vistas.Vistas_AM.ABM_Plato;

public class ABM_Menu_Controller implements ActionListener {

	private ABM_Menu vistaMenus;

	private List<entradaDTO> entrada;
	private List<principalDTO> principal;
	private List<postreDTO> postre;
	private List<conAlcoholDTO> conAlcohol;
	private List<sinAlcoholDTO> sinAlcohol;
	private List<cafeDTO> cafe;
	private List<Bebida> bebidas;

	private Carta carta;

	public ABM_Menu_Controller(ABM_Menu vistaMenus, Carta carta) {
		this.vistaMenus = vistaMenus;
		this.carta = carta;

		this.vistaMenus.getBtnAgregarAlMenu().addActionListener(this);
		this.vistaMenus.getBtnQuitarDelMenu().addActionListener(this);
	}

	public void inicializar() {

		this.setEntrada(carta.obtenerEntradas());
		this.setPrincipal(carta.obtenerPrincipales());
		this.setPostre(carta.obtenerPostres());
		this.setConAlcohol(carta.obtenerConAlcoholes());
		this.setSinAlcohol(carta.obtenerSinAlcoholes());
		this.setCafe(carta.obtenerCafes());
		this.bebidas = new ArrayList<Bebida>();
		this.cargarTablas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vistaMenus.getBtnAgregarAlMenu()) {

			// this.agregarPlato();

		}
	}

	public void cargarTablas() {

		Object[] filaE = { "Entradas:" };
		this.vistaMenus.getModelMenu().addRow(filaE);
		Object[] filaP = { "Principales:" };
		this.vistaMenus.getModelMenu().addRow(filaP);
		Object[] filaPo = { "Postres:" };
		this.vistaMenus.getModelMenu().addRow(filaPo);
		Object[] filaB = { "Bebidas:" };
		this.vistaMenus.getModelMenu().addRow(filaB);
		Object[] filaM = { "Menus:" };
		this.vistaMenus.getModelMenu().addRow(filaM);

		for (int i = 0; i < this.entrada.size(); i++) {
			Object[] fila = { this.entrada.get(i).getNombre(), this.entrada.get(i).getPrecio().toString() };
			this.vistaMenus.getModelEntrada().addRow(fila);
		}

		for (int i = 0; i < this.principal.size(); i++) {
			Object[] fila = { this.principal.get(i).getNombre(), this.principal.get(i).getPrecio().toString() };
			this.vistaMenus.getModelPrincipal().addRow(fila);
		}

		for (int i = 0; i < this.postre.size(); i++) {
			Object[] fila = { this.postre.get(i).getNombre(), this.postre.get(i).getPrecio().toString() };
			this.vistaMenus.getModelPostre().addRow(fila);
		}

		this.cargarBebida();

		for (int i = 0; i < this.bebidas.size(); i++) {
			Object[] fila = { this.bebidas.get(i).getNombre(), this.bebidas.get(i).getPrecio().toString() };
			this.vistaMenus.getModelBebida().addRow(fila);
		}
	}
	
	public void cargarBebida() {
		for (int i = 0; i < this.conAlcohol.size(); i++) {
			this.bebidas.add(this.conAlcohol.get(i));
		}
		for (int i = 0; i < this.sinAlcohol.size(); i++) {
			this.bebidas.add(this.sinAlcohol.get(i));
		}
		for (int i = 0; i < this.cafe.size(); i++) {
			this.bebidas.add(this.cafe.get(i));
		}
	}
	
	public List<entradaDTO> getEntrada() {
		return entrada;
	}

	public void setEntrada(List<entradaDTO> entrada) {
		this.entrada = entrada;
	}

	public List<principalDTO> getPrincipal() {
		return principal;
	}

	public void setPrincipal(List<principalDTO> principal) {
		this.principal = principal;
	}

	public List<postreDTO> getPostre() {
		return postre;
	}

	public void setPostre(List<postreDTO> postre) {
		this.postre = postre;
	}

	public List<conAlcoholDTO> getConAlcohol() {
		return conAlcohol;
	}

	public void setConAlcohol(List<conAlcoholDTO> conAlcohol) {
		this.conAlcohol = conAlcohol;
	}

	public List<sinAlcoholDTO> getSinAlcohol() {
		return sinAlcohol;
	}

	public void setSinAlcohol(List<sinAlcoholDTO> sinAlcohol) {
		this.sinAlcohol = sinAlcohol;
	}

	public List<cafeDTO> getCafe() {
		return cafe;
	}

	public void setCafe(List<cafeDTO> cafe) {
		this.cafe = cafe;
	}

}