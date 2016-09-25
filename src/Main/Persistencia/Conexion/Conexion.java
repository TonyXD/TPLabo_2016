package Persistencia.Conexion;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion 
{
	public static Conexion instancia;
	private final static String driver = "com.mysql.jdbc.Driver";
	private Connection conexion;
	public Conexion()
	{
		try
		{		
			
			Class.forName(driver).newInstance();
			//TODO: Agregar string coneccion
			conexion = DriverManager.getConnection("jdbc:mysql://");
			System.out.println("Conexion exitosa");
		}
		catch(Exception e)
		{
			File file = new File("conexion.xml");

    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
			System.out.println("Conexion fallida");
		}
	}	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return conexion;
	}

	public void cerrarConexion()
	{
		instancia = null;
	}
}
