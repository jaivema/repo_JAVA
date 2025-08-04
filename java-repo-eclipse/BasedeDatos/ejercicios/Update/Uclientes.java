package Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Uclientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			}
			catch(Exception c1) {
				System.out.println("Error al leer BBDD CLIENTES: "+c1.getMessage());
			}
			finally {
				try {
					rs.close();
				} 
				catch (Exception c2) {
					System.out.println("error al cerrar BBDD CLIENTES: "+c2.getMessage());
				}
			}

		}
		catch(Exception c) {
			System.out.println("Error al conectar a la BBDD: "+c.getMessage());
		}
		
		
		Scanner entrada = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection conUpdate = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/programacion","usuario1","Curso2022"
					);
		
			System.out.println("Introduce el id a modificar: ");
			String id=entrada.nextLine();
			System.out.println("Introduce el nuevo nombre: ");
			String nombre=entrada.nextLine();
                
            try {
                //guarda variable sql la sentencia DELETE
                String sql="UPDATE `nombres` SET `nombre`='"+nombre+"' WHERE `nombres`.`id` = "+id;
                PreparedStatement preparedstmt = conUpdate.prepareStatement(sql);
                
                //ejecuta el sql
                preparedstmt.execute();
            
            }
            catch(Exception u1) {
            	System.out.println("Error al modificar BBDD CLIENTES: \n"+u1.getMessage());
            	
            }
            finally{
            	try {
					conUpdate.close();
				} 
            	catch (Exception u2) {
					System.out.println("error al cerrar BBDD CLIENTES: "+u2.getMessage());
				}
            }
                
		}catch(Exception u) {
			System.out.println("Error al leer BBDD CLIENTES: \n"+u.getMessage());
			
		}
		entrada.close();
	}

}
