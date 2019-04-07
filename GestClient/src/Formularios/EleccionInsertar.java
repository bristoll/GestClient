package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class EleccionInsertar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EleccionInsertar frame = new EleccionInsertar();
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
	public EleccionInsertar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionaElElemento = new JLabel("Selecciona el elemento que deseas insertar");
		lblSeleccionaElElemento.setBounds(89, 30, 254, 16);
		contentPane.add(lblSeleccionaElElemento);
		
		JButton btnNuevoCliente = new JButton("Nuevo Cliente");
		btnNuevoCliente.setBounds(141, 88, 150, 25);
		contentPane.add(btnNuevoCliente);
		
		JButton btnNuevaPresupuesto = new JButton("Nueva Presupuesto");
		btnNuevaPresupuesto.setBounds(141, 126, 150, 25);
		contentPane.add(btnNuevaPresupuesto);
		
		JButton btnMen = new JButton("Men\u00FA");
		btnMen.setBounds(12, 215, 97, 25);
		contentPane.add(btnMen);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(323, 215, 97, 25);
		contentPane.add(btnSalir);
	}
}
