package Operaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Sentencias {
	Scanner entrada;
	
	public Sentencias(Scanner entrada) {
		super();
		this.entrada = entrada;
		}

////SELECT //////////// Metodo
	public void _consulta() {
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
				System.out.println("Error al leer BBDD: "+c1.getMessage());
			}
			finally {
				try {
					rs.close();
				} catch (Exception c2) {
					System.out.println("Error al cerrar BBDD: "+c2.getMessage());
				}
			}
			
		}
		catch(Exception c) {
				System.out.println("Error al conectar a la BBDD: "+c.getMessage());
			}
		}

/////INSERT ///////// Metodo
	public void _insertar() {
		String Nombre=null;
		System.out.println("***** INSERTAR *****");
		System.out.print("Nombre: ");		 Nombre = entrada.nextLine();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conInsert = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/programacion","usuario1","Curso2022"
					);
			Statement stmtInsert = conInsert.createStatement();
		
			try {
				//ejecutar la sentencia sql
				String sql = "INSERT INTO `nombres`(`nombre`) "
						+ "VALUES ('"+Nombre+"')";
					
				stmtInsert.executeUpdate(sql);
				
			}
			catch(Exception i1) {
				System.out.println("Error al insertar datos BBDD: "+i1.getMessage());
			}
			finally {
				//cierra base de datos
				conInsert.close();
			}

		}
		catch(Exception i) {
			System.out.println("Error al abrir insert BBDD: "+i.getMessage());
		}
	}
	
/////DELETE /////////// Metodo
	public void _delete() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection conDelete = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/programacion","usuario1","Curso2022"
					);
		
			System.out.println("Introduce el id a eliminar:");
            String id=entrada.nextLine();
                
            try {
                //guarda variable sql la sentencia DELETE
                String sql="DELETE FROM `nombres` WHERE `nombres`.`id` = "+id;
                Statement stmtDelete = conDelete.prepareStatement(sql);
                
                //ejecuta el sql
                stmtDelete.executeUpdate(sql);
            
            }
            catch(Exception d) {
            	System.out.println("Error al borrar BBDD: \n"+d.getMessage());
            	
            }
            finally{
            	//cierra conexion delete
            	conDelete.close();
            }
                
		}
		catch(Exception d1) {
			System.out.println("Error al leer BBDD: \n"+d1.getMessage());
		}
	}
	
	public void _update() {
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
                String sql="UPDATE `nombres` SET `nombre`='"+nombre+"' WHERE `id` = "+id;
                Statement stmtUpdate = conUpdate.prepareStatement(sql);
                
                //ejecuta el sql
                stmtUpdate.executeUpdate(sql);
            
            }
            catch(Exception u1) {
            	System.out.println("Error al modificar BBDD: \n"+u1.getMessage());
            }
            finally{
            	try {
					conUpdate.close();
				} 
            	catch (Exception u2) {
					System.out.println("Error al cerrar modificar BBDD: "+u2.getMessage());
				}
            }
		}
		catch(Exception u) {
			System.out.println("Error al abrir update BBDD: \n"+u.getMessage());
		}	
	
	}
}
