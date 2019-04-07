package Clientes;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexion.Conexion;
//Importante que hay que especificar que ClienteDAOImpl esta implementando la interface de ClienteDAO
public class ClienteDAOImpl implements ClienteDAO {
	
	//Definimos los metodos que habiamos listado en la clase cliente DAO
	
	//Insertar nuevos datos del cliente
	public boolean registrar(Cliente cliente) {
		boolean registrar = false;
		
		//objetos para la conexion a la base de datos
		Statement stm = null;
		Connection con = null;
		
		//Definimos el query SQL que vamos a utilizar( ojo que accedemos a traves de objeto cliente que hemos creado no hace falta instanciar nada)
		String insert = "INSERT INTO clientes values (NULL,'"+cliente.getNombre()+"','"+cliente.getTelefono()+"')";
		
		try {
			//Hacemos la conexion y ejecutamos el query
			con = Conexion.conectar();//Aun por crear la clase
			stm = con.createStatement();
			stm.execute(insert);
			//Si ha llegado hasta aquí es que se ha registrado por lo que hacemos registrar = true
			registrar=true;
			
			//Cerramos la conexion
			stm.close();
			con.close();
			
			
		}catch(SQLException e){
			System.out.println("Error: Clase ClienteDAOImpl, método registrar");
			e.printStackTrace();
		}
		return registrar;//devuelve true si se ha conseguido insertar y false en caso contrario
	}
	
	//Recuperar los datos de cliente de la BBDD
public List<Cliente> obtener(){
	//objetos para la conexion a la base de datos
	Connection co = null;
	Statement stm = null;
	ResultSet rs=null;
	
	//Establecemos el query para obtener los datos de la base de datos
	String select= "SELECT * FROM clientes ORDER BY ID";
	
	//instanciamos un nuevo arraylist para guardar los datos que vayamos sacando
	List<Cliente> listacliente = new ArrayList<Cliente>();
	
	try {
		//Conexion a la base de datos
		co = Conexion.conectar();
		stm = co.createStatement();
		rs = stm.executeQuery(select);
		
		//mientras queden registros ir metiendo las propiedades de cada registro en la lista
		while(rs.next()) {
			Cliente client = new Cliente();//instanciamos
			//cogemos los valores de las columnas
			client.setID(rs.getInt(1));
			client.setNombre(rs.getString(2));
			client.setTelefono(rs.getInt(3));
			
			//metemos el cliente con toda la info en la lista
			listacliente.add(client);
		}
		//cerramos conexiones
		stm.close();
		rs.close();
		co.close();
	}catch(SQLException e) {
		System.out.println("Error: Clase ClienteDAOImpl, método registrar");
		e.printStackTrace();
	}
	return listacliente;//Devuelve la lista con los clientes y sus datos
}
	//Actualizar un registro de la base de datos
	public boolean actualizar (Cliente cliente) {
		Connection connect = null;
		Statement stm = null;
		
		boolean actualizar = false;
		
		String updt="UPDATE clientes SET Nombre='"+cliente.getNombre()+"', Telefono='"+cliente.getTelefono() +" WHERE ID="+cliente.getID();
		try {
			connect = Conexion.conectar();
			stm = connect.createStatement();
			stm.execute(updt);
			actualizar = true;
		}catch(SQLException e){
			System.out.println("Error: Clase ClienteDAOImpl, método registrar");
			e.printStackTrace();
		}
		return actualizar;
	}
	
	
	//Eliminar registro de la base de datos
	public boolean eliminar(Cliente cliente) {
		Connection connect = null;
		Statement stm = null;
		
		boolean eliminar = false;
		
		String delete = "DELETE FROM clientes WHERE ID="+cliente.getID();
		try {
			connect = Conexion.conectar();
			stm = connect.createStatement();
			stm.execute(delete);
			eliminar = true;
		}catch(SQLException e) {
			System.out.println("Error: Clase ClienteDAOImpl, método registrar");
			e.printStackTrace();
		}
		return eliminar;
	
}
	

}
