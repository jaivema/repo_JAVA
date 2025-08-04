package lecturaformato;

import java.io.File;
import java.util.Scanner;
public class FormatoMatriz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivo = new File("RADFormato2.txt");
		Scanner entrada=null;
		String lectura=null;
		
		int numeropersonas=2, numdatos=7;
		String MyMatriz[][]=new String[numeropersonas][numdatos];
		
		try {
			entrada = new Scanner(archivo);
			
			while(entrada.hasNextLine()) {
				
				for (int i=0; i<numeropersonas; i++) {
					for(int j=0; j<numdatos; j++) {
						lectura = entrada.nextLine();			
						MyMatriz[i][j] = lectura;	
					}
				}
			}

		}catch(Exception e) {
			
			System.out.println("Error al leer archivo Formato2 " + e.getMessage());
		}finally{
			
			try {
				if (entrada!=null) {
					entrada.close();
				}
			}catch(Exception e2) {
				
				System.out.println("Error al cerrar entrada Formato2 " + e2.getMessage());
			}
		}
		
		try {
			System.out.println("Formato de salida");
			System.out.println("-----------------");
			for (int i=0; i<numeropersonas; i++) {
				System.out.println("Ficha del sujeto " + (i+1) + "\n");
				System.out.println("Nombre   : " + MyMatriz[i][0]);
				System.out.println("Apellido : " + MyMatriz[i][1]);
				System.out.println("Calle    : " + MyMatriz[i][2]);
				System.out.println("CP       : " + MyMatriz[i][3]);
				System.out.println("Ciudad   : " + MyMatriz[i][4]);
				System.out.println("Telf     : " + MyMatriz[i][5]);
				System.out.println("Mail     : " + MyMatriz[i][6]);
				System.out.println("\n");
			}
			
		}catch(Exception e3) {
			
			System.out.println("Error al dar formato2 de salida" + e3.getMessage());
		}
	}

}
