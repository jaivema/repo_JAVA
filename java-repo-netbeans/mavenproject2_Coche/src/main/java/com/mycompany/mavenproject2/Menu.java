package com.mycompany.mavenproject2;

import java.util.Scanner;
import java.util.ArrayList;
/*
Existen dos manera de añadir al concesionario coches.
    1.Introduce datos del coche para luego visualizarlo(2) o añadir al concesionario(4)
    2.Introduce datos para añdir el coche directamente al concesionario con la opcion(4)
*/
public class Menu {
    char salir;
    char opcion;
    Scanner sc;
    Coche c1;
    boolean anadido_al_concesionario;
    public ArrayList<Coche> concesionario;

    public Menu(){
        concesionario=new ArrayList();
        do{ salir='n';
            menu_General();
        }while (salir!='s');
    }
    
////// MENU PRINCIPAL DE COCHES
    public void menu_General(){
        sc=new Scanner(System.in);
        anadido_al_concesionario = false;
        salir='n';
        System.out.println("Existen dos manera de añadir al concesionario coches.\n" +
            "1.Introduce datos del coche para luego visualizarlo(2) o añadir al concesionario(4)\n" +
            "2.Introduce datos para añdir el coche directamente al concesionario con la opcion(4)");
        do{ System.out.println("<-        MENU PRINCIPAL        ->        ");
            System.out.println("  1. Introducir datos de un coche.        ");
            System.out.println("  2. Modificar datos de un coche.         ");
            System.out.println("  3. Visualizar datos de un coche.        ");
            System.out.println("  4. Añadir coche al concesionario.       ");
            System.out.println("  5. Listar coches del concesionario.     ");
            System.out.println("  6. Buscar un coche.                     ");
            System.out.println("  7. Modificar un coche del concesionario.");
            System.out.println("  8. Borrar coche del concesionario.      ");
            System.out.println("  0. Salir.                               ");
            System.out.println(" Selecciona una opción: ");
            opcion=sc.next().toLowerCase().charAt(0);
            switch(opcion) {
                    case '1':
                        if ((c1==null)||(!anadido_al_concesionario))
                            c1=introducir_datos_coche();   
                        else System.out.println("Todavia no se ha añadido el "
                                + "coche al concesionario. Pulsa (4).");
                    break;
                    case '2':
                        if (c1==null){
                            System.out.println("Todavia no se ha "
                                + "introducido un coche para modificarlo o ");
                            System.out.println( "ya se ha añadido a la lista"
                                + " del concesionario. Pulsa (1).");
                        }else modificar_datos_Coche();
                    break;
                    case '3':
                        ver_datos_Coche();
                    break;
                    case '4':
                        anadir_coche_concesionario(c1);
                    break;
                    case '5':
                        listar_coches_concesionario();
                    break;
                    case '6':
                        if (concesionario.isEmpty())
                            System.out.println("No existen coches en el concesionario. Pulsa (4).");
                        else buscar_coche();
                    break;
                    case '7':
                        modificar_coche_concesionario();
                    break;
                    case '8':
                        borrar_coche_concesionario();
                    break;
                    case '0':salir='s';
                    break;
                    default:
                        System.out.println("Se ha introducido una opción incorrecta.");
                        break;
            }
        }while(salir!='s');
        sc.close();
    }

////// METODOS DE BUSQUEDA
    public void buscar_coche(){
        salir='n';
        do{ System.out.println("<- BUSCAR DATOS DE UN COCHE     -> ");
            System.out.println("  1. Buscar matrícula.             ");
            System.out.println("  2. Buscar marca.                 ");
            System.out.println("  3. Buscar modelo.                ");
            System.out.println("  4. Buscar kilometraje.           ");
            System.out.println("  0. Volver.                       ");
            System.out.println("                                   ");
            System.out.println("> Selecciona opción: ");

            opcion = sc.next().toLowerCase().charAt(0);
            switch(opcion) {
                case '1':buscar_Matricula();
                break;
                case '2':buscar_Marca();
                break;
                case '3':buscar_Modelo();
                break;
                case '4':buscar_Km();
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
    
    public void buscar_Km(){
        boolean encontrado = false;
        int km;
        int contador =0;
        Coche c=new Coche();        
        System.out.println("Introduce el kilometraje del coche que quieres buscar: ");
        km=sc.nextInt();
        
        for (int x=0;x<concesionario.size();x++) {
            c =concesionario.get(x);
            if (c.getKm()>=km) {
                encontrado = true;
                contador++;
                System.out.println(x+".-> "+concesionario.get(x));
            }
        }
        if (encontrado) System.out.println("Se han encontrado "+contador
                +" con un kilometraje igual o superior \n");
        else System.out.println("No se ha encontrado el kilometraje solicitado \n");
    }

    public void buscar_Modelo(){
        boolean encontrado = false;
        String modelo=new String();
        int contador =0;
        Coche c=new Coche();        
        System.out.println("Introduce el modelo del coche que quieres buscar: ");
        modelo=sc.next();
        for (int x=0;x<concesionario.size();x++) {
            c =concesionario.get(x);
            if (c.getModelo().toLowerCase().equals(modelo.toLowerCase())) {
                encontrado = true;
                contador++;
                System.out.println(x+".-> "+concesionario.get(x));
                break;
            }
        }
        if (encontrado) System.out.println("Se han encontrado "+contador
                +" coches que coinciden con el modelo solicitada \n");
        else System.out.println("No se ha encontrado el modelo solicitado \n");
    }
    
    public void buscar_Marca(){
        boolean encontrado = false;
        int contador=0;
        String marca=new String();
        Coche c=new Coche();        
        System.out.println("Introduce la marca del coche que quieres buscar: ");
        marca=sc.next();
        for (int x=0;x<concesionario.size();x++) {
                c =concesionario.get(x);
            if (c.getMarca().toLowerCase().equals(marca.toLowerCase())) {
                encontrado = true;
                contador++;
                System.out.println(x+".-> "+concesionario.get(x));
            }
        }
        if (encontrado) System.out.println("Se han encontrado "+contador
                +" coches que coinciden con la marca solicitada \n");
        else System.out.println("No se ha encontrado la marca solicitada \n");
    }

    public void buscar_Matricula(){
        boolean encontrado = false;
        String matricula=new String();        
        Coche c=new Coche();        
        System.out.println("Introduce la matricula del coche que quieres buscar: ");
        matricula=sc.next();
        for (int x=0;x<concesionario.size();x++) {
            c =concesionario.get(x);
            if (c.getMatricula().toLowerCase().equals(matricula.toLowerCase())) {
                encontrado = true;
                System.out.println("Se ha encontrado la clave solicitada");
                System.out.println(x+".-> "+concesionario.get(x));
                break;
            }
        }
        if (!encontrado){
            System.out.println("No se ha encontrado la matricula solicitada \n");
        }
    }

/////// GESTIONAR CONCESIONARIO    
    public void borrar_coche_concesionario(){
        if (concesionario.isEmpty())
            System.out.println("No tienes coches en el concesionario !!"
                    + " Pulsa (4)");
        else{
            System.out.println("Introduce el coche del concesionario a borrar: ");
            int indice =sc.nextInt();
            if (indice>=concesionario.size())
                System.out.println("Coche no existe !!");
            else{ 
                Coche aux=concesionario.remove(indice);
                System.out.println("Se ha eliminado "+aux+" del concesionario.");
            }
        }
    }

    public void modificar_coche_concesionario(){
        if (concesionario.isEmpty())
            System.out.println("No existen coches en el concesionario. Pulsa (4).");
        else{ 
            System.out.println("Introduce el coche del concesionario a modificar: ");
            int indice =sc.nextInt();
            c1=concesionario.get(indice);
            modificar_datos_Coche();
            concesionario.set(indice, c1);
            c1=null;
            System.out.println("Se ha actualizado "+concesionario.get(indice)+" del concesionario.");
        }
    }

    public void listar_coches_concesionario(){
        if (concesionario.isEmpty()) {
            System.out.println("Todavia no tienes coches en el concesionario !!"
                    + " Pulsa (4).");
        }else{
            for (int i=0; i<concesionario.size();i++) {
                System.out.println(i+".-> "+concesionario.get(i));
            }
        }
    }

    public void anadir_coche_concesionario(Coche caux){
        if (caux==null) {
            introducir_datos_coche();
            concesionario.add(c1);
            System.out.println("Se ha añadido el coche al concesionario."+c1);
        }else {
            concesionario.add(caux);
            System.out.println("Se ha añadido el coche al concesionario."+caux);
        }
        anadido_al_concesionario=true;
        c1=null;
    }
    
/////// MODIFICAR DATOS
    public void modificar_datos_Coche(){
        salir='n';
        do{ System.out.println("<- MODIFICAR DATOS DE UN COCHE  -> ");
            System.out.println("  1. Modificar todos los datos.    ");
            System.out.println("  2. Modificar matrícula.          ");
            System.out.println("  3. Modificar marca.              ");
            System.out.println("  4. Modificar modelo.             ");
            System.out.println("  5. Modificar kilometraje.        ");
            System.out.println("  6. Visualizar datos del coche.   ");
            System.out.println("  0. Volver.                       ");
            System.out.println("                                   ");
            System.out.println("> Selecciona opción: ");

            opcion = sc.next().toLowerCase().charAt(0);
            switch(opcion) {
                case '1':modificar_Datos();
                break;
                case '2':modificar_Matricula();
                break;
                case '3':modificar_Marca();
                break;
                case '4':modificar_Modelo();
                break;
                case '5':modificar_Km();
                break;
                case '6':ver_datos_Coche();
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
    
    public void modificar_Datos(){
        System.out.println("Los datos del coche actual que serán reemplazados: ");
        ver_datos_Coche();
        modificar_Matricula();
        modificar_Marca();
        modificar_Modelo();
        modificar_Km();
        System.out.println("Los datos han sido modificados: ");
        ver_datos_Coche();
    }
    
    public void modificar_Matricula(){
        System.out.println("Matricula: "+c1.getMatricula());
        c1.setMarca(introducir_Matricula());
    }
    
    public void modificar_Marca(){
        System.out.println("Marca: "+c1.getMarca());
        c1.setMarca(introducir_Marca());
    }
    
    public void modificar_Modelo(){
        System.out.println("Modelo: "+c1.getModelo());
        c1.setModelo(introducir_Modelo());
    }
    
    public void modificar_Km(){
        System.out.println("Kilometraje: "+c1.getKm());
        c1.setKm(introducir_Km());
    }
    
/////////// INTRODUCIR DATOS
    public Coche introducir_datos_coche(){
        Coche aux=new Coche();
        aux.setMatricula(introducir_Matricula());
        aux.setMarca(introducir_Marca());
        aux.setModelo(introducir_Modelo());
        aux.setKm(introducir_Km());
        c1=aux;
        anadido_al_concesionario=false;
        return aux;
    }

    public int introducir_Km(){
        int k;
        System.out.println("> Introduce el kilometraje del coche: ");
        k = sc.nextInt();
        return k;
    }

    public String introducir_Modelo(){
        String m;
        System.out.println("> Introduce el modelo del coche: ");
        m = sc.next();
        return m;
    }
    
    public String introducir_Marca(){
        String m;
        System.out.println("> Introduce marca del coche: ");
        m = sc.next();
        return m;
    }
    
    public String introducir_Matricula(){
        String m;
        System.out.println("> Introduce número de matrícula: ");
        m = sc.next();
        return m;
    }
    
    public void ver_datos_Coche(){
    if (c1==null)
        System.out.println("Todavia no se ha introducido un coche"
            + " para visualizar o ya se añadió al inventario. Pulsa (1).");
    else System.out.println(c1);
    }
}