package MainClass;

import Controllers.ABM_Plato_Controller;
import Modelo.Negocio.Carta;
import Vistas.Vistas_AM.ABM_Plato;

public class MainABMPlato {

	public static void main(String[] args) {

		ABM_Plato vistaPlatos = new ABM_Plato();
		Carta carta = new Carta();
		ABM_Plato_Controller control = new ABM_Plato_Controller(vistaPlatos, carta);
		control.inicializar();
		
		vistaPlatos.setVisible(true);
			
	}

}
