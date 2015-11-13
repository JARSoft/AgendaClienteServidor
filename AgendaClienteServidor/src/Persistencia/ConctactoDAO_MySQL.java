package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Dominio.Servidor.Contacto;

public class ConctactoDAO_MySQL {
	static String sql = "";

	/**
	 * 
	 * @param c
	 */
	public static boolean nuevo(Contacto c) {
		// TODO - implement ConctactoDAO_MySQL.nuevo
		try{
			sql = "INSERT INTO CONTACTOS VALUES ('" + c.getNombre() + "', '" + c.getTelefono() + "','" + c.getEmail() + "');";
			AgenteBD.insert(sql);
		}catch(NullPointerException e){
			//va a dar null porque le estamos pasando un contacto vacio, sino lo buscaria
		}

		return true;
	}

	/**
	 * 
	 * @param c
	 */
	public static boolean borrar(Contacto c) {
		// TODO - implement ConctactoDAO_MySQL.borrar
		System.out.println("Borrando contacto en la base de datos");
		try{
			sql = "DELETE Email FROM CONTACTOS WHERE nombre=" + c.getNombre() + ";";
			AgenteBD.delete(sql);
		}catch(NullPointerException e){
			//va a dar null porque le estamos pasando un contacto vacio, sino lo buscaria
		}
		
		return true;
	}

	public static ArrayList<Contacto> mostrar() {
		// TODO - implement ConctactoDAO_MySQL.mostrar
		System.out.println("Mostrando contactos en la base de datos");
		try{
			sql = "SELECT * FROM CONTACTOS;";
			ResultSet data = AgenteBD.select(sql);
			try {
				ArrayList<Contacto> lista = new ArrayList<Contacto>();
				while (data.next()) {
					lista.add((Contacto) data);
				}
				return lista;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}catch(NullPointerException e){
			//va a dar null porque le estamos pasando un contacto vacio, sino lo buscaria
		}
		
		return null;
	}

	/**
	 * 
	 * @param c
	 */
	public static ArrayList<Contacto> buscar(Contacto c) {
		// TODO - implement ConctactoDAO_MySQL.buscar
		System.out.println("Buscando contacto en la base de datos");
		try{
			sql = "SELECT * FROM CONTACTOS;";
			ResultSet data = AgenteBD.select(sql);
			try {
				ArrayList<Contacto> lista = new ArrayList<Contacto>();
				while (data.next()) {
					lista.add((Contacto) data);
				}
				return lista;
			} catch (Exception e) {
				//No hay data
			}
		}catch(NullPointerException e){
			//va a dar null porque le estamos pasando un contacto vacio, sino lo buscaria
		}
		
		return null;
	}

	/**
	 * 
	 * @param n
	 * @param telefono
	 */
	public static boolean modificar(String n, int telefono) {
		// TODO - implement ConctactoDAO_MySQL.modificar
		System.out.println("Modificando contacto en la base de datos");
		try{
			sql = "UPDATE CONTACTOS SET name='" + n + "' WHERE telefono='" + telefono + "';";
			AgenteBD.update(sql);
		}catch(NullPointerException e){
			//va a dar null porque le estamos pasando un contacto vacio, sino lo buscaria
		}
		
		return true;
	}

}