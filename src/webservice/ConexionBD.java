package webservice;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
	
	private static ConexionBD instance=null;
	private static Connection con=null;
	private static final String url="jdbc:sqlserver://172.17.35.10:1433;databaseName=servicios";
	private static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String user="sa";
	private static final String pass="123456";
	
	private ConexionBD() {
		
		try {
			Class.forName(driver).newInstance();
			con=DriverManager.getConnection(url, user, pass);
			System.out.println("CONEXION CORRECTA");
		}catch(Exception ex) {
			System.out.println("ERROR DE CONEXION");
			ex.printStackTrace();
		}
	}
	public synchronized static ConexionBD generarInstancia() {
		if(instance==null) {
			instance = new ConexionBD();
		}
		return instance;
	}
	
	public Connection getCon() {
		return con;
	}
	public void cerrarConexion() {
		instance = null;
	}

}









