package matriz;
import java.util.Scanner;

public class MainMatriz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//////Array Sin contenido con x posiciones determinadas por el usuario
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Cuantos alumnos quieres añadir");
        String lectura = entrada.nextLine();
        int numero = Integer.parseInt(lectura);
        
 // crea el array con el numero que a introducido el usuario
        String alumnos[][] = new String[numero][4];
        String alumno;
        
 //le pregunta el numero de veces que a puesto el usuario e inicializa el array
        for(int i=0;i<numero;i++) {
                System.out.println("escribeme el nombre del alumno " + i);
                 alumno = entrada.nextLine();
                 alumnos[i][0]=alumno;
                 System.out.println("escribeme la nota del alumno " + alumnos[i][0] );
                 alumno = entrada.nextLine();
                 alumnos[i][1]=alumno;
                 System.out.println("escribeme la nota 2 del alumno " + alumnos[i][0] );
                 alumno = entrada.nextLine();
                 alumnos[i][2]=alumno;
                 
 //convertir el string dea la matriz en double para calcular la media
                 double Dnota1 = Double.parseDouble(alumnos[i][1]);
                 double Dnota2 = Double.parseDouble(alumnos[i][2]);
                 double media = (Dnota1 + Dnota2)/2;
 //convertir el double en String para almacenar en la matriz
                 //String Smedia = "" + media;
                 String Smedia = String.valueOf(media);
                 
 //media de las (nota1 + nota2)/2 y almacena en nota3
                 alumnos[i][3]=Smedia;
                
        }
        
 //muestra el contenido del array
        for(int i=0; i<alumnos.length; i++) {
                
                System.out.println("Alumno "+i+": "+ alumnos[i][0] 
                		+ " (Nota1: " + alumnos[i][1] 
                		+ " Nota2: " + alumnos[i][2] + ")" 
                		+ " con media de " + alumnos[i][3]);
        
        }
        entrada.close();

	}

}
