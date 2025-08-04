package EjerciciosBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MainInmobiliaria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
////////INSERTAR PROPIEDADES
		String FechaAlta, TipoInmueble, Operacion, Provincia, FechaVenta, Vendedor; 
		String Baja; 
		int PrecioVenta, Superficie;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("FechaAlta: ");		FechaAlta = entrada.nextLine();
		System.out.print("TipoInmueble: ");		TipoInmueble = entrada.nextLine();		
		System.out.print("Operacion: ");		Operacion = entrada.nextLine();
		System.out.print("Provincia: ");		Provincia = entrada.nextLine();
		System.out.print("Superficie: ");		Superficie = Integer.parseInt(entrada.nextLine());
		System.out.print("PrecioVenta: ");		PrecioVenta = Integer.parseInt(entrada.nextLine());
		System.out.print("FechaVenta: ");		FechaVenta = entrada.nextLine();
		System.out.print("Vendedor: ");			Vendedor = entrada.nextLine();
		System.out.print("Baja: ");				Baja = entrada.nextLine();
				
		//cierra Scanner de entrada
		entrada.close();
		
		try {
			//Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Conexion con la tabla de datos
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inmobiliaria","usuario1","Curso2022");
			Statement stmt = con.createStatement();
			
			try {
				//ejecutar la sentencia sql
				String sql = "INSERT INTO `propiedades`(`FechaAlta`, `TipoInmueble`, `Operacion`, `Provincia`, `Superficie`, `PrecioVenta`, `FechaVenta`, `Vendedor`, `Baja`) "
						+ "VALUES ('"+FechaAlta+"','"+TipoInmueble+"','"+Operacion+"','"+Provincia+"','"+Superficie+"','"+PrecioVenta+"','"+FechaVenta+"','"+Vendedor+"','"+Baja+"')";
  				
				stmt.executeUpdate(sql);
				//System.out.println("\n" + sql);
				
			}catch(Exception i1) {
				System.out.println("Error al insertar datos PROPIEDADES: "+i1.getMessage());
			}finally {
				try {
					//cierra base de datos
					con.close();
					
				} catch (Exception i2) {
					System.out.println("error al cerrar insert PROPIEDADES: "+i2.getMessage());
				}
			}
		}catch(Exception i) {
			System.out.println("error al abrir insert PROPIEDADES: "+i.getMessage());
		}
		
////////LEER PROPIEDADES
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection con = DriverManager.getConnection(
					//											user		pass
					"jdbc:mysql://localhost:3306/inmobiliaria","usuario1","Curso2022"
					);
			Statement stmt = con.createStatement();
			
			//ejecutar la sentencia sql
			ResultSet   rs = stmt.executeQuery("SELECT * FROM `propiedades`");
		
			try {
				//lectura y mostrar por consola el contenido
				System.out.println("***********************************************************");
				while (rs.next()){
					System.out.println("Referencia:    |"+rs.getString(1));
					System.out.println("FechaAlta:     |"+rs.getString(2));
					System.out.println("TipoInmueble:  |"+rs.getString(3));
					System.out.println("Operacion:     |"+rs.getString(4));
					System.out.println("Provincia:     |"+rs.getString(5));
					System.out.println("Superficie:    |"+rs.getString(6));
					System.out.println("PrecioVenta:   |"+rs.getString(7));
					System.out.println("FechaVenta:    |"+rs.getString(8));
					System.out.println("Vendedor:      |"+rs.getString(9));
					System.out.println("Baja:          |"+rs.getString(10));
					System.out.println("***********************************************************");					
				}
	
			}catch(Exception e1) {
				System.out.println("Error al leer BBDD PROPIEDADES: "+e1.getMessage());
			}finally {
				try {
					rs.close();
				} catch (Exception e2) {
					System.out.println("error al cerrar select PROPIEDADES: "+e2.getMessage());
				}
			}
		}catch(Exception e) {
			System.out.println("error al abrir select PROPIEDADES: "+e.getMessage());
		}
	}

}
