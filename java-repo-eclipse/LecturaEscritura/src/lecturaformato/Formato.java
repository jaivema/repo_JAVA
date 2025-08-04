package lecturaformato;

import java.io.File;
import java.util.Scanner;

public class Formato {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		File archivo = new File("RADFormato2.txt");
		Scanner entrada = null;
		String lectura="";
		String Cadena="";
		
		String MyArray[]= {"nombre","apelllido","calle","cp","telefono","mail",""};
		
		try {
			entrada = new Scanner(archivo);
			
			while(entrada.hasNextLine()) {
				
				for (int i=0; i<MyArray.length; i++) {
					lectura = entrada.nextLine();
					Cadena=lectura + Cadena;					
					MyArray[i] = lectura;
				}
			}

		}catch(Exception e) {
			
			System.out.println("Error al leer archivo Formato " + e.getMessage());
		}finally{
			
			try {
				if (entrada!=null) {
					entrada.close();
				}
			}catch(Exception e2) {
				
				System.out.println("Error al cerrar entrada Formato " + e2.getMessage());
			}
		}
		
		try {
			System.out.println("Formato de salida");
			System.out.println("-----------------");
			System.out.println("Nombre   : " + MyArray[0]);
			System.out.println("Apellido : " + MyArray[1]);
			System.out.println("Calle    : " + MyArray[2]);
			System.out.println("CP       : " + MyArray[3]);
			System.out.println("Ciudad   : " + MyArray[4]);
			System.out.println("Telf     : " + MyArray[5]);
			System.out.println("Mail     : " + MyArray[6]);
		}catch(Exception e3) {
			
			System.out.println("Error al dar formato de salida" + e3.getMessage());
		}
	}
}
