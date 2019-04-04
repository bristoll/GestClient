package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	//Funcion para conectar usa el tipo Connection de sql
	public static Connection conectar() {
		Connection con = null;
		
		String usuario = "root";
		String pass = "";
		try {
			String servidor ="";
			con = DriverManager.getConnection(servidor, usuario, pass);
			
			if(con!=null) {
				System.out.println("Conectado");
			}
		}catch(SQLException e) {
			System.out.println("No se ha podido conectar");
			e.printStackTrace();
		}
		return con;
	}
}
