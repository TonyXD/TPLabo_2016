package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Modelo.DTO.Bebidas.cafeDTO;
import Modelo.DTO.Bebidas.conAlcoholDTO;
import Modelo.DTO.Bebidas.sinAlcoholDTO;
import Modelo.DTO.Comidas.entradaDTO;
import Modelo.DTO.Comidas.postreDTO;
import Modelo.DTO.Comidas.principalDTO;
import Modelo.Negocio.Carta;
import Vistas.Encargado.GestorDeCarta;
import Vistas.Vistas_AM.ABM_Bebida;
import Vistas.Vistas_AM.ABM_Plato;
import Vistas.Vistas_AM.Alta_Menu;

public class GestorDeCarta_Controller implements ActionListener {

	private List<entradaDTO> entrada;
	private List<principalDTO> principal;
	private List<postreDTO> postre;
	private List<conAlcoholDTO> conAlcohol;
	private List<sinAlcoholDTO> sinAlcohol;
	private List<cafeDTO> cafe;

	private GestorDeCarta vistaCarta;
	private Carta carta;

	public GestorDeCarta_Controller(GestorDeCarta vistaCarta, Carta carta) {

		this.vistaCarta = vistaCarta;
		this.carta = carta;

		this.vistaCarta.getBtnGestionarPlatos().addActionListener(this);
		this.vistaCarta.getBtnGestionarBebida().addActionListener(this);
		this.vistaCarta.getBtnGestionarMenu().addActionListener(this);

		this.inicializar();
	}

	public void inicializar() {

		this.setEntrada(carta.obtenerEntradas());
		this.setPrincipal(carta.obtenerPrincipales());
		this.setPostre(carta.obtenerPostres());
		this.setConAlcohol(carta.obtenerConAlcoholes());
		this.setSinAlcohol(carta.obtenerSinAlcoholes());
		this.setCafe(carta.obtenerCafes());

		this.cargarTablas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vistaCarta.getBtnGestionarPlatos()) {

			ABM_Plato vistaPlato = new ABM_Plato(this);
			ABM_Plato_Controller controlPlato = new ABM_Plato_Controller(vistaPlato, carta);
			controlPlato.inicializar();
			vistaPlato.setVisible(true);
			this.vistaCarta.setEnabled(false);

		} else if (e.getSource() == this.vistaCarta.getBtnGestionarBebida()) {

			ABM_Bebida vistaBebida = new ABM_Bebida(this);
			ABM_Bebida_Controller controlBebida = new ABM_Bebida_Controller(vistaBebida, carta);
			controlBebida.inicializar();
			vistaBebida.setVisible(true);
			this.vistaCarta.setEnabled(false);

		} else if (e.getSource() == this.vistaCarta.getBtnGestionarMenu()) {

			Alta_Menu vistaMenu = new Alta_Menu(this);
			Alta_Menu_Controller controlMenu = new Alta_Menu_Controller(vistaMenu, carta);
			controlMenu.inicializar();
			vistaMenu.setVisible(true);
			this.vistaCarta.setEnabled(false);
		}

	}

	public void cargarTablas() {

		this.reiniciarTablas();

		for (int i = 0; i < this.entrada.size(); i++) {

			Object[] fila = { this.entrada.get(i).getNombre(), this.entrada.get(i).getPrecio().toString() };
			this.vistaCarta.getModelEntrada().addRow(fila);
		}

		for (int i = 0; i < this.principal.size(); i++) {

			Object[] fila = { this.principal.get(i).getNombre(), this.principal.get(i).getPrecio().toString() };
			this.vistaCarta.getModelPrincipal().addRow(fila);
		}

		for (int i = 0; i < this.postre.size(); i++) {

			Object[] fila = { this.postre.get(i).getNombre(), this.postre.get(i).getPrecio().toString() };
			this.vistaCarta.getModelPostre().addRow(fila);
		}

		for (int i = 0; i < this.conAlcohol.size(); i++) {

			Object[] fila = { this.conAlcohol.get(i).getNombre(), this.conAlcohol.get(i).getPrecio() };
			this.vistaCarta.getModelConAlcohol().addRow(fila);
		}

		for (int i = 0; i < this.sinAlcohol.size(); i++) {

			Object[] fila = { this.sinAlcohol.get(i).getNombre(), this.sinAlcohol.get(i).getPrecio() };
			this.vistaCarta.getModelSinAlcohol().addRow(fila);

		}
		for (int i = 0; i < this.cafe.size(); i++) {

			Object[] fila = { this.cafe.get(i).getNombre(), this.cafe.get(i).getPrecio() };
			this.vistaCarta.getModelCafe().addRow(fila);
		}
	}

	public void reiniciarTablas() {

		this.vistaCarta.getModelEntrada().setRowCount(0);
		this.vistaCarta.getModelEntrada().setColumnCount(0);
		this.vistaCarta.getModelEntrada().setColumnIdentifiers(this.vistaCarta.getNombreColumnas());
		this.vistaCarta.getModelPrincipal().setRowCount(0);
		this.vistaCarta.getModelPrincipal().setColumnCount(0);
		this.vistaCarta.getModelPrincipal().setColumnIdentifiers(this.vistaCarta.getNombreColumnas());
		this.vistaCarta.getModelPostre().setRowCount(0);
		this.vistaCarta.getModelPostre().setColumnCount(0);
		this.vistaCarta.getModelPostre().setColumnIdentifiers(this.vistaCarta.getNombreColumnas());
		this.vistaCarta.getModelConAlcohol().setRowCount(0);
		this.vistaCarta.getModelConAlcohol().setColumnCount(0);
		this.vistaCarta.getModelConAlcohol().setColumnIdentifiers(this.vistaCarta.getNombreColumnas());
		this.vistaCarta.getModelSinAlcohol().setRowCount(0);
		this.vistaCarta.getModelSinAlcohol().setColumnCount(0);
		this.vistaCarta.getModelSinAlcohol().setColumnIdentifiers(this.vistaCarta.getNombreColumnas());
		this.vistaCarta.getModelCafe().setRowCount(0);
		this.vistaCarta.getModelCafe().setColumnCount(0);
		this.vistaCarta.getModelCafe().setColumnIdentifiers(this.vistaCarta.getNombreColumnas());
		this.vistaCarta.getModelMenu().setRowCount(0);
		this.vistaCarta.getModelMenu().setColumnCount(0);
		this.vistaCarta.getModelMenu().setColumnIdentifiers(this.vistaCarta.getNombreColumnas());
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

	public List<postreDTO> getPostre() {
		return postre;
	}

	public void setPostre(List<postreDTO> postre) {
		this.postre = postre;
	}

	public List<principalDTO> getPrincipal() {
		return principal;
	}

	public void setPrincipal(List<principalDTO> principal) {
		this.principal = principal;
	}

	public List<entradaDTO> getEntrada() {
		return entrada;
	}

	public void setEntrada(List<entradaDTO> entrada) {
		this.entrada = entrada;
	}

	public GestorDeCarta getVistaCarta() {
		return vistaCarta;
	}

	public void setVistaCarta(GestorDeCarta vistaCarta) {
		this.vistaCarta = vistaCarta;
	}

}
