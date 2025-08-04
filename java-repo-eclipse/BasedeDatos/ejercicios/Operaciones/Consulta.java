package Operaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Consulta {
	Scanner entrada;

	public Consulta(Scanner entrada) {
	super();
	this.entrada = entrada;
	}
	
	public void consulta() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(""
					+ "jdbc:mysql://localhost:3306/programacion","usuario1","Curso2022"
					);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `nombres`");

			try {
				//lectura y mostrar por consola el contenido
				System.out.println("***********************************************************");
				while (rs.next()){
					System.out.println("id:            |"+rs.getString(1));
					System.out.println("Nombre:        |"+rs.getString(2));
					System.out.println("***********************************************************");					
				}
			}catch(Exception c1) {
				System.out.println("Error al leer BBDD CLIENTES: "+c1.getMessage());
			}finally {
				try {
					rs.close();
				} catch (Exception c2) {
					System.out.println("error al cerrar BBDD CLIENTES: "+c2.getMessage());
				}
			}
			
			}catch(Exception c) {
				System.out.println("Error al conectar a la BBDD: "+c.getMessage());
			}
		}
	}
