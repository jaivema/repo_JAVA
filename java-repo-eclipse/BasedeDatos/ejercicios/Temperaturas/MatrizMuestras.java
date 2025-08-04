package Temperaturas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MatrizMuestras {


	public void _matriz() {
		int cero = 0;
		int cont = cero;
		int filas = cero, columnas = cero;
		
		////////// SELECT ///////////////////////////////
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conSelect = DriverManager.getConnection(""
					+ "jdbc:mysql://92.57.66.37:3306/temperaturas", "usuario1",	"Curso2022");
			Statement stmt = conSelect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, cont);

			ResultSet rs = stmt.executeQuery("SELECT * FROM `muestras`");

			try {
				// lectura y mostrar por consola el contenido
				System.out.println("***********************************************************");

				while (rs.next()) {
					System.out.println("Ciudad:            |" + rs.getString(1));
					System.out.println("Fecha:             |" + rs.getString(2));
					System.out.println("Temperatura:       |" + rs.getString(3));
					System.out.println("***********************************************************");
					cont++;
				}
				
			} catch (Exception s1) {
				System.out.println("Error al leer BBDD: " + s1.getMessage());
			}

			System.out.println("\nInformo matriz de muestras"); 
			String matrizMuestras[][] = new String[cont][3];

			try {
				for (filas = 1; filas <= cont; filas++) {
					rs.absolute(filas);

					for (columnas = 1; columnas <= 3; columnas++) {
						matrizMuestras[filas - 1][columnas - 1] = rs.getString(columnas);

						System.out.println(matrizMuestras[filas - 1][columnas - 1]);
					}
				}
			} catch (Exception e) {
				System.out.println("-> **Error al informar la matriz de muestras:  " + e.getMessage());
				return;
			}

			// cierro conexion
			conSelect.close();
			rs.close();
			System.out.println("->  Existen " + cont + " muestras.");
			
		} catch (Exception s) {
			System.out.println("error al abrir consulta BBDD: " + s.getMessage());
		}
	}
}