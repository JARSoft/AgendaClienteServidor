package Dominio.Servidor;

import Persistencia.ConctactoDAO_MySQL;
import Persistencia.UsuarioDAO;

public class Gestor_Anadir {

	/**
	 * 
	 * @param c
	 */
	public static  boolean anadirContacto(Contacto c) {
		// TODO - implement Gestor_Añadir.añadirContacto
		return ConctactoDAO_MySQL.nuevo(c);
	}

}