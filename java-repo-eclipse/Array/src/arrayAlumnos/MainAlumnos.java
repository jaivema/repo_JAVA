package arrayAlumnos;
import java.util.Scanner;

public class MainAlumnos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        
//////  Array Sin contenido con x posiciones determinadas por el usuario
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nCuantos alumnos quieres añadir");
        
        String lectura = entrada.nextLine();
        int numero = Integer.parseInt(lectura);
        
//////  crea el array con el numero que a introducido el usuario
        String alumnos[] = new String[numero];
        String alumno;
        
//////  le pregunta el numero de veces que a puesto el usuario e inicializa el array
        for(int i=0; i<numero; i++) {
                System.out.println("Nombre del nuevo alumno: ");
                 alumno = entrada.nextLine();
                 alumnos[i]=alumno;
        }
        
        for(int i=0; i<alumnos.length; i++) {
			System.out.print(" " + alumnos[i]); 
		}
        entrada.close();
        
        }  
	}