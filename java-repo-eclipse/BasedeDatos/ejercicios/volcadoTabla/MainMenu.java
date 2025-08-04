package volcadoTabla;

import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu = 0;

		Scanner entrada = new Scanner(System.in);
		
		Metodos Met_consulta = new Metodos(entrada);
		Metodos Met_inserta = new Metodos(entrada);
		Metodos Met_borra = new Metodos(entrada);
		Metodos Met_actualiza = new Metodos(entrada);
		Metodos Met_volcado = new Metodos(entrada);
		Metodos Met_salir = new Metodos(entrada);
		
		Met_volcado._volcado();
		
		while (menu != 99) {
			System.out.println("\n * Menu principal * \n");
			System.out.println("1.  Para consulta");
			System.out.println("2.  Para insertar");
			System.out.println("3.  Para borrar");
			System.out.println("4.  Para actualizar");
			System.out.println("99. Salir");

			menu = Integer.parseInt(entrada.nextLine());

			switch (menu) {
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
			case 99:
				Met_salir._salir();
				
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
