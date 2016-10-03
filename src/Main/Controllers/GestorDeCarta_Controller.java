package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Modelo.DTO.Bebidas.bebidaDTO;
import Modelo.DTO.Comidas.platoDTO;
import Modelo.Negocio.Carta;
import Vistas.Encargado.GestorDeCarta;
import Vistas.Vistas_AM.ABM_Bebida;
import Vistas.Vistas_AM.ABM_Menus;
import Vistas.Vistas_AM.ABM_Plato;
import Vistas.Vistas_AM.Alta_Menu;

public class GestorDeCarta_Controller implements ActionListener {
	
	private List<platoDTO> platos;
	private List<bebidaDTO> bebidas;
 
	private GestorDeCarta vistaCarta;
	private Carta carta;

	public GestorDeCarta_Controller(GestorDeCarta vistaCarta, Carta carta) {

		this.vistaCarta = vistaCarta;
		this.carta = carta;

		this.vistaCarta.getBtnGestionarPlatos().addActionListener(this);
		this.vistaCarta.getBtnGestionarBebida().addActionListener(this);
		this.vistaCarta.getBtnGestionarMenu().addActionListener(this);

		this.inicializar();
	}

	public void inicializar() {

		
		this.platos = carta.obtenerPlatos();
		this.bebidas = carta.obtenerBebidas();
		
		this.cargarTablas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.vistaCarta.getBtnGestionarPlatos()) {

			ABM_Plato vistaPlato = new ABM_Plato(this);
			ABM_Plato_Controller controlPlato = new ABM_Plato_Controller(vistaPlato, carta);
			controlPlato.inicializar();
			vistaPlato.setVisible(true);
			this.vistaCarta.setEnabled(false);

		} else if (e.getSource() == this.vistaCarta.getBtnGestionarBebida()) {

			ABM_Bebida vistaBebida = new ABM_Bebida(this);
			ABM_Bebida_Controller controlBebida = new ABM_Bebida_Controller(vistaBebida, carta);
			controlBebida.inicializar();
			vistaBebida.setVisible(true);
			this.vistaCarta.setEnabled(false);

		} else if (e.getSource() == this.vistaCarta.getBtnGestionarMenu()) {
			
			ABM_Menus adminMenu = new ABM_Menus(this);
			ABM_Menu_Controller controlAbmMenu = new ABM_Menu_Controller(adminMenu, carta);
			controlAbmMenu.inicializar();
			adminMenu.setVisible(true);
			this.vistaCarta.setEnabled(false);
			
		}

	}

	public void cargarTablas() {

		this.reiniciarTablas();

		for (int i = 0; i < this.platos.size(); i++) {
			
			if(this.platos.get(i).getTipo().equals("Entrada")){
				
				Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio().toString() };
				this.vistaCarta.getModelEntrada().addRow(fila);
			}else if(this.platos.get(i).getTipo().equals("Principal")){
				
				Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio().toString() };
				this.vistaCarta.getModelPrincipal().addRow(fila);
				
			}else{
				
				Object[] fila = { this.platos.get(i).getNombre(), this.platos.get(i).getPrecio().toString() };
				this.vistaCarta.getModelPostre().addRow(fila);
				
			}
			
		}

		for (int i = 0; i < this.bebidas.size(); i++) {

			if(this.bebidas.get(i).getTipo().equals("Con Alcohol")){
				
				Object[] fila = { this.bebidas.get(i).getNombre(), this.bebidas.get(i).getPrecio() };
				this.vistaCarta.getModelConAlcohol().addRow(fila);
				
			}if(this.bebidas.get(i).getTipo().equals("Con Alcohol")){
				
				Object[] fila = { this.bebidas.get(i).getNombre(), this.bebidas.get(i).getPrecio() };
				this.vistaCarta.getModelSinAlcohol().addRow(fila);
				
			}else{
				
				Object[] fila = { this.bebidas.get(i).getNombre(), this.bebidas.get(i).getPrecio() };
				this.vistaCarta.getModelCafe().addRow(fila);
			}
		}
	}

	public void reiniciarTablas() {

		this.vistaCarta.getModelEntrada().setRowCount(0);
		this.vistaCarta.getModelEntrada().setColumnCount(0);
		this.vistaCarta.getModelEntrada().setColumnIdentifiers(this.vistaCarta.getNombreColumnas());
		this.vistaCarta.getModelPrincipal().setRowCount(0);
		this.vistaCarta.getModelPrincipal().setColumnCount(0);
		this.vistaCarta.getModelPrincipal().setColumnIdentifiers(this.vistaCarta.getNombreColumnas());
		this.vistaCarta.getModelPostre().setRowCount(0);
		this.vistaCarta.getModelPostre().setColumnCount(0);
		this.vistaCarta.getModelPostre().setColumnIdentifiers(this.vistaCarta.getNombreColumnas());
		this.vistaCarta.getModelConAlcohol().setRowCount(0);
		this.vistaCarta.getModelConAlcohol().setColumnCount(0);
		this.vistaCarta.getModelConAlcohol().setColumnIdentifiers(this.vistaCarta.getNombreColumnas());
		this.vistaCarta.getModelSinAlcohol().setRowCount(0);
		this.vistaCarta.getModelSinAlcohol().setColumnCount(0);
		this.vistaCarta.getModelSinAlcohol().setColumnIdentifiers(this.vistaCarta.getNombreColumnas());
		this.vistaCarta.getModelCafe().setRowCount(0);
		this.vistaCarta.getModelCafe().setColumnCount(0);
		this.vistaCarta.getModelCafe().setColumnIdentifiers(this.vistaCarta.getNombreColumnas());
		this.vistaCarta.getModelMenu().setRowCount(0);
		this.vistaCarta.getModelMenu().setColumnCount(0);
		this.vistaCarta.getModelMenu().setColumnIdentifiers(this.vistaCarta.getNombreColumnas());
	}

	public GestorDeCarta getVistaCarta() {
		return vistaCarta;
	}

	public void setVistaCarta(GestorDeCarta vistaCarta) {
		this.vistaCarta = vistaCarta;
	}

	public List<platoDTO> getPlatos() {
		return platos;
	}

	public void setPlatos(List<platoDTO> platos) {
		this.platos = platos;
	}

	public List<bebidaDTO> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<bebidaDTO> bebidas) {
		this.bebidas = bebidas;
	}

}
