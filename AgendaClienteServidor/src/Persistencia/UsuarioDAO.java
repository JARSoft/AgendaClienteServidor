package Persistencia;

import java.sql.Connection;

import Dominio.Servidor.Usuario;

public class UsuarioDAO {
	static String sql = "";
	
	/**
	 * 
	 * @param u
	 */
	public static boolean newUser(Usuario u) {
		// TODO - implement UsuarioDAO_MySQL.newUser
		//no tiene por que funcionar aun
		try{
			sql = "INSERT INTO USUARIOS VALUES ('" + u.getLogin() + "', '" + u.getPassword() + "','" + u.getEmail() + "');";
			AgenteBD.insert(sql);
		}catch(NullPointerException e){
			//va a dar null porque le estamos pasando un usuario vacio, sino lo buscaria
		}
		
		return true;
	}

	/**
	 * 
	 * @param u
	 */
	public static boolean readUser(Usuario u) {
//		// TODO - implement UsuarioDAO_MySQL.readUser
		AgenteBD.conectar();
		//no tiene por que funcionar aun
		try{
			sql = "SELECT email FROM USUARIOS WHERE email = " + u.getEmail() + ";";
			AgenteBD.select(sql);
		}catch(NullPointerException e){
			//va a dar null porque le estamos pasando un usuario vacio, sino lo buscaria
		}
		
		return true;
	}
	
}
