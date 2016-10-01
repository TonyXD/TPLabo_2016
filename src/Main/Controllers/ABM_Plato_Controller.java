package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.DTO.Comidas.entradaDTO;
import Modelo.DTO.Comidas.postreDTO;
import Modelo.DTO.Comidas.principalDTO;
import Modelo.Negocio.Carta;
import Vistas.Vistas_AM.ABM_Plato;

public class ABM_Plato_Controller implements ActionListener {

	private ABM_Plato vistaPlatos;

	private List<entradaDTO> entrada;
	private List<principalDTO> principal;
	private List<postreDTO> postre;

	private Carta carta;

	public ABM_Plato_Controller(ABM_Plato vistaPlatos, Carta carta) {
		this.vistaPlatos = vistaPlatos;
		this.carta = carta;

		this.vistaPlatos.getBtnAgregar().addActionListener(this);
		this.vistaPlatos.getBtnCargar().addActionListener(this);
		this.vistaPlatos.getBtnEditar().addActionListener(this);
		this.vistaPlatos.getBtnBorrar().addActionListener(this);
		
		this.inicializar();
	}

	public void inicializar() {
		this.setEntrada(carta.obtenerEntradas());
		this.setPrincipal(carta.obtenerPrincipales());
		this.setPostre(carta.obtenerPostres());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vistaPlatos.getBtnAgregar()) {

			this.agregarPlato(this.vistaPlatos.getCbxTipoPlato().getSelectedIndex());

		} else if (e.getSource() == this.vistaPlatos.getBtnCargar()) {

			this.cargarTabla(this.vistaPlatos.getCbxTipoPlato().getSelectedIndex());

		} else if (e.getSource() == this.vistaPlatos.getBtnEditar()) {

			this.editarPlato(this.vistaPlatos.getCbxTipoPlato().getSelectedIndex());

		} else if (e.getSource() == this.vistaPlatos.getBtnBorrar()) {

			this.borrarPlato(this.vistaPlatos.getCbxTipoPlato().getSelectedIndex());
		}
	}

	public void agregarPlato(int indice) {

		String nombre = this.vistaPlatos.getNombre().getText();
		BigDecimal precio = new BigDecimal(this.vistaPlatos.getPrecio().getText().replaceAll(",", ""));

		if (indice == 0) {
			entradaDTO ent = new entradaDTO(0, nombre, precio);
			this.carta.agregarEntrada(ent);
			this.entrada.add(ent);
			this.cargarTabla(0);

		} else if (indice == 1) {
			principalDTO prin = new principalDTO(0, nombre, precio);
			this.carta.agregarPrincipal(prin);
			this.principal.add(prin);
			this.cargarTabla(1);

		} else {
			postreDTO pos = new postreDTO(0, nombre, precio);
			this.carta.agregarPostre(pos);
			this.postre.add(pos);
			this.cargarTabla(2);
		}
	}

	public void cargarTabla(int indice) {

		this.vistaPlatos.getModelPersonas().setRowCount(0);
		this.vistaPlatos.getModelPersonas().setColumnCount(0);
		this.vistaPlatos.getModelPersonas().setColumnIdentifiers(this.vistaPlatos.getNombreColumnas());

		if (indice == 0) {
			for (int i = 0; i < this.entrada.size(); i++) {
				Object[] fila = { this.entrada.get(i).getNombre(), this.entrada.get(i).getPrecio().toString() };
				this.vistaPlatos.getModelPersonas().addRow(fila);
				this.vistaPlatos.getTxfNombreSe().setText("");
				this.vistaPlatos.getTxfPrecioSe().setText("");
			}
		} else if (indice == 1) {
			for (int i = 0; i < this.principal.size(); i++) {
				Object[] fila = { this.principal.get(i).getNombre(), this.principal.get(i).getPrecio().toString() };
				this.vistaPlatos.getModelPersonas().addRow(fila);
				this.vistaPlatos.getTxfNombreSe().setText("");
				this.vistaPlatos.getTxfPrecioSe().setText("");
			}
		} else {
			for (int i = 0; i < this.postre.size(); i++) {
				Object[] fila = { this.postre.get(i).getNombre(), this.postre.get(i).getPrecio().toString() };
				this.vistaPlatos.getModelPersonas().addRow(fila);
				this.vistaPlatos.getTxfNombreSe().setText("");
				this.vistaPlatos.getTxfPrecioSe().setText("");
			}
		}
	}

	public void borrarPlato(int indice) {

		int seleccion = this.vistaPlatos.getTabla().getSelectedRow();

		if (seleccion >= 0) {
			if (indice == 0) {

				this.carta.borrarEntrada(this.entrada.get(seleccion));
				this.entrada.remove(seleccion);
				this.cargarTabla(0);
				this.vistaPlatos.getTxfNombreSe().setText("");
				this.vistaPlatos.getTxfPrecioSe().setText("");

			} else if (indice == 1) {

				this.carta.borrarPrincipal(this.principal.get(seleccion));
				this.principal.remove(seleccion);
				this.cargarTabla(1);
				this.vistaPlatos.getTxfNombreSe().setText("");
				this.vistaPlatos.getTxfPrecioSe().setText("");

			} else {

				this.carta.borrarPostre(this.postre.get(seleccion));
				this.postre.remove(seleccion);
				this.cargarTabla(2);
				this.vistaPlatos.getTxfNombreSe().setText("");
				this.vistaPlatos.getTxfPrecioSe().setText("");
			}
		} else {
			JOptionPane.showMessageDialog(vistaPlatos, "Seleccione una fila");
		}
	}

	public void editarPlato(int indice) {
		
		int seleccion = this.vistaPlatos.getTabla().getSelectedRow();
		
		if(seleccion>=0){
			
			String nombre = this.vistaPlatos.getTxfNombreSe().getText();
			BigDecimal precio = new BigDecimal(this.vistaPlatos.getTxfPrecioSe().getText().replaceAll(",", ""));
			
			if (indice == 0) {
				
				entradaDTO edit = new entradaDTO(this.entrada.get(seleccion).getIdEntrada(), nombre, precio);
				this.carta.editarEntrada(edit);
				this.entrada = carta.obtenerEntradas();
				this.cargarTabla(0);
				this.vistaPlatos.getTxfNombreSe().setText("");
				this.vistaPlatos.getTxfPrecioSe().setText("");

			} else if (indice == 1) {
				
				principalDTO edit = new principalDTO(this.principal.get(seleccion).getIdPrincipal(), nombre, precio);
				this.carta.editarPrincipal(edit);
				this.principal = carta.obtenerPrincipales();
				this.cargarTabla(1);
				this.vistaPlatos.getTxfNombreSe().setText("");
				this.vistaPlatos.getTxfPrecioSe().setText("");
				
			} else {
				
				postreDTO edit = new postreDTO(this.postre.get(seleccion).getIdPostre(), nombre, precio);
				this.carta.editarPostre(edit);
				this.postre = carta.obtenerPostres();
				this.cargarTabla(2);
				this.vistaPlatos.getTxfNombreSe().setText("");
				this.vistaPlatos.getTxfPrecioSe().setText("");
				
			}
		}else {
			JOptionPane.showMessageDialog(vistaPlatos, "Seleccione una fila");
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
}