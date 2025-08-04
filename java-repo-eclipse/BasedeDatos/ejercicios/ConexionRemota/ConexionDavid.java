package ConexionRemota;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ConexionDavid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String Nombre=null;
		
 //////Crear la conexion a la base de datos de mysql
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://92.57.66.37:3306/programacion","usuario1","Curso2022"
					);
			Statement stmt = con.createStatement();
			
			//ejecutar la sentencia sql
			ResultSet   rs = stmt.executeQuery("SELECT * FROM `nombres`");
		
			try {
				//lectura y mostrar por consola el contenido
				System.out.println("***********************************************************");
				while (rs.next()){
					System.out.println("id:            |"+rs.getString(1));
					System.out.println("Nombre         |"+rs.getString(2));
					System.out.println("***********************************************************");					
				}
	
			}catch(Exception e1) {
				System.out.println("Error al leer BBDD NOMBRES: "+e1.getMessage());
			}finally {
				try {
					rs.close();
				} catch (Exception e2) {
					System.out.println("error al cerrar BBDD NOMBRES: "+e2.getMessage());
				}
			}
		}catch(Exception e) {
			System.out.println("error al abrir BBDD NOMBRES: "+e.getMessage());
		}

		Scanner entrada = new Scanner (System.in);
				
		System.out.println("***** INSERTAR NOMBRES *****");
		System.out.print("Nombre: ");		 Nombre = entrada.nextLine();
		try {
////////Conexion del INSERT
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conInsert = DriverManager.getConnection(
					"jdbc:mysql://92.57.66.37:3306/programacion","usuario1","Curso2022"
					);
			Statement stmt = conInsert.createStatement();
			
			try {
				//ejecutar la sentencia sql
				String sql = "INSERT INTO `nombres`(`nombre`) "
						+ "VALUES ('"+Nombre+"')";
  				
				stmt.executeUpdate(sql);
				
			}catch(Exception i1) {
				System.out.println("Error al insertar datos NOMBRES: "+i1.getMessage());
			}finally {
				//cierra base de datos
				conInsert.close();
			}

		}catch(Exception i) {
			System.out.println("error al abrir insert NOMBRES: "+i.getMessage());
		}
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection conDelete = DriverManager.getConnection(
					"jdbc:mysql://92.57.66.37:3306/programacion","usuario1","Curso2022"
					);
		
			System.out.println("Introduce el id a eliminar:");
            String id=entrada.nextLine();
                
                try {
                    //guarda variable sql la sentencia DELETE
                    String sql="DELETE FROM `nombres` WHERE `nombres`.`id` = "+id;
                    PreparedStatement preparedstmt = conDelete.prepareStatement(sql);
                    
                    //ejecuta el sql
                    preparedstmt.execute();
                
                }catch(Exception d) {
                	System.out.println("Error al borrar BBDD NOMBRES: \n"+d.getMessage());
                	
                }finally{
                	//cierra Scanner entrada
                	entrada.close();
                	//cierra conexion delete
                	conDelete.close();
                }
                
		}catch(Exception d1) {
			System.out.println("Error al leer BBDD NOMBRES: \n"+d1.getMessage());
			
		}finally {
			System.out.println("****** PROGRAMA FINALIZADO ******");
		}
	}
}


