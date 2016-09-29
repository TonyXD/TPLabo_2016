package Persistencia.DAO.Bebida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.DTO.Bebidas.sinAlcoholDTO;
import Persistencia.Conexion.Conexion;

public class sinAlcoholDAO {

	private static final String insert = "INSERT INTO sinAlcohol(idSinAlcohol, nombre, precio) VALUES(?,?,?)";
	private static final String delete = "DELETE FROM sinAlcohol WHERE idSinAlcohol = ?";
	private static final String readall = "SELECT * FROM sinAlcohol";
	private static final Conexion conexion = Conexion.getConexion();

	public boolean insert(sinAlcoholDTO sinAlcohol) {
		PreparedStatement statement;
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, sinAlcohol.getIdSinAlcohol());
			statement.setString(2, sinAlcohol.getNombre());
			statement.setBigDecimal(3, sinAlcohol.getPrecio());

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

	public boolean delete(sinAlcoholDTO sinAlcohol) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(sinAlcohol.getIdSinAlcohol()));
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

	public List<sinAlcoholDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<sinAlcoholDTO> sinAlcoholes = new ArrayList<sinAlcoholDTO>();

		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				sinAlcoholes.add(new sinAlcoholDTO(resultSet.getInt("idSinAlcohol"), resultSet.getString("nombre"),
						resultSet.getBigDecimal("precio")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return sinAlcoholes;
	}

	public boolean update() {
		return false;
	}
}