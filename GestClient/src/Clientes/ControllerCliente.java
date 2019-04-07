package Clientes;

import java.util.ArrayList;
import java.util.List;



public class ControllerCliente {
	
	//Creamos una nueva vista
	private VistaCliente vista = new VistaCliente();
	
	//Porque el constructor se queda vacio? porque no inicializa con nada??
	public ControllerCliente() {
		}
	
	
	//Llamada el "metodo" para guardar cliente
	public void registrar (Cliente cliente) {
		ClienteDAO dao = new ClienteDAOImpl();//OJO porque es del tipo clienteDAO pero de la clase ClienteDAOImpl!
		vista.verCliente(cliente);
		dao.registrar(cliente);
		
	}
	
	//Llamada el "metodo" para guardar cliente
	public void actualizar (Cliente cliente) {
		ClienteDAO dao = new ClienteDAOImpl();//OJO porque es del tipo clienteDAO pero de la clase ClienteDAOImpl!
		vista.verCliente(cliente);
		dao.actualizar(cliente);
		
	}	
	
	//Llamada el "metodo" para eliminar cliente
	public void eliminar (Cliente cliente) {
		ClienteDAO dao = new ClienteDAOImpl();//OJO porque es del tipo clienteDAO pero de la clase ClienteDAOImpl!
		vista.verCliente(cliente);
		dao.eliminar(cliente);
		
	}
	//llama al DAO("metodo") para obtener todos los clientes y luego los muestra en la vista
	public void verClientes(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteDAO dao= new  ClienteDAOImpl();
		clientes=dao.obtener();
		vista.verClientes(clientes);//Llamamos a ver clientes para mostrar el resultado
	}
	
	
}
