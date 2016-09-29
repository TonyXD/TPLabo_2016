package Persistencia.DAO.Comida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.DTO.Comidas.principalDTO;
import Persistencia.Conexion.Conexion;

public class principalDAO {

	private static final String insert = "INSERT INTO principal(idPrincipal, nombre, precio) VALUES(?,?,?)";
	private static final String delete = "DELETE FROM principal WHERE idPrincipal = ?";
	private static final String readall = "SELECT * FROM principal";
	private static final Conexion conexion = Conexion.getConexion();

	public boolean insert(principalDTO principal) {
		PreparedStatement statement;
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, principal.getIdPrincipal());
			statement.setString(2, principal.getNombre());
			statement.setBigDecimal(3, principal.getPrecio());

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

	public boolean delete(principalDTO principal) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(principal.getIdPrincipal()));
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

	public List<principalDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<principalDTO> principales = new ArrayList<principalDTO>();

		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				principales.add(new principalDTO(resultSet.getInt("idPrincipal"), resultSet.getString("nombre"),
						resultSet.getBigDecimal("precio")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return principales;
	}

	public boolean update() {
		return false;
	}
}