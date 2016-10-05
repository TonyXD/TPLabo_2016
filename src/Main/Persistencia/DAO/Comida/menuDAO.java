package Persistencia.DAO.Comida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.DTO.Bebidas.bebidaDTO;
import Modelo.DTO.Comidas.menuDTO;
import Modelo.DTO.Comidas.platoDTO;
import Persistencia.Conexion.Conexion;

public class menuDAO {

	private static final String insert = "INSERT INTO menu(idMenu, nombre, precio) VALUES(?,?,?)";
	private static final String delete = "DELETE FROM menu WHERE idMenu = ?";
	private static final String update = "UPDATE menu SET nombre=?, precio=?  WHERE idMenu=?";
	private static final String readall = "SELECT * FROM menu";

	private static final Conexion conexion = Conexion.getConexion();

	public boolean insert(menuDTO menu) {

		PreparedStatement statement = null;

		try {

			statement = conexion.getSQLConexion().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

			statement.setInt(1, menu.getIdMenu());
			statement.setString(2, menu.getNombre());
			statement.setDouble(3, menu.getPrecio());

			statement.executeUpdate();

			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {

				long valor = generatedKeys.getLong(1);
				this.insertarPlatos(menu, valor);
				this.insertarBebidas(menu, valor);

			} else {
				throw new SQLException("Creating user failed, no ID obtained.");
			}
			return true;

		} catch (

		SQLException e) {
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

			borrarBebidas(menu);
			borrarPlatos(menu);

			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(menu.getIdMenu()));
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

	@SuppressWarnings("unchecked")
	public List<menuDTO> readAll() {
		PreparedStatement statement;

		ResultSet resultSet; // Guarda el resultado de la query

		ArrayList<menuDTO> menus = new ArrayList<menuDTO>();

		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				ArrayList<platoDTO> platos = damePlatos(resultSet.getInt("idMenu"));
				ArrayList<bebidaDTO> bebidas = dameBebidas(resultSet.getInt("idMenu"));

				menus.add(new menuDTO(resultSet.getInt("idMenu"), resultSet.getString("nombre"),
						resultSet.getDouble("precio"), platos, bebidas));

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
			statement.setObject(2, menu.getPlatos());
			statement.setObject(3, menu.getBebidas());
			statement.setString(4, menu.getNombre());
			statement.setDouble(5, menu.getPrecio());
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

	private void insertarBebidas(menuDTO menu, long id) {

		PreparedStatement statement;

		try {
			for (int i = 0; i < menu.getBebidas().size(); i++) {

				statement = conexion.getSQLConexion()
						.prepareStatement("Insert into menus_bebidas (idMenu, idBebida) VALUES(?,?)");
				statement.setString(1, Long.toString(id));
				statement.setString(2, Integer.toString(menu.getBebidas().get(i).getIdBebida()));

				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}

	}

	private void insertarPlatos(menuDTO menu, long id) {

		PreparedStatement statement;

		try {
			for (int i = 0; i < menu.getPlatos().size(); i++) {

				statement = conexion.getSQLConexion()
						.prepareStatement("Insert into menus_platos (idMenu, idPlato) VALUES(?,?)");
				statement.setString(1, Long.toString(id));
				statement.setString(2, Integer.toString(menu.getPlatos().get(i).getIdPlato()));

				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}

	}

	public ArrayList<bebidaDTO> dameBebidas(int idMenu) {

		PreparedStatement statement0;
		PreparedStatement statement1;

		ResultSet resultSet;
		ResultSet resultSet1;

		ArrayList<bebidaDTO> bebidas = new ArrayList<bebidaDTO>();

		try {
			statement0 = conexion.getSQLConexion().prepareStatement("Select * from menus_bebidas WHERE idMenu=?");
			statement0.setInt(1, idMenu);
			resultSet = statement0.executeQuery();

			while (resultSet.next()) {

				statement1 = conexion.getSQLConexion().prepareStatement("Select * from bebidas WHERE idBebida=?");
				statement1.setInt(1, resultSet.getInt("idBebida"));
				resultSet1 = statement1.executeQuery();

				while (resultSet1.next()) {

					bebidas.add(new bebidaDTO(resultSet1.getInt("idBebida"), resultSet1.getString("nombre"),
							resultSet1.getDouble("precio"), resultSet1.getString("tipo")));

				}

			}

			return bebidas;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return null;

	}

	public ArrayList<platoDTO> damePlatos(int idMenu) {
		PreparedStatement statement0;
		PreparedStatement statement1;

		ResultSet resultSet;
		ResultSet resultSet1;

		ArrayList<platoDTO> platos = new ArrayList<platoDTO>();

		try {
			statement0 = conexion.getSQLConexion().prepareStatement("Select * from menus_platos WHERE idMenu=?");
			statement0.setInt(1, idMenu);
			resultSet = statement0.executeQuery();

			while (resultSet.next()) {

				statement1 = conexion.getSQLConexion().prepareStatement("Select * from platos WHERE idPlato=?");
				statement1.setInt(1, resultSet.getInt("idPlato"));
				resultSet1 = statement1.executeQuery();

				while (resultSet1.next()) {

					platos.add(new platoDTO(resultSet1.getInt("idPlato"), resultSet1.getString("nombre"),
							resultSet1.getDouble("precio"), resultSet1.getString("tipo")));

				}

			}

			return platos;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return null;
	}

	public void borrarBebidas(menuDTO menu) {

		PreparedStatement statement0;
		PreparedStatement statement1;
		ResultSet resultSet;

		try {
			statement0 = conexion.getSQLConexion().prepareStatement("Select * from menus_bebidas WHERE idMenu=?");
			statement0.setInt(1, menu.getIdMenu());
			resultSet = statement0.executeQuery();

			while (resultSet.next()) {

				statement1 = conexion.getSQLConexion().prepareStatement("DELETE from menus_bebidas WHERE idMenu=?");
				statement1.setInt(1, menu.getIdMenu());
				statement1.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
	}

	public void borrarPlatos(menuDTO menu) {
		
		PreparedStatement statement0;
		PreparedStatement statement1;
		ResultSet resultSet;

		try {
			statement0 = conexion.getSQLConexion().prepareStatement("Select * from menus_platos WHERE idMenu=?");
			statement0.setInt(1, menu.getIdMenu());
			resultSet = statement0.executeQuery();

			while (resultSet.next()) {

				statement1 = conexion.getSQLConexion().prepareStatement("DELETE from menus_platos WHERE idMenu=?");
				statement1.setInt(1, menu.getIdMenu());
				statement1.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
	}
}