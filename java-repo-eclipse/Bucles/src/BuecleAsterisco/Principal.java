package BuecleAsterisco;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String SAst;
		int IAst;
		int contador;
		String Cadena="";
		
		Scanner entradas = new Scanner(System.in);
		
//		System.out.println("Numero de asteriscos: ");
  		
//		SAst = entradas.nextLine();
//  	IAst = Integer.parseInt(SAst);
//		for (contador=1; contador<=IAst; contador++) {
//			Cadena=Cadena + "*";
//			System.out.println(Cadena);
//		}

		System.out.println("Numero de numeros: ");
		SAst = entradas.nextLine();
  		IAst = Integer.parseInt(SAst);

  		//de un for a un dowhile
		for (contador=1; contador<=IAst; contador++) {
			Cadena=Cadena + contador;
			System.out.println(Cadena);
		}
		
		//el FOR en Dowhile
//		contador=1;
//		do {
//			Cadena=Cadena + contador;
//			System.out.println(Cadena);
//			contador++;
//		}while(contador<=IAst);
//		
		
		entradas.close();

	}
}

