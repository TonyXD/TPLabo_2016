package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.sun.javafx.font.Disposer;

import Modelo.DTO.Bebidas.Bebida;
import Modelo.DTO.Bebidas.cafeDTO;
import Modelo.DTO.Bebidas.conAlcoholDTO;
import Modelo.DTO.Bebidas.sinAlcoholDTO;
import Modelo.DTO.Comidas.entradaDTO;
import Modelo.DTO.Comidas.menuDTO;
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
	
	private ArrayList<entradaDTO> entradaSe;
	private ArrayList<principalDTO> principalSe;
	private ArrayList<postreDTO> postreSe;
	private ArrayList<conAlcoholDTO> conAlcoholSe;
	private ArrayList<sinAlcoholDTO> sinAlcoholSe;
	private ArrayList<cafeDTO> cafeSe;
	
	private ArrayList<Bebida> bebidas;

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
		
		this.entradaSe = new ArrayList<entradaDTO>();
		this.principalSe = new ArrayList<principalDTO>();
		this.postreSe = new ArrayList<postreDTO>();
		this.setConAlcoholSe(new ArrayList<conAlcoholDTO>());
		this.setSinAlcoholSe(new ArrayList<sinAlcoholDTO>());
		this.setCafeSe(new ArrayList<cafeDTO>());
		
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
						
						this.entradaSe.add(this.entrada.get(filaSelect));

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
						
						this.principalSe.add(this.principal.get(filaSelect));
						
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
						
						this.postreSe.add(this.postre.get(filaSelect));
						
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
					
//					this.bebidas.add(this.)

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
					cantidadSeleccionada = cantidadSeleccionada -1;
				}else{
					JOptionPane.showMessageDialog(vistaMenus, "No puede borrar los encabezados de menu.");
				}

			} else {

				JOptionPane.showMessageDialog(vistaMenus, "No selecciono ninguna fila del menu.");
			}

		}else if (e.getSource() == this.vistaMenus.getBtnCrearMenu()) {
			
			String nombreMenu = this.vistaMenus.getTxfNombre().getText();
			BigDecimal precio = new BigDecimal(this.vistaMenus.getTxfPrecio().getText().replaceAll(",", ""));
			
			menuDTO menu = new menuDTO(0,nombreMenu, precio, entradaSe, principalSe, postreSe, bebidas);
			
			this.carta.agregarMenu(menu);
			
			this.vistaMenus.dispose();
			
		}else if (e.getSource() == this.vistaMenus.getBtnCancelarMenu()) {
			
			
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
	
	public ArrayList<entradaDTO> getEntradaSe() {
		return entradaSe;
	}

	public void setEntradaSe(ArrayList<entradaDTO> entradaSe) {
		this.entradaSe = entradaSe;
	}
	
	public ArrayList<principalDTO> getPrincipalSe() {
		return principalSe;
	}

	public void setPrincipalSe(ArrayList<principalDTO> principalSe) {
		this.principalSe = principalSe;
	}
	
	public ArrayList<postreDTO> getPostreSe() {
		return postreSe;
	}

	public void setPostreSe(ArrayList<postreDTO> postreSe) {
		this.postreSe = postreSe;
	}
	
	public ArrayList<conAlcoholDTO> getConAlcoholSe() {
		return conAlcoholSe;
	}

	public void setConAlcoholSe(ArrayList<conAlcoholDTO> conAlcoholSe) {
		this.conAlcoholSe = conAlcoholSe;
	}

	public ArrayList<sinAlcoholDTO> getSinAlcoholSe() {
		return sinAlcoholSe;
	}

	public void setSinAlcoholSe(ArrayList<sinAlcoholDTO> sinAlcoholSe) {
		this.sinAlcoholSe = sinAlcoholSe;
	}

	public ArrayList<cafeDTO> getCafeSe() {
		return cafeSe;
	}

	public void setCafeSe(ArrayList<cafeDTO> cafeSe) {
		this.cafeSe = cafeSe;
	}
}