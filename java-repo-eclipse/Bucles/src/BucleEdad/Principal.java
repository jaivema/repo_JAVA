package BucleEdad;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String SEdad;
		int IEdad;
		int contador;
		
		Scanner entradas = new Scanner(System.in);
		
		System.out.println("Edad: ");
		SEdad = entradas.nextLine();
		IEdad = Integer.parseInt(SEdad);
		
		for (contador=1; contador<=IEdad; contador++) {
			System.out.println(contador + " Edad");
		}
		entradas.close();
	}

}
