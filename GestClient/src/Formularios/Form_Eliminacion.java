package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clientes.Cliente;
import Clientes.ControllerCliente;
import Presupuesto.ControllerPresupuesto;
import Presupuesto.Presupuesto;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form_Eliminacion extends JFrame {

	private JPanel contentPane;
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Eliminacion frame = new Form_Eliminacion();
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
	public Form_Eliminacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItemAEliminar = new JLabel("Item a eliminar: ");
		lblItemAEliminar.setBounds(12, 49, 96, 16);
		contentPane.add(lblItemAEliminar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Presupuesto"}));
		comboBox.setBounds(163, 46, 106, 22);
		contentPane.add(comboBox);
		
		JLabel lblIdAEliminar = new JLabel("ID a eliminar:");
		lblIdAEliminar.setBounds(12, 105, 96, 16);
		contentPane.add(lblIdAEliminar);
		
		textID = new JTextField();
		textID.setBounds(163, 102, 106, 22);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ((String)comboBox.getSelectedItem() == "Cliente"){
					//Hacemos la eliminacion para el ID del cliente seleccionado
						Cliente cliente = new Cliente();
						ControllerCliente controlador = new ControllerCliente();
						int ID = Integer.parseInt(textID.getText());//Convertimos el texto obtenido en int para poder meterlo en la base de datos y en el setter de la clase cliente
						cliente.setID(ID);
						controlador.eliminar(cliente);
						
						
				}else {
					//Hacemos la eliminacion para el ID del presupuesto
						Presupuesto presupuesto = new Presupuesto();
						ControllerPresupuesto controlador = new ControllerPresupuesto();
						int NPresupuesto = Integer.parseInt(textID.getText());//Convertimos el texto obtenido en int para poder meterlo en la base de datos y en el setter de la clase cliente
						presupuesto.setNPresupuesto(NPresupuesto);
						controlador.eliminar(presupuesto);
				}
				
				
			}
		});
		btnEliminar.setBounds(167, 156, 97, 25);
		contentPane.add(btnEliminar);
		
		JButton btnMen = new JButton("Men\u00FA");
		btnMen.setBounds(11, 215, 97, 25);
		contentPane.add(btnMen);
		
		JButton btnSallir = new JButton("Sallir");
		btnSallir.setBounds(323, 215, 97, 25);
		contentPane.add(btnSallir);
	}
}
