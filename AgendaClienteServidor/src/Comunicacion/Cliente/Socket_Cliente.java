package Comunicacion.Cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Socket_Cliente {
	private static Socket cliente;

	//    public Socket_Cliente() {
	//        try {
	//            cliente = new Socket("localhost", 4500);
	//        } catch (Exception e) {
	//            System.err.println("Client Error: " + e.getMessage());
	//            System.err.println("Localized: " + e.getLocalizedMessage());
	//            System.err.println("Stack Trace: " + e.getStackTrace());
	//        }
	//    }

	public static boolean realizarPeticion(ArrayList<String> componentes){

		startSocket();

		ObjectOutputStream msg;
		boolean encontrado = false;

		try {

			//Peticion
			msg = new ObjectOutputStream(cliente.getOutputStream());
			msg.writeObject(componentes);

			//Recepcion
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
			encontrado = (boolean)entrada.readObject();

			//Fin
			System.out.println("Recibido por el servidor: >>"+encontrado+"<<");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encontrado;

	}

	public static Object realizarPeticionConRetornoDeObjeto(int key){

		startSocket();

		ObjectOutputStream msg;
		Object retorno = null;

		try {

			//Peticion
			msg = new ObjectOutputStream(cliente.getOutputStream());
			msg.writeObject(key);


			//Recepcion
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
			retorno = entrada.readObject();

			//Fin
			System.out.println("Recibido por el servidor: >>"+retorno+"<<");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retorno;

	}


	public static Object realizarPeticionConBusquedaYRetornoDeObjeto(int key, String keyWord){
		
		startSocket();

		ObjectOutputStream msg;
		Object retorno = null;
		
		String[] composicion = {Integer.toString(key), keyWord};

		try {

			//Peticion
			msg = new ObjectOutputStream(cliente.getOutputStream());
			msg.writeObject(composicion);


			//Recepcion
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
			retorno = entrada.readObject();

			//Fin
			System.out.println("Recibido por el servidor: >>"+retorno+"<<");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;

	}
	
	
	private static void startSocket(){
		try {
			cliente = new Socket("localhost", 4500);
		} catch (Exception e) {
			System.err.println("Client Error: " + e.getMessage());
			System.err.println("Localized: " + e.getLocalizedMessage());
			System.err.println("Stack Trace: " + e.getStackTrace());
		}
	}
	
	public void close(){
		try {
			cliente.close();
			System.out.println("Conexion cerrada");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}