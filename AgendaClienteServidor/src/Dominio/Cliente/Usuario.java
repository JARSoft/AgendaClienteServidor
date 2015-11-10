package Dominio.Cliente;

public class Usuario {

	private String login;
	private String password;
	private String email;

	public String getLogin() {
		return this.login;
	}

	public String getPassword() {
		return this.password;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param l
	 */
	public void setLogin(String l) {
		this.login = l;
	}

	/**
	 * 
	 * @param p
	 */
	public void setPassword(String p) {
		this.password = p;
	}

	/**
	 * 
	 * @param e
	 */
	public void setEmail(String e) {
		this.email = e;
	}

}