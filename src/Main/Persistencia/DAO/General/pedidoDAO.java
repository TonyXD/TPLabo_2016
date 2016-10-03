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
import Modelo.DTO.Comidas.postreDTO;
import Modelo.DTO.Comidas.principalDTO;
import Modelo.DTO.General.estadoDTO;
import Modelo.DTO.General.mesaDTO;
import Modelo.DTO.General.pedidoDTO;
import Modelo.DTO.RecursosHumanos.mozoDTO;
import Persistencia.Conexion.Conexion;

public class pedidoDAO {

	private static final String insert = "INSERT INTO pedido(idPedido, ) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String delete = "DELETE FROM pedido WHERE idPedido = ?";
	private static final String readall = "SELECT * FROM pedido";
	private static final Conexion conexion = Conexion.getConexion();

	public boolean insert(pedidoDTO pedido) {
		PreparedStatement statement;
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, pedido.getIdPedido());
			statement.setObject(2, pedido.getEntrada());
			statement.setObject(3, pedido.getPrincipal());
			statement.setObject(4, pedido.getPostre());
			statement.setObject(5, pedido.getConAlcohol());
			statement.setObject(6, pedido.getSinAlcohol());
			statement.setObject(7, pedido.getCafe());
			statement.setObject(8, pedido.getMozo());
			statement.setObject(9, pedido.getMesa());
			statement.setInt(10, pedido.getEstado().getIdEstado());
			statement.setDate(11, pedido.getFecha());
			
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
				
				estadoDTO estado = cargarEstado(resultSet.getInt("idEstado"));;

				pedido.add(new pedidoDTO(
						resultSet.getInt("idPedido"),
						(ArrayList<entradaDTO>) resultSet.getObject("entrada"),
						(ArrayList<principalDTO>) resultSet.getObject("principal"),
						(ArrayList<postreDTO>) resultSet.getObject("postre"),
						(ArrayList<conAlcoholDTO>) resultSet.getObject("conAlcohol"),
						(ArrayList<sinAlcoholDTO>) resultSet.getObject("sinAlcohol"),
						(ArrayList<cafeDTO>) resultSet.getObject("cafe"), 
						(ArrayList<mozoDTO>) resultSet.getObject("mozo"),
						(ArrayList<mesaDTO>) resultSet.getObject("mesa"), 
						estado, 
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
	
	public estadoDTO cargarEstado(int idEstado){
		PreparedStatement statement;
		ResultSet resultSet;
		estadoDTO estado;

		try {
			statement = conexion.getSQLConexion()
					.prepareStatement("SELECT * FROM estado where estado.idestado =" + Integer.toString(idEstado));
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				return estado = new estadoDTO(resultSet.getInt("idEstado"), resultSet.getString("tipoEstado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally // Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return null;
	}

	public boolean update() {
		return false;
	}
}
