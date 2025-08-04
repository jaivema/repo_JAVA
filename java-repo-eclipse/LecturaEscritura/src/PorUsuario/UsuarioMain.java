package PorUsuario;

import java.util.Scanner;
import java.io.FileWriter;

public class UsuarioMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
////////// NOMBRE DEL FICHERO //////////////////////////////////////////////////
		
		String ficheroTXT="ALumnos.txt";
		
////////////////////////////////////////////////////////////////////////////////
		
		Scanner entrada = new Scanner(System.in);
        
		System.out.print("\nCuantos alumnos quieres añadir: ");
        String lectura = entrada.nextLine();
        int numero = Integer.parseInt(lectura);
		
		String alumnos[] = new String[numero];
        
        for(int i=0; i<numero; i++) {
            System.out.print("Nombre del alumno: ");
            lectura = entrada.nextLine();
            alumnos[i]=lectura;
        }	
		
/////// escribo ficheroTXT
        FileWriter fichero = null;
		try {
			fichero=new FileWriter(ficheroTXT);
			fichero.write("--------------------------------\n");
			fichero.write(" Numero de alumnos: " +alumnos.length+ "\n");
			fichero.write("--------------------------------\n");
			fichero.write("\n");
			
			for (int i=0; i<alumnos.length; i++) {
				fichero.write((i+1)+".   "+alumnos[i]+ "\n");
			}
			
			System.out.print("\nSe ha grabado el fichero " + ficheroTXT);
			
		}catch(Exception e1) {
			System.out.println("Error al escribir el fichero" + e1.getMessage());
		}finally {
			try {
//////////////// cierro el fichero
				fichero.close();
//////////////// cierro scanner entrada
		        entrada.close();
			} catch (Exception e2) {
				System.out.println("error al cerrar"+e2.getMessage());
			}
		}
	}

}
