package Presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Dominio.Cliente.Gestor_Agenda_cliente;

import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class FichaContacto extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldTelefono;
	private JTextField textFieldEmail;
	
	private ArrayList<String> contacto;

	/**
	 * Create the frame.
	 */
	public FichaContacto(ArrayList<String> arrayList, int auxIndex) {
		// TODO Auto-generated constructor stub
		this.contacto = arrayList;
		Procedure();
	}
	
	public FichaContacto() {
		Procedure();
	}

	private void Procedure() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(175, 41, 178, 28);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		if(contacto!=null){
			textFieldNombre.setText(contacto.get(0));
			textFieldNombre.addFocusListener( new FocusListener() {
				public void focusLost(FocusEvent e) {  Gestor_Agenda_cliente.modificarNombre(textFieldNombre.getText(), 
						Integer.parseInt(textFieldTelefono.getText())); }
				public void focusGained(FocusEvent e) {}
			});
		}
		
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(175, 90, 178, 28);
		contentPane.add(textFieldTelefono);
		if(contacto!=null){
			textFieldTelefono.setText(contacto.get(1));
			textFieldTelefono.addFocusListener( new FocusListener() {
				public void focusLost(FocusEvent e) {  Gestor_Agenda_cliente.modifcarTelefono(Integer.parseInt(
						textFieldTelefono.getText()), Integer.parseInt(contacto.get(1)));}
				public void focusGained(FocusEvent e) {}
			});
		}
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(175, 141, 178, 28);
		contentPane.add(textFieldEmail);
		if(contacto!=null){
			textFieldEmail.setText(contacto.get(2));
			textFieldEmail.addFocusListener( new FocusListener() {
				public void focusLost(FocusEvent e) {  Gestor_Agenda_cliente.modificarEmail(textFieldEmail.getText(),
						Integer.parseInt(contacto.get(1)));}
				public void focusGained(FocusEvent e) {}
			});
		}
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FichaContacto.this.dispose();
			}
		});
		btnConfirmar.setBounds(229, 211, 124, 23);
		contentPane.add(btnConfirmar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(21, 48, 93, 14);
		contentPane.add(lblNombre);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(21, 97, 93, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(21, 148, 93, 14);
		contentPane.add(lblEmail);
	}

}
