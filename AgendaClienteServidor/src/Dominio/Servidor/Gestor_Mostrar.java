package Dominio.Servidor;

import java.util.ArrayList;

import Persistencia.ConctactoDAO_MySQL;

public class Gestor_Mostrar {

	public static ArrayList<Contacto> mostrarContactos() {
		// TODO - implement Gestor_Mostrar.mostrarContactos
		return ConctactoDAO_MySQL.mostrar();
	}

}