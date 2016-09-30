package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;

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

	private int cantidadSeleccionada;
	private BigDecimal total;

	public TomaDePedido_Controller(TomaDePedido vistaPedido, Pedido pedido, Carta carta) {
		this.setVistaPedido(vistaPedido);
		this.setPedido(pedido);
		this.carta = carta;
		this.cantidadSeleccionada = 5;
		this.total = new BigDecimal(0);
		this.vistaPedido.getBtnAgregar().addActionListener(this);
		this.vistaPedido.getBtnQuitarDelPedido().addActionListener(this);
		this.vistaPedido.getBtnCrearPedido().addActionListener(this);
		this.vistaPedido.getBtnCancelarPedido().addActionListener(this);

		this.inicializar();
	}

	public void inicializar() {

		this.setEntrada(carta.obtenerEntradas());
		this.setPrincipal(carta.obtenerPrincipales());
		this.setPostre(carta.obtenerPostres());
		this.setConAlcohol(carta.obtenerConAlcoholes());
		this.setSinAlcohol(carta.obtenerSinAlcoholes());
		this.setCafe(carta.obtenerCafes());
		this.bebidas = new ArrayList<Bebida>();
		this.cargarTablas();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vistaPedido.getBtnAgregar()) {

			int tabSelect = this.vistaPedido.getTabbedPane().getSelectedIndex();
			int indice = 0;
			String observaciones = this.vistaPedido.getTxtObservaciones().getText();
			Integer cantidad = (Integer) this.vistaPedido.getSpnCantidad().getValue();

			if (tabSelect >= 0) {

				if (tabSelect == 0) {

					int filaSelect = this.vistaPedido.getTblEntrada().getSelectedRow();

					if (filaSelect >= 0) {

						for (int i = 0; i < this.cantidadSeleccionada; i++) {
							String filin = (String) this.vistaPedido.getTblPedidoSelect().getValueAt(i, 0);
							if (filin.equals("Principales:")) {
								indice = i;
								this.sumarTotal(this.entrada.get(filaSelect).getPrecio(), cantidad);
							}
						}

						Object[] fila = { this.entrada.get(filaSelect).getNombre(), observaciones, cantidad };
						this.vistaPedido.getModelSelect().insertRow(indice, fila);

						cantidadSeleccionada = cantidadSeleccionada + 1;
					}

				} else if (tabSelect == 1) {

					int filaSelect = this.vistaPedido.getTblPrincipal().getSelectedRow();

					if (filaSelect >= 0) {

						for (int i = 0; i < this.cantidadSeleccionada; i++) {
							if (this.vistaPedido.getTblPedidoSelect().getValueAt(i, 0).equals("Postres:")) {
								indice = i;
								this.sumarTotal(this.principal.get(filaSelect).getPrecio(), cantidad);
							}
						}

						Object[] fila = { this.principal.get(filaSelect).getNombre(), observaciones, cantidad };
						this.vistaPedido.getModelSelect().insertRow(indice, fila);

						cantidadSeleccionada = cantidadSeleccionada + 1;

					}

				} else if (tabSelect == 2) {

					int filaSelect = this.vistaPedido.getTblPostres().getSelectedRow();

					if (filaSelect >= 0) {

						for (int i = 0; i < this.cantidadSeleccionada; i++) {
							if (this.vistaPedido.getTblPedidoSelect().getValueAt(i, 0).equals("Bebidas:")) {
								indice = i;
								this.sumarTotal(this.postre.get(filaSelect).getPrecio(), cantidad);
							}
						}

						Object[] fila = { this.postre.get(filaSelect).getNombre(), observaciones, cantidad };
						this.vistaPedido.getModelSelect().insertRow(indice, fila);

						cantidadSeleccionada = cantidadSeleccionada + 1;
					}

				} else if (tabSelect == 3) {

					int filaSelect = this.vistaPedido.getTblBebidas().getSelectedRow();

					if (filaSelect >= 0) {

						for (int i = 0; i < this.cantidadSeleccionada; i++) {
							if (this.vistaPedido.getTblPedidoSelect().getValueAt(i, 0).equals("Menus:")) {
								indice = i;
								this.sumarTotal(this.bebidas.get(filaSelect).getPrecio(), cantidad);
							}
						}

						Object[] fila = { this.bebidas.get(filaSelect).getNombre(), observaciones, cantidad };
						this.vistaPedido.getModelSelect().insertRow(indice, fila);

						cantidadSeleccionada = cantidadSeleccionada + 1;
					}

				} else {

//					int filaSelect = this.vistaPedido.getTblMenu().getSelectedRow();
//
//					if (filaSelect >= 0) {
//						
//						this.sumarTotal(this.menu.get(filaSelect).getPrecio());
//						
//						Object[] fila = { this.entrada.get(filaSelect).getNombre(), observaciones, cantidad };
//						this.vistaPedido.getModelSelect().addRow(fila);
//
//						cantidadSeleccionada = cantidadSeleccionada + 1;
//					}

				}
			}
		}
	}

	public void cargarTablas() {

		Object[] filaE = { "Entradas:" };
		this.vistaPedido.getModelSelect().addRow(filaE);
		Object[] filaP = { "Principales:" };
		this.vistaPedido.getModelSelect().addRow(filaP);
		Object[] filaPo = { "Postres:" };
		this.vistaPedido.getModelSelect().addRow(filaPo);
		Object[] filaB = { "Bebidas:" };
		this.vistaPedido.getModelSelect().addRow(filaB);
		Object[] filaM = { "Menus:" };
		this.vistaPedido.getModelSelect().addRow(filaM);

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

		for (int i = 0; i < this.bebidas.size(); i++) {
			Object[] fila = { this.bebidas.get(i).getNombre(), this.bebidas.get(i).getPrecio().toString() };
			this.vistaPedido.getModelBebidas().addRow(fila);
		}
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
	
	public void sumarTotal(BigDecimal precio, Integer cantidad){
	
		for(int i=0;i<cantidad;i++){
			this.total= total.add(precio);
		}
		this.vistaPedido.getTxfTotal().setText(total.toString());
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
