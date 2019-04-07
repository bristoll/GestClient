package Clientes;

import java.util.List;

public class VistaCliente {

	//Creamosdos metodos, uno para ver un solo cliente y otro para ver una lista de cliente
	public void verCliente(Cliente cliente) {
		System.out.println("Datos del cliente; "+cliente);
	}
	//Se crea un nuevo metodo con la lista que llamamos clientes e imprimimos cada cliente dentro de la lista de clientes
	public void verClientes(List<Cliente> clientes) {
		for (Cliente cliente:clientes) {
			System.out.println("Datos de cliente: "+cliente);
		}
	}
}
