package MainClass;

import Controllers.MainView_Controller;
import Modelo.Negocio.Carta;
import Modelo.Negocio.Pedido;
import Vistas.Encargado.EncargadoMain_View;

public class MainView {
	
	public static void main(String[] args) {
		
		Carta carta = new Carta();
		Pedido pedido = new Pedido();
		
		EncargadoMain_View vistaEncargado = new EncargadoMain_View();
		MainView_Controller control = new MainView_Controller(vistaEncargado, carta, pedido);
		vistaEncargado.setVisible(true);
	}
}
