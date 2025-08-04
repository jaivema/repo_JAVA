package Operaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Delete {
	Scanner entrada;

	public Delete(Scanner entrada) {
		super();
		this.entrada = entrada;
	}

	public void delete() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Conexion con la tabla de datos
			Connection conDelete = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/programacion","usuario1","Curso2022"
					);
		
			System.out.println("Introduce el id a eliminar:");
            String id=entrada.nextLine();
                
            try {
                //guarda variable sql la sentencia DELETE
                String sql="DELETE FROM `nombres` WHERE `nombres`.`id` = "+id;
                PreparedStatement preparedstmt = conDelete.prepareStatement(sql);
                
                //ejecuta el sql
                preparedstmt.execute();
            
            }catch(Exception d) {
            	System.out.println("Error al borrar BBDD CLIENTES: \n"+d.getMessage());
            	
            }finally{
            	//cierra conexion delete
            	conDelete.close();
            }
                
		}catch(Exception d1) {
			System.out.println("Error al leer BBDD CLIENTES: \n"+d1.getMessage());
			
		}
	}
}
