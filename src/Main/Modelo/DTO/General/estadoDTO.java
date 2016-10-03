package Modelo.DTO.General;

public class estadoDTO {
	
	private int idEstado;
	private String tipoEstado;
	
	public estadoDTO(int idEstado, String tipoEstado){
		this.setIdEstado(idEstado);
		this.setTipoEstado(tipoEstado);
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(String tipoEstado) {
		this.tipoEstado = tipoEstado;
	}
}
