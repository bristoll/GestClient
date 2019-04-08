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

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form_Actualizar_Cliente extends JFrame {

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
					Form_Actualizar_Cliente frame = new Form_Actualizar_Cliente();
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
	public Form_Actualizar_Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setBounds(12, 27, 56, 16);
		contentPane.add(lblId);
		
		JComboBox comboID = new JComboBox();
		comboID.setBounds(179, 24, 76, 22);
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
		
		JLabel lblCamposAActualizar = new JLabel("Campos a actualizar: ");
		lblCamposAActualizar.setBounds(153, 78, 125, 16);
		contentPane.add(lblCamposAActualizar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 115, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(12, 144, 56, 16);
		contentPane.add(lblTelfono);
		
		textNombre = new JTextField();
		textNombre.setBounds(159, 112, 116, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textTlfn = new JTextField();
		textTlfn.setBounds(159, 141, 116, 22);
		contentPane.add(textTlfn);
		textTlfn.setColumns(10);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Instanciamos los objetos necesarios
				Cliente cliente = new Cliente();
				ControllerCliente controlador = new ControllerCliente();
				
				//Metemos los datos a traves de los set 
				int ID = Integer.parseInt((String)comboID.getSelectedItem());
				cliente.setID(ID);
				int Tlfn = Integer.parseInt(textTlfn.getText());//Convertimos el texto obtenido en int para poder meterlo en la base de datos y en el setter de la clase cliente
				cliente.setTelefono(Tlfn);
				cliente.setNombre(textNombre.getText());
				controlador.actualizar(cliente);
				
				
			}
		});
		btnActualizar.setBounds(168, 184, 97, 25);
		contentPane.add(btnActualizar);
		
		JButton btnMen = new JButton("Men\u00FA");
		btnMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EleccionActualizar Menu = new EleccionActualizar();
				Menu.setVisible(true);
				dispose();
			}
		});
		btnMen.setBounds(12, 270, 97, 25);
		contentPane.add(btnMen);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(325, 270, 97, 25);
		contentPane.add(btnSalir);
	}

}
