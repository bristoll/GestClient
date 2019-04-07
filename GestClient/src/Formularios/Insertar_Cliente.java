package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

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
