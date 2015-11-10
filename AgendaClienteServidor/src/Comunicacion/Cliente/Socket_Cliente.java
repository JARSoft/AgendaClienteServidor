package Comunicacion.Cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Socket_Cliente {
    private static Socket cliente;

    public Socket_Cliente() {
        try {
            cliente = new Socket("localhost", 4500);
        } catch (Exception e) {
            System.err.println("Client Error: " + e.getMessage());
            System.err.println("Localized: " + e.getLocalizedMessage());
            System.err.println("Stack Trace: " + e.getStackTrace());
        }
    }

    public boolean realizarPeticion(ArrayList<String> componentes){

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

    public ArrayList<String> realizarPeticionConRetornoDeObjeto(int key){

        ObjectOutputStream msg;
        boolean encontrado = false;

        try {

            //Peticion
            msg = new ObjectOutputStream(cliente.getOutputStream());
            msg.writeObject(key);


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

        return null;

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