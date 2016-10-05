package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Negocio.Carta;
import Modelo.Negocio.Pedido;
import Modelo.Negocio.Restorant;
import Vistas.Encargado.EncargadoMain_View;
import Vistas.Encargado.GestorDeCarta;
import Vistas.Encargado.GestorPedidos;
import Vistas.Vistas_AM.ABM_Mesa;

public class MainView_Controller implements ActionListener{

	private EncargadoMain_View vistaEncargado;
	
	private Carta carta;
	private Pedido pedido;
	private Restorant resto;
	
	public MainView_Controller(EncargadoMain_View vistaEncargado, Carta carta, Pedido pedido, Restorant resto){
		
		this.vistaEncargado = vistaEncargado;
		
		this.vistaEncargado.getBtnVerMesas().addActionListener(this);
		this.vistaEncargado.getBtnVerPedido().addActionListener(this);
		this.vistaEncargado.getBtnVerReserva().addActionListener(this);
		this.vistaEncargado.getBtnVerCarta().addActionListener(this);
		this.vistaEncargado.getBtnVerCocina().addActionListener(this);
		this.vistaEncargado.getBtnVerStock().addActionListener(this);
		
		this.carta = carta;
		this.pedido = pedido;
		this.resto = resto;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.vistaEncargado.getBtnVerMesas()) {
			
			ABM_Mesa vistaMesas = new ABM_Mesa();
			ABM_Mesa_Controller controlMesas = new ABM_Mesa_Controller(vistaMesas, resto);
			vistaMesas.setVisible(true);
			
		}else if(e.getSource() == this.vistaEncargado.getBtnVerPedido()){
			
			GestorPedidos vistaPedido = new GestorPedidos();
			GestorPedidos_Controller controlPedido = new GestorPedidos_Controller(vistaPedido, pedido, resto, carta);
			vistaPedido.setVisible(true);
			
		}else if(e.getSource() == this.vistaEncargado.getBtnVerCarta()){
			
			GestorDeCarta vistaCarta = new GestorDeCarta();
			GestorDeCarta_Controller controlCarta = new GestorDeCarta_Controller(vistaCarta, carta);
			vistaCarta.setVisible(true);
			
		}
			
			
			
		
		
	}

}
