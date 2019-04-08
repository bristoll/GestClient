package Presupuesto;

public class Presupuesto {

	
	//Definimos los atributos que va a tener nuestra clase cliente(basicamente los campos de nuestra tabla en la base de datos)
	private int NPresupuesto;
	private String Cliente;    
	private String Precio;
	
	//"metemos" todas esas propiedades en el objeto Presupuesto que sera público
	public Presupuesto() {
		//Con this lo que hacemos es accedes a toda la clase en la que se usa
		this.NPresupuesto = NPresupuesto;
		this.Precio = Precio;
		this.Cliente=Cliente;
	}
	
	//Defininos los Get y los Set para meter o recuperar valores de esos atributos

	//Get y Set NPresupuesto
public int getNPresupuesto() {
	return NPresupuesto;
}
public void setNPresupuesto( int NPresupuesto) { //Para los set el tipo es void ya que no devuelve nada, solo mete valores pasados como parametro a la funcion en el atributo NPresupuesto del objeto Cliente
	this.NPresupuesto = NPresupuesto;
}

//Get y Set cliente
public String getCliente() {
return Cliente;
}
public void setCliente( String Cliente) {
this.Cliente = Cliente;
}


	//Get y Set Precio
public String getPrecio() {
	return Precio;
}
public void setPrecio( String Precio) {
	this.Precio = Precio;
}


//Definimos el metodo que nos devolvera un string con todos los datos separados por coma que luego usaremos en el Listar del CRUD
public String toString() {
	return this.NPresupuesto+","+this.Cliente+","+this.Precio;
}








}
