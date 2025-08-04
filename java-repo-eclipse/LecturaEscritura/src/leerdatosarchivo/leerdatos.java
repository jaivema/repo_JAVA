package leerdatosarchivo;
import java.io.File;
import java.util.Scanner;

public class leerdatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//si el fichero esta dentro del proyecto
		File archivo = new File("datos.txt");
		//si el fichero esta fuera del proyecto
		//File archivo = new File("D:\\eclipse-workspace\\leerdatosarchivo\\datos.txt");
		Scanner entrada = null;
		
		try {
			//Leemos el fichero
			System.out.println("leemos el contenido del fichero: ");
			entrada = new Scanner(archivo);
			//leemos el contenido del fichero mientras existan lineas siguientes
			while(entrada.hasNextLine()) {
				String lectura = entrada.nextLine();
				System.out.println(lectura);
			}
				
		}catch(Exception e) {
			System.out.println("Error al leer archivo" + e.getMessage());
		}finally{
			//Cerramos el fichero tanto si la lectura es correcta o no.
			try {
				if (entrada!=null) {
					entrada.close();
				}
			}catch(Exception e2) {
				System.out.println("Error al cerrar entrada " + e2.getMessage());
			}
		}
	}
	
}