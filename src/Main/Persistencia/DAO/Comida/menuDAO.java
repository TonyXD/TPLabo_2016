package Persistencia.DAO.Comida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.DTO.Bebidas.bebidaDTO;
import Modelo.DTO.Comidas.menuDTO;
import Modelo.DTO.Comidas.platoDTO;
import Persistencia.Conexion.Conexion;

public class menuDAO {

	private static final String insert = "INSERT INTO menu(idMenu, nombreMenu, precioMenu) VALUES(?,?,?)";
	private static final String insertPlatosBebidas = "INSERT INTO menus_platos_bebida(idMenu, idPlato, idBebida) VALUES (?,?,?)";
	private static final String delete = "DELETE FROM menu WHERE idMenu = ?";
	private static final String update = "UPDATE menu SET idPlato=?, idBebida=?, nombreMenu=?, precioMenu=?  WHERE idMenu=?";
	private static final String readall = "SELECT * FROM menu";
	private static final String readallPlatosBebidas = "SELECT * FROM menu, menus_platos_bebidas, platos, bebidas WHERE idMenu=menus_platos_bebidas.idMenu";

	private static final Conexion conexion = Conexion.getConexion();

	public boolean insert(menuDTO menu) {
		PreparedStatement statement;
		PreparedStatement statementPlatosBebidas;

		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statementPlatosBebidas = conexion.getSQLConexion().prepareStatement(insertPlatosBebidas);

			statement.setInt(1, menu.getIdMenu());

			for (int i = 0; i < menu.getPlatos().size(); i++) {
				statementPlatosBebidas.setInt(i + 1, menu.getIdMenu());
				statementPlatosBebidas.setInt(i + 1, menu.getPlatos().get(i).getIdPlato());
			}

			for (int i = 0; i < menu.getBebidas().size(); i++) {
				statementPlatosBebidas.setInt(i + 1, menu.getIdMenu());
				statementPlatosBebidas.setInt(i + 1, menu.getBebidas().get(i).getIdBebida());
			}

			statement.setString(2, menu.getNombre());
			statement.setDouble(3, menu.getPrecio());

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
		PreparedStatement statementPlatosBebidas;
		ResultSet resultSet; // Guarda el resultado de la query
		ResultSet resultSetPlatosBebidas;

		ArrayList<menuDTO> menus = new ArrayList<menuDTO>();
		ArrayList<platoDTO> platos = new ArrayList<platoDTO>();
		ArrayList<bebidaDTO> bebidas = new ArrayList<bebidaDTO>();

		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statementPlatosBebidas = conexion.getSQLConexion().prepareStatement(readallPlatosBebidas);

			resultSet = statement.executeQuery();
			resultSetPlatosBebidas = statementPlatosBebidas.executeQuery();

			while (resultSetPlatosBebidas.next()) {
				for (int i = 0; i < menus.size(); i++) {
					platos.add(new platoDTO(resultSetPlatosBebidas.getInt("idPlato"),
							resultSetPlatosBebidas.getString("nombrePlato"),
							resultSetPlatosBebidas.getDouble("precioPlato"),
							resultSetPlatosBebidas.getString("tipoPlato")));

					bebidas.add(new bebidaDTO(resultSetPlatosBebidas.getInt("idBebida"),
							resultSetPlatosBebidas.getString("nombreBebida"),
							resultSetPlatosBebidas.getDouble("precioBebida"),
							resultSetPlatosBebidas.getString("tipoBebida")));
				}
			}

			while (resultSet.next()) {

				menus.add(new menuDTO(resultSet.getInt("idMenu"), resultSet.getString("nombreMenu"),
						resultSet.getDouble("precioMenu"), platos, bebidas));
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
}