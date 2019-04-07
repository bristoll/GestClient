package Presupuesto;

import java.util.ArrayList;
import java.util.List;



public class ControllerPresupuesto {
	
	//Creamos una nueva vista
	private VistaPresupuesto vista = new VistaPresupuesto();
	
	//Porque el constructor se queda vacio? porque no inicializa con nada??
	public ControllerPresupuesto() {
		}
	
	
	//Llamada el "metodo" para guardar presupuesto
	public void registrar (Presupuesto presupuesto) {
		PresupuestoDAO dao = new PresupuestoDAOImpl();//OJO porque es del tipo presupuestoDAO pero de la clase PresupuestoDAOImpl!
		vista.verPresupuesto(presupuesto);
		dao.registrar(presupuesto);
		
	}
	
	//Llamada el "metodo" para guardar presupuesto
	public void actualizar (Presupuesto presupuesto) {
		PresupuestoDAO dao = new PresupuestoDAOImpl();//OJO porque es del tipo presupuestoDAO pero de la clase PresupuestoDAOImpl!
		vista.verPresupuesto(presupuesto);
		dao.actualizar(presupuesto);
		
	}	
	
	//Llamada el "metodo" para eliminar presupuesto
	public void eliminar (Presupuesto presupuesto) {
		PresupuestoDAO dao = new PresupuestoDAOImpl();//OJO porque es del tipo presupuestoDAO pero de la clase PresupuestoDAOImpl!
		vista.verPresupuesto(presupuesto);
		dao.eliminar(presupuesto);
		
	}
	//llama al DAO("metodo") para obtener todos los presupuestos y luego los muestra en la vista
	public void verPresupuestos(){
		List<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
		PresupuestoDAO dao= new  PresupuestoDAOImpl();
		presupuestos=dao.obtener();
		vista.verPresupuestos(presupuestos);//Llamamos a ver presupuestos para mostrar el resultado
	}
	
	
}
