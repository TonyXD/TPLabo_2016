package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Modelo.DTO.General.estadoDTO;
import Modelo.DTO.General.mesaDTO;
import Modelo.Negocio.Restorant;
import Vistas.Vistas_AM.ABM_Mesa;

public class ABM_Mesa_Controller implements ActionListener {

	ABM_Mesa vistaMesas;
	Restorant resto;
	List<mesaDTO> mesas;

	public ABM_Mesa_Controller(ABM_Mesa vistaMesas, Restorant resto) {
		this.vistaMesas = vistaMesas;
		this.resto = resto;

		inicializar();

	}

	public void inicializar() {

		this.mesas = resto.obtenerMesas();
		cargarTabla();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vistaMesas.getBtnAgregar()) {

			this.agregarMesa();

		} else if (e.getSource() == this.vistaMesas.getBtnEditar()) {
			
			this.editarMesa();
			
		} else if (e.getSource() == this.vistaMesas.getBtnEliminar()) {
			
			this.borrarMesa();
			
		}

	}

	public void agregarMesa(){
		
		int numero =  Integer.parseInt(this.vistaMesas.getTxtNumero().getText());
		int capacidad = (int) this.vistaMesas.getSpnCapacidad().getValue();
		int piso = (int) this.vistaMesas.getSpnPiso().getValue();
		String sector = this.vistaMesas.getTxfSector().getText();
		estadoDTO estado = new estadoDTO(0, "Libre");
		mesaDTO mesa = new mesaDTO(0, numero, capacidad, piso ,sector, estado);
		
		resto.agregarMesa(mesa);
		this.mesas.add(mesa);
		this.cargarTabla();
	}

	public void cargarTabla(){
		
	}

	public void borrarMesa() {

		int filaSeleccion = this.vistaMesas.getTable().getSelectedRow();

		if (filaSeleccion >= 0) {

			this.resto.borrarMesa(this.mesas.get(filaSeleccion));
			this.mesas.remove(this.mesas.get(filaSeleccion));
			this.cargarTabla();
		}
	}
	
	public void editarMesa(){
		
		int numero =  Integer.parseInt(this.vistaMesas.getTxfNumeroEd().getText());
		int capacidad = (int) this.vistaMesas.getSpnCapacidadEd().getValue();
		int piso = (int) this.vistaMesas.getSpnPisoEd().getValue();
		String sector = this.vistaMesas.getTxfSectorEd().getText();
		estadoDTO estado = new estadoDTO(0, "Libre");
		mesaDTO mesa = new mesaDTO(0, numero, capacidad, piso ,sector, estado);
		
		resto.editarMesa(mesa);
		this.mesas = resto.obtenerMesas();
		this.cargarTabla();
		
	}

}
