package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexion.Conexion;
import Presupuesto.ControllerPresupuesto;
import Presupuesto.Presupuesto;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form_Buscar_Presupuesto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Buscar_Presupuesto frame = new Form_Buscar_Presupuesto();
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
	public Form_Buscar_Presupuesto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNpresupuesto = new JLabel("NPresupuesto:");
		lblNpresupuesto.setBounds(12, 42, 92, 16);
		contentPane.add(lblNpresupuesto);
		
		JComboBox comboNPresupuesto = new JComboBox();
		comboNPresupuesto.setBounds(184, 39, 58, 22);
		contentPane.add(comboNPresupuesto);
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
                   	comboNPresupuesto.addItem(""+rs.getObject("NPresupuesto")+"");
                                   
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
		
		JLabel lblInfo = new JLabel("");
		lblInfo.setBounds(169, 93, 144, 25);
		contentPane.add(lblInfo);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Presupuesto presupuesto = new Presupuesto();
				ControllerPresupuesto controlador = new ControllerPresupuesto();
				
				int NPresupuesto = Integer.parseInt((String)comboNPresupuesto.getSelectedItem());
				presupuesto.setNPresupuesto(NPresupuesto);
				
				controlador.Buscar(presupuesto);
				String datos= presupuesto.toString();
				lblInfo.setText(datos);
				
			}
		});
		btnBuscar.setBounds(163, 131, 97, 25);
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
		
		JLabel lblNpresidclienteprecio = new JLabel("NPres.,IDcliente,Precio");
		lblNpresidclienteprecio.setBounds(169, 74, 156, 16);
		contentPane.add(lblNpresidclienteprecio);
	}

}
