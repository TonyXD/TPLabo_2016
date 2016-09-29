package Modelo.DTO;

import java.util.List;

import Modelo.DTO.General.Localidad_DTO;
import Persistencia.DAO.Localidad_DAO;

public class Localidad {

private Localidad_DAO localidad; 
	
	public Localidad()
	{
		this.localidad = new Localidad_DAO();
	}
	
	public List<Localidad_DTO> BuscarLocalidades()
	{
		return localidad.readAll();		
	}
	
	public void insertLocalidad(Localidad_DTO agregarLocalidad)
	{
		localidad.insert(agregarLocalidad);
	}
	
	public void updateLocalidad(Localidad_DTO editarLocalidad) {
		localidad.update(editarLocalidad);
	}


	public int findIdLocalidadByDescrip(String localidad) {

		int idLocalidad = this.localidad.findByDescrip(localidad).getIdLocalidad() ;
		return idLocalidad;
	}

	public boolean findIfLocalidadIsAssing(int localidad) {
		
		return this.localidad.findIfLocalidadIsAssing(localidad);
	}

	public void borrarLocalidad(Localidad_DTO localidadDTO) {
		this.localidad.borrarLocalidad(localidadDTO);
	}
	
}
