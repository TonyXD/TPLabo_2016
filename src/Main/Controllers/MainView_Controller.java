package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Negocio.Carta;
import Modelo.Negocio.Pedido;
import Vistas.Encargado.EncargadoMain_View;
import Vistas.Encargado.GestorDeCarta;
import Vistas.Encargado.GestorMesas;
import Vistas.Vistas_AM.ABM_Mesa;

public class MainView_Controller implements ActionListener{

	private EncargadoMain_View vistaEncargado;
	
	private Carta carta;
	private Pedido pedido;
	
	public MainView_Controller(EncargadoMain_View vistaEncargado, Carta carta, Pedido pedido){
		
		this.vistaEncargado = vistaEncargado;
		
		this.vistaEncargado.getBtnVerMesas().addActionListener(this);
		this.vistaEncargado.getBtnVerPedido().addActionListener(this);
		this.vistaEncargado.getBtnVerReserva().addActionListener(this);
		this.vistaEncargado.getBtnVerCarta().addActionListener(this);
		this.vistaEncargado.getBtnVerCocina().addActionListener(this);
		this.vistaEncargado.getBtnVerStock().addActionListener(this);
		
		this.carta = carta;
		this.pedido = pedido;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.vistaEncargado.getBtnVerMesas()) {
			
			GestorMesas vistaMesas = new GestorMesas();
			GestorMesas_Controller controlMesas = new GestorMesas_Controller(vistaMesas, pedido);
			vistaMesas.setVisible(true);
			
		}else if(e.getSource() == this.vistaEncargado.getBtnVerPedido()){
			
			
			
		}else if(e.getSource() == this.vistaEncargado.getBtnVerCarta()){
			
			GestorDeCarta vistaCarta = new GestorDeCarta();
			GestorDeCarta_Controller controlCarta = new GestorDeCarta_Controller(vistaCarta, carta);
			vistaCarta.setVisible(true);
			
		}
			
			
			
		
		
	}

}
