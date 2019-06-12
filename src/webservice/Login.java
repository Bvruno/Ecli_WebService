package webservice;

public class Login {

	public boolean loginUser(String correo, String clave) {
		boolean result;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		result = usuarioDAO.login(correo, clave);
		return result;
	}
}
