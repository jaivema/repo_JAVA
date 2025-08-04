package com.mycompany.mavenproject8_videoclub.menu;

/**
 *
 * @author Jaime Verdejo Martí
 */
import com.mycompany.mavenproject8_videoclub.ficheros.FicheroDVD;
import com.mycompany.mavenproject8_videoclub.objetos.DVD;
import java.util.*;
import java.io.*;

public class MenuDVD implements Serializable {

    char opcion;
    boolean salir;
    Scanner sc;
    DVD dvd, daux;
    ArrayList<DVD> dvds = new ArrayList();
    FicheroDVD fDvds = new FicheroDVD();

    public MenuDVD(Scanner s, ArrayList al) throws ClassNotFoundException, IOException {
        sc = new Scanner(System.in);
        do {
            this.salir = false;
            menu_Dvd(s, al);
        } while (this.salir = false);
    }
    public MenuDVD(int c, ArrayList<DVD> aldvds){
        
    }
    public void menu_Dvd(Scanner s, ArrayList al) throws ClassNotFoundException, IOException {
        this.dvds = al;
        this.salir = false;
        do {
            System.out.println("\n      MENU DVD Videoclub ");
            System.out.println("        1. - Nuevo dvd.");
            System.out.println("        2. - Buscar dvd.");
            System.out.println("        3. - Modificar dvd.");
            System.out.println("        4. - Ver lista dvds.");
            System.out.println("        5. - Baja dvd.");
            System.out.println("        6. - Guardar en archivo.");
            System.out.println("        7. - Leer de archivo.");
            System.out.println("        0. - Salir.");
            System.out.println("                            ");
            System.out.println("> Selecciona opción: ");

            opcion = this.sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case '1':
                    nuevoDvd();
                    break;
                case '2':
                    buscarDvd();
                    break;
                case '3':
                    modDatosDvd();
                    break;
                case '4':
                    verDvds();
                    break;
                case '5':
                    bajaDvd();
                    break;
                case '6':
                    guardarDvd();
                    break;
                case '7':
                    leerDvd();
                    break;
                case '0':
                    this.salir = true;
                    break;
                default:
                    System.out.println("Se ha introducido una opcion incorrecta.");
                    break;
            }
        } while (!this.salir);
        this.salir = false;
    }
/// FICHERO ////////////////////////////////////////////////////////////////////

    public void leerDvd() throws ClassNotFoundException, IOException {
        ArrayList<DVD> aldvds = new ArrayList();
        aldvds = fDvds.leer_fichero(dvds);
        if (!aldvds.isEmpty()) {
            System.out.println("> Lista de dvds actualizada: ");
            for (int i = 0; i < aldvds.size(); i++) {
                System.out.println(i + ".-> " + aldvds.get(i));
            }
        }
    }

    public void guardarDvd() throws ClassNotFoundException, IOException {
        if (dvds.isEmpty()) {
            System.out.println("> No hay DVDs. Añade un DVD al videoclub antes de guardar");
        } else {
            fDvds.guardar_fichero(dvds);
        }
    }
/// NUEVOS DATOS ///////////////////////////////////////////////////////////////

    public void nuevoDvd() {
        DVD nDvd = new DVD();
        sc.nextLine();
        nDvd.setTitulo(intrTitulo());
        nDvd.setNumVol(intrnVol());
        int c = dvds.size() + 1;
        nDvd.setCodigo(c);
        dvds.add(nDvd);
    }

    public String intrTitulo() {
        System.out.println("> Título del dvd: ");
        String n = sc.nextLine();
        return n;
    }

    public int intrnVol() {
        System.out.println("> Número de volumenes en inventario: ");
        int c = sc.nextInt();
        return c;
    }

    public int intrCodigo() {
        System.out.println("> Código: ");
        int c = sc.nextInt();
        return c;
    }
/// ELIMINAR DATOS /////////////////////////////////////////////////////////////

    public void bajaDvd() {
        System.out.println("Introduce el índice a borrar: ");
        int c = sc.nextInt();
        if (c >= dvds.size()) {
            System.out.println("> Código " + c + " no existe !!");
        } else {
            daux = dvds.remove(c);
            System.out.println("> Se ha eliminado " + daux + ".");
        }
    }
/// VER LISTADO ////////////////////////////////////////////////////////////////

    public void verDvds() {
        if (dvds.isEmpty()) {
            System.out.println("> Todavía no hay datos de alta !!");
        } else {
            for (int i = 0; i < dvds.size(); i++) {
                System.out.println(i + ".-> " + dvds.get(i));
            }
        }
    }
/// MODIFICAR DATOS ////////////////////////////////////////////////////////

    public void modDatosDvd() {
        this.salir = false;
        do {
            System.out.println("\n      MODIFICAR DATOS DVD Videoclub ");
            System.out.println("        1. Modificar título.");
            System.out.println("        2. Modificar número de vols.");
            System.out.println("        0. Volver.");
            System.out.println("                                   ");
            System.out.println("> Selecciona opción: ");

            opcion = sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case '1':
                    modDVD();
                    break;
                case '2':
                    modnVol();
                    break;
                case '0':
                    this.salir = true;
                    break;
                default:
                    System.out.println("> Se ha introducido una opcion incorrecta.");
                    break;
            }
        } while (!this.salir);
        salir = false;
    }

    public void modDVD() {
        boolean encontrado = false;
        sc.nextLine();
        String n = intrTitulo();
        for (int i = 0; i < dvds.size(); i++) {
            daux = dvds.get(i);
            if (daux.getTitulo().toLowerCase().equals(n.toLowerCase())) {
                encontrado = true;
                //System.out.println("Dvd encontrado: "+n+".");
                System.out.println(i + ".-> " + dvds.get(i));
            }
            if (encontrado) {
                System.out.println("Nuevo título: ");
                n = sc.nextLine();
                daux.setTitulo(n);
                dvds.set(i, daux);
            }
            System.out.println(daux);
        }
    }

    public void modnVol() {
        int c = intrnVol();
        for (int i = 0; i < dvds.size(); i++) {
            daux = dvds.get(i);
            if (daux.getNumVol() == c) {
                //System.out.println("dvd encontrado: "+c+".");
                System.out.println(i + ".-> " + dvds.get(i));
                System.out.println("Número de volumenes: ");
                int n = sc.nextInt();
                daux.setNumVol(n);
                dvds.set(i, daux);
            }
        }
        System.out.println(daux);
    }

/// BUSCAR DATOS //////////////////////////////////////////////////////////////
    public void buscarDvd() {
        this.salir = false;
        do {
            System.out.println("\n      BUSCAR DVD Videoclub ");
            System.out.println("        1. Buscar por título.");
            System.out.println("        2. Buscar por codigo.");
            System.out.println("        3. Buscar por numero de vol.");
            System.out.println("        0. Volver.");
            System.out.println(" Selecciona una opción: ");
            opcion = sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case '1': buscar_titulo();
                    break;
                case '2': buscar_codigo();
                    break;
                case '3': buscar_nVol();
                    break;
                case '0': this.salir = true;
                    break;
                default:
                    System.out.println("> Se ha introducido una opcion incorrecta.");
                    break;
            }
        } while (!this.salir);
        salir = false;
    }

    public void buscar_titulo() {
        boolean encontrado = false;
        sc.nextLine();
        String n = intrTitulo();
        for (int i = 0; i < dvds.size(); i++) {
            daux = dvds.get(i);
            if (daux.getTitulo().toLowerCase().equals(n.toLowerCase())) {
                System.out.println(i + ".-> " + dvds.get(i));
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("> No se ha encontrado \n");
    }

    public void buscar_codigo() {
        boolean encontrado = false;
        int c = intrCodigo();
        for (int i = 0; i < dvds.size(); i++) {
            daux = dvds.get(i);
            if (daux.getCodigo() == c) {
                System.out.println(i + ".-> " + dvds.get(i));
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("> No se ha encontrado. \n");
    }

    public boolean buscar_codigo(int c, ArrayList<DVD> aldvds) {
        boolean duplicado = false;
        for (int i = 0; i < aldvds.size(); i++) {
            dvd = aldvds.get(i);
            if (dvd.getCodigo() == c) {
                System.out.println(i + ".-> " + aldvds.get(i));
                duplicado = true;
            }
        }
        return duplicado;
    }
    
    public void buscar_nVol() {
        boolean encontrado = false;
        int c = intrnVol();
        for (int i = 0; i < dvds.size(); i++) {
            daux = dvds.get(i);
            if (daux.getNumVol() == c) {
                System.out.println(i + ".-> " + dvds.get(i));
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("> No se ha encontrado. \n");
    }
}
