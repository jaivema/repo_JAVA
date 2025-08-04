package almacen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;


public class Almacen {
	Statement stmt;
	Connection con;
	Scanner entrada;
	
	String ISBN = null;
	String Nombre = null;
	float PVP;
	float PVD;
	int Stock = 0;
	float Alto;
	float Ancho;
	String sql=null;
	
	public Almacen(Scanner entrada) {
		super();
		this.entrada = entrada;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/productos", "usuario1","Curso2022");
			
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("> Error en la conexion al Host: "+e.getMessage());
		} 
	}

	public void _select() {
		try {

			ResultSet rs = stmt.executeQuery("SELECT * FROM `stock` ORDER BY `stock`.`ISBN` DESC");
			
			try {
				// lectura y mostrar por consola el contenido
				System.out.println("*************** CONSULTA DE STOCK *************************");
				int cont=1;
				while (rs.next()) {
					System.out.println(cont+".-------------------------------");
					System.out.println("   ISBN:      |" + rs.getString(1));
					System.out.println("   Nombre:    |" + rs.getString(2));
					System.out.println("   PVD:       |" + rs.getString(3));
					System.out.println("   PVP:       |" + rs.getString(4));
					System.out.println("   Stock:     |" + rs.getString(5));
					System.out.println("   Alto:      |" + rs.getString(6));
					System.out.println("   Ancho:     |" + rs.getString(7));
					cont++;
				}
				cont--;
				System.out.println("\n> Total productos en stock: "+cont); 
				System.out.println("***********************************************************");
				rs.close();
				
			} catch (Exception e) {
				System.out.println("Error al leer BBDD: " + e.getMessage());
			} 
		} catch (SQLException e) {
			System.out.println("Error al abrir consulta BBDD: " + e.getMessage());
		}
	}
	
	public void _insertar(Scanner entrada) {
		
		
		System.out.println("\n- Menu insertar -");
		System.out.println(">ISBN: "); 		ISBN = entrada.nextLine();
		System.out.println(">Nombre: "); 	Nombre = entrada.nextLine();
		try {
		  	System.out.println(">PVD: "); 	PVD = Float.parseFloat(entrada.nextLine());
		  	System.out.println(">PVP: "); 	PVP = Float.parseFloat(entrada.nextLine());
			System.out.println(">Stock: "); Stock = Integer.parseInt(entrada.nextLine());
		  	System.out.println(">Alto: "); 	Alto = Float.parseFloat(entrada.nextLine());
		  	System.out.println(">Ancho: "); Ancho = Float.parseFloat(entrada.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("> Introduce un número válido.");
			_insertar(entrada);
		}
		try {
			sql = "INSERT INTO `stock`(`ISBN`, `Nombre`, `PVD`, `PVP`, `Stock`, `Alto`, `Ancho`) " + "VALUES "
					+ "('"+ISBN+"','"+Nombre+"','"+PVD+"','"+PVP+"','"+Stock+"','"+Alto+"','"+Ancho+"')";

			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			System.out.println("> Error al insertar datos: " + e.getMessage());
		}
	}
	
	public void _borrar(Scanner entrada) {
		System.out.println("\n- ELIMINAR -");
		System.out.println("ISBN: "); ISBN = entrada.nextLine();
		
		sql = "DELETE FROM `Stock` WHERE `Stock`.`ISBN`="+ISBN;
		
		try {	
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("> Error al eliminar datos: " + e.getMessage());
		}
	}

	public void _actualizar(Scanner entrada) {
		String sqlSel = "",
				uISBN = null,
				uNombre = null
		;
		float uPVD;
		float uPVP;
		int uStock = 0;
		float uAlto;
		float uAncho;
		int menu=0;
		boolean actualiza=true;
		System.out.println("\n Introduce el ISBN a actualizar: \n-------------------------------------");
		System.out.println(">ISBN: "); ISBN = entrada.nextLine();
		
		
		while (menu != 99) {
			System.out.println("\n - Introduce campo a actualizar - \n -----------------------");
			System.out.println("1.  ISBN");
			System.out.println("2.  Nombre");
			System.out.println("3.  PVD");
			System.out.println("4.  PVP");
			System.out.println("5.  Stock" );
			System.out.println("6.  Alto" );
			System.out.println("7.  Ancho" );
			System.out.println("99. Salir" );
			
			menu = Integer.parseInt(entrada.nextLine());
			
			switch (menu) {
			case 1:
				System.out.println("Actualizar ISBN: ");
				uISBN = entrada.nextLine();
				sqlSel = "`ISBN`='" + uISBN + "'";
				menu=99;
				break;
			case 2:
				System.out.println("Actualizar Nombre: ");
				uNombre = entrada.nextLine();
				sqlSel = "`Nombre`='" + uNombre + "'";
				break;
			case 3:
				System.out.println("Actualizar PVD: ");
				uPVD = Float.parseFloat(entrada.nextLine());
				sqlSel = "`PVD`=" + uPVD;
				break;
			case 4:
				System.out.println("Actualizar PVP: ");
				uPVP = Float.parseFloat(entrada.nextLine());
				sqlSel = "`PVP`=" + uPVP;
				break;
			case 5:
				System.out.println("Actualizar Stock: ");
				uStock = Integer.parseInt(entrada.nextLine());
				sqlSel = "`Stock`=" + uStock;
				break;
			case 6:
				System.out.println("Actualizar Alto: ");
				uAlto = Float.parseFloat(entrada.nextLine());
				sqlSel = "`Alto`=" + uAlto;
				break;
			case 7:
				System.out.println("Actualizar Ancho: ");
				uAncho = Float.parseFloat(entrada.nextLine());
				sqlSel = "`Ancho`=" + uAncho;
				break;
			case 99:
				actualiza=false;
				break;
				default:
					System.out.println("> Error. Introduce un número válido");
					break;
			}
			if (actualiza == true) {
				sql = "UPDATE `stock` SET "+sqlSel+" "+"WHERE `ISBN`='"+ISBN+"'";
				try {
					stmt.executeUpdate(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("> Error al actualizar datos: " + e.getMessage());
				}
			}
		}
	}
	
	public void _salir(Scanner entrada) {
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("> Error al cerrar conexión: " + e.getMessage());
		}
		entrada.close();
	}
}
