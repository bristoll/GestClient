package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clientes.Cliente;
import Clientes.ControllerCliente;
import Conexion.Conexion;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form_Buscar_Cliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Buscar_Cliente frame = new Form_Buscar_Cliente();
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
	public Form_Buscar_Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboID = new JComboBox();
		comboID.setBounds(188, 44, 56, 22);
		contentPane.add(comboID);
		
		//Hacemos una conexión a la base de datos para obtener los datos con los que rellenar el desplegable 
        try {
            //   System.out.println("INICIO DE EJECUCIÓN.");
               Class.forName("com.mysql.cj.jdbc.Driver");
               
               Conexion conex=new Conexion();
       		
               Statement st = conex.conectar().createStatement();
               ResultSet rs = st.executeQuery("SELECT * FROM clientes");
              
               if (rs != null) {
               //    System.out.println("El listado de viviendas es el siguiente:");
    
                   while (rs.next()) {
                  //Recupera los campos ID y Nombre para mostrarlos en el desplegable
                   	comboID.addItem(""+rs.getObject("ID")+"");
                                   
                   }
                   
                   
                   rs.close();
               }
               st.close();
    
           }
           catch(SQLException s)
           {
               System.out.println("Error: SQL.");
               System.out.println("SQLException: " + s.getMessage());
           }
           catch(Exception s)
           {
               System.out.println("Error: Varios.");
               System.out.println("SQLException: " + s.getMessage());
		
           }
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(12, 47, 56, 16);
		contentPane.add(lblId);
		
		JLabel labelInfo = new JLabel("");
		labelInfo.setBounds(116, 99, 287, 22);
		contentPane.add(labelInfo);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				ControllerCliente controlador = new ControllerCliente();
				int ID = Integer.parseInt((String)comboID.getSelectedItem());
				cliente.setID(ID);
				
				controlador.Buscar(cliente);
				String datos = cliente.toString();
				labelInfo.setText(datos);
			}
		});
		btnBuscar.setBounds(167, 134, 97, 25);
		contentPane.add(btnBuscar);
		
		JButton btnMen = new JButton("Men\u00FA");
		btnMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EleccionBuscar VenB = new EleccionBuscar();
				VenB.setVisible(true);
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
		
		JLabel lblIdNombreTelfono = new JLabel("Id, Nombre, Tel\u00E9fono");
		lblIdNombreTelfono.setBounds(116, 68, 163, 16);
		contentPane.add(lblIdNombreTelfono);
		
		
	}

}
