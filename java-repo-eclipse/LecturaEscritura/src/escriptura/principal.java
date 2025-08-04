package escriptura;

import java.io.FileWriter;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String miArray[] = {"Pepe","Maria","Jose","Javier","Pilar","Nuria"};
		
		FileWriter fichero = null;
		
		try {
			fichero=new FileWriter("datos.txt");
			
			for (int i=0; i<miArray.length; i++) {
				fichero.write((i+1)+".   "+miArray[i]+ "\n");
			}			
			System.out.print("\nSe ha grabado el fichero datos.txt");
			
		}catch(Exception e) {
			System.out.println("Error al escribir el fichero" + e.getMessage());
		}finally {
			try {
				fichero.close();
				
			} catch (Exception e2) {
				System.out.println("Error al cerrar" + e2.getMessage());

			}
		}
	}
}