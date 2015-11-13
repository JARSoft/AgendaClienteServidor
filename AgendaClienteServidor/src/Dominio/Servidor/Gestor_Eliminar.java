package Dominio.Servidor;

import Persistencia.ConctactoDAO_MySQL;

public class Gestor_Eliminar {

	/**
	 * 
	 * @param c
	 */
	public static boolean eliminarContacto(Contacto c) {
		// TODO - implement Gestor_Eliminar.eliminarContacto
		return ConctactoDAO_MySQL.borrar(c);
	}

}