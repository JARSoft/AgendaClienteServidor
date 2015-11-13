package Comunicacion.Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import Dominio.Servidor.Contacto;
import Dominio.Servidor.Gestor_agenda_servidor;

//import Dominio.Gestor_agenda_servidor;

public class SocketServidor {
	private static ServerSocket servidor;
	private static Socket clienteNuevo;


	public static void main(String[]args){
		try {
			while(true){
				servidor = new ServerSocket(4500);
				clienteNuevo = servidor.accept();
				System.out.println("\nSocket establecido...");

				//Recibir
				ObjectInputStream entrada = new ObjectInputStream(clienteNuevo.getInputStream());
				int  msg_server = (int)entrada.readObject();

				switch (msg_server) {
				case 0://login
					//deberia recibir el objeto del cliente, pero esta en null porque es un prototipo
					
					ObjectOutputStream respKey0 = new ObjectOutputStream(clienteNuevo.getOutputStream());
					Gestor_agenda_servidor.login(null);
					respKey0.writeObject(1);

					break;

				case 1://registrar
					//deberia recibir el objeto del cliente, pero esta en null porque es un prototipo
					ObjectOutputStream respKey1 = new ObjectOutputStream(clienteNuevo.getOutputStream());
					Gestor_agenda_servidor.registrar(null);
					respKey1.writeObject(1);

					break;

				case 2://mostrar cintacto
					//deberia recibir el objeto del cliente, pero esta en null porque es un prototipo
					ObjectOutputStream respKey2 = new ObjectOutputStream(clienteNuevo.getOutputStream());
					Gestor_agenda_servidor.mostrarContactos();
					respKey2.writeObject(1);

					break;

				case 3://buscar contacto
					//deberia recibir el objeto del cliente, pero esta en null porque es un prototipo
					ObjectOutputStream respKey3 = new ObjectOutputStream(clienteNuevo.getOutputStream());
					Gestor_agenda_servidor.buscarContacto(null);
					respKey3.writeObject(1);

					break;

				case 4://modificar nombre
					//deberia recibir el objeto del cliente, pero esta en null porque es un prototipo
					ObjectOutputStream respKey4 = new ObjectOutputStream(clienteNuevo.getOutputStream());
					Gestor_agenda_servidor.modificarNombre(null);
					respKey4.writeObject(1);

					break;
				case 5://modificar telefono
					//deberia recibir el objeto del cliente, pero esta en null porque es un prototipo
					ObjectOutputStream respKey5 = new ObjectOutputStream(clienteNuevo.getOutputStream());
					Gestor_agenda_servidor.modifcarTelefono(null);
					respKey5.writeObject(1);

					break;
				case 6://modificar email
					//deberia recibir el objeto del cliente, pero esta en null porque es un prototipo
					ObjectOutputStream respKey6 = new ObjectOutputStream(clienteNuevo.getOutputStream());
					Gestor_agenda_servidor.modificarEmail(null);
					respKey6.writeObject(1);

					break;
				case 7://eliminar contacto
					//deberia recibir el objeto del cliente, pero esta en null porque es un prototipo
					System.out.println("ELIM");
					ObjectOutputStream respKey7 = new ObjectOutputStream(clienteNuevo.getOutputStream());
					Gestor_agenda_servidor.eliminarContacto(null);
					respKey7.writeObject(1);

					break;
				case 8://anadir contacto
					//deberia recibir el objeto del cliente, pero esta en null porque es un prototipo
					ObjectOutputStream respKey8 = new ObjectOutputStream(clienteNuevo.getOutputStream());
					Gestor_agenda_servidor.anadirContacto(null);
					respKey8.writeObject(1);

					break;

				default:
					System.out.println("Not any registered parameter: "+msg_server);
					break;
				}

				//				switch(msg_server.getClass().getName()){
				//				case "java.util.ArrayList":
				//
				//					ArrayList<String> msg_server_encoded = (ArrayList<String>)msg_server;
				//					System.out.print("El cliente pide ");
				//					for(int i=0;i<msg_server_encoded.size();i++){
				//						System.out.print(">>"+msg_server_encoded.get(i)+"<<  ");
				//					}
				//
				//					//Enviar
				//					ObjectOutputStream resp = new ObjectOutputStream(clienteNuevo.getOutputStream());
				//					resp.writeObject(true);
				//					//				clienteNuevo.close();
				//
				//					break;
				//				case "java.lang.Integer":
				//					int key = (int)msg_server;
				//
				//					switch(key){
				//					case 0:
				//						//Enviar
				//						ObjectOutputStream respKey = new ObjectOutputStream(clienteNuevo.getOutputStream());
				//						respKey.writeObject(new ArrayList<ArrayList<String>>(Arrays.asList(
				//								new ArrayList<String>(Arrays.asList("Juanal", "666", "juanal@gmail.com")),
				//								new ArrayList<String>(Arrays.asList("Raul", "667", "raul@gmail.com")),
				//								new ArrayList<String>(Arrays.asList("Alex", "668", "alex@gmail.com"))
				//								))
				//						);
				//
				//					}
				//					break;
				//
				//				case "[Ljava.lang.String;":
				//
				//					String[] composicion = (String[])msg_server;
				//					int key_2 = Integer.parseInt(composicion[0]);
				//					String keyWord = composicion[1];
				//
				//					switch(key_2){
				//					case 0:
				//						//Buscar contacto por nombre
				//						ObjectOutputStream respKey_0 = new ObjectOutputStream(clienteNuevo.getOutputStream());
				//						respKey_0.writeObject(new ArrayList<ArrayList<String>>(Arrays.asList(
				//								new ArrayList<String>(Arrays.asList(keyWord, "666", "juanal@gmail.com")),
				//								new ArrayList<String>(Arrays.asList(keyWord, "667", "raul@gmail.com"))
				//								))
				//						);
				//						break;
				//					case 1:
				//						//Buscar contacto por telefono
				//						ObjectOutputStream respKey_1 = new ObjectOutputStream(clienteNuevo.getOutputStream());
				//						respKey_1.writeObject(new ArrayList<ArrayList<String>>(Arrays.asList(
				//								new ArrayList<String>(Arrays.asList(keyWord, "666", "juanal@gmail.com")),
				//								new ArrayList<String>(Arrays.asList(keyWord, "667", "raul@gmail.com"))
				//								))
				//						);
				//						break;
				//					}
				//
				//				break;
				//				
				//			default:
				//				System.out.println("Not any class: "+msg_server.getClass().getName());
				//			}

				clienteNuevo.close();
				servidor.close();
				System.out.println("Fin de la operacion");
			}

		} catch (IOException e) {
			System.err.println("Server Error: " + e.getMessage());
			System.err.println("Localized: " + e.getLocalizedMessage());
			System.err.println("Stack Trace: " + e.getStackTrace());
			System.err.println("To String: " + e.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close(){
		try {
			clienteNuevo.close();
			servidor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
