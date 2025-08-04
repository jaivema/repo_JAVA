package Academia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateCamp {
	Scanner entrada;
	
	public UpdateCamp(Scanner entrada) {
		super();
		this.entrada = entrada;
	}
	
//////UPDATE POR CAMPO//////////////////////////////////////////////////////
	public void _updateCurso() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection conUpdate = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/academia","usuario1","Curso2022"
					);
		
			System.out.println("Introduce el id a modificar: ");
			String id=entrada.nextLine();
			System.out.println("Introduce el nuevo curso: ");
			String curso=entrada.nextLine();
                
            try {
                //guarda variable sql la sentencia DELETE
                String sql="UPDATE `alumnos` SET `Curso`='"+curso+"' WHERE `Id` = "+id;
                Statement stmtUpdate = conUpdate.prepareStatement(sql);
                
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
	
	public void _updateProf() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection conUpdate = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/academia","usuario1","Curso2022"
					);
		
			System.out.println("Introduce el id a modificar: ");
			String id=entrada.nextLine();
			System.out.println("Introduce el nuevo profesor: ");
			String profesor=entrada.nextLine();
                
            try {
                //guarda variable sql la sentencia DELETE
                String sql="UPDATE `alumnos` SET `Profesor`='"+profesor+"' WHERE `Id` = "+id;
                Statement stmtUpdate = conUpdate.prepareStatement(sql);
                
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
	public void _updateTelProf() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection conUpdate = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/academia","usuario1","Curso2022"
					);
		
			System.out.println("Introduce el id a modificar: ");
			String id=entrada.nextLine();
			System.out.println("Introduce el nuevo telefono del profesor: ");
			String telprof=entrada.nextLine();
                
            try {
                //guarda variable sql la sentencia DELETE
                String sql="UPDATE `alumnos` SET `TelProf`='"+telprof+"' WHERE `Id` = "+id;
                Statement stmtUpdate = conUpdate.prepareStatement(sql);
                
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
	public void _updateNombreAlumno() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection conUpdate = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/academia","usuario1","Curso2022"
					);
		
			System.out.println("Introduce el id a modificar: ");
			String id=entrada.nextLine();
			System.out.println("Introduce la nueva fecha de inicio: ");
			String NombreAlumno=entrada.nextLine();
                
            try {
                //guarda variable sql la sentencia DELETE
                String sql="UPDATE `alumnos` SET `NombreAlumno`='"+NombreAlumno+"' WHERE `Id` = "+id;
                Statement stmtUpdate = conUpdate.prepareStatement(sql);
                
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
	public void _updateApellidosAlumno() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection conUpdate = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/academia","usuario1","Curso2022"
					);
		
			System.out.println("Introduce el id a modificar: ");
			String id=entrada.nextLine();
			System.out.println("Introduce la nueva fecha de inicio: ");
			String ApellidosAlumno=entrada.nextLine();
                
            try {
                //guarda variable sql la sentencia DELETE
                String sql="UPDATE `alumnos` SET `ApellidosAlumno`='"+ApellidosAlumno+"' WHERE `Id` = "+id;
                Statement stmtUpdate = conUpdate.prepareStatement(sql);
                
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
	public void _updateTelAlumno() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection conUpdate = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/academia","usuario1","Curso2022"
					);
		
			System.out.println("Introduce el id a modificar: ");
			String id=entrada.nextLine();
			System.out.println("Introduce el nuevo Telefono del alumno: ");
			String TelAlumno=entrada.nextLine();
                
            try {
                //guarda variable sql la sentencia DELETE
                String sql="UPDATE `alumnos` SET `TelAlumno`='"+TelAlumno+"' WHERE `Id` = "+id;
                Statement stmtUpdate = conUpdate.prepareStatement(sql);
                
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
