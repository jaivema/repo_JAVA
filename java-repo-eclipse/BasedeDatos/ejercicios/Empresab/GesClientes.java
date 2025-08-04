package Empresab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class GesClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cero=0, Id=cero;
		String Nombre=null, Email=null, Ciudad=null, Telefono=null;
		
		Scanner entrada = new Scanner(System.in);
		
		try {
			System.out.println("\n***** CONSULTA DE CLIENTES *****");
////////Conexion SELECT
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Conexion con la tabla de datos
			Connection conSelect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/empresab","usuario1","Curso2022"
					);
			Statement stmt = conSelect.createStatement();
			
			//ejecutar la sentencia sql
			ResultSet rs = stmt.executeQuery("SELECT * FROM `clientes`");

			try {
				//lectura y mostrar por consola el contenido
				System.out.println("***********************************************************");
				
				while (rs.next()){
					System.out.println("Id:                |"+rs.getString(1));
					System.out.println("Nombre:            |"+rs.getString(2));
					System.out.println("Email:             |"+rs.getString(3));
					System.out.println("Ciudad:            |"+rs.getString(4));
					System.out.println("Telefono:          |"+rs.getString(5));
				    System.out.println("***********************************************************");
				}
				
				}catch(Exception s1) {
				System.out.println("Error al leer BBDD clientes: "+s1.getMessage());
				
				}finally {
					conSelect.close();
					rs.close();
				}
			
		}catch(Exception s) {
			System.out.println("error al abrir consulta BBDD clientes: "+s.getMessage());
		}
		
		
		System.out.println("***** INSERTAR CLIENTES *****");
		System.out.print("Nombre: ");		Nombre = entrada.nextLine();
		System.out.print("Email: ");		Email = entrada.nextLine();		
		System.out.print("Ciudad: ");		Ciudad = entrada.nextLine();
		System.out.print("Telefono: ");		Telefono = entrada.nextLine();
		
		try {
////////Conexion del INSERT
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conInsert = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/empresab","usuario1","Curso2022"
					);
			Statement stmt = conInsert.createStatement();
			
			try {
				//ejecutar la sentencia sql
				String sql = "INSERT INTO `clientes`(`Nombre`, `Email`, `Ciudad`, `Telefono`) "
						+ "VALUES ('"+Nombre+"','"+Email+"','"+Ciudad+"','"+Telefono+"')";
  				
				stmt.executeUpdate(sql);
				
			}catch(Exception i1) {
				System.out.println("Error al insertar datos clientes: "+i1.getMessage());
			}finally {
				//cierra base de datos
				conInsert.close();
			}

		}catch(Exception i) {
			System.out.println("error al abrir insert clientes: "+i.getMessage());
		}
		
		
		try {
			System.out.println("***** BORRAR CLIENTES *****");
////////Conexion del DELETE
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conDelete = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/empresab","usuario1","Curso2022"
					);
			
			System.out.println("Introduce la Id a borrar: ");
            Id=Integer.parseInt(entrada.nextLine()); 
                        
            try {
                //ejecuta el sql
                String sql="DELETE FROM `clientes` WHERE `clientes`.`Id` = "+Id;
                PreparedStatement preparedstmt = conDelete.prepareStatement(sql);

                preparedstmt.execute();
            
            }catch(Exception d) {
            	System.out.println("Error al borrar BBDD clientes: \n"+d.getMessage());
            	
            }finally{
            	//cierra conexion delete
            	conDelete.close();
            }
            
		}catch(Exception d1) {
			System.out.println("Error al abrir BBDD clientes a borrar: "+d1.getMessage());
			
		}finally {
			System.out.println("\n****** PROGRAMA FINALIZADO ******");
		}
		//cierra Scanner de entrada
		entrada.close();
	}
}
