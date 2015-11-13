package Dominio.Servidor;

public class Contacto {

	private String nombre;
	private int telefono;
	private String email;

	public String getNombre() {
		return this.nombre;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param n
	 */
	public void setNombre(String n) {
		this.nombre = n;
	}

	/**
	 * 
	 * @param tlfn
	 */
	public void setTelefono(int tlfn) {
		this.telefono = tlfn;
	}

	/**
	 * 
	 * @param e
	 */
	public void setEmail(String e) {
		this.email = e;
	}

}