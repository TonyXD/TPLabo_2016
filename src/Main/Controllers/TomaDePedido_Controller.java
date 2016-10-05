package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.DTO.Bebidas.bebidaDTO;
import Modelo.DTO.Comidas.menuDTO;
import Modelo.DTO.Comidas.platoDTO;
import Modelo.DTO.General.estadoDTO;
import Modelo.DTO.General.mesaDTO;
import Modelo.DTO.General.pedidoDTO;
import Modelo.DTO.RecursosHumanos.mozoDTO;
import Modelo.Negocio.Carta;
import Modelo.Negocio.Pedido;
import Vistas.Encargado.TomaDePedido;

public class TomaDePedido_Controller implements ActionListener {

	private TomaDePedido vistaPedido;

	private List<bebidaDTO> bebidas;
	private List<platoDTO> platos;
	private List<menuDTO> menus;
	private ArrayList<menuDTO> menusSe;
	private ArrayList<platoDTO> platosSe;
	private ArrayList<bebidaDTO> bebidasSe;

	private Pedido pedido;
	private Carta carta;

	private int cantidadSeleccionada;
	private Double total;

	public TomaDePedido_Controller(TomaDePedido vistaPedido, Pedido pedido, Carta carta) {
		this.setVistaPedido(vistaPedido);
		this.setPedido(pedido);
		this.carta = carta;
		this.cantidadSeleccionada = 7;
		this.total = 0.0;
		this.vistaPedido.getBtnAgregar().addActionListener(this);
		this.vistaPedido.getBtnQuitarDelPedido().addActionListener(this);
		this.vistaPedido.getBtnCrearPedido().addActionListener(this);
		this.vistaPedido.getBtnCancelarPedido().addActionListener(this);

		this.inicializar();
	}

	public void inicializar() {

		this.platos = carta.obtenerPlatos();
		this.bebidas = carta.obtenerBebidas();
		this.menus = carta.obtenermenus();
		this.platosSe = new ArrayList<platoDTO>();
		this.bebidasSe = new ArrayList<bebidaDTO>();
		this.menusSe = new ArrayList<menuDTO>();
		this.cargarTablas();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vistaPedido.getBtnAgregar()) {

			int tabSelect = this.vistaPedido.getTabbedPane().getSelectedIndex();
			int indice = 0;
			String observaciones = this.vistaPedido.getTxtObservaciones().getText();
			Integer cantidad = (Integer) this.vistaPedido.getSpnCantidad().getValue();
			int posicion = 0;

			if (tabSelect >= 0) {

				if (tabSelect == 0) {

					int filaSelect = this.vistaPedido.getTblEntrada().getSelectedRow();

					if (filaSelect >= 0) {

						indice = this.buscarIndice("Principales:");

						for (int i = 0; i < this.platos.size(); i++) {

							if (this.platos.get(i).getTipo().equals("Entrada")) {

								if (posicion == filaSelect) {

									Object[] fila = { this.platos.get(i).getNombre(), observaciones, cantidad };
									this.vistaPedido.getModelSelect().insertRow(indice, fila);
									this.platosSe.add(this.platos.get(i));
									cantidadSeleccionada = cantidadSeleccionada + 1;
								}
								posicion = posicion + 1;
							}
						}
					}

				} else if (tabSelect == 1) {

					int filaSelect = this.vistaPedido.getTblPrincipal().getSelectedRow();

					if (filaSelect >= 0) {

						indice = this.buscarIndice("Postres:");

						for (int i = 0; i < this.platos.size(); i++) {

							if (this.platos.get(i).getTipo().equals("Principal")) {

								if (posicion == filaSelect) {

									Object[] fila = { this.platos.get(i).getNombre(), observaciones, cantidad };
									this.vistaPedido.getModelSelect().insertRow(indice, fila);
									this.platosSe.add(this.platos.get(i));
									cantidadSeleccionada = cantidadSeleccionada + 1;
								}
								posicion = posicion + 1;
							}
						}
					}

				} else if (tabSelect == 2) {

					int filaSelect = this.vistaPedido.getTblPostres().getSelectedRow();

					if (filaSelect >= 0) {

						indice = this.buscarIndice("Con Alcohol:");

						for (int i = 0; i < this.platos.size(); i++) {

							if (this.platos.get(i).getTipo().equals("Postre")) {

								if (posicion == filaSelect) {

									Object[] fila = { this.platos.get(i).getNombre(), observaciones, cantidad };
									this.vistaPedido.getModelSelect().insertRow(indice, fila);
									this.platosSe.add(this.platos.get(i));
									cantidadSeleccionada = cantidadSeleccionada + 1;
								}
								posicion = posicion + 1;
							}
						}
					}

				} else if (tabSelect == 3) {

					int filaSelect = this.vistaPedido.getTblBebidas().getSelectedRow();

					if (filaSelect >= 0) {

						indice = this.buscarIndice("Sin Alcohol:");

						for (int i = 0; i < this.bebidas.size(); i++) {

							if (this.bebidas.get(i).getTipo().equals("Con Alcohol")) {

								if (posicion == filaSelect) {

									Object[] fila = { this.platos.get(i).getNombre(), observaciones, cantidad };
									this.vistaPedido.getModelSelect().insertRow(indice, fila);
									this.bebidasSe.add(this.bebidas.get(i));
									cantidadSeleccionada = cantidadSeleccionada + 1;
								}
								posicion = posicion + 1;
							}
						}
					}

				} else if (tabSelect == 4) {

					int filaSelect = this.vistaPedido.getTblSinAlcohol().getSelectedRow();

					if (filaSelect >= 0) {

						indice = this.buscarIndice("Cafeteria:");

						for (int i = 0; i < this.bebidas.size(); i++) {

							if (this.bebidas.get(i).getTipo().equals("Sin Alcohol")) {

								if (posicion == filaSelect) {

									Object[] fila = { this.bebidas.get(i).getNombre(), observaciones, cantidad };
									this.vistaPedido.getModelSelect().insertRow(indice, fila);
									this.bebidasSe.add(this.bebidas.get(i));
									cantidadSeleccionada = cantidadSeleccionada + 1;
								}
								posicion = posicion + 1;
							}
						}
					}
				} else if (tabSelect == 5) {

					int filaSelect = this.vistaPedido.getTblCafe().getSelectedRow();

					if (filaSelect >= 0) {

						indice = this.buscarIndice("Menus:");

						for (int i = 0; i < this.bebidas.size(); i++) {

							if (this.bebidas.get(i).getTipo().equals("Cafeteria")) {

								if (posicion == filaSelect) {

									Object[] fila = { this.bebidas.get(i).getNombre(), observaciones, cantidad };
									this.vistaPedido.getModelSelect().insertRow(indice, fila);
									this.bebidasSe.add(this.bebidas.get(i));
									cantidadSeleccionada = cantidadSeleccionada + 1;
								}
								posicion = posicion + 1;
							}
						}
					}
				} else {

					int filaSelect = this.vistaPedido.getTblMenu().getSelectedRow();

					if (filaSelect >= 0) {

						Object[] fila = { this.menus.get(filaSelect).getNombre(), observaciones, cantidad };
						this.vistaPedido.getModelSelect().addRow(fila);
						this.menusSe.add(this.menus.get(filaSelect));
						cantidadSeleccionada = cantidadSeleccionada + 1;
					}
				}
			}
		}
		if (e.getSource() == this.vistaPedido.getBtnQuitarDelPedido()) {

			int filaSelect = this.vistaPedido.getTblPedidoSelect().getSelectedRow();

			if (filaSelect >= 0) {

				String filaNombre = (String) this.vistaPedido.getTblPedidoSelect().getValueAt(filaSelect, 0);

				if (filaNombre != "Entradas:" & filaNombre != "Principales:" & filaNombre != "Postres:"
						& filaNombre != "Con Alcohol:" & filaNombre != "Sin Alcohol:" & filaNombre != "Cafeteria:"
						& filaNombre != "Menus:") {
					this.vistaPedido.getModelSelect().removeRow(filaSelect);
					cantidadSeleccionada = cantidadSeleccionada - 1;
				} else {
					JOptionPane.showMessageDialog(vistaPedido, "No puede borrar los encabezados de menu.");
				}

			} else {

				JOptionPane.showMessageDialog(vistaPedido, "No selecciono ninguna fila del menu.");
			}
		} else if (e.getSource() == this.vistaPedido.getBtnCrearPedido()) {

			ArrayList<mozoDTO> mozo = new ArrayList<mozoDTO>();
			ArrayList<mesaDTO> mesa = new ArrayList<mesaDTO>();
			estadoDTO estado = new estadoDTO(6, "Nuevo", false, false, true);

			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());

			pedidoDTO pedido = new pedidoDTO(0, platosSe, bebidasSe, menusSe, mozo, mesa, estado, sqlDate);

			this.pedido.agregarPedido(pedido);

		}

	}

	public void cargarTablas() {

		Object[] filaE = { "Entradas:" };
		this.vistaPedido.getModelSelect().addRow(filaE);

		Object[] filaP = { "Principales:" };
		this.vistaPedido.getModelSelect().addRow(filaP);

		Object[] filaPo = { "Postres:" };
		this.vistaPedido.getModelSelect().addRow(filaPo);

		Object[] filaB = { "Con Alcohol:" };
		this.vistaPedido.getModelSelect().addRow(filaB);

		Object[] filaBa = { "Sin Alcohol:" };
		this.vistaPedido.getModelSelect().addRow(filaBa);

		Object[] filaCE = { "Cafeteria:" };
		this.vistaPedido.getModelSelect().addRow(filaCE);

		Object[] filaM = { "Menus:" };
		this.vistaPedido.getModelSelect().addRow(filaM);

		for (int i = 0; i < this.platos.size(); i++) {

			if (this.platos.get(i).getTipo().equals("Entrada")) {

				Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio().toString() };
				this.vistaPedido.getModelEntrada().addRow(fila);

			} else if (this.platos.get(i).getTipo().equals("Principal")) {

				Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio().toString() };
				this.vistaPedido.getModelPrincipal().addRow(fila);

			} else {

				Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio().toString() };
				this.vistaPedido.getModelPostre().addRow(fila);

			}

		}

		for (int i = 0; i < this.bebidas.size(); i++) {

			if (this.bebidas.get(i).getTipo().equals("Con Alcohol")) {

				Object[] fila = { this.bebidas.get(i).getNombre(), this.bebidas.get(i).getPrecio() };
				this.vistaPedido.getModelBebidas().addRow(fila);

			}
			if (this.bebidas.get(i).getTipo().equals("Sin Alcohol")) {

				Object[] fila = { this.bebidas.get(i).getNombre(), this.bebidas.get(i).getPrecio() };
				this.vistaPedido.getModelSinAlcohol().addRow(fila);

			} else {

				Object[] fila = { this.bebidas.get(i).getNombre(), this.bebidas.get(i).getPrecio() };
				this.vistaPedido.getModelCafe().addRow(fila);
			}
		}

		for (int i = 0; i < this.menus.size(); i++) {

			Object[] fila = { this.menus.get(i).getNombre(), this.menus.get(i).getPrecio() };
			this.vistaPedido.getModelMenus().addRow(fila);

		}
	}

	public void sumarTotal(Double precio, Integer cantidad) {

		this.total = this.total + (precio * cantidad);
		this.vistaPedido.getTxfTotal().setText(total.toString());
	}

	public int buscarIndice(String encabezado) {

		for (int i = 0; i < this.cantidadSeleccionada; i++) {
			if (this.vistaPedido.getTblPedidoSelect().getValueAt(i, 0).equals(encabezado)) {
				return i;
			}
		}

		return -1;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public TomaDePedido getVistaPedido() {
		return vistaPedido;
	}

	public void setVistaPedido(TomaDePedido vistaPedido) {
		this.vistaPedido = vistaPedido;
	}

	public List<bebidaDTO> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<bebidaDTO> bebidas) {
		this.bebidas = bebidas;
	}

	public List<platoDTO> getPlatos() {
		return platos;
	}

	public void setPlatos(List<platoDTO> platos) {
		this.platos = platos;
	}

	public List<bebidaDTO> getBebidasSe() {
		return bebidasSe;
	}

	public void setBebidasSe(ArrayList<bebidaDTO> bebidasSe) {
		this.bebidasSe = bebidasSe;
	}

	public List<platoDTO> getPlatosSe() {
		return platosSe;
	}

	public void setPlatosSe(ArrayList<platoDTO> platosSe) {
		this.platosSe = platosSe;
	}

	public List<menuDTO> getMenus() {
		return menus;
	}

	public void setMenus(List<menuDTO> menus) {
		this.menus = menus;
	}

	public List<menuDTO> getMenusSe() {
		return menusSe;
	}

	public void setMenusSe(ArrayList<menuDTO> menusSe) {
		this.menusSe = menusSe;
	}
}
