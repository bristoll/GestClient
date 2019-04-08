package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexion.Conexion;

import Presupuesto.ControllerPresupuesto;
import Presupuesto.Presupuesto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;


public class Insertar_Presupuesto extends JFrame {

	private JPanel contentPane;
	private JTextField textPrecio;
	//private JComboBox comboClient;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insertar_Presupuesto frame = new Insertar_Presupuesto();
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
	public Insertar_Presupuesto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertaLosDatos = new JLabel("Inserta los datos del presupuesto");
		lblInsertaLosDatos.setBounds(121, 13, 190, 16);
		contentPane.add(lblInsertaLosDatos);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(12, 66, 56, 16);
		contentPane.add(lblCliente);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(12, 96, 56, 16);
		contentPane.add(lblPrecio);
		
		
		JComboBox comboClient = new JComboBox();
		comboClient.setBounds(80, 63, 116, 22);
		contentPane.add(comboClient);
		
		
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
                   	comboClient.addItem(""+rs.getObject("ID")+"");
                                   
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
		
		
		
		
		
		
		textPrecio = new JTextField();
		//Comprueba que en cuando se introduce algun caracter en el campo de texto es un numero
		textPrecio.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent evt) {
				char validar = evt.getKeyChar();

				if (Character.isLetter(validar)) {
					getToolkit().beep();
					evt.consume();

					JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
				}
			}
		});
		textPrecio.setBounds(80, 93, 116, 22);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Comprobamos que el campo precio no haya quedado vacio
				if(textPrecio.getText().length()==0) {
					JOptionPane.showMessageDialog(rootPane, "El campo precio no puede quedar vacío");
				}else {
					//Hacemos la inserción a traves del controlador
					
					//Instanciamos los objetos necesarios
					Presupuesto presupuesto = new Presupuesto(); 
					
					presupuesto.setCliente((String)comboClient.getSelectedItem());
					presupuesto.setPrecio(textPrecio.getText());
					ControllerPresupuesto controlador = new ControllerPresupuesto();
					
					//Accedemos a los metodos de los objetos que acabamos de instanciar
					controlador.registrar(presupuesto);
					controlador.verPresupuestos();//nos muestra todos los presupuestos en la consola
				}
				
			}
		});
		btnAadir.setBounds(167, 155, 97, 25);
		contentPane.add(btnAadir);
		
		JButton btnMen = new JButton("Men\u00FA");
		btnMen.setBounds(12, 215, 97, 25);
		contentPane.add(btnMen);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(323, 215, 97, 25);
		contentPane.add(btnSalir);
		

	}
}
