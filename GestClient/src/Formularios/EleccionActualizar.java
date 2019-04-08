package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EleccionActualizar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EleccionActualizar frame = new EleccionActualizar();
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
	public EleccionActualizar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnActualizarCliente = new JButton("Actualizar Cliente");
		btnActualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Form_Actualizar_Cliente VentA = new Form_Actualizar_Cliente();
				VentA.setVisible(true);
				dispose();
			}
		});
		btnActualizarCliente.setBounds(150, 67, 131, 45);
		contentPane.add(btnActualizarCliente);
		
		JButton btnActualizarPresupuesto = new JButton("Actualizar Presupuesto");
		btnActualizarPresupuesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Form_Actualizar_Presupuesto VentA = new Form_Actualizar_Presupuesto();
				VentA.setVisible(true);
				dispose();
			}
		});
		btnActualizarPresupuesto.setBounds(132, 125, 168, 45);
		contentPane.add(btnActualizarPresupuesto);
		
		JButton btnMen = new JButton("Men\u00FA");
		btnMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_principal menu = new Menu_principal();
				menu.setVisible(true);
				dispose();
			}
		});
		btnMen.setBounds(12, 215, 97, 25);
		contentPane.add(btnMen);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(323, 215, 97, 25);
		contentPane.add(btnSalir);
	}

}
