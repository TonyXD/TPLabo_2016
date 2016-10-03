package Persistencia.DAO.Comida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.DTO.Bebidas.Bebida;
import Modelo.DTO.Comidas.entradaDTO;
import Modelo.DTO.Comidas.menuDTO;
import Modelo.DTO.Comidas.postreDTO;
import Modelo.DTO.Comidas.principalDTO;
import Persistencia.Conexion.Conexion;

public class menuDAO {

	private static final String insert = "INSERT INTO menu(idMenu, nombre, precio, entrada, principal, postre, bebidas) VALUES(?,?,?,?,?,?,?)";
	private static final String delete = "DELETE FROM menu WHERE idMenu = ?";
	private static final String update = "UPDATE menu SET nombre=?, precio=?, entrada=?, principal=?, postre=?, bebidas=? WHERE idMenu=?";
	private static final String readall = "SELECT * FROM menu";

	private static final Conexion conexion = Conexion.getConexion();

	public boolean insert(menuDTO menu) {
		PreparedStatement statement;
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, menu.getIdMenu());
			statement.setString(2, menu.getNombre());
			statement.setBigDecimal(3, menu.getPrecio());
			statement.setObject(4, menu.getEntrada());
			statement.setObject(5, menu.getPrincipal());
			statement.setObject(6, menu.getPostre());
			statement.setObject(7, menu.getBebidas());

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

	public boolean delete(menuDTO menu) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(menu.getIdMenu()));
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

	@SuppressWarnings("unchecked")
	public List<menuDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<menuDTO> menus = new ArrayList<menuDTO>();

		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				menus.add(new menuDTO(resultSet.getInt("idMenu"), 
						resultSet.getString("nombre"),
						resultSet.getBigDecimal("precio"), 
						(ArrayList<entradaDTO>) resultSet.getObject("entrada"),
						(ArrayList<principalDTO>) resultSet.getObject("principal"),
						(ArrayList<postreDTO>) resultSet.getObject("postre"),
						(ArrayList<Bebida>) resultSet.getObject("bebidas")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return menus;
	}

	public boolean update(menuDTO menu) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, menu.getNombre());
			statement.setBigDecimal(2, menu.getPrecio());
			statement.setObject(3, menu.getEntrada());
			statement.setObject(4, menu.getPrincipal());
			statement.setObject(5, menu.getPostre());
			statement.setObject(6, menu.getBebidas());
			statement.setInt(7, menu.getIdMenu());
			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // Si se ejecut� devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}
}