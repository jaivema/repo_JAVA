package Delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Dclientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection con = DriverManager.getConnection(
					//											user		pass
					"jdbc:mysql://localhost:3306/tiendaropa","usuario1","Curso2022"
					);
			Statement stmt = con.createStatement();
			
			//ejecutar la sentencia sql
			ResultSet rs = stmt.executeQuery("SELECT * FROM `clientes`");
		
			try {
				//lectura y mostrar por consola el contenido
				System.out.println("***********************************************************");
				while (rs.next()){
					System.out.println("id:            |"+rs.getString(1));
					System.out.println("dni:           |"+rs.getString(2));
					System.out.println("Nombre:        |"+rs.getString(3));
					System.out.println("Apellidos:     |"+rs.getString(4));
					System.out.println("Direccion:     |"+rs.getString(5));
					System.out.println("Codigo postal: |"+rs.getString(6));
					System.out.println("Ciudad:        |"+rs.getString(7));
					System.out.println("Telefono:      |"+rs.getString(8));
					System.out.println("Email@:        |"+rs.getString(9));
					System.out.println("***********************************************************");					
				}
				System.out.println("Introduce el id a eliminar:");
                String id=entrada.nextLine();
                
                try {
                    //guarda variable sql la sentencia DELETE
                    String sql="DELETE FROM `clientes` WHERE `clientes`.`id` = "+id;
                    PreparedStatement preparedstmt = con.prepareStatement(sql);
                    
                    //ejecuta el sql
                    preparedstmt.execute();
                
                }catch(Exception d) {
                	System.out.println("Error al borrar BBDD CLIENTES: \n"+d.getMessage());
                	
                }finally{
                	//cierra Scanner entrada
                	entrada.close();
                	//cierra conexion delete
                	con.close();
                }
                
			}catch(Exception e1) {
				System.out.println("Error al leer BBDD CLIENTES: \n"+e1.getMessage());
				
			}finally {
				//cierra conexion select
				rs.close();
				System.out.println("****** PROGRAMA FINALIZADO ******");
			}
			
		}catch(Exception e) {
			System.out.println("error al abrir BBDD CLIENTES: \n"+e.getMessage());
		}
	}

}
