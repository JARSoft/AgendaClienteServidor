package Dominio.Cliente;

import java.util.ArrayList;
import java.util.Arrays;

import Comunicacion.Cliente.Socket_Cliente;

public class Gestor_Agenda_cliente {

	/**
	 * 
	 * @param user
	 * @param pass
	 */

	private final static int STATIC_MOSTRAR_CONTACTOS = 0;
	private final static int STATIC_BUSCAR_CONTACTOS = 0;
	private final static int STATIC_ELIMINAR_CONATCTOS = 1;


	public static boolean login(String user, String pass) {
		// TODO - implement Gestor_Agenda_cliente.login
		//		throw new UnsupportedOperationException();

		ArrayList<String> componentes= new ArrayList<String>();
		componentes.add(user);componentes.add(pass);
		boolean exito = Socket_Cliente.realizarPeticion(componentes);

		return exito;
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
		boolean exito = Socket_Cliente.realizarPeticion(componentes);

		return exito;
	}

	public static ArrayList<ArrayList<String>> mostrarContactos() {
		// TODO - implement Gestor_Agenda_cliente.mostrarContactos

		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<String>> componentes = (ArrayList<ArrayList<String>>) Socket_Cliente.
				realizarPeticionConRetornoDeObjeto(STATIC_MOSTRAR_CONTACTOS);

		return componentes;

	}

	/**
	 * 
	 * @param nombre
	 * @param tlfn
	 * @param email
	 */
	public static boolean anadirContacto(String nombre, int tlfn, String email) {

		ArrayList<String> componentes= new ArrayList<String>();
		componentes.add(nombre);componentes.add(Integer.toString(tlfn)); componentes.add(email);
		boolean exito = Socket_Cliente.realizarPeticion(componentes);

		return exito;
	}

	/**
	 * 
	 * @param nombre
	 */
	public static ArrayList<ArrayList<String>> buscarContacto(String nombre) {
		
		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<String>> componentes = (ArrayList<ArrayList<String>>) Socket_Cliente.
				realizarPeticionConBusquedaYRetornoDeObjeto(STATIC_BUSCAR_CONTACTOS, nombre);

		return componentes;
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
		ArrayList<String> componentes= new ArrayList<String>();
		componentes.add(nombre);componentes.add(Integer.toString(telefono));
		boolean exito = Socket_Cliente.realizarPeticion(componentes);

		return exito;
	}

	/**
	 * 
	 * @param tlfn
	 * @param telefono
	 */
	public static boolean modifcarTelefono(int tlfn, int telefono) {
		// TODO - implement Gestor_Agenda_cliente.modifcarTelefono
		
		ArrayList<String> componentes= new ArrayList<String>();
		componentes.add(Integer.toString(tlfn)); componentes.add(Integer.toString(telefono));
		boolean exito = Socket_Cliente.realizarPeticion(componentes);

		return exito;
	}

	/**
	 * 
	 * @param email
	 * @param telefono
	 */
	public static boolean modificarEmail(String email, int telefono) {
		// TODO - implement Gestor_Agenda_cliente.modificarEmail
		ArrayList<String> componentes= new ArrayList<String>();
		componentes.add(email); componentes.add(Integer.toString(telefono));
		boolean exito = Socket_Cliente.realizarPeticion(componentes);

		return exito;
	}

	/**
	 * 
	 * @param nombre
	 * @param tlfn
	 * @param email
	 */
	public static boolean eliminarContacto(String nombre, int tlfn, String email) {
		// TODO - implement Gestor_Agenda_cliente.eliminarContacto
		ArrayList<String> componentes= new ArrayList<String>();
		componentes.add(nombre);componentes.add(Integer.toString(tlfn));componentes.add(email); 
		boolean exito = Socket_Cliente.realizarPeticion(componentes);

		return exito;
	}

}