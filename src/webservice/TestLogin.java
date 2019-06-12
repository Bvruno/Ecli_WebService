package webservice;

public class TestLogin {

	public static void main(String[] args) {
		ConexionBD.generarInstancia();
		String correo="admin";
		String clave="1234";
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if(usuarioDAO.login(correo, clave)) {
			System.out.println("LOGIN CORRECTO");
		}else {
			System.out.println("LOGIN INCORRECTO");
		}
	}
}
