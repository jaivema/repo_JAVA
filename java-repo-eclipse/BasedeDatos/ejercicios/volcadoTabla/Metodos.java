package volcadoTabla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Metodos {
	Scanner entrada;

	String Ciudad = null;
	String Fecha = null;
	int Temperatura = 0;
	String sql = null;

	public Metodos(Scanner entrada) {
		super();
		this.entrada = entrada;
	}

//////////SELECT ///////////////////////////////
	public void _select() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conSelect = DriverManager.getConnection("jdbc:mysql://localhost:3306/temperaturas", "usuario1",
					"Curso2022");

			Statement stmt = conSelect.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM `muestras`");

			try {
				// lectura y mostrar por consola el contenido
				System.out.println("***********************************************************");

				while (rs.next()) {
					System.out.println("Ciudad:            |" + rs.getString(1));
					System.out.println("Fecha:             |" + rs.getString(2));
					System.out.println("Temperatura:       |" + rs.getString(3));
					System.out.println("***********************************************************");
				}
			} catch (Exception s1) {
				System.out.println("Error al leer BBDD: " + s1.getMessage());
			} finally {
				conSelect.close();
				rs.close();
			}
		} catch (Exception s) {
			System.out.println("error al abrir consulta BBDD: " + s.getMessage());
		}
	}

//////DELETE ///////////////////////////////////////////
	public void _delete() {
		try {
			System.out.println("***** BORRAR  *****");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conDelete = DriverManager.getConnection("jdbc:mysql://localhost:3306/temperaturas", "usuario1",
					"Curso2022");

			int Temperatura = 0;
			try {
				System.out.print("Ciudad: ");
				Ciudad = entrada.nextLine();
				System.out.print("Fecha: ");
				Fecha = entrada.nextLine();
				System.out.print("Temperatura: ");
				Temperatura = Integer.parseInt(entrada.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Valor introducido no permitido " + e.getMessage());
				_delete();
			}
			try {
				String sql = "DELETE FROM `muestras` WHERE `muestras`.`Ciudad` = '" + Ciudad + "'"
						+ "AND `muestras`.`Fecha` = '" + Fecha + "'" + "AND `muestras`.`Temperatura` = '" + Temperatura
						+ "'";

				Statement stmtDelete = conDelete.prepareStatement(sql);
				System.out.println(sql);
				stmtDelete.executeUpdate(sql);
			} catch (Exception d) {
				System.out.println("Error al borrar BBDD: \n" + d.getMessage());
			} finally {
				conDelete.close();
			}
		} catch (Exception d1) {
			System.out.println("Error al abrir temperaturas BBDD: " + d1.getMessage());
		}
	}

///// INSERT ////////////////////////////////////////////
	public void _insert() {

		System.out.println("***** INSERTAR *****");

		try {
			System.out.print("Ciudad: ");
			Ciudad = entrada.nextLine();
			System.out.print("Fecha: ");
			Fecha = entrada.nextLine();
			System.out.print("Temperatura: ");
			Temperatura = Integer.parseInt(entrada.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Valor introducido no permitido " + e.getMessage());
			_insert();
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conInsert = DriverManager.getConnection("jdbc:mysql://localhost:3306/temperaturas", "usuario1",
					"Curso2022");
			Statement stmt = conInsert.createStatement();

			try {
				String sql = "INSERT INTO `muestras`(`Ciudad`, `Fecha`, `Temperatura`) " + "VALUES ('" + Ciudad + "','"
						+ Fecha + "','" + Temperatura + "')";

				stmt.executeUpdate(sql);

			} catch (Exception i1) {
				System.out.println("Error al insertar datos: " + i1.getMessage());
			} finally {
				conInsert.close();
			}

		} catch (Exception i) {
			System.out.println("error al abrir insert: " + i.getMessage());
		}
	}

//////UPDATE //////////////////////////////////////////////////////
	public void _update() {

		int menu = 0;
		String sqlSel = null;
		String uCiudad = null;
		String uFecha = null;
		int uTemperatura = 0;
		System.out.println("\n Introduce el registro a actualizar: \n-------------------------------------");

		try {
			System.out.println("Ciudad: ");
			Ciudad = entrada.nextLine();
			System.out.println("Fecha: ");
			Fecha = entrada.nextLine();
			System.out.println("Temperatura: ");
			Temperatura = Integer.parseInt(entrada.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Valor introducido no permitido " + e.getMessage());
			_update();
		}

		while (menu != 99) {
			System.out.println("\n - Campos a actualizar - \n -----------------------");
			System.out.println("1.  Ciudad");
			System.out.println("2.  Fecha");
			System.out.println("3.  Temperatura");
			System.out.println("99. Salir");

			menu = Integer.parseInt(entrada.nextLine());

			switch (menu) {
			case 1:
				System.out.println("Actualizar Ciudad: ");
				uCiudad = entrada.nextLine();
				sqlSel = "`Ciudad`='" + uCiudad + "'";
				_updateSel(sqlSel);
				break;
			case 2:
				System.out.println("Actualizar fecha: ");
				uFecha = entrada.nextLine();
				sqlSel = "`Fecha`='" + uFecha + "'";
				_updateSel(sqlSel);
				break;
			case 3:
				System.out.println("Actualizar Temperatura: ");
				uTemperatura = Integer.parseInt(entrada.nextLine());
				sqlSel = "`Temperatura`=" + uTemperatura;
				_updateSel(sqlSel);
				break;
			case 99:
				break;
			default:
				System.out.println("*****Error, introduce un numero valido *******");
				break;
			}
		}
	}

	public void _updateSel(String sqlSel) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Conexion con la tabla de datos
			Connection conUpdate = DriverManager.getConnection("jdbc:mysql://localhost:3306/temperaturas", "usuario1",
					"Curso2022");

			try {
				String sql = "UPDATE `muestras` SET " + sqlSel + " " + "WHERE `Ciudad`='" + Ciudad + "' "
						+ "AND `Fecha`='" + Fecha + "' " + "AND `Temperatura`=" + Temperatura;
				Statement stmtUpdate = conUpdate.prepareStatement(sql);

				stmtUpdate.executeUpdate(sql);
			} catch (Exception u1) {
				System.out.println("Error al modificar BBDD: \n" + u1.getMessage());
			} finally {
				try {
					conUpdate.close();
				} catch (Exception u2) {
					System.out.println("Error al cerrar modificar BBDD: " + u2.getMessage());
				}
			}
		} catch (Exception u) {
			System.out.println("Error al abrir update BBDD: \n" + u.getMessage());
		}
	}

///////// CREAR TABLA Y VOLCADO DE DATOS
	public void _volcado() {
		
		boolean exitoso = true;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conVolcado = DriverManager.getConnection("jdbc:mysql://localhost:3306/temperaturas", "usuario1",
					"Curso2022");
			Connection conRemote = DriverManager.getConnection("jdbc:mysql://92.57.66.37:3306/temperaturas", "usuario1",
					"Curso2022");

			try {
				// guarda variable sql la sentencia DELETE
				String sql = "CREATE TABLE `muestras` (Ciudad varchar(100), Fecha date, Temperatura int(2))";
				PreparedStatement createstmt = conVolcado.prepareStatement(sql);
				// ejecuta el sql
				createstmt.execute();

				Statement stmt = conRemote.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM `muestras`");

				String sql2 = null;
				////////////// LECTURA Y VOLCADO
				try {
					while (rs.next()) {
						Statement Vstmt = conVolcado.createStatement();

						Ciudad = rs.getString(1);
						Fecha = rs.getString(2);
						Temperatura = Integer.parseInt(rs.getString(3));

						sql2 = "INSERT INTO `muestras`(`Ciudad`, `Fecha`, `Temperatura`) " + "VALUES ('" + Ciudad
								+ "','" + Fecha + "','" + Temperatura + "')";

						Vstmt.executeUpdate(sql2);
					}
				} catch (Exception e) {
					System.out.println("-> Error al volcar BBDD: \n" + e.getMessage());
					exitoso = false;
				} finally {
					rs.close();
				}
			} catch (Exception c) {
				System.out.println("-> Error al crear BBDD: \n" + c.getMessage());
				exitoso = false;
				
			} finally {
				// cierra conexion delete
				conVolcado.close();
				conRemote.close();
			}
		} catch (Exception s) {
			System.out.println("error al abrir conexion: " + s.getMessage());
			exitoso = false;
		} finally {
			if (exitoso==true) {
				System.out.println("-> Tabla volcada con exito. FIN");
			}else {
				System.out.println("-> Error al volcar la tabla. FIN");
			}
			
		}
	}
	public void _salir() {
	//// BORRADO DE LA TABLA
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conBorrado = DriverManager.getConnection("jdbc:mysql://localhost:3306/temperaturas", "usuario1",
					"Curso2022");
			Statement Bstmt = conBorrado.createStatement();
			
			try {
			//// VACIADO DE LA TABLA	
				sql="TRUNCATE TABLE `muestras`";
				Bstmt.executeUpdate(sql);
				
			//// BORRADO DE LA TABLA
				sql="DROP TABLE `muestras`";
				Bstmt.executeUpdate(sql);
			} catch (Exception e) {
				System.out.println("Error al eliminar tabla: " + e.getMessage());
			}
		}catch (Exception e) {
			System.out.println("Error de conexion: " + e.getMessage());
		}
	}
}
