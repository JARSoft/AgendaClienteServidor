package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

import Dominio.Cliente.Gestor_Agenda_cliente;
import Dominio.Cliente.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class OperacionesCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBusqueda;
	private static JScrollPane scrollPanel;
	private JPanel panel = new JPanel();
	
	private ArrayList<ArrayList<String>> contactos; 

	static int auxIndex = -1;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OperacionesCliente frame = new OperacionesCliente();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public OperacionesCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Agenda",TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 549, 397);
		contentPane.add(panel);

		JButton button_3 = new JButton("Detalles");
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(10, 234, 137, 23);
		panel.add(button_3);

		textFieldBusqueda = new JTextField();
		textFieldBusqueda.setColumns(10);
		textFieldBusqueda.setBounds(234, 31, 193, 29);
		panel.add(textFieldBusqueda);

		{
			ImageIcon icon = new ImageIcon("/Presentacion/len.PNG");
			JButton button = new JButton();
			button.setBounds(168, 31, 43, 29);
			button.setIcon(new ImageIcon(OperacionesCliente.class.getResource("/Presentacion/len.png")));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(textFieldBusqueda.getText()!=null){
						ArrayList<ArrayList<String>> resultado_de_busqueda =Gestor_Agenda_cliente.buscarContacto(textFieldBusqueda.getText());
					filtrarPanel(resultado_de_busqueda);
					}
				}
			});
			panel.add(button);

			actualizarPanel(true);
		}
		
		{
			JButton btnNuevoContacto = new JButton("Nuevo Contacto");
			btnNuevoContacto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FichaContacto fc = new FichaContacto();
					fc.setResizable(false);
					fc.setVisible(true);
					esperarVentanaHija(fc, true);
				}
			});
			btnNuevoContacto.setBackground(Color.WHITE);
			btnNuevoContacto.setBounds(10, 80, 137, 23);
			panel.add(btnNuevoContacto);
		}
		{
			JButton btnModificarContacto = new JButton("Modificar Contacto");
			btnModificarContacto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FichaContacto fc = new FichaContacto(contactos.get(auxIndex),auxIndex);
					fc.setResizable(false);
					fc.setVisible(true);
					esperarVentanaHija(fc, true);
				}
			});
			btnModificarContacto.setBackground(Color.WHITE);
			btnModificarContacto.setBounds(10, 115, 137, 23);
			panel.add(btnModificarContacto);
		}
		{
			JButton btnEliminarContacto = new JButton("Eliminar Contacto");
			btnEliminarContacto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Gestor_Agenda_cliente.eliminarContacto(contactos.get(auxIndex).get(0), Integer.parseInt(contactos.get(auxIndex).get(1)),
							contactos.get(auxIndex).get(2));
				}
			});
			btnEliminarContacto.setBackground(Color.WHITE);
			btnEliminarContacto.setBounds(10, 154, 137, 23);
			panel.add(btnEliminarContacto);
		}
		
	}


	private void actualizarPanel(boolean primerUso){

		contactos = Gestor_Agenda_cliente.mostrarContactos();

		DefaultListModel<ArrayList<String>> model = new DefaultListModel<ArrayList<String>>();

		for (int i = 0; i < contactos.size(); i++) {
			ArrayList<String> auxContacto = contactos.get(i);
			model.addElement(auxContacto);
		}

		JList<ArrayList<String>> dataList = new JList<ArrayList<String>>(model);

		if (!primerUso) scrollPanel.setViewportView(dataList);
		else scrollPanel = new JScrollPane(dataList);

		scrollPanel.setBounds(200, 81, 280, 180);
		panel.add(scrollPanel);

		dataList.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				auxIndex = dataList.getSelectedIndex();
			}
		});


	}

	private void filtrarPanel(ArrayList<ArrayList<String>> resultado_de_busqueda) {

//		ArrayList<ArrayList<String>> contactos = resultado_de_busqueda;

		DefaultListModel<ArrayList<String>> model = new DefaultListModel<ArrayList<String>>();

		for (int i = 0; i < resultado_de_busqueda.size(); i++) {
			ArrayList<String> auxContacto = resultado_de_busqueda.get(i);
			model.addElement(auxContacto);
		}
		
		JList<ArrayList<String>> dataList = new JList<ArrayList<String>>(model);
		scrollPanel.setViewportView(dataList);
		scrollPanel.setBounds(200, 81, 280, 180);
		panel.add(scrollPanel);

		dataList.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
						auxIndex  = dataList.getSelectedIndex();
			}
		});
	}
	
	
	private void esperarVentanaHija(JFrame window, boolean actualizar) {

		window.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {
				OperacionesCliente.this.setEnabled(true);
				OperacionesCliente.this.setVisible(true);
				if(actualizar) actualizarPanel(false);
			}
			public void windowActivated(WindowEvent e) {}
		});
	}
	
	
}