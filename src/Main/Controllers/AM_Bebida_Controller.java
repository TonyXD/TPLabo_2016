package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.DTO.Bebidas.cafeDTO;
import Modelo.DTO.Bebidas.conAlcoholDTO;
import Modelo.DTO.Bebidas.sinAlcoholDTO;
import Modelo.Negocio.Carta;
import Vistas.Vistas_AM.ABM_Bebida;

public class AM_Bebida_Controller implements ActionListener {

	private ABM_Bebida vistaBebida;

	private List<conAlcoholDTO> conAlcohol;
	private List<sinAlcoholDTO> sinAlcohol;
	private List<cafeDTO> cafe;

	private Carta carta;

	public AM_Bebida_Controller(ABM_Bebida vistaBebidas, Carta carta) {
		this.vistaBebida = vistaBebidas;
		this.carta = carta;

		this.vistaBebida.getBtnAgregarBebida().addActionListener(this);
		this.vistaBebida.getBtnCargar().addActionListener(this);
		this.vistaBebida.getBtnBorrarBebida().addActionListener(this);
		this.vistaBebida.getBtnEditarBebida().addActionListener(this);

		this.inicializar();
	}

	public void inicializar() {
		this.conAlcohol = carta.obtenerConAlcoholes();
		this.sinAlcohol = carta.obtenerSinAlcoholes();
		this.cafe = carta.obtenerCafes();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vistaBebida.getBtnAgregarBebida()) {

			this.agregarBebida(this.vistaBebida.getCbxTipoBebidas().getSelectedIndex());

		} else if (e.getSource() == this.vistaBebida.getBtnCargar()) {

			this.cargarTabla(this.vistaBebida.getCbxTipoBebidas().getSelectedIndex());

		} else if (e.getSource() == this.vistaBebida.getBtnEditarBebida()) {

			this.editarBebida(this.vistaBebida.getCbxTipoBebidas().getSelectedIndex());

		} else if (e.getSource() == this.vistaBebida.getBtnBorrarBebida()) {

			this.borrarBebida(this.vistaBebida.getCbxTipoBebidas().getSelectedIndex());

		}
	}

	public void agregarBebida(int indice) {

		String nombre = this.vistaBebida.getNombre().getText();
		BigDecimal precio = new BigDecimal(this.vistaBebida.getPrecio().getText().replaceAll(",", ""));

		if (indice == 0) {

			conAlcoholDTO con = new conAlcoholDTO(0, nombre, precio);
			this.carta.agregarConAlcohol(con);
			this.conAlcohol.add(con);
			this.cargarTabla(0);

		} else if (indice == 1) {

			sinAlcoholDTO sin = new sinAlcoholDTO(0, nombre, precio);
			this.carta.agregarSinAlcohol(sin);
			this.sinAlcohol.add(sin);
			this.cargarTabla(1);

		} else {

			cafeDTO cafe = new cafeDTO(0, nombre, precio);
			this.carta.agregarCafe(cafe);
			this.cafe.add(cafe);
			this.cargarTabla(2);
		}
	}

	public void cargarTabla(int indice) {

		this.vistaBebida.getModelPersonas().setRowCount(0);
		this.vistaBebida.getModelPersonas().setColumnCount(0);
		this.vistaBebida.getModelPersonas().setColumnIdentifiers(this.vistaBebida.getNombreColumnas());

		if (indice == 0) {
			for (int i = 0; i < this.conAlcohol.size(); i++) {
				Object[] fila = { this.conAlcohol.get(i).getNombre(), this.conAlcohol.get(i).getPrecio() };
				this.vistaBebida.getModelPersonas().addRow(fila);
				this.vistaBebida.getTxfNombreSe().setText("");
				this.vistaBebida.getTxfPrecioSe().setText("");
			}
		} else if (indice == 1) {
			for (int i = 0; i < this.sinAlcohol.size(); i++) {
				Object[] fila = { this.sinAlcohol.get(i).getNombre(), this.sinAlcohol.get(i).getPrecio() };
				this.vistaBebida.getModelPersonas().addRow(fila);
				this.vistaBebida.getTxfNombreSe().setText("");
				this.vistaBebida.getTxfPrecioSe().setText("");
			}
		} else {
			for (int i = 0; i < this.cafe.size(); i++) {
				Object[] fila = { this.cafe.get(i).getNombre(), this.cafe.get(i).getPrecio() };
				this.vistaBebida.getModelPersonas().addRow(fila);
				this.vistaBebida.getTxfNombreSe().setText("");
				this.vistaBebida.getTxfPrecioSe().setText("");
			}
		}
	}

	public void borrarBebida(int indice) {

		Integer seleccion = this.vistaBebida.getTablaBebida().getSelectedRow();

		if (seleccion >= 0) {
			if (indice == 0) {

				this.carta.borrarConAlcohol(this.conAlcohol.get(seleccion));
				this.conAlcohol.remove(seleccion);
				this.cargarTabla(0);
				this.vistaBebida.getTxfNombreSe().setText("");
				this.vistaBebida.getTxfPrecioSe().setText("");

			} else if (indice == 1) {

				this.carta.borrarSinAlcohol(this.sinAlcohol.get(seleccion));
				this.sinAlcohol.remove(seleccion);
				this.cargarTabla(1);
				this.vistaBebida.getTxfNombreSe().setText("");
				this.vistaBebida.getTxfPrecioSe().setText("");

			} else {

				this.carta.borrarCafe(this.cafe.get(seleccion));
				this.cafe.remove(seleccion);
				this.cargarTabla(2);
				this.vistaBebida.getTxfNombreSe().setText("");
				this.vistaBebida.getTxfPrecioSe().setText("");
			}
		} else {
			JOptionPane.showMessageDialog(vistaBebida, "Seleccione una fila");
		}
	}

	public void editarBebida(int indice) {
		
		int seleccion = this.vistaBebida.getTablaBebida().getSelectedRow();
		
		if(seleccion>=0){
			
			String nombre = this.vistaBebida.getTxfNombreSe().getText();
			BigDecimal precio = new BigDecimal(this.vistaBebida.getTxfPrecioSe().getText().replaceAll(",", ""));

			if (indice == 0) {

				conAlcoholDTO edit = new conAlcoholDTO(this.conAlcohol.get(seleccion).getIdConAlcohol(), nombre, precio);
				this.carta.editarConAlcohol(edit);
				this.conAlcohol = carta.obtenerConAlcoholes();
				this.cargarTabla(0);
				this.vistaBebida.getTxfNombreSe().setText("");
				this.vistaBebida.getTxfPrecioSe().setText("");

			} else if (indice == 1) {

				sinAlcoholDTO edit = new sinAlcoholDTO(this.sinAlcohol.get(seleccion).getIdSinAlcohol(), nombre, precio);
				this.carta.editarSinAlcohol(edit);
				this.sinAlcohol = carta.obtenerSinAlcoholes();
				this.cargarTabla(1);
				this.vistaBebida.getTxfNombreSe().setText("");
				this.vistaBebida.getTxfPrecioSe().setText("");

			} else {

				cafeDTO edit = new cafeDTO(this.cafe.get(seleccion).getIdCafe(), nombre, precio);
				this.carta.editarCafe(edit);
				this.cafe = carta.obtenerCafes();
				this.cargarTabla(2);
				this.vistaBebida.getTxfNombreSe().setText("");
				this.vistaBebida.getTxfPrecioSe().setText("");

			}
		}
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