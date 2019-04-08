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
import Presupuesto.ControllerPresupuesto;
import Presupuesto.Presupuesto;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form_Actualizar_Presupuesto extends JFrame {

	private JPanel contentPane;
	private JTextField textPrecio;
	private JTextField textCactual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Actualizar_Presupuesto frame = new Form_Actualizar_Presupuesto();
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
	public Form_Actualizar_Presupuesto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("NPresupuesto");
		lblId.setBounds(12, 30, 97, 16);
		contentPane.add(lblId);
		
		JComboBox comboID = new JComboBox();
		comboID.setBounds(170, 27, 95, 22);
		contentPane.add(comboID);
		//Hacemos una conexión a la base de datos para obtener los datos con los que rellenar el desplegable 
        try {
            //   System.out.println("INICIO DE EJECUCIÓN.");
               Class.forName("com.mysql.cj.jdbc.Driver");
               
               Conexion conex=new Conexion();
       		
               Statement st = conex.conectar().createStatement();
               ResultSet rs = st.executeQuery("SELECT * FROM presupuestos");
              
               if (rs != null) {
               //    System.out.println("El listado de viviendas es el siguiente:");
    
                   while (rs.next()) {
                  //Recupera los campos ID y Nombre para mostrarlos en el desplegable
                   	comboID.addItem(""+rs.getObject("NPresupuesto")+"");
                                   
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
		
		JLabel lblDatosAActualizar = new JLabel("Datos a actualizar:");
		lblDatosAActualizar.setBounds(164, 142, 107, 16);
		contentPane.add(lblDatosAActualizar);
		
		JLabel lblCliente = new JLabel("Nuevo cliente:");
		lblCliente.setBounds(12, 194, 97, 16);
		contentPane.add(lblCliente);
		
		JComboBox comboCliente = new JComboBox();
		comboCliente.setBounds(170, 191, 95, 22);
		contentPane.add(comboCliente);
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
                	    Object Presup = rs.getObject("ID");
                   	comboCliente.addItem(""+Presup+"");
                                   
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
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(12, 253, 56, 16);
		contentPane.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(159, 250, 116, 22);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		JLabel lblClienteActual = new JLabel("Cliente Actual:");
		lblClienteActual.setBounds(12, 84, 97, 16);
		contentPane.add(lblClienteActual);
		
		
		//Prendiente de implementar
		//Mostrar el cliente actual  segun el NPresupuesto seleccionado.
		//El problema es que no se actualiza al cambiar la seleccion hay que buscar algun actionlistener para ello
		
//		textCactual = new JTextField();
//		textCactual.setBounds(189, 81, 56, 22);
//		contentPane.add(textCactual);
//		textCactual.setColumns(10);
//		//Hacemos una conexión a la base de datos para obtener los datos con los que rellenar el desplegable 
//        try {
//            //   System.out.println("INICIO DE EJECUCIÓN.");
//               Class.forName("com.mysql.cj.jdbc.Driver");
//               
//               Conexion conex=new Conexion();
//       		
//               Statement st = conex.conectar().createStatement();
//               ResultSet rs = st.executeQuery("SELECT cliente FROM presupuestos WHERE NPresupuesto="+comboID.getSelectedItem());
//              
//               if (rs != null) {
//               //    System.out.println("El listado de viviendas es el siguiente:");
//    
//                   while (rs.next()) {
//                  //Recupera los campos ID y Nombre para mostrarlos en el desplegable
//                	   textCactual.setText(""+rs.getObject("Cliente")+"");
//                                   
//                   }
//                   
//                   
//                   rs.close();
//               }
//               st.close();
//    
//           }
//           catch(SQLException s)
//           {
//               System.out.println("Error: SQL.");
//               System.out.println("SQLException: " + s.getMessage());
//           }
//           catch(Exception s)
//           {
//               System.out.println("Error: Varios.");
//               System.out.println("SQLException: " + s.getMessage());
//		
//           }
		
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Instanciamos los objetos necesarios
				Presupuesto presupuesto = new Presupuesto();
				ControllerPresupuesto controlador = new ControllerPresupuesto();
				
				//Metemos los datos a traves de los set 
				int NPresupuesto = Integer.parseInt((String)comboID.getSelectedItem());
				presupuesto.setNPresupuesto(NPresupuesto);
				presupuesto.setPrecio(textPrecio.getText());
				presupuesto.setCliente((String)comboCliente.getSelectedItem());
				controlador.actualizar(presupuesto);
				
			}
		});
		btnActualizar.setBounds(169, 288, 97, 25);
		contentPane.add(btnActualizar);
		
		JButton btnMen = new JButton("Men\u00FA");
		btnMen.setBounds(12, 360, 97, 25);
		contentPane.add(btnMen);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(326, 360, 97, 25);
		contentPane.add(btnSalir);
		

	}

}
