package Persistencia.DAO.Bebida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.DTO.Bebidas.conAlcoholDTO;
import Modelo.DTO.Comidas.entradaDTO;
import Persistencia.Conexion.Conexion;

public class conAlcoholDAO {

	private static final String insert = "INSERT INTO conAlcohol(idConAlcohol, nombre, precio) VALUES(?,?,?)";
	private static final String delete = "DELETE FROM conAlcohol WHERE idConAlcohol = ?";
	private static final String update = "UPDATE conAlcohol SET nombre=?, precio=? WHERE idConAlcohol=?";
	private static final String readall = "SELECT * FROM conAlcohol";
	private static final Conexion conexion = Conexion.getConexion();

	public boolean insert(conAlcoholDTO conAlcohol) {
		PreparedStatement statement;
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, conAlcohol.getIdConAlcohol());
			statement.setString(2, conAlcohol.getNombre());
			statement.setBigDecimal(3, conAlcohol.getPrecio());

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

	public boolean delete(conAlcoholDTO conAlcohol) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(conAlcohol.getIdConAlcohol()));
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

	public List<conAlcoholDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<conAlcoholDTO> conAlcoholes = new ArrayList<conAlcoholDTO>();

		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				conAlcoholes.add(new conAlcoholDTO(resultSet.getInt("idConAlcohol"), resultSet.getString("nombre"),
						resultSet.getBigDecimal("precio")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return conAlcoholes;
	}

	public boolean update(conAlcoholDTO conAlcohol) {
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, conAlcohol.getNombre());
			statement.setBigDecimal(2, conAlcohol.getPrecio());
			statement.setInt(3, conAlcohol.getIdConAlcohol());
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