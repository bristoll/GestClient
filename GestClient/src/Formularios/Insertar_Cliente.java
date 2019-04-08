package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import Clientes.Cliente;
import Clientes.ControllerCliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Insertar_Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textTlfn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insertar_Cliente frame = new Insertar_Cliente();
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
	public Insertar_Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInserteLosDatos = new JLabel("Inserte los datos del nuevo cliente");
		lblInserteLosDatos.setBounds(116, 13, 200, 16);
		contentPane.add(lblInserteLosDatos);
		
		JLabel lblNombreCompleto = new JLabel("Nombre completo: ");
		lblNombreCompleto.setBounds(12, 80, 118, 16);
		contentPane.add(lblNombreCompleto);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(12, 109, 56, 16);
		contentPane.add(lblTelfono);
		
		textNombre = new JTextField();
		textNombre.setBounds(158, 77, 116, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textTlfn = new JTextField();
		textTlfn.setBounds(158, 106, 116, 22);
		contentPane.add(textTlfn);
		textTlfn.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Instanciamos un nuevo cliente
				Cliente cliente = new Cliente();
				cliente.setNombre(textNombre.getText());//Obtenemos el nombre introducido en el campo de texto y lo metemos en el setter de la clase cliente
				int tlfn = Integer.parseInt(textTlfn.getText());//Convertimos el texto obtenido en int para poder meterlo en la base de datos y en el setter de la clase cliente
				cliente.setTelefono(tlfn);
				
				//Instanciamos el controlador para poder usarlo
				ControllerCliente controlador = new ControllerCliente();
				
				//Accedemos a los metodos que queremos usar mediante el controlador
				controlador.registrar(cliente);
				controlador.verClientes();
				
			}
		});
		btnRegistrar.setBounds(168, 159, 97, 25);
		contentPane.add(btnRegistrar);
		
		JButton btnMen = new JButton("Men\u00FA");
		btnMen.setBounds(12, 215, 97, 25);
		contentPane.add(btnMen);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(323, 215, 97, 25);
		contentPane.add(btnSalir);
	}

}
