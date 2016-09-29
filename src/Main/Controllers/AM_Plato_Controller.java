package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import Modelo.DTO.Comidas.entradaDTO;
import Modelo.DTO.Comidas.postreDTO;
import Modelo.DTO.Comidas.principalDTO;
import Modelo.Negocio.Carta;
import Vistas.Vistas_AM.AM_Plato;

public class AM_Plato_Controller implements ActionListener {

	private AM_Plato vistaPlatos;

	private List<entradaDTO> entrada;
	private List<principalDTO> principal;
	private List<postreDTO> postre;

	private Carta carta;

	public AM_Plato_Controller(AM_Plato vistaPlatos, Carta carta) {
		this.vistaPlatos = vistaPlatos;
		this.carta = carta;
	}

	public void inicializar() {
		this.setEntrada(carta.obtenerEntradas());
		this.setPrincipal(carta.obtenerPrincipales());
		this.setPostre(carta.obtenerPostres());
		
		this.vistaPlatos.getBtnAgregar().addActionListener(this);
		this.vistaPlatos.getBtnCargar().addActionListener(this);
		this.vistaPlatos.getBtnEditar().addActionListener(this);
		this.vistaPlatos.getBtnBorrar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vistaPlatos.getBtnAgregar()) {

			this.agregarPlato(this.vistaPlatos.getCbxTipoPlato().getSelectedIndex());

		} else if (e.getSource() == this.vistaPlatos.getBtnCargar()) {

			this.cargarTabla(this.vistaPlatos.getCbxTipoPlato().getSelectedIndex());

		} else if (e.getSource() == this.vistaPlatos.getBtnEditar()) {

		} else if (e.getSource() == this.vistaPlatos.getBtnBorrar()) {
			
			this.borrarPlato(this.vistaPlatos.getCbxTipoPlato().getSelectedIndex());
		}
	}

	public void agregarPlato(int indice) {

		String nombre = this.vistaPlatos.getNombre().getText();
		BigDecimal precio = new BigDecimal(this.vistaPlatos.getPrecio().getText().replaceAll(",", ""));

		if (indice == 0) {

			this.carta.agregarEntrada(new entradaDTO(1, nombre, precio));

		} else if (indice == 1) {

			this.carta.agregarPrincipal(new principalDTO(1, nombre, precio));

		} else {

			this.carta.agregarPostre(new postreDTO(1, nombre, precio));
		}
	}

	public void cargarTabla(int indice) {

		this.vistaPlatos.getTablaPlato().removeAll();

		if (indice == 0) {
			for (int i = 0; i < this.entrada.size(); i++) {
				vistaPlatos.getTablaPlato().setValueAt(entrada.get(i).getNombre(), i, 0);
				vistaPlatos.getTablaPlato().setValueAt(entrada.get(i).getPrecio(), i, 1);
			}
		} else if (indice == 1) {
			for (int i = 0; i < this.principal.size(); i++) {
				vistaPlatos.getTablaPlato().setValueAt(principal.get(i).getNombre(), i, 0);
				vistaPlatos.getTablaPlato().setValueAt(principal.get(i).getPrecio(), i, 1);
			}
		} else {
			for (int i = 0; i < this.postre.size(); i++) {
				vistaPlatos.getTablaPlato().setValueAt(postre.get(i).getNombre(), i, 0);
				vistaPlatos.getTablaPlato().setValueAt(postre.get(i).getPrecio(), i, 1);
			}
		}
	}
	
	public void borrarPlato(int indice){
		
		Integer seleccion = this.vistaPlatos.getTablaPlato().getSelectedRow();
		
		if(indice==0){
			
			this.carta.borrarEntrada(this.entrada.get(seleccion));
			this.entrada.remove(seleccion);
			this.cargarTabla(0);
			
		}else if(indice==1){
			
			this.carta.borrarPrincipal(this.principal.get(seleccion));
			this.principal.remove(seleccion);
			this.cargarTabla(1);
			
		}else{
			
			this.carta.borrarPostre(this.postre.get(seleccion));
			this.postre.remove(seleccion);
			this.cargarTabla(2);
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