package escribe;

import java.io.FileWriter;

public class escribeMain {

	public static void main(String[] args) {

		String[] lineas= {"uno", "dos", "tres", "cuatro"};
		FileWriter fichero =null;

		try {
			fichero=new FileWriter("numeros.txt");
			for (int i =0; i<lineas.length;i++) {
				fichero.write(lineas[i]+"\n");
			}
		}catch(Exception e) {
			System.out.println("Error al escribir el fichero" + e.getMessage());
		}finally {
			try {
				fichero.close();
			} catch (Exception e) {
				System.out.println("error al cerrar"+e.getMessage());
			}
		}
	}
}