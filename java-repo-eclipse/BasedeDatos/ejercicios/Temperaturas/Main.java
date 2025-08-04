package Temperaturas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu = 0;

		Scanner entrada = new Scanner(System.in);

		Seleccion Met_consulta = new Seleccion(entrada);
		Seleccion Met_inserta = new Seleccion(entrada);
		Seleccion Met_borra = new Seleccion(entrada);
		Seleccion Met_actualiza = new Seleccion(entrada);
		MatrizMuestras Met_matriz = new MatrizMuestras();

		while (menu != 99) {
			System.out.println("\n * Menu principal * \n");
			System.out.println("1.  Para consulta");
			System.out.println("2.  Para insertar");
			System.out.println("3.  Para borrar");
			System.out.println("4.  Para actualizar");
			System.out.println("5.  Matriz de muestras");
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
			case 5:
				Met_matriz._matriz();
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
