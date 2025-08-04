package Academia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InfoCursos {
	Scanner entrada;
	
	public InfoCursos(Scanner entrada) {
		super();
		this.entrada = entrada;
	}
	
	int cero=0, Id=cero;
	String Curso=null, Profesor=null, TelProf=null, Fini=null, Ffin=null, 
			Horario=null, NombreAlumno=null, ApellidosAlumno=null, TelAlumno=null;

////////// SELECT ///////////////////////////////
	public void _select() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conSelect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/academia","usuario1","Curso2022"
					);
			Statement stmt = conSelect.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM `alumnos`");
	
			try {
				//lectura y mostrar por consola el contenido
				System.out.println("***********************************************************");
				
				while (rs.next()){
					System.out.println("Id:                |"+rs.getString(1));
					System.out.println("Curso:             |"+rs.getString(2));
					System.out.println("Profesor:          |"+rs.getString(3));
					System.out.println("Telefono profesor: |"+rs.getString(4));
					System.out.println("Fecha inial:       |"+rs.getString(5));
					System.out.println("Fecha final:       |"+rs.getString(6));
					System.out.println("Horario:           |"+rs.getString(7));
					System.out.println("Nombre alumno:     |"+rs.getString(8));
				    System.out.println("Apellidos alumno:  |"+rs.getString(9));
				    System.out.println("Telefono alumno:   |"+rs.getString(10));
				    System.out.println("***********************************************************");
				}
			}
			catch(Exception s1) {
				System.out.println("Error al leer BBDD alumnos: "+s1.getMessage());	
			}
			finally {
				conSelect.close();
				rs.close();
			}
		}
		catch(Exception s) {
			System.out.println("error al abrir consulta BBDD alumnos: "+s.getMessage());
		}
	}
	
	
	
////// DELETE ///////////////////////////////////////////
	public void _delete() {
		try {
			System.out.println("***** BORRAR alumnos *****");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conDelete = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/academia","usuario1","Curso2022"
					);

			System.out.println("Introduce la Id a borrar: ");
            Id=Integer.parseInt(entrada.nextLine()); 
                        
            try {
                String sql="DELETE FROM `alumnos` WHERE `alumnos`.`Id` = "+Id;
                Statement stmtDelete = conDelete.prepareStatement(sql);

                stmtDelete.executeUpdate(sql);
            }
            catch(Exception d) {
            	System.out.println("Error al borrar BBDD alumnos: \n"+d.getMessage());
            }
            finally{
            	conDelete.close();
            }
		}
		catch(Exception d1) {
			System.out.println("Error al abrir BBDD alumnos a borrar: "+d1.getMessage());
		}
	}
	
	
///// INSERT ////////////////////////////////////////////
	public void _insert() {
		
		System.out.println("***** INSERTAR ALUMNOS *****");
		System.out.print("Curso: ");			Curso = entrada.nextLine();
		System.out.print("Profesor: ");			Profesor = entrada.nextLine();		
		System.out.print("Telefono profesor: ");TelProf = entrada.nextLine();
		System.out.print("Fecha inial: ");		Fini = entrada.nextLine();
		System.out.print("Fecha final: ");		Ffin = entrada.nextLine();
		System.out.print("Horario: ");			Horario = entrada.nextLine();
		System.out.print("Nombre alumno: ");	NombreAlumno = entrada.nextLine();
		System.out.print("Apellidos alumno: ");	ApellidosAlumno = entrada.nextLine();
		System.out.print("Telelfono alumno: ");	TelAlumno = entrada.nextLine();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conInsert = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/academia","usuario1","Curso2022"
					);
			Statement stmt = conInsert.createStatement();
			
			try {
				String sql = "INSERT INTO `alumnos`(`Curso`, `Profesor`, `TelProf`, `Fini`, `Ffin`, `Horario`, `NombreAlumno`, `ApellidosAlumno`, `TelAlumno`) "
						+ "VALUES ('"+Curso+"','"+Profesor+"','"+TelProf+"','"+Fini+"','"+Ffin+"','"+Horario+"','"+NombreAlumno+"','"+ApellidosAlumno+"','"+TelAlumno+"')";
					
				stmt.executeUpdate(sql);
				
			}catch(Exception i1) {
				System.out.println("Error al insertar datos alumnos: "+i1.getMessage());
			}finally {
				conInsert.close();
			}
	
		}catch(Exception i) {
			System.out.println("error al abrir insert alumnos: "+i.getMessage());
		}
		
	}
	
	
	
////// UPDATE //////////////////////////////////////////////////////
	public void _update() {
		
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
}		
			
			
			
	
