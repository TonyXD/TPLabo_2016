package MainClass;

import Controllers.ABM_Menu_Controller;
import Modelo.Negocio.Carta;
import Vistas.Vistas_AM.ABM_Menu;

public class MainMenu {

	public static void main(String[] args) {
		
		ABM_Menu vistaMenus = new ABM_Menu();
		Carta carta = new Carta();
		ABM_Menu_Controller control = new ABM_Menu_Controller(vistaMenus, carta);
		
		vistaMenus.setVisible(true);

	}

}
