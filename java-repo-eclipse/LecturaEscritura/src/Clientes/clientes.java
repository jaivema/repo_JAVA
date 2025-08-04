package Clientes;

import java.util.Scanner;
public class clientes {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dni="", nombre="", apellidos="", direccion="", ciudad="", telefono="", email=""; 
		int cpostal=00000;
		
		Scanner entrada = new Scanner(System.in);
		
		
		System.out.print("DNI: ");
		dni = entrada.nextLine();
		
		System.out.print("Nombre: ");
		nombre = entrada.nextLine();
		
		System.out.print("Apellidos: ");
		apellidos = entrada.nextLine();
		
		System.out.print("Direccion: ");
		direccion = entrada.nextLine();
		
		System.out.print("Codigo Postal: ");
		cpostal = Integer.parseInt(entrada.nextLine());
		
		System.out.print("Ciudad: ");
		ciudad = entrada.nextLine();
		
		System.out.print("Telefono: ");
		telefono = entrada.nextLine();
		
		System.out.print("Email: ");
		email = entrada.nextLine();

		entrada.close();
		
	}

}
