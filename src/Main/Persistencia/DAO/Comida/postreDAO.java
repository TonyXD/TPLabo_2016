package Persistencia.DAO.Comida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.DTO.Comidas.entradaDTO;
import Modelo.DTO.Comidas.postreDTO;
import Persistencia.Conexion.Conexion;

public class postreDAO {

	private static final String insert = "INSERT INTO postre(idPostre, nombre, precio) VALUES(?,?,?)";
	private static final String delete = "DELETE FROM postre WHERE idPostre = ?";
	private static final String update = "UPDATE postre SET nombre=?, precio=? WHERE idPostre=?";
	private static final String readall = "SELECT * FROM postre";
	private static final Conexion conexion = Conexion.getConexion();

	public boolean insert(postreDTO postre) {
		PreparedStatement statement;
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, postre.getIdPostre());
			statement.setString(2, postre.getNombre());
			statement.setBigDecimal(3, postre.getPrecio());

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

	public boolean delete(postreDTO postre) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(postre.getIdPostre()));
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

	public List<postreDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<postreDTO> postres = new ArrayList<postreDTO>();

		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				postres.add(new postreDTO(resultSet.getInt("idPostre"), resultSet.getString("nombre"),
						resultSet.getBigDecimal("precio")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return postres;
	}

	public boolean update(postreDTO postre) {
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, postre.getNombre());
			statement.setBigDecimal(2, postre.getPrecio());
			statement.setInt(3, postre.getIdPostre());
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