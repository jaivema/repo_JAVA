package adivinaNumero;

import java.util.Scanner;

public class adivinaNumero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada=new Scanner(System.in);
		
		int aleatorio=(int)(Math.random()*100);
		//*****************************************************
		int numero=0;				//numero a adivinar
		//*****************************************************
		int intentos=5;			//numero de vidas
		//*****************************************************
		
		do {
			System.out.println("Introduce un número");
			numero=entrada.nextInt();
			
			if(aleatorio<numero) {
				System.out.println("Más bajo");
				intentos--;
			}
			else if(aleatorio>numero) {
				System.out.println("Más alto");
				intentos--;
			}
		}while(numero!=aleatorio && intentos!=0);
		
		
		if (intentos==0) {
			System.out.println("\n***************************");
			System.out.println("       ESTAS MUERTO        ");
			System.out.println("***************************");
			System.out.println("\nNumero de vidas agotadas !!");
			System.out.println("El numero que no has acertado es el " + numero);
		}else {
			System.out.println("\n***************************");
			System.out.println("     NUMERO CORRECTO       ");
			System.out.println("***************************");
			System.out.println("Intentos restantes: " + intentos);
		}
		System.out.println("- programa finalizado -");
		entrada.close();
	}

}
