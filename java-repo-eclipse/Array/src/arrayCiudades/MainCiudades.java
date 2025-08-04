package arrayCiudades;
import java.util.Scanner;

public class MainCiudades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//se informa el array con una lista de ciudades
		String ciudadesarray[]= {"Barcelona", "Madrid", "Valencia", "Orense"};
		
		for(int i=0;i<ciudadesarray.length;i++) {
            System.out.println(ciudadesarray[i]);
		}
		
		
	//////Array Sin contenido con x posiciones determinadas por el usuario
        Scanner entrada = new Scanner(System.in);
        System.out.println("Cuantas ciudades quieres añadir");
        String lectura = entrada.nextLine();
        int numero = Integer.parseInt(lectura);
        // crea el array con el numero que a introducido el usuario
        String ciudades[] = new String[numero];
        String ciudad;
        
        //le pregunta el numero de veces que a puesto el usuario e inicializa el array
        for(int i=0;i<numero;i++) {
                System.out.println("escribeme una ciudad");
                 ciudad = entrada.nextLine();
                 ciudades[i]=ciudad;
        }
        
        //muestra el contenido del array
        for(int i=0;i<ciudades.length;i++) {
                System.out.println(ciudades[i]);
        }
        entrada.close();
	}

}
