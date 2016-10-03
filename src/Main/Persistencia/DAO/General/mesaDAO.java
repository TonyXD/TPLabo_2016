package Persistencia.DAO.General;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.DTO.General.estadoDTO;
import Modelo.DTO.General.mesaDTO;
import Modelo.DTO.RecursosHumanos.mozoDTO;
import Persistencia.Conexion.Conexion;

public class mesaDAO {

	private static final String insert = "INSERT INTO mesa(idMesa, numero, capacidad, piso, sector, estado) VALUES(?,?,?,?,?,?)";
	private static final String delete = "DELETE FROM mesa WHERE idMesa = ?";
	private static final String readall = "SELECT * FROM mesa";
	private static final String update = "UPDATE mesa SET numero=?, capacidad=?, piso=?, sector=?, estado=? WHERE idMesa=?";
	private static final Conexion conexion = Conexion.getConexion();

	public boolean insert(mesaDTO mesa) {
		PreparedStatement statement;
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, mesa.getIdMesa());
			statement.setInt(2, mesa.getNumero());
			statement.setInt(3, mesa.getCapacidad());
			statement.setInt(4, mesa.getPiso());
			statement.setString(5, mesa.getSector());
			statement.setInt(6, mesa.getEstado().getIdEstado());

			if (statement.executeUpdate() > 0) // Si se ejecuta devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

	public boolean delete(mesaDTO mesa) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(mesa.getIdMesa()));
			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // Si se ejecuta devuelvo true
				return true;
		} catch (SQLException e) {
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

	public List<mesaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<mesaDTO> mesas = new ArrayList<mesaDTO>();

		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				
				estadoDTO estado = dameEstado(resultSet.getInt("estado"));
				
				mesas.add(new mesaDTO(resultSet.getInt("idMesa"),
						resultSet.getInt("numero"),
						resultSet.getInt("capacidad"),
						resultSet.getInt("piso"),
						resultSet.getString("sector"), 
						estado));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return mesas;
	}

	public boolean update(mesaDTO mesa) {
		
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setInt(1, mesa.getNumero());
			statement.setInt(2, mesa.getCapacidad());
			statement.setInt(3, mesa.getPiso());
			statement.setString(4, mesa.getSector());
			statement.setInt(5, mesa.getEstado().getIdEstado());
			statement.setInt(6, mesa.getIdMesa());
			
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}
	
	private estadoDTO dameEstado(int idEstado){
		
		PreparedStatement statement0;
		
		ResultSet resultSet;
		
		estadoDTO estado;
		
		try {
			statement0 = conexion.getSQLConexion().prepareStatement("Select * from estados WHERE idEstado=?");
			statement0.setInt(1, idEstado);
			resultSet = statement0.executeQuery();

			while (resultSet.next()) {
				return estado = new estadoDTO(resultSet.getInt("idEstado"), resultSet.getString("tipoEstado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return null;
	}
}