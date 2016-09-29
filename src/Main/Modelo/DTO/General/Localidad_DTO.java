package Modelo.DTO.General;


public class Localidad_DTO 
{
	private int IdLocalidad;
	private String Descripcion;
	private int CodigoPostal;
	
	public Localidad_DTO(int id, String descripcion, int CP)
	{
		this.IdLocalidad = id;
		this.Descripcion = descripcion;
		this.CodigoPostal = CP;
	}	
	
	public Localidad_DTO()
	{
		
	}	
	
	
	public int getIdLocalidad() {
		return IdLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		IdLocalidad = idLocalidad;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getCodigoPostal() {
		return CodigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		CodigoPostal = codigoPostal;
	}

}
