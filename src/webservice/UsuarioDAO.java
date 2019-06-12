package webservice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

	private static PreparedStatement pstm=null;
	private static ResultSet res=null;
	private static ConexionBD con=ConexionBD.generarInstancia();
	private static final String SQL_LOGIN="select * from usuario where correo=? and clave=?";
	
	public boolean login(String correo, String clave) {
		boolean result = false;
		try {
			pstm=con.getCon().prepareStatement(SQL_LOGIN);
			pstm.setString(1, correo);
			pstm.setString(2, clave);
			res = pstm.executeQuery();
			if(res.next()) {
				result = true;
			}
		}catch(Exception ex) {
			System.out.println("ERROR LOGIN"+ex.getMessage());
		}
		finally {
			cerrarConexion();
		}
		return result;
	}
	private void cerrarConexion() {
		try {
			if(res!=null)res.close();
			if(pstm!=null)pstm.close();
			if(con!=null)con.cerrarConexion();
		}catch(Exception ex) {
			System.out.println("ERROR"+ex.getMessage());
		}
	}
}
