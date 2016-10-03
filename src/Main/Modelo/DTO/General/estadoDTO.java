package Modelo.DTO.General;

public class estadoDTO {
	
	private int idEstado;
	private String Descripcion;
	private boolean esMesa;
	private boolean esMozo;
	private boolean esPedido;
	
	public estadoDTO(int idEstado, String descripcion, boolean esMesa, boolean esMozo, boolean esPedido){
		this.setIdEstado(idEstado);
		this.setDescripcion(descripcion);
		this.esMesa = esMesa;
		this.esMozo = esMozo;
		this.esPedido = esPedido;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public boolean isEsMesa() {
		return esMesa;
	}

	public void setEsMesa(boolean esMesa) {
		this.esMesa = esMesa;
	}

	public boolean isEsMozo() {
		return esMozo;
	}

	public void setEsMozo(boolean esMozo) {
		this.esMozo = esMozo;
	}

	public boolean isEsPedido() {
		return esPedido;
	}

	public void setEsPedido(boolean esPedido) {
		this.esPedido = esPedido;
	}
}
