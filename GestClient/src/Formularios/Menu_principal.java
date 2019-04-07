package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Menu_principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		btnFormInsercin.setBounds(151, 59, 180, 55);
		contentPane.add(btnFormInsercin);
		
		JButton btnFormEliminacin = new JButton("Form. Eliminaci\u00F3n");
		btnFormEliminacin.setBounds(151, 126, 180, 55);
		contentPane.add(btnFormEliminacin);
		
		JButton btnFormConsulta = new JButton("Form. Consulta");
		btnFormConsulta.setBounds(151, 194, 180, 55);
		contentPane.add(btnFormConsulta);
		
		JButton btnFormActualizacin = new JButton("Form. Actualizaci\u00F3n");
		btnFormActualizacin.setBounds(151, 262, 180, 55);
		contentPane.add(btnFormActualizacin);
	}
}
