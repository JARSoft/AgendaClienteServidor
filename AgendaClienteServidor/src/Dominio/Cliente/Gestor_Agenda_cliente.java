package Dominio.Cliente;

import java.util.ArrayList;

import Comunicacion.Cliente.Socket_Cliente;

public class Gestor_Agenda_cliente {

	/**
	 * 
	 * @param user
	 * @param pass
	 */

    private final int STATIC_MOSTRAR_CONATCTOS = 0;
    private static Socket_Cliente sc = new Socket_Cliente();


	public static boolean login(String user, String pass) {
		// TODO - implement Gestor_Agenda_cliente.login
//		throw new UnsupportedOperationException();

        ArrayList<String> componentes= new ArrayList<String>();
        componentes.add(user);componentes.add(pass);
        boolean encontrado = sc.realizarPeticion(componentes);

        return encontrado;
	}

	/**
	 * 
	 * @param user
	 * @param pass
	 * @param email
	 */
	public static boolean registrar(String user, String pass, String email) {
		// TODO - implement Gestor_Agenda_cliente.registrar
//		throw new UnsupportedOperationException();

        ArrayList<String> componentes= new ArrayList<String>();
        componentes.add(user);componentes.add(pass); componentes.add(email);
        boolean encontrado = sc.realizarPeticion(componentes);

        return encontrado;
	}

	public static ArrayList<ArrayList<String>> mostrarContactos() {
		// TODO - implement Gestor_Agenda_cliente.mostrarContactos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nombre
	 * @param tlfn
	 * @param email
	 */
	public static boolean anadirContacto(String nombre, int tlfn, String email) {
		// TODO - implement Gestor_Agenda_cliente.añadirContacto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nombre
	 */
	public static ArrayList<ArrayList<String>> buscarContacto(String nombre) {
		// TODO - implement Gestor_Agenda_cliente.buscarContacto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tlfn
	 */
	public static ArrayList<String> buscarContacto(int tlfn) {
		// TODO - implement Gestor_Agenda_cliente.buscarContacto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nombre
	 * @param telefono
	 */
	public static boolean modificarNombre(String nombre, int telefono) {
		// TODO - implement Gestor_Agenda_cliente.modificarNombre
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tlfn
	 * @param telefono
	 */
	public static boolean modifcarTelefono(int tlfn, int telefono) {
		// TODO - implement Gestor_Agenda_cliente.modifcarTelefono
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param telefono
	 */
	public static boolean modificarEmail(String email, int telefono) {
		// TODO - implement Gestor_Agenda_cliente.modificarEmail
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nombre
	 * @param tlfn
	 * @param email
	 */
	public static boolean eliminarContacto(String nombre, int tlfn, String email) {
		// TODO - implement Gestor_Agenda_cliente.eliminarContacto
		throw new UnsupportedOperationException();
	}

}