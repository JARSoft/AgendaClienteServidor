package Dominio.Servidor;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Persistencia.UsuarioDAO;

public class Gestor_Registrar_Usuario {

	/**
	 * 
	 * @param u
	 */
	public static boolean registrar(Usuario u) {
		try{
			UsuarioDAO.newUser(u);
			return true;
		// TODO - implement Gestor_Registrar_Usuario.registrar
		} catch (Exception e) {
            System.out.println(e);
        }
        return false;
	}
	
}