package Productos;

import java.io.File;
import java.util.Scanner;

public class productosMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivo = new File("procesadores");
		Scanner entrada=null;
		String lectura=null;
		
		int numeroproductos=3, numdatos=5;
		String MyMatriz[][]=new String[numeroproductos][numdatos];
		
		try {
			entrada = new Scanner(archivo);
			
			while(entrada.hasNextLine()) {
				
				for (int i=0; i<numeroproductos; i++) {
					for(int j=0; j<numdatos; j++) {
						lectura = entrada.nextLine();			
						MyMatriz[i][j] = lectura;	
					}
				}
			}

		}catch(Exception e) {
			System.out.println("Error al leer listado de procesadores " + e.getMessage());
		}finally{
			
			try {
				if (entrada!=null) {
					entrada.close();
				}
			}catch(Exception e2) {
				System.out.println("Error al cerrar listado de procesadores " + e2.getMessage());
			}
		}
		
		try {
			System.out.println("	  | PRODUCTOS |");
			System.out.println("	  | --------- |");
			System.out.println("\n");
			for (int i=0; i<numeroproductos; i++) {
				System.out.println("PROCESADOR " + (i+1));
				System.out.println("Producto   : " + MyMatriz[i][0]);
				System.out.println("Marca      : " + MyMatriz[i][1]);
				System.out.println("Modelo     : " + MyMatriz[i][2]);
				System.out.println("Nucleos    : " + MyMatriz[i][3]);
				System.out.println("Precio     : " + MyMatriz[i][4]);
				System.out.println("\n");
			}
			
		}catch(Exception e3) {
			
			System.out.println("Error al mostrar listado de procesadores " + e3.getMessage());
		}
	}
}
