//package Persistencia.DAO.Comida;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import Modelo.DTO.Comidas.entradaDTO;
//import Persistencia.Conexion.Conexion;
//
//public class entradaDAO {
//
//	private static final String insert = "INSERT INTO entrada(idEntrada, nombre, precio) VALUES(?,?,?)";
//	private static final String delete = "DELETE FROM entrada WHERE idEntrada = ?";
//	private static final String update = "UPDATE entrada SET nombre=?, precio=? WHERE idEntrada=?";
//	private static final String readall = "SELECT * FROM entrada";
//	
//	private static final Conexion conexion = Conexion.getConexion();
//
//	public boolean insert(entradaDTO entrada) {
//		PreparedStatement statement;
//		try {
//			statement = conexion.getSQLConexion().prepareStatement(insert);
//			statement.setInt(1, entrada.getIdEntrada());
//			statement.setString(2, entrada.getNombre());
//			statement.setBigDecimal(3, entrada.getPrecio());
//
//			if (statement.executeUpdate() > 0) // Si se ejecuta devuelvo true
//				return true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally // Se ejecuta siempre
//		{
//			conexion.cerrarConexion();
//		}
//		return false;
//	}
//
//	public boolean delete(entradaDTO entrada) {
//		PreparedStatement statement;
//		int chequeoUpdate = 0;
//		try {
//			statement = conexion.getSQLConexion().prepareStatement(delete);
//			statement.setString(1, Integer.toString(entrada.getIdEntrada()));
//			chequeoUpdate = statement.executeUpdate();
//			if (chequeoUpdate > 0) // Si se ejecuta devuelvo true
//				return true;
//		} catch (SQLException e) {
//		} finally // Se ejecuta siempre
//		{
//			conexion.cerrarConexion();
//		}
//		return false;
//	}
//
//	public List<entradaDTO> readAll() {
//		PreparedStatement statement;
//		ResultSet resultSet; // Guarda el resultado de la query
//		ArrayList<entradaDTO> entradas = new ArrayList<entradaDTO>();
//
//		try {
//			statement = conexion.getSQLConexion().prepareStatement(readall);
//			resultSet = statement.executeQuery();
//
//			while (resultSet.next()) {
//
//				entradas.add(new entradaDTO(resultSet.getInt("idEntrada"), resultSet.getString("nombre"),
//						resultSet.getBigDecimal("precio")));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally // Se ejecuta siempre
//		{
//			conexion.cerrarConexion();
//		}
//		return entradas;
//	}
//
//	public boolean update(entradaDTO entrada) {
//		PreparedStatement statement;
//		int chequeoUpdate=0;
//		try 
//		{
//			statement = conexion.getSQLConexion().prepareStatement(update);
//			statement.setString(1, entrada.getNombre());
//			statement.setBigDecimal(2, entrada.getPrecio());
//			statement.setInt(3, entrada.getIdEntrada());
//			chequeoUpdate = statement.executeUpdate();
//			if(chequeoUpdate > 0) //Si se ejecut� devuelvo true
//				return true;
//		} 
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
//		finally //Se ejecuta siempre
//		{
//			conexion.cerrarConexion();
//		}
//		return false;
//	}
//}