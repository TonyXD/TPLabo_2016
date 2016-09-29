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

	private Pedido pedido;
	private Carta carta;
	
	
	public TomaDePedido_Controller(TomaDePedido vistaPedido, Pedido pedido, Carta carta) {
		this.setVistaPedido(vistaPedido);
		this.setPedido(pedido);
		this.carta = carta;
	}

	public void inicializar() {
		
		this.setEntrada(carta.obtenerEntradas());
		this.setPrincipal(carta.obtenerPrincipales());
		this.setPostre(carta.obtenerPostres());
		this.setConAlcohol(carta.obtenerConAlcoholes());
		this.setSinAlcohol(carta.obtenerSinAlcoholes());
		this.setCafe(carta.obtenerCafes());
		
//		this.vistaPlatos.getBtnAgregar().addActionL1istener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		if (e.getSource() == this.vistaPlatos.getBtnAgregar()) {
//			
//		}
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
}
