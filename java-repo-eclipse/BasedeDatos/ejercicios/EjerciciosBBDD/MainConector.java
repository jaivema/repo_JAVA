package EjerciciosBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainConector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//Crear la conexion a la base de datos de mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection con = DriverManager.getConnection(
					//											user		pass
					"jdbc:mysql://localhost:3306/programacion","usuario1","Curso2022"
					);
			Statement stmt = con.createStatement();
			
			//ejecutar la sentencia sql
			ResultSet   rs = stmt.executeQuery("SELECT * FROM `nombres`");
			
			//lectura y mostrar por consola el contenido
			while (rs.next()){
				int id = 1;
				int nombre = 2; 
				System.out.println(rs.getInt(id)+" "+rs.getString(nombre));
			}

		}catch(Exception e) {
			System.out.println("Error al conectar a la BBDD: "+e.getMessage());
		}
	}
}
