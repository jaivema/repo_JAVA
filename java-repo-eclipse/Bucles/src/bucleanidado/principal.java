package bucleanidado;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//321
		//21
		//1
		
		String Snumero;
		String Cadena="";
		int Inumero;
		
		Scanner entradas = new Scanner(System.in);
			
		System.out.println("Introduce un numero entero mayor que 2: ");
		Snumero = entradas.nextLine();
  		Inumero = Integer.parseInt(Snumero);
  		
  		//rellena fila y printa en consola hasta llegar a 1
		for (int i=Inumero; i>0; i--) {
			for (int j=i; j>=1; j--) {
				Cadena = (Cadena + j);	
			}
			
			System.out.println(Cadena);
			Cadena="";
			
		}
		entradas.close();
	}

}
