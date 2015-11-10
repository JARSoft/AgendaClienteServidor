package Presentacion.Cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import Dominio.Cliente.Gestor_Agenda_cliente;

import java.awt.Checkbox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAutentificarse = new JLabel("Autentificarse");
		lblAutentificarse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAutentificarse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutentificarse.setBounds(21, 11, 115, 24);
		contentPane.add(lblAutentificarse);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(160, 84, 213, 29);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setBounds(160, 54, 76, 24);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setBounds(160, 124, 115, 24);
		contentPane.add(lblContrasea);
		
		password = new JPasswordField();
		password.setBounds(158, 154, 215, 29);
		contentPane.add(password);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(Gestor_Agenda_cliente.login(txtUsuario.getText(),String.valueOf(password.getPassword()))){
					OperacionesCliente op = new OperacionesCliente();
					op.setVisible(true);
				}
				
			}
//			public void actionPerformed(ActionEvent e) {
//				//El servidor siempre estará iniciado
//				boolean continuar = true;
//				
//
//				while(continuar){
//					
//					System.out.println("Selecciona una operacion");
//					Scanner leer = new Scanner(System.in);
//					int opcion = leer.nextInt();
//					
//					switch(opcion){
//					case 1:
//						boolean encontrado = gac.login("Carmelo", "lascabrasvanalcampo");
//						if(encontrado) System.out.println("\tEl usuario existe, log completado");
//						else System.out.println("El usuario no existe");
//						break;
//					case 2:
//						boolean registrado = gac.registrar("Otra vez Carmelo", "1234", "ejemplo555@hotmail.com");
//						if(registrado) System.out.println("\tEl usuario ha sido registrado con exito");
//						else System.out.println("El usuario no ha sido registrado");
//						break;
//					case 10:
//						continuar=false;
//						break;
//					}
//				}
//				
//				System.out.println("Fin");
//
//			}
		});
		btnAcceder.setBounds(284, 207, 89, 23);
		contentPane.add(btnAcceder);
		
		Checkbox checkbox = new Checkbox("Recordarme");
		checkbox.setBounds(160, 208, 95, 22);
		contentPane.add(checkbox);
	}
}
