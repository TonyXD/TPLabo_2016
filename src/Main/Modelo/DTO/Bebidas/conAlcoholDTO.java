package Modelo.DTO.Bebidas;

import java.math.BigDecimal;

public class conAlcoholDTO extends Bebida {
	
	private int idConAlcohol;
	
	public conAlcoholDTO(int idConAlcohol, String nombre, BigDecimal precio) {
		super(nombre, precio);
		
		this.idConAlcohol = idConAlcohol;
		
	}
	
	public int getIdConAlcohol() {
		return idConAlcohol;
	}

	public void setIdConAlcohol(int idConAlcohol) {
		this.idConAlcohol = idConAlcohol;
	}
}
