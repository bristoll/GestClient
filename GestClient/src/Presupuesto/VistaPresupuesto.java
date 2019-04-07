package Presupuesto;

import java.util.List;

public class VistaPresupuesto {

	//Creamosdos metodos, uno para ver un solo presupuesto y otro para ver una lista de presupuesto
	public void verPresupuesto(Presupuesto presupuesto) {
		System.out.println("Datos del presupuesto; "+presupuesto);
	}
	//Se crea un nuevo metodo con la lista que llamamos presupuestos e imprimimos cada presupuesto dentro de la lista de presupuestos
	public void verPresupuestos(List<Presupuesto> presupuestos) {
		for (Presupuesto presupuesto:presupuestos) {
			System.out.println("Datos de presupuesto: "+presupuesto);
		}
	}
}
