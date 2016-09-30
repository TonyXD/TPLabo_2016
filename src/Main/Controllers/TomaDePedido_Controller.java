package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Modelo.DTO.Bebidas.Bebida;
import Modelo.DTO.Bebidas.cafeDTO;
import Modelo.DTO.Bebidas.conAlcoholDTO;
import Modelo.DTO.Bebidas.sinAlcoholDTO;
import Modelo.DTO.Comidas.entradaDTO;
import Modelo.DTO.Comidas.postreDTO;
import Modelo.DTO.Comidas.principalDTO;
import Modelo.Negocio.Carta;
import Modelo.Negocio.Pedido;
import Vistas.Encargado.TomaDePedido;

public class TomaDePedido_Controller implements ActionListener {

	private TomaDePedido vistaPedido;

	private List<entradaDTO> entrada;
	private List<principalDTO> principal;
	private List<postreDTO> postre;
	private List<conAlcoholDTO> conAlcohol;
	private List<sinAlcoholDTO> sinAlcohol;
	private List<cafeDTO> cafe;

	private List<entradaDTO> entradaSe;
	private List<principalDTO> principalSe;
	private List<postreDTO> postreSe;
	private List<conAlcoholDTO> conAlcoholSe;
	private List<sinAlcoholDTO> sinAlcoholSe;
	private List<cafeDTO> cafeSe;

	private List<Bebida> bebidas;

	private Pedido pedido;
	private Carta carta;

	public TomaDePedido_Controller(TomaDePedido vistaPedido, Pedido pedido, Carta carta) {
		this.setVistaPedido(vistaPedido);
		this.setPedido(pedido);
		this.carta = carta;

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

		// this.vistaPlatos.getBtnAgregar().addActionL1istener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// if (e.getSource() == this.vistaPlatos.getBtnAgregar()) {
		//
		// }
	}

	public void cargarTablas() {

		for (int i = 0; i < this.entrada.size(); i++) {
			Object[] fila = { this.entrada.get(i).getNombre(), this.entrada.get(i).getPrecio().toString() };
			this.vistaPedido.getModelEntrada().addRow(fila);
		}

		for (int i = 0; i < this.principal.size(); i++) {
			Object[] fila = { this.principal.get(i).getNombre(), this.principal.get(i).getPrecio().toString() };
			this.vistaPedido.getModelPrincipal().addRow(fila);
		}

		for (int i = 0; i < this.postre.size(); i++) {
			Object[] fila = { this.postre.get(i).getNombre(), this.postre.get(i).getPrecio().toString() };
			this.vistaPedido.getModelPostre().addRow(fila);
		}

		this.cargarBebida();

		// for (int i = 0; i < this.entrada.size(); i++) {
		// Object[] fila = { this.entrada.get(i).getNombre(),
		// this.entrada.get(i).getPrecio().toString() };
		// this.vistaPedido.getModelEntrada().addRow(fila);
		// }
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

	public List<entradaDTO> getEntradaSe() {
		return entradaSe;
	}

	public void setEntradaSe(List<entradaDTO> entradaSe) {
		this.entradaSe = entradaSe;
	}

	public List<principalDTO> getPrincipalSe() {
		return principalSe;
	}

	public void setPrincipalSe(List<principalDTO> principalSe) {
		this.principalSe = principalSe;
	}

	public List<postreDTO> getPostreSe() {
		return postreSe;
	}

	public void setPostreSe(List<postreDTO> postreSe) {
		this.postreSe = postreSe;
	}

	public List<conAlcoholDTO> getConAlcoholSe() {
		return conAlcoholSe;
	}

	public void setConAlcoholSe(List<conAlcoholDTO> conAlcoholSe) {
		this.conAlcoholSe = conAlcoholSe;
	}

	public List<sinAlcoholDTO> getSinAlcoholSe() {
		return sinAlcoholSe;
	}

	public void setSinAlcoholSe(List<sinAlcoholDTO> sinAlcoholSe) {
		this.sinAlcoholSe = sinAlcoholSe;
	}

	public List<cafeDTO> getCafeSe() {
		return cafeSe;
	}

	public void setCafeSe(List<cafeDTO> cafeSe) {
		this.cafeSe = cafeSe;
	}

	public List<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}
}
