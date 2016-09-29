package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import Modelo.DTO.Bebidas.cafeDTO;
import Modelo.DTO.Bebidas.conAlcoholDTO;
import Modelo.DTO.Bebidas.sinAlcoholDTO;
import Modelo.Negocio.Carta;
import Vistas.Vistas_AM.AM_Bebida;

public class AM_Bebida_Controller implements ActionListener {

	private AM_Bebida vistaBebida;
	
	private List<conAlcoholDTO> conAlcohol;
	private List<sinAlcoholDTO> sinAlcohol;
	private List<cafeDTO> cafe;

	private Carta carta;
	
	public AM_Bebida_Controller(AM_Bebida vistaBebidas, Carta carta)
	{
		this.vistaBebida = vistaBebidas;
		this.carta = carta;
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

		} else if (e.getSource() == this.vistaBebida.getBtnBorrarBebida()) {
			
			this.borrarBebida(this.vistaBebida.getCbxTipoBebidas().getSelectedIndex());

		}
	}
	
	public void agregarBebida(int indice) {

		String nombre = this.vistaBebida.getNombre().getText();
		BigDecimal precio = new BigDecimal(this.vistaBebida.getPrecio().getText().replaceAll(",", ""));

		if (indice == 0) {

			this.carta.agregarConAlcohol(new conAlcoholDTO(1, nombre, precio));

		} else if (indice == 1) {

			this.carta.agregarSinAlcohol(new sinAlcoholDTO(1, nombre, precio));

		} else {

			this.carta.agregarCafe(new cafeDTO(1, nombre, precio));
		}
	}

	public void cargarTabla(int indice) {

		this.vistaBebida.getTablaBebida().removeAll();

		if (indice == 0) {
			for (int i = 0; i < this.conAlcohol.size(); i++) {
				vistaBebida.getTablaBebida().setValueAt(conAlcohol.get(i).getNombre(), i, 0);
				vistaBebida.getTablaBebida().setValueAt(conAlcohol.get(i).getPrecio(), i, 1);
			}
		} else if (indice == 1) {
			for (int i = 0; i < this.sinAlcohol.size(); i++) {
				vistaBebida.getTablaBebida().setValueAt(sinAlcohol.get(i).getNombre(), i, 0);
				vistaBebida.getTablaBebida().setValueAt(sinAlcohol.get(i).getPrecio(), i, 1);
			}
		} else {
			for (int i = 0; i < this.cafe.size(); i++) {
				vistaBebida.getTablaBebida().setValueAt(cafe.get(i).getNombre(), i, 0);
				vistaBebida.getTablaBebida().setValueAt(cafe.get(i).getPrecio(), i, 1);
			}
		}
	}
	
	public void borrarBebida(int indice){
		
		Integer seleccion = this.vistaBebida.getTablaBebida().getSelectedRow();
		
		if(indice==0){
			
			this.carta.borrarConAlcohol(this.conAlcohol.get(seleccion));
			this.conAlcohol.remove(seleccion);
			this.cargarTabla(0);
			
		}else if(indice==1){
			
			this.carta.borrarSinAlcohol(this.sinAlcohol.get(seleccion));
			this.sinAlcohol.remove(seleccion);
			this.cargarTabla(1);
			
		}else{
			
			this.carta.borrarCafe(this.cafe.get(seleccion));
			this.cafe.remove(seleccion);
			this.cargarTabla(2);
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