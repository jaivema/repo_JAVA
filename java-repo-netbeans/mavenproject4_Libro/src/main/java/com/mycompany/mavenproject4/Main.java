package com.mycompany.mavenproject4;
/*
1. Generar un nuevo proyecto y crear una clase Libro de la que guardaremos la siguiente información:
Título del Libro.
Autor del Libro.
Precio del Libro.
Nº de volúmenes del libro en stock.
 */

/*
Existen dos maneras de añadir a la libreria los libros.
- Introduce datos del libro(1) para luego visualizarlo(2) y/o añadir a la libreria(3).
- Introduce datos para añadir el libro directamente a la libreria(3) y visualiza 
todos los libros en el libreria(4).

Para borrar se exige el índice del libro a eliminar(6).
*/

import java.io.*;

public class Main implements Serializable {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Menu m = new Menu();
        
        System.out.println("\n\n<-       FIN DE PROGRAMA        ->");
    }
}
