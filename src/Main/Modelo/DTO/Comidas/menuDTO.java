package Modelo.DTO.Comidas;

import java.math.BigDecimal;
import java.util.ArrayList;

import Modelo.DTO.Bebidas.Bebida;

public class menuDTO {

	private String nombre;
	private BigDecimal precio;

	private ArrayList<entradaDTO> entrada;
	private ArrayList<principalDTO> principal;
	private ArrayList<postreDTO> postre;
	private ArrayList<Bebida> bebidas;

	public menuDTO(String nombre, BigDecimal precio, ArrayList<entradaDTO> entrada, ArrayList<principalDTO> principal,
			ArrayList<postreDTO> postre, ArrayList<Bebida> bebidas) {
		
		this.nombre = nombre;
		this.precio = precio;
		this.entrada = entrada;
		this.principal = principal;
		this.postre = postre;
		this.bebidas = bebidas;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public ArrayList<entradaDTO> getEntrada() {
		return entrada;
	}

	public void setEntrada(ArrayList<entradaDTO> entrada) {
		this.entrada = entrada;
	}

	public ArrayList<principalDTO> getPrincipal() {
		return principal;
	}

	public void setPrincipal(ArrayList<principalDTO> principal) {
		this.principal = principal;
	}

	public ArrayList<postreDTO> getPostre() {
		return postre;
	}

	public void setPostre(ArrayList<postreDTO> postre) {
		this.postre = postre;
	}

	public ArrayList<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(ArrayList<Bebida> bebidas) {
		this.bebidas = bebidas;
	}
}
