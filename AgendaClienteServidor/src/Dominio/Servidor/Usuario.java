package Dominio.Servidor;

public class Usuario {

	private String login;
	private int password;
	private String email;

	public String getLogin() {
		return this.login;
	}

	public int getPassword() {
		return this.password;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param n
	 */
	public void setLogin(String n) {
		this.login = n;
	}

	/**
	 * 
	 * @param pass
	 */
	public void setPassword(int pass) {
		this.password = pass;
	}

	/**
	 * 
	 * @param e
	 */
	public void setEmail(String e) {
		this.email = e;
	}

}
