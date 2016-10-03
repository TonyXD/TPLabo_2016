package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.DTO.Comidas.platoDTO;
import Modelo.Negocio.Carta;
import Vistas.Vistas_AM.ABM_Plato;

public class ABM_Plato_Controller implements ActionListener {

	private ABM_Plato vistaPlatos;

	private List<platoDTO> platos;

	private Carta carta;

	public ABM_Plato_Controller(ABM_Plato vistaPlatos, Carta carta) {
		this.vistaPlatos = vistaPlatos;
		this.carta = carta;

		this.vistaPlatos.getBtnAgregar().addActionListener(this);
		this.vistaPlatos.getBtnCargar().addActionListener(this);
		this.vistaPlatos.getBtnEditar().addActionListener(this);
		this.vistaPlatos.getBtnBorrar().addActionListener(this);
	}

	public void inicializar() {

		this.platos = carta.obtenerPlatos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vistaPlatos.getBtnAgregar()) {

			this.agregarPlato(this.vistaPlatos.getCbxTipoPlato().getSelectedIndex());

		} else if (e.getSource() == this.vistaPlatos.getBtnCargar()) {

			this.cargarTablas(this.vistaPlatos.getCbxTipoPlato().getSelectedIndex());

		} else if (e.getSource() == this.vistaPlatos.getBtnEditar()) {

			this.editarPlato(this.vistaPlatos.getCbxTipoPlato().getSelectedIndex());

		} else if (e.getSource() == this.vistaPlatos.getBtnBorrar()) {

			this.borrarPlato(this.vistaPlatos.getCbxTipoPlato().getSelectedIndex());
		}
	}

	public void agregarPlato(int indice) {

		String nombre = this.vistaPlatos.getNombre().getText();
		Double precio = Double.valueOf(this.vistaPlatos.getPrecio().getText());
		String tipo = "";

		if (indice == 0) {
			tipo = "Entrada";
		} else if (indice == 1) {
			tipo = "Principal";
		} else {
			tipo = "Postre";
		}

		platoDTO ent = new platoDTO(0, nombre, precio, tipo);
		this.carta.agregarPlato(ent);
		this.platos.add(ent);

		this.cargarTablas(indice);

	}

	public void cargarTablas(int indice) {

		this.vistaPlatos.getModelPersonas().setRowCount(0);
		this.vistaPlatos.getModelPersonas().setColumnCount(0);
		this.vistaPlatos.getModelPersonas().setColumnIdentifiers(this.vistaPlatos.getNombreColumnas());

		if (indice == 0) {

			for (int i = 0; i < this.platos.size(); i++) {

				if (this.platos.get(i).getTipo().equals("Entrada")) {

					Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio().toString() };
					this.vistaPlatos.getModelPersonas().addRow(fila);
				}
			}
		} else if (indice == 1) {

			for (int i = 0; i < this.platos.size(); i++) {

				if (this.platos.get(i).getTipo().equals("Principal")) {

					Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio().toString() };
					this.vistaPlatos.getModelPersonas().addRow(fila);
				}
			}
		} else {

			for (int i = 0; i < this.platos.size(); i++) {

				if (this.platos.get(i).getTipo().equals("Postre")) {

					Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio().toString() };
					this.vistaPlatos.getModelPersonas().addRow(fila);
				}
			}
		}
		
		this.vistaPlatos.getTxfNombreSe().setText("");
		this.vistaPlatos.getTxfPrecioSe().setText("");
	}

	public void borrarPlato(int indice) {

		int filaSeleccion = this.vistaPlatos.getTabla().getSelectedRow();
		int posicion = 0;

		if (filaSeleccion >= 0) {

			if (indice == 0) {

				for (int i = 0; i < this.platos.size(); i++) {

					if (this.platos.get(i).getTipo().equals("Entrada")) {

						if (posicion == filaSeleccion) {

							this.carta.borrarPlato(this.platos.get(i));
							this.platos.remove(this.platos.get(i));
							this.cargarTablas(0);
						}
						posicion = posicion + 1;
					}
				}

			} else if (indice == 1) {

				for (int i = 0; i < this.platos.size(); i++) {

					if (this.platos.get(i).getTipo().equals("Principal")) {

						if (posicion == filaSeleccion) {

							this.carta.borrarPlato(this.platos.get(i));
							this.platos.remove(this.platos.get(i));
							this.cargarTablas(1);
						}
						posicion = posicion + 1;
					}
				}
			} else if (indice == 2) {

				for (int i = 0; i < this.platos.size(); i++) {

					if (this.platos.get(i).getTipo().equals("Postre")) {

						if (posicion == filaSeleccion) {

							this.carta.borrarPlato(this.platos.get(i));
							this.platos.remove(this.platos.get(i));
							this.cargarTablas(0);
						}
						posicion = posicion + 1;
					}
				}
			}

		} else {

			JOptionPane.showMessageDialog(vistaPlatos, "Seleccione una fila");

			this.vistaPlatos.getTxfNombreSe().setText("");
			this.vistaPlatos.getTxfPrecioSe().setText("");
		}
	}

	public void editarPlato(int indice) {

		int filaSeleccion = this.vistaPlatos.getTabla().getSelectedRow();

		if (filaSeleccion >= 0) {

			String nombre = this.vistaPlatos.getTxfNombreSe().getText();
			Double precio = Double.valueOf(this.vistaPlatos.getTxfPrecioSe().getText());
			int posicion = 0;

			if (indice == 0) {

				String tipo = "Entrada";

				for (int i = 0; i < this.platos.size(); i++) {

					if (this.platos.get(i).getTipo().equals("Entrada")) {

						if (posicion == filaSeleccion) {

							platoDTO edit = new platoDTO(this.platos.get(i).getIdPlato(), nombre, precio, tipo);
							this.carta.editarPlato(edit);
							this.platos = carta.obtenerPlatos();
							this.cargarTablas(0);
						}
						posicion = posicion + 1;
					}
				}
			} else if (indice == 1) {

				String tipo = "Principal";

				for (int i = 0; i < this.platos.size(); i++) {

					if (this.platos.get(i).getTipo().equals("Principal")) {

						if (posicion == filaSeleccion) {

							platoDTO edit = new platoDTO(this.platos.get(i).getIdPlato(), nombre, precio, tipo);
							this.carta.editarPlato(edit);
							this.platos = carta.obtenerPlatos();
							this.cargarTablas(1);							
						}
						posicion = posicion + 1;
					}
				}

			} else {

				String tipo = "Postre";
				for (int i = 0; i < this.platos.size(); i++) {

					if (this.platos.get(i).getTipo().equals("Principal")) {

						if (posicion == filaSeleccion) {

							platoDTO edit = new platoDTO(this.platos.get(i).getIdPlato(), nombre, precio, tipo);
							this.carta.editarPlato(edit);
							this.platos = carta.obtenerPlatos();
							this.cargarTablas(2);
						}
						posicion = posicion + 1;
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(vistaPlatos, "Seleccione una fila");
		}

		this.vistaPlatos.getTxfNombreSe().setText("");
		this.vistaPlatos.getTxfPrecioSe().setText("");
	}
}