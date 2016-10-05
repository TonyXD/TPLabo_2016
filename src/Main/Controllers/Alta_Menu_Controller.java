package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.DTO.Bebidas.bebidaDTO;
import Modelo.DTO.Comidas.menuDTO;
import Modelo.DTO.Comidas.platoDTO;
import Modelo.Negocio.Carta;
import Vistas.Vistas_AM.Alta_Menu;

public class Alta_Menu_Controller implements ActionListener {

	private Alta_Menu vistaMenus;

	private List<platoDTO> platos;
	private List<bebidaDTO> bebidas;

	private ArrayList<platoDTO> platosSe;
	private ArrayList<bebidaDTO> bebidasSe;

	private Integer cantidadSeleccionada;

	private Carta carta;

	public Alta_Menu_Controller(Alta_Menu vistaMenus, Carta carta) {
		this.vistaMenus = vistaMenus;
		this.carta = carta;
		this.cantidadSeleccionada = 6;

		this.vistaMenus.getBtnAgregarAlMenu().addActionListener(this);
		this.vistaMenus.getBtnQuitarDelMenu().addActionListener(this);
		this.vistaMenus.getBtnCrearMenu().addActionListener(this);
		this.vistaMenus.getBtnCancelarMenu().addActionListener(this);
	}

	public void inicializar() {

		this.platos = carta.obtenerPlatos();
		this.bebidas = carta.obtenerBebidas();

		this.platosSe = new ArrayList<platoDTO>();
		this.bebidasSe = new ArrayList<bebidaDTO>();

		this.cargarTablas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vistaMenus.getBtnAgregarAlMenu()) {

			int tabSelect = this.vistaMenus.getTbdPaneComidas().getSelectedIndex();
			int posicion = 0;
			int indice = 0;

			if (tabSelect >= 0) {

				if (tabSelect == 0) {

					int filaSelect = this.vistaMenus.getTblEntrada().getSelectedRow();

					if (filaSelect >= 0) {

						for (int i = 0; i < this.cantidadSeleccionada; i++) {
							String filaNombre = (String) this.vistaMenus.getTblMenu().getValueAt(i, 0);
							if (filaNombre.equals("Principales:")) {
								indice = i;
							}
						}

						for (int i = 0; i < this.platos.size(); i++) {

							if (this.platos.get(i).getTipo().equals("Entrada")) {

								if (posicion == filaSelect) {

									Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio(), };
									this.vistaMenus.getModelMenu().insertRow(indice, fila);
									this.platosSe.add(this.platos.get(i));
									cantidadSeleccionada = cantidadSeleccionada + 1;
								}
								posicion = posicion + 1;
							}
						}
					}

				} else if (tabSelect == 1) {

					int filaSelect = this.vistaMenus.getTblPrincipal().getSelectedRow();

					if (filaSelect >= 0) {

						for (int i = 0; i < this.cantidadSeleccionada; i++) {
							if (this.vistaMenus.getTblMenu().getValueAt(i, 0).equals("Postres:")) {
								indice = i;
							}
						}

						for (int i = 0; i < this.platos.size(); i++) {

							if (this.platos.get(i).getTipo().equals("Principal")) {

								if (posicion == filaSelect) {

									Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio(), };
									this.vistaMenus.getModelMenu().insertRow(indice, fila);
									this.platosSe.add(this.platos.get(i));
									cantidadSeleccionada = cantidadSeleccionada + 1;
								}
								posicion = posicion + 1;
							}
						}

					}

				} else if (tabSelect == 2) {

					int filaSelect = this.vistaMenus.getTblPostre().getSelectedRow();

					if (filaSelect >= 0) {

						for (int i = 0; i < this.cantidadSeleccionada; i++) {
							if (this.vistaMenus.getTblMenu().getValueAt(i, 0).equals("Sin Alcohol:")) {
								indice = i;
							}
						}

						for (int i = 0; i < this.platos.size(); i++) {

							if (this.platos.get(i).getTipo().equals("Postre")) {

								if (posicion == filaSelect) {

									Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio(), };
									this.vistaMenus.getModelMenu().insertRow(indice, fila);
									this.platosSe.add(this.platos.get(i));
									cantidadSeleccionada = cantidadSeleccionada + 1;
								}
								posicion = posicion + 1;
							}
						}
					}

				}

				else if (tabSelect == 3) {

					int filaSelect = this.vistaMenus.getTblSinAlcohol().getSelectedRow();

					if (filaSelect >= 0) {

						for (int i = 0; i < this.cantidadSeleccionada; i++) {
							if (this.vistaMenus.getTblMenu().getValueAt(i, 0).equals("Con Alcohol:")) {
								indice = i;
							}
						}

						for (int i = 0; i < this.bebidas.size(); i++) {

							if (this.bebidas.get(i).getTipo().equals("Sin Alcohol")) {

								if (posicion == filaSelect) {

									Object[] fila = { this.bebidas.get(i).getNombre(),
											this.bebidas.get(i).getPrecio(), };
									this.vistaMenus.getModelMenu().insertRow(indice, fila);
									this.bebidasSe.add(this.bebidas.get(i));
									cantidadSeleccionada = cantidadSeleccionada + 1;
								}
								posicion = posicion + 1;
							}
						}
					}
				} else if (tabSelect == 4) {

					int filaSelect = this.vistaMenus.getTblBebida().getSelectedRow();

					if (filaSelect >= 0) {

						for (int i = 0; i < this.cantidadSeleccionada; i++) {
							if (this.vistaMenus.getTblMenu().getValueAt(i, 0).equals("Cafeteria:")) {
								indice = i;
							}
						}

						for (int i = 0; i < this.bebidas.size(); i++) {

							if (this.bebidas.get(i).getTipo().equals("Con Alcohol")) {

								if (posicion == filaSelect) {

									Object[] fila = { this.bebidas.get(i).getNombre(),
											this.bebidas.get(i).getPrecio(), };
									this.vistaMenus.getModelMenu().insertRow(indice, fila);
									this.bebidasSe.add(this.bebidas.get(i));
									cantidadSeleccionada = cantidadSeleccionada + 1;
								}
								posicion = posicion + 1;
							}
						}
					}
				} else if (tabSelect == 5) {

					int filaSelect = this.vistaMenus.getTblCafe().getSelectedRow();

					if (filaSelect >= 0) {

						for (int i = 0; i < this.bebidas.size(); i++) {

							if (this.bebidas.get(i).getTipo().equals("Cafeteria")) {

								if (posicion == filaSelect) {

									Object[] fila = { this.bebidas.get(i).getNombre(),
											this.bebidas.get(i).getPrecio(), };
									this.vistaMenus.getModelMenu().addRow(fila);
									this.bebidasSe.add(this.bebidas.get(i));
									cantidadSeleccionada = cantidadSeleccionada + 1;
								}
								posicion = posicion + 1;
							}
						}
					}
				}
			} else if (e.getSource() == this.vistaMenus.getBtnQuitarDelMenu())

			{

				int filaSelect = this.vistaMenus.getTblMenu().getSelectedRow();

				if (filaSelect >= 0) {

					String filaNombre = (String) this.vistaMenus.getTblMenu().getValueAt(filaSelect, 0);

					if (filaNombre != "Entradas:" & filaNombre != "Principales:" & filaNombre != "Postres:"
							& filaNombre != "Con Alcohol:" & filaNombre != "Sin Alcohol:"
							& filaNombre != "Cafeteria:") {
						this.vistaMenus.getModelMenu().removeRow(filaSelect);
						cantidadSeleccionada = cantidadSeleccionada - 1;
					} else {
						JOptionPane.showMessageDialog(vistaMenus, "No puede borrar los encabezados de menu.");
					}

				} else {

					JOptionPane.showMessageDialog(vistaMenus, "No selecciono ninguna fila del menu.");
				}

			} else if (e.getSource() == this.vistaMenus.getBtnCrearMenu())

			{

				String nombreMenu = this.vistaMenus.getTxfNombre().getText();
				Double precio = Double.valueOf(this.vistaMenus.getTxfPrecio().getText());

				menuDTO menu = new menuDTO(0, nombreMenu, precio, platos, bebidas);

				this.carta.agregarMenu(menu);

				this.vistaMenus.dispose();

			} else if (e.getSource() == this.vistaMenus.getBtnCancelarMenu()) {

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

		Object[] filaSa = { "Sin Alcohol:" };
		this.vistaMenus.getModelMenu().addRow(filaSa);

		Object[] filaCa = { "Con Alcohol:" };
		this.vistaMenus.getModelMenu().addRow(filaCa);

		Object[] filaFe = { "Cafeteria:" };
		this.vistaMenus.getModelMenu().addRow(filaFe);

		for (int i = 0; i < this.platos.size(); i++) {

			if (this.platos.get(i).getTipo().equals("Entrada")) {

				Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio().toString() };
				this.vistaMenus.getModelEntrada().addRow(fila);

			} else if (this.platos.get(i).getTipo().equals("Principal")) {

				Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio().toString() };
				this.vistaMenus.getModelPrincipal().addRow(fila);

			} else if (this.platos.get(i).getTipo().equals("Postre")) {

				Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio().toString() };
				this.vistaMenus.getModelPostre().addRow(fila);

			}

		}

		for (int i = 0; i < this.bebidas.size(); i++) {

			if (this.bebidas.get(i).getTipo().equals("Sin Alcohol")) {

				Object[] fila = { this.bebidas.get(i).getNombre(), this.bebidas.get(i).getPrecio() };
				this.vistaMenus.getModelSinAlcohol().addRow(fila);

			} else if (this.bebidas.get(i).getTipo().equals("Con Alcohol")) {

				Object[] fila = { this.bebidas.get(i).getNombre(), this.bebidas.get(i).getPrecio() };
				this.vistaMenus.getModelBebida().addRow(fila);

			} else if (this.bebidas.get(i).getTipo().equals("Cafeteria")) {

				Object[] fila = { this.bebidas.get(i).getNombre(), this.bebidas.get(i).getPrecio() };
				this.vistaMenus.getModelCafe().addRow(fila);
			}
		}

	}

	public List<platoDTO> getPlatos() {
		return platos;
	}

	public void setPlatos(ArrayList<platoDTO> platos) {
		this.platos = platos;
	}

	public ArrayList<platoDTO> getPlatosSe() {
		return platosSe;
	}

	public void setPlatosSe(ArrayList<platoDTO> platosSe) {
		this.platosSe = platosSe;
	}

	public ArrayList<bebidaDTO> getBebidasSe() {
		return bebidasSe;
	}

	public void setBebidasSe(ArrayList<bebidaDTO> bebidasSe) {
		this.bebidasSe = bebidasSe;
	}
}