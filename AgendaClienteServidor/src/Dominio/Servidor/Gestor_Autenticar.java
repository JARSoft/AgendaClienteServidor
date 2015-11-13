package Dominio.Servidor;
import Persistencia.UsuarioDAO;

public class Gestor_Autenticar {

	/**
	 * 
	 * @param u
	 */
	public static  void autenticarUsuario(Usuario u) {
		// TODO - implement Gestor_Autenticar.autenticarUsuario
		UsuarioDAO.readUser(u);
	}

}