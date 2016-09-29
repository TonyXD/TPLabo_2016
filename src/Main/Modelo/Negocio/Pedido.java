package Modelo.Negocio;

import java.util.List;

import Modelo.DTO.General.pedidoDTO;
import Persistencia.DAO.General.pedidoDAO;

public class Pedido {

	private pedidoDAO pedido;
	
	public Pedido(){
		this.setPedido(new pedidoDAO());
	}
	
	public void agregarPedido(pedidoDTO x) {
		this.pedido.insert(x);
	}
	
	public void borrarPedido(pedidoDTO x) {
		this.pedido.delete(x);
	}
	
	public List<pedidoDTO> obtenerPedidos() {
		return this.pedido.readAll();
	}
	
	public pedidoDAO getPedido() {
		return pedido;
	}

	public void setPedido(pedidoDAO pedido) {
		this.pedido = pedido;
	}
}
