package MainClass;

import Controllers.AM_Plato_Controller;
import Controllers.TomaDePedido_Controller;
import Modelo.Negocio.Carta;
import Modelo.Negocio.Pedido;
import Vistas.Encargado.TomaDePedido;
import Vistas.Vistas_AM.AM_Plato;

public class MainClass {

	public static void main(String[] args) {

//		AM_Plato vistaPlatos = new AM_Plato();
//		Carta carta = new Carta();
//		AM_Plato_Controller control = new AM_Plato_Controller(vistaPlatos, carta);
//		control.inicializar();
//		
//		vistaPlatos.setVisible(true);
		
		TomaDePedido vistaPedido = new TomaDePedido();
		Carta carta = new Carta();
		Pedido pedido = new Pedido();
		TomaDePedido_Controller control = new TomaDePedido_Controller(vistaPedido,pedido,carta);
//		control.inicializar();
		
		vistaPedido.setVisible(true);

	}

}
