package Presentacion.Cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

public class OperacionesCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperacionesCliente frame = new OperacionesCliente();
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
	public OperacionesCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Agenda",TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 414, 397);
		contentPane.add(panel);
		
		JButton button = new JButton("Eliminar");
		button.setBackground(Color.WHITE);
		button.setBounds(10, 154, 91, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Nueva");
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(10, 80, 91, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Modificar");
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(10, 115, 91, 23);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Detalles");
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(10, 234, 91, 23);
		panel.add(button_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(126, 31, 193, 29);
		panel.add(textField);
		
		JButton button_4 = new JButton();
		button_4.setBounds(73, 31, 43, 29);
		panel.add(button_4);
	}
}
