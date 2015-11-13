package Dominio.Servidor;

import java.util.ArrayList;

import Dominio.Servidor.Usuario;

public class Gestor_agenda_servidor {

	/**
	 * 
	 * @param u
	 */
	public static boolean login(Usuario u) {
		// TODO - implement Gestor_agenda_servidor.login
		Gestor_Autenticar.autenticarUsuario(u);
		return true;
	}

	/**
	 * 
	 * @param u
	 */
	public static boolean registrar(Usuario u) {
		// TODO - implement Gestor_agenda_servidor.registrar
		Gestor_Registrar_Usuario.registrar(u);
		return true;
	}

	public static ArrayList<Contacto> mostrarContactos() {
		// TODO - implement Gestor_agenda_servidor.mostrarContactos
		Gestor_Mostrar.mostrarContactos();
		return null;
	}

	/**
	 * 
	 * @param c
	 */
	public static boolean anadirContacto(Contacto c) {
		// TODO - implement Gestor_agenda_servidor.añadirContacto
		Gestor_Anadir.anadirContacto(c);
		return true;
	}

	/**
	 * 
	 * @param c
	 */
	public static ArrayList<Contacto> buscarContacto(Contacto c) {
		// TODO - implement Gestor_agenda_servidor.buscarContacto
		Gestor_Buscar.buscarContacto(c);
		return null;
	}

	/**
	 * 
	 * @param c
	 */
	public static boolean modificarNombre(Contacto c) {
		// TODO - implement Gestor_agenda_servidor.modificarNombre
		Gestor_Modificar.modificarContacto(c);
		return true;
	}

	/**
	 * 
	 * @param c
	 */
	public static boolean modifcarTelefono(Contacto c) {
		// TODO - implement Gestor_agenda_servidor.modifcarTelefono
		Gestor_Modificar.modificarContacto(c);
		return true;
	}

	/**
	 * 
	 * @param c
	 */
	public static boolean modificarEmail(Contacto c) {
		// TODO - implement Gestor_agenda_servidor.modificarEmail
		Gestor_Modificar.modificarContacto(c);
		return true;
	}

	/**
	 * 
	 * @param c
	 */
	public static boolean eliminarContacto(Contacto c) {
		// TODO - implement Gestor_agenda_servidor.eliminarContacto
		Gestor_Eliminar.eliminarContacto(c);
		return true;
	}

	/**
	 * 
	 * @param tlfn
	 */
	public static Contacto buscarContacto(int tlfn) {
		// TODO - implement Gestor_agenda_servidor.buscarContacto
		Gestor_Buscar.buscarContacto(null);
		return null;
	}

}