package Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class Iclientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dni, nombre, apellidos, direccion, ciudad, telefono, email; 
		int cpostal;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("DNI: ");				dni = entrada.nextLine();
		System.out.print("Nombre: ");			nombre = entrada.nextLine();		
		System.out.print("Apellidos: ");		apellidos = entrada.nextLine();
		System.out.print("Direccion: ");		direccion = entrada.nextLine();
		System.out.print("Codigo Postal: ");	cpostal = Integer.parseInt(entrada.nextLine());
		System.out.print("Ciudad: ");			ciudad = entrada.nextLine();
		System.out.print("Telefono: ");			telefono = entrada.nextLine();
		System.out.print("Email: ");			email = entrada.nextLine();
		
		//cierra Scanner de entrada
		entrada.close();
		
		try {
			//Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Conexion con la tabla de datos
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaropa","usuario1","Curso2022");
			Statement stmt = con.createStatement();
			
			try {
				//ejecutar la sentencia sql
				String sql = "INSERT INTO `clientes`(`dni`, `nombre`, `apellidos`, `direccion`, `cpostal`, `ciudad`, `telefono`, `email`) "
						+ "VALUES ('"+dni+"','"+nombre+"','"+apellidos+"','"+direccion+"','"+cpostal+"','"+ciudad+"','"+telefono+"','"+email+"')";
  				
				stmt.executeUpdate(sql);
				//System.out.println("\n" + sql);
				
			}catch(Exception e1) {
				System.out.println("Error al insertar BBDD CLIENTES: "+e1.getMessage());
			}finally {
				try {
					//cierra base de datos
					con.close();
					System.out.println("****** PROGRAMA FINALIZADO ******");
				} catch (Exception e2) {
					System.out.println("Error al cerrar BBDD CLIENTES: \n"+e2.getMessage());
				}
			}
		}catch(Exception e) {
			System.out.println("Error al abrir BBDD CLIENTES: \n"+e.getMessage());
		}
	}

}
