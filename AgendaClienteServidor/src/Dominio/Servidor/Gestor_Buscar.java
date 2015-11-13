package Dominio.Servidor;

import java.util.ArrayList;

import Persistencia.ConctactoDAO_MySQL;

public class Gestor_Buscar {

	/**
	 * 
	 * @param c
	 */
	public static ArrayList<Contacto> buscarContacto(Contacto c) {
		// TODO - implement Gestor_buscar.buscarContacto
		return ConctactoDAO_MySQL.buscar(c);
	}

}