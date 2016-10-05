package Persistencia.DAO.Comida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.DTO.Comidas.platoDTO;
import Persistencia.Conexion.Conexion;

public class platoDAO {

	private static final String insert = "INSERT INTO platos(idPlato, nombre, precio, tipo) VALUES(?,?,?,?)";
	private static final String delete = "DELETE FROM platos WHERE idPlato = ?";
	private static final String update = "UPDATE platos SET nombre=?, precio=?, tipo=? WHERE idPlato=?";
	private static final String readall = "SELECT * FROM platos";
	private static final Conexion conexion = Conexion.getConexion();
	
	
	public boolean insert(platoDTO plato) {
		PreparedStatement statement;
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, plato.getIdPlato());
			statement.setString(2, plato.getNombre());
			statement.setDouble(3, plato.getPrecio());
			statement.setString(4, plato.getTipo());

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

	public boolean delete(platoDTO plato) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(plato.getIdPlato()));
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

	public List<platoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<platoDTO> platos = new ArrayList<platoDTO>();

		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				platos.add(new platoDTO(resultSet.getInt("idPlato"), 
						resultSet.getString("nombre"),
						resultSet.getDouble("precio"),
						resultSet.getString("tipo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return platos;
	}
	
	public boolean update(platoDTO plato) {
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, plato.getNombre());
			statement.setDouble(2, plato.getPrecio());
			statement.setString(3, plato.getTipo());
			statement.setInt(4, plato.getIdPlato());
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
}