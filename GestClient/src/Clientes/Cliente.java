package Clientes;
//Clase que contendra todas las propiedades de la base de datos de la tabla clientes y que tendra todos los metodos para introducir y recuperar datos del objeto cliente
public class Cliente {
	
	//Definimos los atributos que va a tener nuestra clase cliente(basicamente los campos de nuestra tabla en la base de datos)
	private int ID;
	private String Nombre;
	private int Telefono;
	
	//"metemos" todas esas propiedades en el objeto cliente que sera público
	public Cliente() {
		//Con this lo que hacemos es accedes a toda la clase en la que se usa
		this.ID = ID;
		this.Nombre = Nombre;
		this.Telefono = Telefono;
	}
	
	//Defininos los Get y los Set para meter o recuperar valores de esos atributos

	//Get y Set ID
public int getID() {
	return ID;
}
public void setID( int ID) { //Para los set el tipo es void ya que no devuelve nada, solo mete valores pasados como parametro a la funcion en el atributo ID del objeto Cliente
	this.ID = ID;
}
	//Get y Set Nombre
public String getNombre() {
	return Nombre;
}
public void setNombre( String Nombre) {
	this.Nombre = Nombre;
}
	//Get y Set Telefono
public int getTelefono() {
	return Telefono;
}
public void setTelefono( int Telefono) {
	this.Telefono = Telefono;
}

//Definimos el metodo que nos devolvera un string con todos los datos separados por coma que luego usaremos en el Listar del CRUD
public String toString() {
	return this.ID+","+this.Nombre+","+this.Telefono;
}






}
