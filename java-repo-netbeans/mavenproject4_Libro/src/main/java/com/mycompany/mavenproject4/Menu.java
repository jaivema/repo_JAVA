package com.mycompany.mavenproject4;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Menu implements Serializable {
    char salir, opcion;
    Scanner entrada;
    boolean anadido_libreria;
    Libro libro, laux;
    Subtotal saux;
    ArrayList<Libro> libreria;
    ArrayList<Subtotal> alSubtotal;
    Ficheros f;
    
    public Menu() throws ClassNotFoundException, IOException{
        do{
            salir='n';
            Menu_general();
        }while (salir!='s');
    }
    
/// MENU PRINCIPAL ////////////////////////////////////////////////////////////
    public void Menu_general() throws ClassNotFoundException, IOException{
        entrada=new Scanner(System.in);
        libreria=new ArrayList();
        alSubtotal=new ArrayList();
        anadido_libreria = false;
        salir='n';
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Existen dos manera de añadir a la libreria los libros.\n"+
            "- Introduce datos del libro(1) para luego visualizarlo(2) y/o añadir a la libreria(3).\n"+
            "- Introduce datos para añadir el libro directamente a la libreria(3) y visualiza \n"+
            "todos los libros en el libreria(4).\n"+
            "\nPara borrar se exige el índice del libro a eliminar(6).");
        System.out.println("---------------------------------------------------------------------------------------------\n");
        do{ 
            System.out.println("\n<-        MENU PRINCIPAL         ->");
            System.out.println(" >Libro a libro                   ");
            System.out.println("  1. Introducir datos del libro.     ");
            System.out.println("  2. Visualizar datos del libro.     ");
            System.out.println(" >Listado de libros                  ");
            System.out.println("  3. Introducir libro a la librería. ");
            System.out.println("  4. Visualizar librería.            ");
            System.out.println("  5. Buscar un libro en la librería. ");
            System.out.println("  6. Borrar libro de la librería.    ");
            System.out.println(" >Listado de totales por título      ");
            System.out.println("  7. Precio total en inventario.     ");
            System.out.println(" >Trabajar con ficheros              ");
            System.out.println("  8. Guardar libros en el fichero.   ");
            System.out.println("  9. Leer Libros del fichero.        ");
            System.out.println(" >Salir de la aplicación             ");
            System.out.println("  0. Salir.                          ");
            System.out.println(" Selecciona una opción: ");
            opcion=entrada.next().toLowerCase().charAt(0);
            switch(opcion){
                case '1':
                    if ((libro==null)||(anadido_libreria))
                        libro=introducir_datos_libro();   
                    else System.out.println("Todavía no se ha añadido el "
                            +"libro a la librería. Pulsa(3) para introducir uno nuevo y añadirlo.");
                break;
                case '2':
                    ver_datos_libro();
                break;
                case '3':
                    anadir_libro_libreria(libro);
                break;
                case '4':
                    visualizar_libreria();
                break;
                case '5':
                    if (libreria.isEmpty())
                        System.out.println("No existen libros en la librería. Pulsa(3).");
                    else buscar_libro();
                break;
                case '6':
                    if (libreria.isEmpty())
                        System.out.println("No existen libros en la librería. Pulsa(3).");
                    else eliminar_libro();
                break;
                case '7':calculo_total();
                break;
                case '8':
                    f=new Ficheros();
                    f.guardar_fichero(libreria);
                break;
                case '9':
                    f=new Ficheros();
                    f.leer_fichero(libreria);
                break;
                case '0':salir='s';
                break;
                default:
                    System.out.println("Se ha introducido una opción incorrecta.");
                break;
            }
        }while(salir!='s');
        entrada.close();
    }

/// OPERACIONES DE CALCULO ////////////////////////////////////////////////////
/// PRECIO TOTAL
    public void calculo_total(){
        laux=new Libro();
        saux=new Subtotal();
        String titulo_total=new String();
        double precio_total=0;
        
        for (int i=0;i<libreria.size();i++){
            laux=libreria.get(i);
            if(laux.getTitulo().equals(titulo_total)){
                precio_total=precio_total+laux.getPrecio();
                //actualiza registro
                for (int x=0;x<alSubtotal.size();x++){
                    saux=alSubtotal.get(x);
                    if(saux.getTitulo().equals(titulo_total)){
                       saux.setTotal(precio_total);
                       alSubtotal.set(x, saux);
                    }
                }
            }else{
                //añade nuevo registro
                titulo_total=laux.getTitulo();
                precio_total=laux.getPrecio();
                alSubtotal.add(new Subtotal(titulo_total, precio_total));
            }
        }
        System.out.println("---------------------------------------------");
        for (int i=0;i<alSubtotal.size();i++){
            System.out.println(i+".-> "+alSubtotal.get(i));
            System.out.println("---------------------------------------------");
        }
        alSubtotal.clear();
    }
    
/// ELIMINAR DATOS ////////////////////////////////////////////////////////////
    public void eliminar_libro(){
        laux=new Libro();
        System.out.println("Introduce el índice a borrar: ");
        int indice =entrada.nextInt();
        if (indice>=libreria.size())
            System.out.println("Libro no existe !!");
        else{ 
            laux=libreria.remove(indice);
            System.out.println("Se ha eliminado "+laux+" de la librería.");
        }
    }
    
/// BUSCAR DATOS //////////////////////////////////////////////////////////////
    public void buscar_libro(){
        salir='n';
        do{
            System.out.println("\n<-      BUSCAR LIBROS          ->");
            System.out.println("  1. Buscar por título.          ");
            System.out.println("  2. Buscar por autor.           ");
            System.out.println("  3. Buscar por precio.          ");
            System.out.println("  4. Buscar por número en stock. ");
            System.out.println("  0. Salir.                      ");
            System.out.println(" Selecciona una opción: ");
            opcion=entrada.next().toLowerCase().charAt(0);
            switch(opcion){
                case '1':buscar_titulo();
                    break;
                case '2':buscar_autor();
                    break;
                case '3':buscar_precio();
                    break;
                case '4':buscar_stock();
                    break;
                case '0':salir='s';
                    break;
                default:
                    System.out.println("Se ha introducido una opcion incorrecta.");
                    break;
            }
        }while(salir!='s');
        salir='n';
    }
    
    public void buscar_titulo(){
        boolean encontrado=false;
        String titulo;
        laux=new Libro();
        titulo=introducir_Titulo();
        for (int i=0;i<libreria.size();i++){
            laux=libreria.get(i);
            if (laux.getTitulo().toLowerCase().equals(titulo.toLowerCase())) {
                encontrado = true;
                System.out.println("Se ha encontrado el título solicitado: "+titulo+".");
                System.out.println(i+".-> "+libreria.get(i));
                break;
            }
        }
        if (!encontrado){
            System.out.println("No se ha encontrado título solicitado: "+titulo+" \n");
        }
    }
    
    public void buscar_autor(){
        boolean encontrado=false;
        String autor;
        int contador=0;
        laux=new Libro();
        autor=introducir_Autor();
        for (int i=0;i<libreria.size();i++){
            laux=libreria.get(i);
            if (laux.getAutor().toLowerCase().equals(autor.toLowerCase())) {
                encontrado = true;
                contador++;
                System.out.println(i+".-> "+libreria.get(i));
            }
        }
        if (encontrado) 
            System.out.println("Se ha encontrado "+contador
                +" libros. \n");
        else System.out.println("No se ha encontrado autor solicitado: "+autor+".\n");
    }
    
    public void buscar_precio(){
        boolean encontrado=false;
        double precio;
        int contador=0;
        laux=new Libro();        
        precio=introducir_Precio();
        for (int i=0;i<libreria.size();i++){
            laux=libreria.get(i);
            if (laux.getPrecio()==precio) {
                encontrado = true;
                contador++;                
                System.out.println(i+".-> "+libreria.get(i));
                break;
            }
        }
        if (encontrado) 
            System.out.println("Se ha encontrado "+contador
                +" libros. \n");
        else System.out.println("No se ha encontrado el precio solicitado: "+precio+".\n");
    }
    
    public void buscar_stock(){
        boolean encontrado=false;
        int stock;
        int contador=0;
        laux=new Libro();
        System.out.println("> El sistema buscará cantidad en stock igual o superior al introducido.");
        stock=introducir_Stock();
        for (int i=0;i<libreria.size();i++){
            laux=libreria.get(i);
            if (laux.getStock()>=stock) {
                encontrado = true;
                contador++;                
                System.out.println(i+".-> "+libreria.get(i));
            }
        }
        if (encontrado) 
            System.out.println("Se ha encontrado "+contador
                +" libros. \n");
        else System.out.println("No se ha encontrado en stock. \n");
    }
    
/// VISUALIZAR DATOS //////////////////////////////////////////////////////////
    public void ver_datos_libro(){
    if (libro==null)
        System.out.println("Todavía no se ha introducido un libro"
            + " para visualizar o ya se añadió al inventario. Pulsa(1).");
    else System.out.println(libro);
    }
    
/// INTRODUCIR DATOS //////////////////////////////////////////////////////////
    public Libro introducir_datos_libro(){
        laux = new Libro();
        laux.setTitulo(introducir_Titulo());
        laux.setAutor(introducir_Autor());
        laux.setPrecio(introducir_Precio());
        laux.setStock(introducir_Stock());
        libro=laux;
        anadido_libreria=false;
        return laux;
    }
    
    public int introducir_Stock(){
        int s;
        System.out.println("> Introduce stock del libro: ");
        s = entrada.nextInt();
        return s;
    }

    public double introducir_Precio(){
        double p;
        System.out.println("> Introduce precio del libro: ");
        p = entrada.nextDouble();
        return p;
    }
    
    public String introducir_Autor(){
        String a;
        System.out.println("> Introduce autor del libro: ");
        a = entrada.next();
        return a;
    }
    
    public String introducir_Titulo(){
        String t;
        System.out.println("> Introduce título del libro: ");
        t = entrada.next();
        return t;
    }
    
/// AÑADIR AL ARRAYLIST ///////////////////////////////////////////////////////
    public void anadir_libro_libreria(Libro laux){
        if (laux==null) {
            introducir_datos_libro();
            libreria.add(libro);
            System.out.println("Se ha añadido el libro a la librería."+libro);
        }else {
            libreria.add(laux);
            System.out.println("Se ha añadido el libro a la librería."+laux);
        }
        anadido_libreria=true;
        libro=null;
    }
    
/// VISUALIZAR ARRAYLIST //////////////////////////////////////////////////////
    public void visualizar_libreria(){
        if (libreria.isEmpty()) {
            System.out.println("Todavía no tienes libros en el inventario!!"
                    + " Pulsa(3) para introducir uno a la librería.");
        }else{
            for (int i=0; i<libreria.size();i++) {
                System.out.println(i+".-> "+libreria.get(i));
            }
        }
    }
}