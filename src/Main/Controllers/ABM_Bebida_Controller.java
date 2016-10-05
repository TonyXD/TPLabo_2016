package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.DTO.Bebidas.bebidaDTO;
import Modelo.DTO.Comidas.platoDTO;
import Modelo.Negocio.Carta;
import Vistas.Vistas_AM.ABM_Bebida;
import Vistas.Vistas_AM.ABM_Plato;

public class ABM_Bebida_Controller implements ActionListener {

	private ABM_Bebida vistaBebida;

	private List<bebidaDTO> bebidas;

	private Carta carta;

	public ABM_Bebida_Controller(ABM_Bebida vistaBebida, Carta carta) {
		this.vistaBebida = vistaBebida;
		this.carta = carta;

		this.vistaBebida.getBtnAgregarBebida().addActionListener(this);
		this.vistaBebida.getBtnCargar().addActionListener(this);
		this.vistaBebida.getBtnEditarBebida().addActionListener(this);
		this.vistaBebida.getBtnBorrarBebida().addActionListener(this);
	}

	public void inicializar() {

		this.bebidas = carta.obtenerBebidas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vistaBebida.getBtnAgregarBebida()) {

			this.agregarBebida(this.vistaBebida.getCbxTipoBebidas().getSelectedIndex());

		} else if (e.getSource() == this.vistaBebida.getBtnCargar()) {

			this.cargarTablas(this.vistaBebida.getCbxTipoBebidas().getSelectedIndex());

		} else if (e.getSource() == this.vistaBebida.getBtnEditarBebida()) {

			this.editarBebida(this.vistaBebida.getCbxTipoBebidas().getSelectedIndex());

		} else if (e.getSource() == this.vistaBebida.getBtnBorrarBebida()) {

			this.borrarBebida(this.vistaBebida.getCbxTipoBebidas().getSelectedIndex());
		}
	}

	public void agregarBebida(int indice) {

		String nombre = this.vistaBebida.getNombre().getText();
		Double precio = Double.valueOf(this.vistaBebida.getPrecio().getText());
		String tipo = "";

		if (indice == 0) {
			tipo = "Sin Alcohol";
		} else if (indice == 1) {
			tipo = "Con Alcohol";
		} else {
			tipo = "Cafeteria";
		}

		bebidaDTO ent = new bebidaDTO(0, nombre, precio, tipo);
		this.carta.agregarBebida(ent);
		this.bebidas.add(ent);

		this.cargarTablas(indice);

	}

	public void cargarTablas(int indice) {

		this.vistaBebida.getModelPersonas().setRowCount(0);
		this.vistaBebida.getModelPersonas().setColumnCount(0);
		this.vistaBebida.getModelPersonas().setColumnIdentifiers(this.vistaBebida.getNombreColumnas());

		if (indice == 0) {

			for (int i = 0; i < this.bebidas.size(); i++) {

				if (this.bebidas.get(i).getTipo().equals("Sin Alcohol")) {

					Object[] fila = { this.bebidas.get(i).getNombre(), this.bebidas.get(i).getPrecio().toString() };
					this.vistaBebida.getModelPersonas().addRow(fila);
				}
			}
		} else if (indice == 1) {

			for (int i = 0; i < this.bebidas.size(); i++) {

				if (this.bebidas.get(i).getTipo().equals("Con Alcohol")) {

					Object[] fila = { this.bebidas.get(i).getNombre(), this.bebidas.get(i).getPrecio().toString() };
					this.vistaBebida.getModelPersonas().addRow(fila);
				}
			}
		} else {

			for (int i = 0; i < this.bebidas.size(); i++) {

				if (this.bebidas.get(i).getTipo().equals("Cafeteria")) {

					Object[] fila = { this.bebidas.get(i).getNombre(), this.bebidas.get(i).getPrecio().toString() };
					this.vistaBebida.getModelPersonas().addRow(fila);
				}
			}
		}
		
		this.vistaBebida.getTxfNombreSe().setText("");
		this.vistaBebida.getTxfPrecioSe().setText("");
	}

	public void borrarBebida(int indice) {

		int filaSeleccion = this.vistaBebida.getTablaBebida().getSelectedRow();
		int posicion = 0;

		if (filaSeleccion >= 0) {

			if (indice == 0) {

				for (int i = 0; i < this.bebidas.size(); i++) {

					if (this.bebidas.get(i).getTipo().equals("Sin Alcohol")) {

						if (posicion == filaSeleccion) {

							this.carta.borrarBebida(this.bebidas.get(i));
							this.bebidas.remove(this.bebidas.get(i));
							this.cargarTablas(0);
						}
						posicion = posicion + 1;
					}
				}

			} else if (indice == 1) {

				for (int i = 0; i < this.bebidas.size(); i++) {

					if (this.bebidas.get(i).getTipo().equals("Con Alcohol")) {

						if (posicion == filaSeleccion) {

							this.carta.borrarBebida(this.bebidas.get(i));
							this.bebidas.remove(this.bebidas.get(i));
							this.cargarTablas(1);
						}
						posicion = posicion + 1;
					}
				}
			} else if (indice == 2) {

				for (int i = 0; i < this.bebidas.size(); i++) {

					if (this.bebidas.get(i).getTipo().equals("Cafeteria")) {

						if (posicion == filaSeleccion) {

							this.carta.borrarBebida(this.bebidas.get(i));
							this.bebidas.remove(this.bebidas.get(i));
							this.cargarTablas(0);
						}
						posicion = posicion + 1;
					}
				}
			}

		} else {

			JOptionPane.showMessageDialog(vistaBebida, "Seleccione una fila");

			this.vistaBebida.getTxfNombreSe().setText("");
			this.vistaBebida.getTxfPrecioSe().setText("");
		}
	}

	public void editarBebida(int indice) {

		int filaSeleccion = this.vistaBebida.getTablaBebida().getSelectedRow();

		if (filaSeleccion >= 0) {

			String nombre = this.vistaBebida.getTxfNombreSe().getText();
			Double precio = Double.valueOf(this.vistaBebida.getTxfPrecioSe().getText());
			int posicion = 0;

			if (indice == 0) {

				String tipo = "Sin Alcohol";

				for (int i = 0; i < this.bebidas.size(); i++) {

					if (this.bebidas.get(i).getTipo().equals("Sin Alcohol")) {

						if (posicion == filaSeleccion) {

							bebidaDTO edit = new bebidaDTO(this.bebidas.get(i).getIdBebida(), nombre, precio, tipo);
							this.carta.editarBebida(edit);
							this.bebidas = carta.obtenerBebidas();
							this.cargarTablas(0);
						}
						posicion = posicion + 1;
					}
				}
			} else if (indice == 1) {

				String tipo = "Con Alcohol";

				for (int i = 0; i < this.bebidas.size(); i++) {

					if (this.bebidas.get(i).getTipo().equals("Con Alcohol")) {

						if (posicion == filaSeleccion) {

							bebidaDTO edit = new bebidaDTO(this.bebidas.get(i).getIdBebida(), nombre, precio, tipo);
							this.carta.editarBebida(edit);
							this.bebidas = carta.obtenerBebidas();
							this.cargarTablas(1);							
						}
						posicion = posicion + 1;
					}
				}

			} else {

				String tipo = "Cafeteria";
				for (int i = 0; i < this.bebidas.size(); i++) {

					if (this.bebidas.get(i).getTipo().equals("Cafeteria")) {

						if (posicion == filaSeleccion) {

							bebidaDTO edit = new bebidaDTO(this.bebidas.get(i).getIdBebida(), nombre, precio, tipo);
							this.carta.editarBebida(edit);
							this.bebidas = carta.obtenerBebidas();
							this.cargarTablas(2);
						}
						posicion = posicion + 1;
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(vistaBebida, "Seleccione una fila");
		}

		this.vistaBebida.getTxfNombreSe().setText("");
		this.vistaBebida.getTxfPrecioSe().setText("");
	}
}