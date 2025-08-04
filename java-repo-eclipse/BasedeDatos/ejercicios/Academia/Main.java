package Academia;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu=0;
		
		Scanner entrada = new Scanner (System.in);
		
		InfoCursos Met_consulta 		= new InfoCursos(entrada);
		InfoCursos Met_inserta 			= new InfoCursos(entrada);
		InfoCursos Met_borra 			= new InfoCursos(entrada);
		InfoCursos Met_actualiza		= new InfoCursos(entrada);
		MainCampo  Met_actualizaCampo	= new MainCampo(entrada);
		CampoSelectivo  Met_CampoSel	= new CampoSelectivo(entrada);
		
		while (menu!=99) {
			System.out.println("\n * Menu principal * \n");
			System.out.println("1.  Para consulta");
			System.out.println("2.  Para insertar");
			System.out.println("3.  Para borrar");
			System.out.println("4.  Para actualizar");
			System.out.println("5.  Para actualizar por campo");
			System.out.println("6.  Para actualizar por campo selectivo + Id");
			System.out.println("99. Salir");
			
			menu = Integer.parseInt(entrada.nextLine());
			
			switch(menu) {
				case 1:
					Met_consulta._select();
					break;
				case 2:
					Met_inserta._insert();
					break;
				case 3:
					Met_borra._delete();
				  	break;
				case 4:
					Met_actualiza._update();
					break;
				case 5:
					Met_actualizaCampo.mainCampo();
					break;
				case 6:
					Met_CampoSel.campoSel();
					break;
				case 99:
					System.out.println("****** PROGRAMA FINALIZADO ******");
					entrada.close();
					break;
				default:
					System.out.println("*****Error, introduce un numero valido *******");
					break;
			}
		}
	}

}
