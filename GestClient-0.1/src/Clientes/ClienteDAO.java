package Clientes;
import java.util.List;
//Clase intermedia (interface) que solo sirve para listar de forma independiente de la implementacion lo que luego se usará en la implementacion
public interface ClienteDAO {

	public boolean registrar(Cliente cliente);//( Cliente cliente) es una forma de instanciar Cliente en cliente sin hacerlo dentro (se ve mejor en la implementacion)
	public List<Cliente> obtener();
	public boolean actualizar(Cliente cliente);
	public boolean eliminar(Cliente cliente);
	
	
}
