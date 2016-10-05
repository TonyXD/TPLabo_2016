package Persistencia.DAO.General;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.DTO.Bebidas.bebidaDTO;
import Modelo.DTO.Comidas.menuDTO;
import Modelo.DTO.Comidas.platoDTO;
import Modelo.DTO.General.estadoDTO;
import Modelo.DTO.General.mesaDTO;
import Modelo.DTO.General.pedidoDTO;
import Modelo.DTO.RecursosHumanos.mozoDTO;
import Persistencia.Conexion.Conexion;
import Persistencia.DAO.Comida.menuDAO;

public class pedidoDAO {

	private static final String insert = "INSERT INTO pedidos (idPedido, idEstado, fecha ) VALUES(?,?,?)";
	private static final String delete = "DELETE FROM pedidos WHERE idPedido = ?";
	private static final String readall = "SELECT * FROM pedidos";
	private static final Conexion conexion = Conexion.getConexion();

	public boolean insert(pedidoDTO pedido) {
		PreparedStatement statement;
		try {

			statement = conexion.getSQLConexion().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

			statement.setInt(1, pedido.getIdPedido());
			statement.setInt(2, pedido.getEstado().getIdEstado());
			statement.setDate(3, pedido.getFecha());

			int id = statement.executeUpdate();

			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {

				long valor = generatedKeys.getLong(1);

				this.insertarPlatos(pedido, valor);
				this.insertarBebidas(pedido, valor);
				this.insertarMenus(pedido, valor);
				this.insertarMozos(pedido, valor);
				this.insertarMesas(pedido, valor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

	public boolean delete(pedidoDTO pedido) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(pedido.getIdPedido()));
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
	public List<pedidoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<pedidoDTO> pedido = new ArrayList<pedidoDTO>();

		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				ArrayList<platoDTO> platos = damePlatos(resultSet.getInt("idPedido"));
				ArrayList<bebidaDTO> bebidas = dameBebidas(resultSet.getInt("idPedido"));
				ArrayList<menuDTO> menus = dameMenus(resultSet.getInt("idPedido"));
				ArrayList<mozoDTO> mozos = dameMozo(resultSet.getInt("idPedido"));
				ArrayList<mesaDTO> mesas = dameMesa(resultSet.getInt("idPedido"));

				estadoDTO estado = dameEstado(resultSet.getInt("idEstado"));

				pedido.add(new pedidoDTO(resultSet.getInt("idPedido"), platos, bebidas, menus, mozos, mesas, estado,
						resultSet.getDate("fecha")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return pedido;
	}

	public boolean update() {
		return false;
	}

	private estadoDTO dameEstado(int idEstado) {

		PreparedStatement statement0;

		ResultSet resultSet;

		estadoDTO estado;

		try {
			statement0 = conexion.getSQLConexion().prepareStatement("Select * from estados WHERE idEstados=?");
			statement0.setInt(1, idEstado);
			resultSet = statement0.executeQuery();

			while (resultSet.next()) {
				return estado = new estadoDTO(resultSet.getInt("idEstados"), resultSet.getString("Descripcion"),
						resultSet.getBoolean("esMesa"), resultSet.getBoolean("esMozo"),
						resultSet.getBoolean("esPedido"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return null;
	}

	private void insertarMesas(pedidoDTO pedido, long id) {

		PreparedStatement statement;

		try {
			for (int i = 0; i < pedido.getMesa().size(); i++) {

				statement = conexion.getSQLConexion()
						.prepareStatement("Insert into pedido_mesa (idPedido, idMesa) VALUES(?,?)");
				statement.setString(1, Long.toString(id));
				statement.setString(2, Integer.toString(pedido.getMesa().get(i).getIdMesa()));

				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
	}

	private void insertarMozos(pedidoDTO pedido, long id) {

		PreparedStatement statement;

		try {
			for (int i = 0; i < pedido.getMozo().size(); i++) {

				statement = conexion.getSQLConexion()
						.prepareStatement("Insert into pedido_mozo (idPedido, idMozo) VALUES(?,?)");
				statement.setString(1, Long.toString(id));
				statement.setString(2, Integer.toString(pedido.getMozo().get(i).getIdMozo()));

				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}

	}

	private void insertarMenus(pedidoDTO pedido, long id) {

		PreparedStatement statement;

		try {
			for (int i = 0; i < pedido.getPlatos().size(); i++) {

				statement = conexion.getSQLConexion()
						.prepareStatement("Insert into pedido_menu (idPedido, idMenu) VALUES(?,?)");
				statement.setString(1, Long.toString(id));
				statement.setString(2, Integer.toString(pedido.getMenus().get(i).getIdMenu()));

				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}

	}

	private void insertarBebidas(pedidoDTO pedido , long id) {

		PreparedStatement statement;

		try {
			for (int i = 0; i < pedido.getBebidas().size(); i++) {

				statement = conexion.getSQLConexion()
						.prepareStatement("Insert into pedido_bebida (idPedido, idBebida) VALUES(?,?)");
				statement.setString(1, Long.toString(id));
				statement.setString(2, Integer.toString(pedido.getBebidas().get(i).getIdBebida()));

				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}

	}

	private void insertarPlatos(pedidoDTO pedido, long id) {

		PreparedStatement statement;

		try {
			for (int i = 0; i < pedido.getPlatos().size(); i++) {

				statement = conexion.getSQLConexion()
						.prepareStatement("Insert into pedido_plato (idPedido, idPlato) VALUES(?,?)");
				statement.setString(1, Long.toString(id));
				statement.setString(2, Integer.toString(pedido.getPlatos().get(i).getIdPlato()));

				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}

	}

	private ArrayList<mesaDTO> dameMesa(int idPedido) {

		PreparedStatement statement0;
		PreparedStatement statement1;

		ResultSet resultSet;
		ResultSet resultSet1;

		ArrayList<mesaDTO> mesas = new ArrayList<mesaDTO>();

		try {
			statement0 = conexion.getSQLConexion().prepareStatement("Select * from pedido_mesa WHERE idPedido=?");
			statement0.setInt(1, idPedido);
			resultSet = statement0.executeQuery();

			while (resultSet.next()) {

				statement1 = conexion.getSQLConexion().prepareStatement("Select * from mesa WHERE idMesa=?");
				statement1.setInt(1, resultSet.getInt("idMesa"));
				resultSet1 = statement1.executeQuery();

				while (resultSet1.next()) {

					estadoDTO estado = dameEstado(resultSet1.getInt("estado"));

					mesas.add(new mesaDTO(resultSet1.getInt("idMesa"), resultSet1.getInt("numero"),
							resultSet1.getInt("capacidad"), resultSet1.getInt("piso"), resultSet1.getString("sector"),
							estado));

				}

			}

			return mesas;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return null;
	}

	private ArrayList<mozoDTO> dameMozo(int idPedido) {

		PreparedStatement statement0;
		PreparedStatement statement1;

		ResultSet resultSet;
		ResultSet resultSet1;

		ArrayList<mozoDTO> mozos = new ArrayList<mozoDTO>();

		try {
			statement0 = conexion.getSQLConexion().prepareStatement("Select * from pedido_mozo WHERE idPedido=?");
			statement0.setInt(1, idPedido);
			resultSet = statement0.executeQuery();

			while (resultSet.next()) {

				statement1 = conexion.getSQLConexion().prepareStatement("Select * from mozo WHERE idMozo=?");
				statement1.setInt(1, resultSet.getInt("idMozo"));
				resultSet1 = statement1.executeQuery();

				while (resultSet1.next()) {

					mozos.add(new mozoDTO(resultSet1.getInt("idMozo"), resultSet1.getString("nombre")));

				}

			}

			return mozos;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return null;
	}

	private ArrayList<menuDTO> dameMenus(int idPedido) {

		PreparedStatement statement0;
		PreparedStatement statement1;

		ResultSet resultSet;
		ResultSet resultSet1;

		menuDAO menuDao = new menuDAO();

		ArrayList<menuDTO> menus = new ArrayList<menuDTO>();

		try {
			statement0 = conexion.getSQLConexion().prepareStatement("Select * from pedido_menu where idPedido=?");
			statement0.setInt(1, idPedido);
			resultSet = statement0.executeQuery();

			while (resultSet.next()) {

				statement1 = conexion.getSQLConexion().prepareStatement("Select * from menu where idMenu=?");
				statement1.setInt(1, resultSet.getInt("idMenu"));
				resultSet1 = statement1.executeQuery();

				while (resultSet1.next()) {

					menus.add(new menuDTO(resultSet1.getInt("idMenu"), resultSet1.getString("nombre"),
							resultSet1.getDouble("precio"), menuDao.damePlatos(resultSet1.getInt("idMenu")),
							menuDao.dameBebidas(resultSet1.getInt("idMenu"))));

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return null;
	}

	private ArrayList<bebidaDTO> dameBebidas(int idPedido) {

		PreparedStatement statement0;
		PreparedStatement statement1;

		ResultSet resultSet;
		ResultSet resultSet1;

		ArrayList<bebidaDTO> bebidas = new ArrayList<bebidaDTO>();

		try {
			statement0 = conexion.getSQLConexion().prepareStatement("Select * from pedido_bebida WHERE idPedido=?");
			statement0.setInt(1, idPedido);
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

	private ArrayList<platoDTO> damePlatos(int idPedido) {
		PreparedStatement statement0;
		PreparedStatement statement1;

		ResultSet resultSet;
		ResultSet resultSet1;

		ArrayList<platoDTO> platos = new ArrayList<platoDTO>();

		try {
			statement0 = conexion.getSQLConexion().prepareStatement("Select * from pedido_plato WHERE idPedido=?");
			statement0.setInt(1, idPedido);
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
}