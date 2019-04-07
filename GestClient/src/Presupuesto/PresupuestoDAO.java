package Presupuesto;
import java.util.List;
//Clase intermedia (interface) que solo sirve para listar de forma independiente de la implementacion lo que luego se usará en la implementacion
public interface PresupuestoDAO {

	public boolean registrar(Presupuesto presupuesto);//( Presupuesto presupuesto) es una forma de instanciar Cliente en cliente sin hacerlo dentro (se ve mejor en la implementacion)
	public List<Presupuesto> obtener();
	public boolean actualizar(Presupuesto presupuesto);
	public boolean eliminar(Presupuesto presupuesto);
	
	
}