package Operaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Insertar {
	Scanner entrada;

	//constructor
	public Insertar(Scanner entrada) {
		super();
		this.entrada = entrada;
	}

	public void insertar() {
		String Nombre=null;
		System.out.println("***** INSERTAR CLIENTES *****");
		System.out.print("Nombre: ");		 Nombre = entrada.nextLine();
		
		try {
////////Conexion del INSERT
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conInsert = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/programacion","usuario1","Curso2022"
					);
			Statement stmt = conInsert.createStatement();
		
			try {
				//ejecutar la sentencia sql
				String sql = "INSERT INTO `nombres`(`nombre`) "
						+ "VALUES ('"+Nombre+"')";
					
				stmt.executeUpdate(sql);
				
			}catch(Exception i1) {
				System.out.println("Error al insertar datos CLIENTES: "+i1.getMessage());
			}finally {
				//cierra base de datos
				conInsert.close();
			}

		}catch(Exception i) {
			System.out.println("Error al abrir insert CLIENTES: "+i.getMessage());
		}
	}
}
