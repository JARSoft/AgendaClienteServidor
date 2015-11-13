package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgenteBD {
	static String url = "agenda.db";
	static Connection connect;
	private static AgenteBD agente = null;

	public static boolean conectar(){
		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite:"+url);
			if (connect!=null) {
				System.out.println("Conectado");
				return true;
			}
		}catch (SQLException | ClassNotFoundException ex) {
			System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
		}
		return false;
	}

	public boolean desconectar(){
		//no podra realizar la consulta porque en princpio la base de datos esta vacia
		try {
			connect.close();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(AgenteBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public static AgenteBD getAgente() {
		if (agente == null){
			agente = new AgenteBD();
		}
		return agente;
	}

	public static ResultSet insert(String SQL) {
		//no podra realizar la consulta porque en princpio la base de datos esta vacia
		try {
			getAgente();
			PreparedStatement st = connect.prepareStatement(SQL);
			return st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param SQL
	 */
	public static ResultSet delete(String SQL) {
		//no podra realizar la consulta porque en princpio la base de datos esta vacia
		try {
			getAgente();
			PreparedStatement st = connect.prepareStatement(SQL);
			return st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param SQL
	 */
	public static ResultSet update(String SQL) {
		//no podra realizar la consulta porque en princpio la base de datos esta vacia
		try {
			getAgente();
			PreparedStatement st = connect.prepareStatement(SQL);
			return st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet select(String SQL) {
		//no podra realizar la consulta porque en princpio la base de datos esta vacia
		try {
			getAgente();
			PreparedStatement st = connect.prepareStatement(SQL);
			return st.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param SQL
	 *
	public ArrayList<String> select(String SQL) {
		PreparedStatement st = connect.prepareStatement(SQL);
		return st.get(parameterIndex, x);executeQuery();
        try {
        	int cont = 0;
        	ArrayList<String> lista = new ArrayList<String>();
        	ResultSet result = null;
            PreparedStatement st = connect.prepareStatement(SQL);
            result = st.executeQuery();
            while (result.next()) {
            	lista.add(cont, result.getString("nombre") + result.getString("telefono") + result.getString("email"));
            	cont ++;
            }
            return lista;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
	}*/
}
