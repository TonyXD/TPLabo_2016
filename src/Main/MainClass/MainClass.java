package MainClass;

import java.math.BigDecimal;

import Controllers.AM_Plato_Controller;
import Controllers.TomaDePedido_Controller;
import Modelo.DTO.Bebidas.cafeDTO;
import Modelo.DTO.Bebidas.conAlcoholDTO;
import Modelo.DTO.Bebidas.sinAlcoholDTO;
import Modelo.Negocio.Carta;
import Modelo.Negocio.Pedido;
import Vistas.Encargado.TomaDePedido;
import Vistas.Vistas_AM.ABM_Plato;

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
		
//		conAlcoholDTO x = new conAlcoholDTO(0,"vino",new BigDecimal(10));
//		conAlcoholDTO a = new conAlcoholDTO(0,"vino",new BigDecimal(10));
//		sinAlcoholDTO b = new sinAlcoholDTO(0,"vino",new BigDecimal(10));
//		sinAlcoholDTO c = new sinAlcoholDTO(0,"vino",new BigDecimal(10));
//		cafeDTO d = new cafeDTO(0,"vino",new BigDecimal(10));
		
//		carta.agregarConAlcohol(x);
//		carta.agregarConAlcohol(a);
//		carta.agregarSinAlcohol(b);
//		carta.agregarSinAlcohol(c);
//		carta.agregarCafe(d);
//		
		TomaDePedido_Controller control = new TomaDePedido_Controller(vistaPedido,pedido,carta);
//		control.inicializar();
		
		vistaPedido.setVisible(true);
		
		

	}

}
