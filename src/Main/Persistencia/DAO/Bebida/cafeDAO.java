//package Persistencia.DAO.Bebida;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import Modelo.DTO.Bebidas.cafeDTO;
//import Modelo.DTO.Comidas.entradaDTO;
//import Persistencia.Conexion.Conexion;
//
//public class cafeDAO {
//
//	private static final String insert = "INSERT INTO cafe(idCafe, nombre, precio) VALUES(?,?,?)";
//	private static final String delete = "DELETE FROM cafe WHERE idCafe = ?";
//	private static final String update = "UPDATE cafe SET nombre=?, precio=? WHERE idCafe=?";
//	private static final String readall = "SELECT * FROM cafe";
//	private static final Conexion conexion = Conexion.getConexion();
//	
//	
//	public boolean insert(cafeDTO cafe) {
//		PreparedStatement statement;
//		try {
//			statement = conexion.getSQLConexion().prepareStatement(insert);
//			statement.setInt(1, cafe.getIdCafe());
//			statement.setString(2, cafe.getNombre());
//			statement.setBigDecimal(3, cafe.getPrecio());
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
//	public boolean delete(cafeDTO cafe) {
//		PreparedStatement statement;
//		int chequeoUpdate = 0;
//		try {
//			statement = conexion.getSQLConexion().prepareStatement(delete);
//			statement.setString(1, Integer.toString(cafe.getIdCafe()));
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
//	public List<cafeDTO> readAll() {
//		PreparedStatement statement;
//		ResultSet resultSet; // Guarda el resultado de la query
//		ArrayList<cafeDTO> cafes = new ArrayList<cafeDTO>();
//
//		try {
//			statement = conexion.getSQLConexion().prepareStatement(readall);
//			resultSet = statement.executeQuery();
//
//			while (resultSet.next()) {
//
//				cafes.add(new cafeDTO(resultSet.getInt("idCafe"), resultSet.getString("nombre"),
//						resultSet.getBigDecimal("precio")));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally // Se ejecuta siempre
//		{
//			conexion.cerrarConexion();
//		}
//		return cafes;
//	}
//
//	public boolean update() {
//		return false;
//	}
//	
//	public boolean update(cafeDTO cafe) {
//		PreparedStatement statement;
//		int chequeoUpdate=0;
//		try 
//		{
//			statement = conexion.getSQLConexion().prepareStatement(update);
//			statement.setString(1, cafe.getNombre());
//			statement.setBigDecimal(2, cafe.getPrecio());
//			statement.setInt(3, cafe.getIdCafe());
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