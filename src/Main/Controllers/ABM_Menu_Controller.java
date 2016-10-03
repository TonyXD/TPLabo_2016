package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Modelo.DTO.Comidas.menuDTO;
import Modelo.Negocio.Carta;
import Vistas.Vistas_AM.ABM_Menus;
import Vistas.Vistas_AM.Alta_Menu;

public class ABM_Menu_Controller implements ActionListener {

	private ABM_Menus vistaMenus;

	private List<menuDTO> menus;

	private Carta carta;

	public ABM_Menu_Controller(ABM_Menus vistaMenus, Carta carta) {
		this.vistaMenus = vistaMenus;
		this.carta = carta;

		this.vistaMenus.getBtnAgregar().addActionListener(this);
		this.vistaMenus.getBtnEliminar().addActionListener(this);
		this.vistaMenus.getBtnEditar().addActionListener(this);
	
	}

	public void inicializar() {

		this.setMenus(carta.obtenermenus());
		this.cargarTablas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vistaMenus.getBtnAgregar()) {

			Alta_Menu vistaMenu = new Alta_Menu(this);
			Alta_Menu_Controller controlMenu = new Alta_Menu_Controller(vistaMenu, carta);
			controlMenu.inicializar();
			vistaMenu.setVisible(true);
			this.vistaMenus.setEnabled(false);
			

		} else if (e.getSource() == this.vistaMenus.getBtnEditar()) {

			this.editarMenu();

		} else if (e.getSource() == this.vistaMenus.getBtnEliminar()) {

			this.borrarMenu();
		}
	}

	public void cargarTablas() {
		
		this.vistaMenus.getModelMenus().setRowCount(0);
		this.vistaMenus.getModelMenus().setColumnCount(0);
		this.vistaMenus.getModelMenus().setColumnIdentifiers(this.vistaMenus.getNombreColumnas());

		for (int i = 0; i < this.menus.size(); i++) {

			Object[] fila = { this.menus.get(i).getNombre(), this.menus.get(i).getPrecio().toString() };
			this.vistaMenus.getModelMenus().addRow(fila);
		}
	}

	public void borrarMenu() {
		
		int filaSeleccion = this.vistaMenus.getTblMenu().getSelectedRow();
		
		if(filaSeleccion>=0){
		
			this.carta.borrarMenu((this.menus.get(filaSeleccion)));
			this.menus.remove(this.menus.get(filaSeleccion));
			this.cargarTablas();
		}
	}

	public void editarMenu() {

	}

	public List<menuDTO> getMenus() {
		return menus;
	}

	public void setMenus(List<menuDTO> menus) {
		this.menus = menus;
	}

	public ABM_Menus getVistaMenus() {
		return vistaMenus;
	}

	public void setVistaMenus(ABM_Menus vistaMenus) {
		this.vistaMenus = vistaMenus;
	}
}
