package Academia;

import java.util.Scanner;

public class MainCampo {
	Scanner entrada;
	
	public MainCampo(Scanner entrada) {
	super();
	this.entrada = entrada;
	}
		
	public void mainCampo() {
		int menu=0;
				
		UpdateCamp Met_actualizaCampo	= new UpdateCamp(entrada);
		
		while(menu!=99) {
			System.out.println("\n * Menu para actualizar datos por campo * \n");
			System.out.println("1.  Curso");
			System.out.println("2.  Profesor");
			System.out.println("3.  Telefono del profesor");
			System.out.println("4.  Nombre de alumno");
			System.out.println("5.  Apellidos de alumno");
			System.out.println("6.  Telefono de alumno");
			System.out.println("99. Salir");
			
			menu = Integer.parseInt(entrada.nextLine());
			
			switch(menu) {
				case 1:
					Met_actualizaCampo._updateCurso();
			  		break;
			  	case 2:
			  		Met_actualizaCampo._updateProf();
			  		break;
			  	case 3:
			  		Met_actualizaCampo._updateTelProf();
			  		break;
			  	case 4:
			  		Met_actualizaCampo._updateNombreAlumno();
			  		break;
			  	case 5:
			  		Met_actualizaCampo._updateApellidosAlumno();
			  		break;
			  	case 6:
			  		Met_actualizaCampo._updateTelAlumno();
			  		break;
			  	default:
			  		System.out.println("*****Error, introduce un numero valido *******");
					break;
			}
		}
	}
}

