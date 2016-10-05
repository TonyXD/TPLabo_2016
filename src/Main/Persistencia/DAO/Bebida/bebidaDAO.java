package Persistencia.DAO.Bebida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.DTO.Bebidas.bebidaDTO;
import Persistencia.Conexion.Conexion;

public class bebidaDAO {

	private static final String insert = "INSERT INTO bebidas(idBebida, nombre, precio, tipo) VALUES(?,?,?,?)";
	private static final String delete = "DELETE FROM bebidas WHERE idBebida = ?";
	private static final String update = "UPDATE bebidas SET nombre=?, precio=?, tipo=? WHERE idBebida=?";
	private static final String readall = "SELECT * FROM bebidas";
	private static final Conexion conexion = Conexion.getConexion();
	
	
	public boolean insert(bebidaDTO bebida) {
		PreparedStatement statement;
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, bebida.getIdBebida());
			statement.setString(2, bebida.getNombre());
			statement.setDouble(3, bebida.getPrecio());
			statement.setString(4, bebida.getTipo());

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

	public boolean delete(bebidaDTO bebida) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(bebida.getIdBebida()));
			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // Si se ejecuta devuelvo true
				return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

	public List<bebidaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<bebidaDTO> bebidas = new ArrayList<bebidaDTO>();

		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				bebidas.add(new bebidaDTO(resultSet.getInt("idBebida"), 
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
		return bebidas;
	}
	
	public boolean update(bebidaDTO bebida) {
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, bebida.getNombre());
			statement.setDouble(2, bebida.getPrecio());
			statement.setString(3, bebida.getTipo());
			statement.setInt(4, bebida.getIdBebida());
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