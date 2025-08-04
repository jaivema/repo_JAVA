package EjerciciosBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MaintiendaRopa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

///////SELECT
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection con = DriverManager.getConnection(
					//											user		pass
					"jdbc:mysql://localhost:3306/tiendaropa","usuario1","Curso2022"
					);
			Statement stmt = con.createStatement();
			
			//ejecutar la sentencia sql
			ResultSet   rs = stmt.executeQuery("SELECT * FROM `clientes`");
		
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
	
			}catch(Exception e1) {
				System.out.println("Error al leer BBDD CLIENTES: "+e1.getMessage());
			}finally {
				try {
					rs.close();
				} catch (Exception e2) {
					System.out.println("error al cerrar BBDD CLIENTES: "+e2.getMessage());
				}
			}
		}catch(Exception e) {
			System.out.println("error al abrir BBDD CLIENTES: "+e.getMessage());
		}
		
////////UPDATE		
		
		Scanner entrada = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection conUpdate = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tiendaropa","usuario1","Curso2022"
					);
		
			System.out.println("Introduce el id a modificar: ");
			String id=entrada.nextLine();
			System.out.println("Introduce el nuevo nombre: ");
			String nombre=entrada.nextLine();
			System.out.println("Introduce los nuevos apellidos: ");
			String apellidos=entrada.nextLine();
                
            try {
                //guarda variable sql la sentencia DELETE
                String sql="UPDATE `clientes` SET `nombre`='"+nombre+"',`apellidos`='"+apellidos+"' WHERE `clientes`.`id` = "+id;
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
		}
		catch(Exception u) {
			System.out.println("Error al leer BBDD CLIENTES: \n"+u.getMessage());
		}
		entrada.close();
	}
}