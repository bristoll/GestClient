package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] e) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_principal frame = new Menu_principal();
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
	public Menu_principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFormInsercin = new JButton("Form. Inserci\u00F3n");
		btnFormInsercin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EleccionInsertar ventEleccion = new EleccionInsertar();
				ventEleccion.setVisible(true);
				dispose();
			}
		});
		btnFormInsercin.setBounds(151, 59, 180, 55);
		contentPane.add(btnFormInsercin);
		
		JButton btnFormEliminacin = new JButton("Form. Eliminaci\u00F3n");
		btnFormEliminacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Form_Eliminacion VentE = new Form_Eliminacion();
				VentE.setVisible(true);
				dispose();
			}
		});
		btnFormEliminacin.setBounds(151, 126, 180, 55);
		contentPane.add(btnFormEliminacin);
		
		JButton btnFormConsulta = new JButton("Form. Consulta");
		btnFormConsulta.setBounds(151, 194, 180, 55);
		contentPane.add(btnFormConsulta);
		
		JButton btnFormActualizacin = new JButton("Form. Actualizaci\u00F3n");
		btnFormActualizacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					EleccionActualizar VentA = new EleccionActualizar();
					VentA.setVisible(true);
					dispose();
			}
		});
		btnFormActualizacin.setBounds(151, 262, 180, 55);
		contentPane.add(btnFormActualizacin);
	}
}
