/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author udemy
 */
public class EjemploJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            // Conectar a la BD
            // Elegir el Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Datos de conexión
            String login = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/videoclub";

            // Conectar
            Connection conexion = DriverManager.getConnection(url, login, password);

            // Recuperar el contenido de la tabla Pelicula
            String query = "select * from Pelicula";
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(query);

            // Lista de películas
            List<Pelicula> lista = new LinkedList<Pelicula>();

            // Crear objetos y guardarlos en la lista
            while (resultado.next()) {

                Pelicula p = new Pelicula();

                p.setId(resultado.getInt("id"));
                p.setTitulo(resultado.getString("titulo"));
                p.setSinopsis(resultado.getString("sinopsis"));
                p.setAnyo(resultado.getInt("anyo"));

                lista.add(p);
            }

            // Volcar la lista para ver el contenido
            for (Pelicula p : lista) {
                System.out.println(p);
            }

            // Desconectar
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EjemploJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EjemploJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
