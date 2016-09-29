package MainClass;

import Controllers.AM_Plato_Controller;
import Modelo.Negocio.Carta;
import Vistas.Vistas_AM.AM_Plato;

public class MainClass {

	public static void main(String[] args) {
		
//		Conec
		
		AM_Plato vistaPlatos = new AM_Plato();
		Carta carta = new Carta();
		AM_Plato_Controller control = new AM_Plato_Controller(vistaPlatos, carta);
		control.inicializar();
		
		vistaPlatos.setVisible(true);
		

	}

}
