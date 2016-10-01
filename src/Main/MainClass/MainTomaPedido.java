package MainClass;

import Controllers.TomaDePedido_Controller;
import Modelo.Negocio.Carta;
import Modelo.Negocio.Pedido;
import Vistas.Encargado.TomaDePedido;

public class MainTomaPedido {

	public static void main(String[] args) {

		TomaDePedido vistaPedido = new TomaDePedido();

		Carta carta = new Carta();
		Pedido pedido = new Pedido();

		TomaDePedido_Controller control = new TomaDePedido_Controller(vistaPedido, pedido, carta);

		vistaPedido.setVisible(true);
	}
}
