package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import Vistas.Vistas_AM.Alta_Menu;

public class Alta_Menu_Controller implements ActionListener {

	private Alta_Menu vistaMenus;

	private List<entradaDTO> entrada;
	private List<principalDTO> principal;
	private List<postreDTO> postre;
	private List<conAlcoholDTO> conAlcohol;
	private List<sinAlcoholDTO> sinAlcohol;
	private List<cafeDTO> cafe;
	private List<Bebida> bebidas;

	private Integer cantidadSeleccionada;

	private Carta carta;

	public Alta_Menu_Controller(Alta_Menu vistaMenus, Carta carta) {
		this.vistaMenus = vistaMenus;
		this.carta = carta;
		this.cantidadSeleccionada = 4;

		this.vistaMenus.getBtnAgregarAlMenu().addActionListener(this);
		this.vistaMenus.getBtnQuitarDelMenu().addActionListener(this);
		this.vistaMenus.getBtnCrearMenu().addActionListener(this);
		this.vistaMenus.getBtnCancelarMenu().addActionListener(this);
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

			int tabComidas = this.vistaMenus.getTbdPaneComidas().getSelectedIndex();
			int tabBebida = this.vistaMenus.getTbdPaneComidas().getSelectedIndex();
			int indice = 0;

			if (tabComidas >= 0) {

				if (tabComidas == 0) {

					int filaSelect = this.vistaMenus.getTblEntrada().getSelectedRow();

					if (filaSelect >= 0) {

						for (int i = 0; i < this.cantidadSeleccionada; i++) {
							String filaNombre = (String) this.vistaMenus.getTblMenu().getValueAt(i, 0);
							if (filaNombre.equals("Principales:")) {
								indice = i;
								// this.sumarTotal(this.entrada.get(filaSelect).getPrecio(),
								// cantidad);
							}
						}

						Object[] fila = { this.entrada.get(filaSelect).getNombre(),
								this.entrada.get(filaSelect).getPrecio().toString() };
						this.vistaMenus.getModelMenu().insertRow(indice, fila);

						cantidadSeleccionada = cantidadSeleccionada + 1;
					}

				} else if (tabComidas == 1) {

					int filaSelect = this.vistaMenus.getTblPrincipal().getSelectedRow();

					if (filaSelect >= 0) {

						for (int i = 0; i < this.cantidadSeleccionada; i++) {
							if (this.vistaMenus.getTblMenu().getValueAt(i, 0).equals("Postres:")) {
								indice = i;
								// this.sumarTotal(this.principal.get(filaSelect).getPrecio(),
								// cantidad);
							}
						}

						Object[] fila = { this.principal.get(filaSelect).getNombre(),
								this.entrada.get(filaSelect).getPrecio().toString() };
						this.vistaMenus.getModelMenu().insertRow(indice, fila);

						cantidadSeleccionada = cantidadSeleccionada + 1;

					}

				} else if (tabComidas == 2) {

					int filaSelect = this.vistaMenus.getTblPostre().getSelectedRow();

					if (filaSelect >= 0) {

						for (int i = 0; i < this.cantidadSeleccionada; i++) {
							if (this.vistaMenus.getTblMenu().getValueAt(i, 0).equals("Bebidas:")) {
								indice = i;
								// this.sumarTotal(this.postre.get(filaSelect).getPrecio(),
								// cantidad);
							}
						}

						Object[] fila = { this.postre.get(filaSelect).getNombre(),
								this.entrada.get(filaSelect).getPrecio().toString() };
						this.vistaMenus.getModelMenu().insertRow(indice, fila);

						cantidadSeleccionada = cantidadSeleccionada + 1;
					}

				}
			}

			if (tabBebida >= 0) {

				int filaSelect = this.vistaMenus.getTblBebida().getSelectedRow();

				if (filaSelect >= 0) {

					Object[] fila = { this.bebidas.get(filaSelect).getNombre(),
							this.bebidas.get(filaSelect).getPrecio().toString() };
					this.vistaMenus.getModelMenu().addRow(fila);

					cantidadSeleccionada = cantidadSeleccionada + 1;
				}
			}
		} else if (e.getSource() == this.vistaMenus.getBtnQuitarDelMenu()) {

			int filaSelect = this.vistaMenus.getTblMenu().getSelectedRow();

			if (filaSelect >= 0) {

				String filaNombre = (String) this.vistaMenus.getTblMenu().getValueAt(filaSelect, 0);
				
				if (filaNombre != "Entradas:" & filaNombre != "Principales:" & filaNombre != "Postres:"
						& filaNombre != "Bebidas:") {
					this.vistaMenus.getModelMenu().removeRow(filaSelect);
				}else{
					JOptionPane.showMessageDialog(vistaMenus, "No puede borrar los encabezados de menu.");
				}

			} else {

				JOptionPane.showMessageDialog(vistaMenus, "No selecciono ninguna fila del menu.");
			}

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