package Academia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class CampoSelectivo {
	Scanner entrada;

	public CampoSelectivo(Scanner entrada) {
		super();
		this.entrada = entrada;
	}
	public void campoSel() {
		int menu=0;
		
		String id=null; 
		String Id=null, Curso=null, Profesor=null, TelProf=null, Fini=null, Ffin=null,
				Horario=null, NombreAlumno=null, ApellidosAlumno=null, TelAlumno=null;
		
		String sqlSel=null;
		
		System.out.println("Introduce el id a modificar");
		id = entrada.nextLine();
		
		while(menu!=99) {
			System.out.println("\n * Menu para actualizar datos por campo * \n");
			System.out.println("1.  Id");
			System.out.println("2.  Curso");
			System.out.println("3.  Profesor");
			System.out.println("4.  Telefono del profesor");
			System.out.println("5.  Fecha de inicio");
			System.out.println("6.  Fecha final");
			System.out.println("7.  Horario");
			System.out.println("8.  Nombre de alumno");
			System.out.println("9.  Apellidos de alumno");
			System.out.println("10. Telefono de alumno ");
			System.out.println("99. Salir");
			
			menu = Integer.parseInt(entrada.nextLine());
			
			switch(menu) {
			case 1:
				System.out.println("Actualizar el id: ");
				Id = entrada.nextLine();
				sqlSel = "`Id`='"+Id+"'";
		  		break;	
			case 2:
				System.out.println("Actualizar Curso: ");
				Curso = entrada.nextLine();
				sqlSel = "`Curso`='"+Curso+"'";
		  		break;
			 case 3:
				System.out.println("Actualizar profesor: ");
				Profesor = entrada.nextLine();
			  	sqlSel = "`Profesor`='"+Profesor+"'";
			  	break;
			 case 4:
		  		System.out.println("Actualizar Telefono del profesor: ");
				TelProf = entrada.nextLine();
		  		sqlSel = "`TelProf`='"+TelProf+"'";
		  		break;
		  	case 5:
		  		System.out.println("Actualizar fecha de inicio: ");
				Fini = entrada.nextLine();
		  		sqlSel = "`Fini`='"+Fini+"'";
		  		break;
		  	case 6:
		  		System.out.println("Actualizar fecha de fin: ");
				Ffin = entrada.nextLine();
		  		sqlSel = "`Ffin`='"+Ffin+"'";
		  		break;
		  	case 7:
		  		System.out.println("Actualizar Horario: ");
				Horario = entrada.nextLine();
		  		sqlSel = "`Horario`='"+Horario+"'";
		  		break;
		  	case 8:
		  		System.out.println("Actualizar nombre de alumno: ");
		  		NombreAlumno = entrada.nextLine();
		  		sqlSel = "`NombreAlumno`='"+NombreAlumno+"'";
		  		break;
		  	case 9:
		  		System.out.println("Actualizar apellidos de alumno: ");
		  		ApellidosAlumno = entrada.nextLine();
		  		sqlSel = "`ApellidosAlumno`='"+ApellidosAlumno+"'";
		  		break;
		  	case 10:
		  		System.out.println("Actualizar telefono de alumno: ");
		  		TelAlumno = entrada.nextLine();
		  		sqlSel = "`TelAlumno`='"+TelAlumno+"'";
		  		break;
		  	case 99:
		  		break;
		  	default:
		  		System.out.println("*****Error, introduce un numero valido *******");
				break;
			}
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//Conexion con la tabla de datos
				Connection conUpdate = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/academia","usuario1","Curso2022"
						);        
	            try {
	                //guarda variable sql la sentencia DELETE
	                String sql="UPDATE `alumnos` SET "+sqlSel+" WHERE `Id` = "+id;
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
}