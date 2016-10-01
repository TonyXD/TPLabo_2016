package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Negocio.Pedido;
import Vistas.Encargado.GestorMesas;

public class GestorMesas_Controller implements ActionListener {
	
	private GestorMesas vistaMesas;
	private Pedido pedido;
	
	public GestorMesas_Controller(GestorMesas vistaMesas, Pedido pedido){
		this.setVistaMesas(vistaMesas);
		this.setPedido(pedido);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public GestorMesas getVistaMesas() {
		return vistaMesas;
	}

	public void setVistaMesas(GestorMesas vistaMesas) {
		this.vistaMesas = vistaMesas;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
