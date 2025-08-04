package almacen;

import java.util.Scanner;

public class MainProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu = 0;
		boolean noSpace=true;
		
		Scanner entrada = new Scanner(System.in);
		Almacen almacen =new Almacen(entrada);
			
		while (menu != 99) {
			noSpace=true;
			System.out.println("\n - Menu principal - ");
			System.out.println("1.  Para consulta.");
			System.out.println("2.  Para insertar.");
			System.out.println("3.  Para eliminar.");
			System.out.println("4.  Para actualizar.");
			System.out.println("99. Salir.");
			
			try {
				menu = Integer.parseInt(entrada.nextLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				noSpace=false;
				System.out.println("> Error. Introduce número < ");
			}
			switch (menu) {
			case 1:
				almacen._select();
				break;
			case 2:
				almacen._insertar(entrada);
				break;
			case 3:
				almacen._borrar(entrada);
				break;
			case 4:
				almacen._actualizar(entrada);
				break;
			case 99:
				almacen._salir(entrada);
				entrada.close();
				System.out.println("> FIN DE PROGRAMA.");
				break;
				default:
					if (noSpace==true) {
						System.out.println("> Error. Introduce un número válido del menú de opciones <");
					}
					break;
			}
		}
		
	}

}
