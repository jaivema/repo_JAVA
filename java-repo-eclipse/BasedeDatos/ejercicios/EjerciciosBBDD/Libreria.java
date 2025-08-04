package EjerciciosBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Libreria {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cero=0; int Ref=cero;
		String ISBN=null, Titulo=null, NombreAutor=null, ApellidoAutor=null, Precio=null;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("***** INSERTAR LIBROS *****");
		System.out.print("ISBN: ");			 ISBN = entrada.nextLine();
		System.out.print("Titulo: ");		 Titulo = entrada.nextLine();		
		System.out.print("NombreAutor: ");	 NombreAutor = entrada.nextLine();
		System.out.print("ApellidoAutor: "); ApellidoAutor = entrada.nextLine();
		System.out.print("Precio: ");		 Precio = entrada.nextLine();

		
		try {
////////Conexion del INSERT
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conInsert = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/libreria","usuario1","Curso2022"
					);
			Statement stmt = conInsert.createStatement();
			
			try {
				//ejecutar la sentencia sql
				String sql = "INSERT INTO `libros`(`ISBN`, `Titulo`, `NombreAutor`, `ApellidoAutor`, `Precio`) "
						+ "VALUES ('"+ISBN+"','"+Titulo+"','"+NombreAutor+"','"+ApellidoAutor+"','"+Precio+"')";
  				
				stmt.executeUpdate(sql);
				
			}catch(Exception i1) {
				System.out.println("Error al insertar datos LIBROS: "+i1.getMessage());
			}finally {
				//cierra base de datos
				conInsert.close();
			}

		}catch(Exception i) {
			System.out.println("error al abrir insert LIBROS: "+i.getMessage());
		}
		
		
		try {
			System.out.println("\n***** CONSULTA DE LIBROS *****");
////////Conexion SELECT
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Conexion con la tabla de datos
			Connection conSelect = DriverManager.getConnection(
					//											user		pass
					"jdbc:mysql://localhost:3306/Libreria","usuario1","Curso2022"
					);
			Statement stmt = conSelect.createStatement();
			
			//ejecutar la sentencia sql
			ResultSet rs = stmt.executeQuery("SELECT * FROM `Libros`");

			try {
				//lectura y mostrar por consola el contenido
				System.out.println("***********************************************************");
				
				while (rs.next()){
					System.out.println("Ref:            |"+rs.getString(1));
					System.out.println("ISBN:           |"+rs.getString(2));
					System.out.println("Titulo:         |"+rs.getString(3));
					System.out.println("Nombre Autor:   |"+rs.getString(4));
					System.out.println("Apellido Autor: |"+rs.getString(5));
					System.out.println("Precio:         |"+rs.getString(6));
					System.out.println("***********************************************************");					
				}
				}catch(Exception s1) {
				System.out.println("Error al leer BBDD LIBROS: "+s1.getMessage());
				
				}finally {
					conSelect.close();
					rs.close();
				}
			
		}catch(Exception s) {
			System.out.println("error al abrir consulta BBDD LIBROS: "+s.getMessage());
		}
		
		
		try {
			System.out.println("***** BORRAR LIBROS *****");
////////Conexion del DELETE
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conDelete = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/libreria","usuario1","Curso2022"
					);
			
			System.out.println("Introduce la Referencia a borrar: ");
            Ref=Integer.parseInt(entrada.nextLine()); 
            
            try {
                //ejecuta el sql
                String sql="DELETE FROM `libros` WHERE `libros`.`Ref` = "+Ref;
                PreparedStatement preparedstmt = conDelete.prepareStatement(sql);

                preparedstmt.execute();
            
            }catch(Exception d) {
            	System.out.println("Error al borrar BBDD LIBROS: \n"+d.getMessage());
            	
            }finally{
            	//cierra conexion delete
            	conDelete.close();
            }
            
		}catch(Exception d1) {
			System.out.println("Error al abrir BBDD LIBROS a borrar: "+d1.getMessage());
			
		}finally {
			System.out.println("\n****** PROGRAMA FINALIZADO ******");
		}
		//cierra Scanner de entrada
		entrada.close();
	}
}
