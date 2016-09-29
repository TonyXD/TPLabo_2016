package Modelo.DTO.Comidas;

import java.math.BigDecimal;

public class postreDTO extends Plato {

	private int idPostre;

	public postreDTO(int idPostre, String nombre, BigDecimal precio) {
		super(nombre, precio);

		this.setIdPostre(idPostre);
	}

	public int getIdPostre() {
		return idPostre;
	}

	public void setIdPostre(int idPostre) {
		this.idPostre = idPostre;
	}
}