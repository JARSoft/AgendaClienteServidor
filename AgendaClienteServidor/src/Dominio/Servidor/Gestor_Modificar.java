package Dominio.Servidor;

import Persistencia.ConctactoDAO_MySQL;

public class Gestor_Modificar {

	/**
	 * 
	 * @param c
	 */
	public static boolean modificarContacto(Contacto c) {
		// TODO - implement Gestor_Modificar.modificarContacto
		return ConctactoDAO_MySQL.modificar(c.getNombre(), c.getTelefono());
	}

}