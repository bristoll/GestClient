package Presupuesto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Conexion.Conexion;



//Importante que hay que especificar que PresupuestoDAOImpl esta implementando la interface de PresupuestoDAO
public class PresupuestoDAOImpl implements PresupuestoDAO {
	
	//Definimos los metodos que habiamos listado en la clase presupuesto DAO
	
	//Insertar nuevos datos del presupuesto
	public boolean registrar(Presupuesto presupuesto) {
		boolean registrar = false;
		
		//objetos para la conexion a la base de datos
		Statement stm = null;
		Connection con = null;
		int ClienteID = Integer.parseInt(presupuesto.getCliente());
		//Definimos el query SQL que vamos a utilizar( ojo que accedemos a traves de objeto presupuesto que hemos creado no hace falta instanciar nada)
		String insert = "INSERT INTO presupuestos values (NULL,'"+ClienteID+"','"+presupuesto.getPrecio()+"')";
		
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
			System.out.println("Error: Clase PresupuestoDAOImpl, método registrar");
			e.printStackTrace();
		}
		return registrar;//devuelve true si se ha conseguido insertar y false en caso contrario
	}
	
	//Recuperar los datos de presupuesto de la BBDD
public List<Presupuesto> obtener(){
	//objetos para la conexion a la base de datos
	Connection co = null;
	Statement stm = null;
	ResultSet rs=null;
	
	//Establecemos el query para obtener los datos de la base de datos
	String select= "SELECT * FROM presupuestos ORDER BY NPresupuesto";
	
	//instanciamos un nuevo arraylist para guardar los datos que vayamos sacando
	List<Presupuesto> listapresupuesto = new ArrayList<Presupuesto>();
	
	try {
		//Conexion a la base de datos
		co = Conexion.conectar();
		stm = co.createStatement();
		rs = stm.executeQuery(select);
		
		//mientras queden registros ir metiendo las propiedades de cada registro en la lista
		while(rs.next()) {
			Presupuesto presupuesto = new Presupuesto();//instanciamos
			//cogemos los valores de las columnas
			presupuesto.setNPresupuesto(rs.getInt(1));
			presupuesto.setCliente(rs.getString(2));
			presupuesto.setPrecio(rs.getString(3));
			
			
			//metemos el presupuesto con toda la info en la lista
			listapresupuesto.add(presupuesto);
		}
		//cerramos conexiones
		stm.close();
		rs.close();
		co.close();
	}catch(SQLException e) {
		System.out.println("Error: Clase PresupuestoDAOImpl, método obtener");
		e.printStackTrace();
	}
	return listapresupuesto;//Devuelve la lista con los presupuestos y sus datos
}
	//Actualizar un registro de la base de datos
	public boolean actualizar (Presupuesto presupuesto) {
		Connection connect = null;
		Statement stm = null;
		
		boolean actualizar = false;
		
		String updt="UPDATE presupuestos SET Precio='"+presupuesto.getPrecio()+"', Cliente='"+presupuesto.getCliente()+"' WHERE NPresupuesto="+presupuesto.getNPresupuesto();
		try {
			connect = Conexion.conectar();
			stm = connect.createStatement();
			stm.execute(updt);
			actualizar = true;
		}catch(SQLException e){
			System.out.println("Error: Clase PresupuestoDAOImpl, método actualizar");
			e.printStackTrace();
		}
		return actualizar;
	}
	
	
	//Eliminar registro de la base de datos
	public boolean eliminar(Presupuesto presupuesto) {
		Connection connect = null;
		Statement stm = null;
		
		boolean eliminar = false;
		
		String delete = "DELETE FROM presupuestos WHERE NPresupuesto="+presupuesto.getNPresupuesto();
		try {
			connect = Conexion.conectar();
			stm = connect.createStatement();
			stm.execute(delete);
			eliminar = true;
		}catch(SQLException e) {
			System.out.println("Error: Clase PresupuestoDAOImpl, método eliminar");
			e.printStackTrace();
		}
		return eliminar;
	
}
	

}
