package Persistencia.DAO.General;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.DTO.Bebidas.cafeDTO;
import Modelo.DTO.Bebidas.conAlcoholDTO;
import Modelo.DTO.Bebidas.sinAlcoholDTO;
import Modelo.DTO.Comidas.entradaDTO;
import Modelo.DTO.Comidas.platoDTO;
import Modelo.DTO.Comidas.postreDTO;
import Modelo.DTO.Comidas.principalDTO;
import Modelo.DTO.General.estadoDTO;
import Modelo.DTO.General.mesaDTO;
import Modelo.DTO.General.pedidoDTO;
import Modelo.DTO.RecursosHumanos.mozoDTO;
import Persistencia.Conexion.Conexion;

public class pedidoDAO {

	private static final String insert = "INSERT INTO pedido(idPedido, estado, fecha ) VALUES(?,?,?)";
	private static final String delete = "DELETE FROM pedido WHERE idPedido = ?";
	private static final String readall = "SELECT * FROM pedido";
	private static final Conexion conexion = Conexion.getConexion();

	public boolean insert(pedidoDTO pedido) {
		PreparedStatement statement;
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, pedido.getIdPedido());
			statement.setObject(2, pedido.getEstado());
			statement.setDate(3, pedido.getFecha());

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

				estadoDTO estado = dameEstado(resultSet.getInt("idEstados"));

				pedido.add(new pedidoDTO(resultSet.getInt("idPedido"), estado, resultSet.getDate("fecha")));
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
	
	private ArrayList<platoDTO> damePlatos(int idPedido){
		
		PreparedStatement statement0;

		ResultSet resultSet;

		estadoDTO estado;

		try {
			statement0 = conexion.getSQLConexion().prepareStatement("Select * from estados WHERE idEstados=?");
			statement0.setInt(1, idPedido);
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
}
