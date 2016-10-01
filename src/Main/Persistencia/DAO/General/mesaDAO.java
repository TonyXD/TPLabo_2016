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

	private static final String insert = "INSERT INTO mesa(idMesa, capacidad, mozo, estado) VALUES(?,?,?,?)";
	private static final String delete = "DELETE FROM mesa WHERE idMesa = ?";
	private static final String readall = "SELECT * FROM mesa";
	private static final Conexion conexion = Conexion.getConexion();

	public boolean insert(mesaDTO mesa) {
		PreparedStatement statement;
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, mesa.getIdMesa());
			statement.setInt(2, mesa.getCapacidad());
//			statement.setInt(3, mesa.getMozo().getIdMozo());
			statement.setInt(3, mesa.getEstado().getIdEstado());

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
				mozoDTO mozo = dameMozo(resultSet.getInt("mozo"));
				estadoDTO estado = dameEstado(resultSet.getInt("estado"));
//				mesas.add(new mesaDTO(resultSet.getInt("idMesa"), resultSet.getInt("capacidad"), mozo, estado));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return mesas;
	}

	public boolean update() {
		return false;
	}
	
	private mozoDTO dameMozo(int idMozo){
		return null;
	}
	
	private estadoDTO dameEstado(int idEstado){
		return null;
	}
}