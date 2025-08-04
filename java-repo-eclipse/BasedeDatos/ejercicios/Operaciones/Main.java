package Operaciones;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu=0;
		
		Scanner entrada = new Scanner (System.in);
		Sentencias Met_consulta = new Sentencias(entrada);
		Sentencias Met_insertar = new Sentencias(entrada);
		Sentencias Met_delete = new Sentencias(entrada);
		Sentencias Met_update = new Sentencias(entrada);
		
		while (menu!=99) {
			System.out.println("1. Para Consulta");
			System.out.println("2. Para Insertar");
			System.out.println("3. Para Borrar");
			System.out.println("4. Para Actualizar");
			System.out.println("99. Salir");
			menu = Integer.parseInt(entrada.nextLine());
			
			switch(menu) {
				case 1:
					Met_consulta._consulta();
					break;
				case 2:
					Met_insertar._insertar();
					break;
				  case 3:
					Met_delete._delete();
				  	break;
				  case 4:
					Met_update._update();
					break;
				case 99:
					System.out.println("****** PROGRAMA FINALIZADO ******");
					entrada.close();
					break;
				default:
					System.out.println("Error vuelve a introducir un numero!!!");
					break;
			}
		}
	}
}


